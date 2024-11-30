
public class MultiThreadingSumOfArray {

    public static void main(String[] args) {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; ++i){
            arr[i] = i + 1;
        }
        CalcSumThread evenThread = new CalcSumThread(arr, 0);
        CalcSumThread oddThread = new CalcSumThread(arr, 1);
        evenThread.start();
        oddThread.start();
        try{
            evenThread.join();
            oddThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Sum of even index: " + evenThread.getResult());
        System.out.println("Sum of odd index: " + oddThread.getResult());
        int result = evenThread.getResult() + oddThread.getResult();
        System.out.println("Sum of array: " + result);

    }
}
class CalcSumThread extends Thread{
    private int[] arr;
    private int num;
    private int result;

    public CalcSumThread(int[] arr, int num){
        this.arr = arr;
        this.num = num % 2;
    }
    public void run(){
        for (int i = num; i < arr.length; i +=2){
            result += arr[i];
        }
    }
    public int getResult(){
        return result;
    }
}
