import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Double;

public class ShoppingScanner {


    public static void main(String[] args) throws FileNotFoundException {
        List<Products> ListOfAll = new ArrayList<Products>();
        List<Bag> bags = new ArrayList<Bag>();
        Bag bag = new Bag();
        int BagLoad = bag.getBagLoad();

        double dbweight;
        Scanner scanner = new Scanner(new File("/Users/jpore/Data/product_data.csv"));
        scanner.useDelimiter(",");
        scanner.nextLine();                          //skipping first line of headears
        while (scanner.hasNext()) {
            String id = scanner.next();
            if (id.matches("[0-9]+")) {
            } else {
                scanner.nextLine();
                continue;
            }
            String name = scanner.next();
            String weight = scanner.next();
            String unit = scanner.nextLine();
            dbweight = Double.parseDouble(weight);
            if (unit.equals(",KG")) {
                dbweight = dbweight * 1000.0;
            }
            int intweight = (int) dbweight;
            ListOfAll.add(new Products(Integer.parseInt(id), name, intweight));
        }
        scanner.close();

        List<Long> productsID = new ArrayList<>();
        productsID.add(73323011L);
        productsID.add(77760011L);
        productsID.add(94683011L);
        productsID.add(56966011L);
        productsID.add(241566011L);
    }

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