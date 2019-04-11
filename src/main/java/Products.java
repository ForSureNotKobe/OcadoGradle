

public class Products {
    private int ID;
    private int weight;
    private String name;

    public Products(int ID, String name, int weight) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
    }

    public int getID() {
        return ID;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getID() + " " + getName() + " " + getWeight();
    }
}