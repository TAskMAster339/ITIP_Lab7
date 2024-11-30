public class Product {
    private String name;
    private int weight;

    public Product(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public synchronized int getWeight() {
        return weight;
    }

    public synchronized String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + weight + "кг";
    }

}
