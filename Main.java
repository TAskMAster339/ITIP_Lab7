public class Main {
    public static void main(String[] args) {
        int size = 10;
        Storage storage1 = new Storage("Storage1");

        storage1.addProduct(new Product("absfdb", 40));
        storage1.addProduct(new Product("fafadf", 70));
        storage1.addProduct(new Product("dfgdsfg", 30));
        storage1.addProduct(new Product("adfafxbb", 20));
        storage1.addProduct(new Product("zxczxcb", 10));
        storage1.addProduct(new Product("jkf;jpb", 150));
        storage1.addProduct(new Product("fjsi[hg", 95));
        storage1.addProduct(new Product("wpethb", 39));
        storage1.addProduct(new Product("aфоалвоадф", 60));
        storage1.addProduct(new Product("ajdagh;b", 70));

        storage1.print();

        Storage storage2 = new Storage("Storage2");

        storage2.print();

        Loader loader1 = new Loader("loader1", storage1, 150, storage2);
        Loader loader2 = new Loader("loader2", storage1, 150, storage2);
        Loader loader3 = new Loader("loader3", storage1, 150, storage2);


        loader1.start();
        loader2.start();
        loader3.start();
        try{
            loader1.join();
            loader2.join();
            loader3.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        storage1.print();

        storage2.print();
    }
}
