import java.util.Arrays;

public class MultiThreadingMatrixMaxSearch {

    public static void main(String[] args) {
        int[][] matix = new int[][]{
                {1, 4, 5, 10, 2, 0, -6},
                {5, 10, 400000, 12, -14, 20, 0},
                {123, 500_000, -4134, 3242, 5020, 1000, 0101},
                {0, 0, 0, 0, 0, 0, 0},
                {-1, -2, -3, -4, -5, -6, -7}
        };
        int len = matix.length;
        int[] maximums = new int[len];

        for (int i = 0; i < len; ++i){
            SearchMaxInMatrixRow thread = new SearchMaxInMatrixRow(matix[i], maximums, i);
            thread.start();
            try{
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Arrays.toString(maximums));
        int max = Integer.MIN_VALUE;
        for (int i : maximums){
            if (max < i){
                max = i;
            }
        }
        System.out.println("Max value in matrix: " + max);
    };
}
class SearchMaxInMatrixRow extends Thread{
    private int[] row;
    private int max = Integer.MIN_VALUE;
    private int[] result;
    private int index;

    public SearchMaxInMatrixRow(int[] row, int[] result, int index){
        this.row = row;
        this.result = result;
        this.index = index;
    }
    public void run(){
        for(int i : row){
            if (i > max){
                max = i;
            }
        }
        result[index] = max;
    }

}
