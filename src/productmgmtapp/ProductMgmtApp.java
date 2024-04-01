package productmgmtapp;


import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {

    public static void main(String[] args) {
        Product[] products = {
                new Product(128874119, "Banana", "2023-01-24", 124, 0.55),
                new Product(927458265, "Apple", "2022-12-09", 18, 1.09),
                new Product(189927460, "Carrot", "2023-03-31", 89, 2.99)
        };

        printProducts(products);
    }

    private static void printProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getName));

        // Print products in JSON format
        System.out.println("Products in JSON format:");
        System.out.println("[");

        for (Product product : products) {
            System.out.println("\t{");
            System.out.println("\t\t\"productId\": " + product.getProductId() + ",");
            System.out.println("\t\t\"name\": \"" + product.getName() + "\",");
            System.out.println("\t\t\"dateSupplied\": \"" + product.getDateSupplied() + "\",");
            System.out.println("\t\t\"quantityInStock\": " + product.getQuantityInStock() + ",");
            System.out.println("\t\t\"unitPrice\": " + product.getUnitPrice());
            System.out.println("\t},");
        }

        System.out.println("]");

        // Print products in XML format
        System.out.println("\nProducts in XML format:");
        System.out.println("<Products>");

        for (Product product : products) {
            System.out.println("\t<Product>");
            System.out.println("\t\t<productId>" + product.getProductId() + "</productId>");
            System.out.println("\t\t<name>" + product.getName() + "</name>");
            System.out.println("\t\t<dateSupplied>" + product.getDateSupplied() + "</dateSupplied>");
            System.out.println("\t\t<quantityInStock>" + product.getQuantityInStock() + "</quantityInStock>");
            System.out.println("\t\t<unitPrice>" + product.getUnitPrice() + "</unitPrice>");
            System.out.println("\t</Product>");
        }

        System.out.println("</Products>");

        // Print products in CSV format
        System.out.println("\nProducts in CSV format:");
        System.out.println("productId,name,dateSupplied,quantityInStock,unitPrice");

        for (Product product : products) {
            System.out.println(product.getProductId() + "," + product.getName() + "," +
                    product.getDateSupplied() + "," + product.getQuantityInStock() + "," +
                    product.getUnitPrice());
        }
    }
}
