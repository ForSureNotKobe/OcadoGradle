import java.util.ArrayList;
import java.util.List;

public class Bag {
    private static final int DEF_BAG_LOAD = 3000;
    private int BagLoad = DEF_BAG_LOAD;
    private List<Products> prodInBag = new ArrayList<Products>();

    public Bag() {
        setBagLoad(BagLoad);
    }

    public int getBagLoad() {
        return BagLoad;
    }

    public void setBagLoad(final int newBagLoad) {
        if (newBagLoad <= 0) throw new IllegalArgumentException("Unable to init bag with nonpositive strength.");
        this.BagLoad = newBagLoad;
    }

    public void addNewProduct(final Products newProduct) {
        if (newProduct.getWeight() > this.BagLoad)
            throw new IllegalArgumentException("Product weight exceed bag strength.");
        prodInBag.add(newProduct);
    }

    public int getWeightOfProductsInside() {
        return prodInBag.stream()
                .map(product -> product.getWeight())
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public String toString() {
        String result = "";
        for (Products product : prodInBag) {
            result += "      " + product.toString() + "\n";
        }
        return result;
    }

}