import java.util.concurrent.ConcurrentLinkedQueue;

public class Loader extends Thread {
    private final Storage storage;
    private final Storage target;
    private final int maxWeight;
    private final ConcurrentLinkedQueue<Product> inventory = new ConcurrentLinkedQueue<>();

    public Loader(String name, Storage storage, int maxWeight, Storage target) {
        super(name);
        this.storage = storage;
        this.maxWeight = maxWeight;
        this.target = target;
    }

    @Override
    public void run() {
        int currentWeight = 0;
        while (true) {
            Product product = storage.getProduct();

            if (product == null) {
                if (currentWeight > 0) {
                    System.out.println("-----------------------------\n" + getName() + " отправляется с грузом " + currentWeight + " кг." + "\n-----------------------------");
                    for (var i : inventory){
                        target.addProduct(i);
                    }
                    inventory.clear();
                }
                break;
            }

            if (currentWeight + product.getWeight() > maxWeight) {
                System.out.println("-----------------------------\n" + getName() + " отправляется с грузом " + currentWeight + " кг." + "\n-----------------------------");
                for (var i : inventory){
                    target.addProduct(i);
                }
                inventory.clear();
                currentWeight = 0;
            }

            currentWeight += product.getWeight();
            inventory.add(product);
            System.out.println(getName() + " загружает: " + product);
        }
    }
}