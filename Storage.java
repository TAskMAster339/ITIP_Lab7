import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Storage {
    private final Queue<Product> products = new ConcurrentLinkedQueue<>();
    private String name;

    public Storage(String name){
        this.name = name;
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProduct() {
        return products.poll();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
    public void print(){
        System.out.println(name);
        for (var i : products){
            System.out.println("\t" + i);
        }
        if (isEmpty()){
            System.out.println("\tEmpty");
        }
        System.out.println();
    }
}