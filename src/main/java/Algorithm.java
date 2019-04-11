import java.util.*;

public class Algorithm {
    private List<Products> ListOfAll = new ArrayList<Products>();
    private List<Bag> bags = new ArrayList<Bag>();
    private Bag bag = new Bag();
    private int BagLoad = bag.getBagLoad();

    public void BagCounter(List<Long> productsID) {
        if (ListOfAll == null || ListOfAll.size() == 0)
            throw new RuntimeException("There is no database loaded to compare products to");

        Optional.ofNullable(productsID)
                .orElseThrow(IllegalArgumentException::new)
                .stream()
                .forEach(ID -> {
                    Products currentProduct = ListOfAll.stream()
                            .filter(product -> product.getID() == ID)
                            .findAny()
                            .orElseThrow(() -> new RuntimeException("Product with ID = " + ID + " not found inside product list."));

                    for (Bag currentBag : bag) {
                        if (currentBag.getBagLoad() >=
                                currentBag.getWeightOfProductsInside() + currentProduct.getWeight()) {

                            currentBag.addNewProduct(currentProduct);
                            break;
                        }

                    }
                });
    }
}