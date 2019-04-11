import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Double;

public class main {
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

}