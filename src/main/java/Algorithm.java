import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Algorithm {
    private List<Products> ListOfAll = new ArrayList<>();
    private List<Bag> bags = new ArrayList<>();
    private Bag bag = new Bag();
    private int BagLoad = bag.getBagLoad();

    public List<Products> ScanProducts(String FileName) {
        double dbweight;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(FileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter(",");
        scanner.nextLine();                          //skipping first line of headears
        while (scanner.hasNext()) {
            String id = scanner.next();

            if (id.matches("[0-9]+")) {
            } else {
                System.out.println("Data at index " + id + " seems corrupted, failed to load product.");
                scanner.nextLine();
                continue;
            }
            String name = scanner.next();
            String weight = scanner.next();
            String unit = scanner.nextLine();
            dbweight = Double.parseDouble(weight);
            if (unit.contains("KG")) {
                dbweight = dbweight * 1000.0;
            }
            int intweight = (int) dbweight;
            ListOfAll.add(new Products(Integer.parseInt(id), name, intweight));
        }
        scanner.close();
        return ListOfAll;
    }


    public void BagCounter(List<Long> productsID, int bagCapacity) {
        if (ListOfAll == null || ListOfAll.size() == 0)
            throw new RuntimeException("There is no database loaded to compare products to.");
        if (productsID == null || productsID.size() == 0)
            throw new RuntimeException("There are no products loaded to assign.");
        bags.add(new Bag());
        bags.get(0).setBagLoad(bagCapacity);

        Optional.ofNullable(productsID)
                .orElseThrow(IllegalArgumentException::new)
                .stream()
                .forEach(ID -> {
                    Products currentProduct = ListOfAll.stream()
                            .filter(product -> product.getID() == ID)
                            .findAny()
                            .orElseThrow(() -> new RuntimeException("Product with ID = " + ID + " not found inside product list."));

                    for (int i = 0; i < bags.size(); i++) {
                        bags.get(i).setBagLoad(bagCapacity);
                        if (bags.get(i).getBagLoad() >=
                                bags.get(i).getWeightOfProductsInside() + currentProduct.getWeight()) {

                            bags.get(i).addNewProduct(currentProduct);
                            break;
                        } else if ((i+1) == bags.size()){
                            bags.add(new Bag());
                        } else if (bags.get(i).getBagLoad() < currentProduct.getWeight()){
                            bags.get(i).addNewProduct(currentProduct);
                            break;
                        }
                    }
                });
    }

    public void printResults() {
        System.out.println("For this order, You should prepare " + bags.size() + " bags.");
        for (int i = 0; i < bags.size(); i++) {
            System.out.println("Bag number " + (i+1) + " should contain: \n" + bags.get(i).toString());
        }
    }

    public long CheckBags() {
        return bags.size();
    }


}