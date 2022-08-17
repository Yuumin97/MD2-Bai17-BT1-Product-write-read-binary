package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.ProductController;
import rikkei.academy.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ViewProduct {
    public static ProductController productController = new ProductController();
    public static List<Product> productList = productController.showProduct();
    public static void main(String[] args) {
        System.out.println("======= WELCOME ========");
        System.out.println("1. Create Product");
        System.out.println("2. Show list Product");
        System.out.println("3. Search Product ");
        int chooseMenu = Config.scanner().nextInt();
        switch (chooseMenu){
            case 1:
                formCreateProduct();
                break;
            case 2:
                formShowListProduct();
                break;
            case 3:
                selectProduct(productList);
                break;
        }

    }
    private static void formCreateProduct(){
        System.out.println("==========CREATE PRODUCT==========");
        int idProduct;
        if (productList.size()==0){
            idProduct =1;
        }else {
            idProduct = productList.get(productList.size()-1).getId()+1;
        }
        System.out.println("Enter the name Product");
        String name = Config.scanner().nextLine();
        System.out.println("Enter the country Product");
        String country = Config.scanner().nextLine();
        System.out.println("Enter the price Product");
        int price = Config.scanner().nextInt();
        List<Product> productList = new ArrayList<>();

        Product product = new Product(idProduct, name, country, price);
        productController.createProduct(product);
        productController.showProduct();
        System.out.println("CREATE PRODUCT SUCCESS!");
        formShowListProduct();

    }
    private static List<Product> selectProduct(List<Product> listSelect){
        System.out.println("========ID=========Name=========Country========Price======");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println("====="+productList.get(i).getId()+"========"+productList.get(i).getName()+"====="+productList.get(i).getCountry()
            +"======="+productList.get(i).getPrice()+"=======");
        }
        System.out.println("Enter id of product to select: ");
        int idProduct = Config.scanner().nextInt();
        System.out.println("Enter eny key to continue - Enter quit to exit select Singer");
        String exitSelect = Config.scanner().nextLine();
        if (exitSelect.equalsIgnoreCase("quit")){
            return listSelect;
        }else {
            selectProduct(listSelect);
        }
        return listSelect;
    }
    private static void formShowListProduct(){
        showListProduct();
        System.out.println("Enter any key to continue - Enter quit to exit select Singer");
        String exitSelect = Config.scanner().nextLine();
        if (exitSelect.equalsIgnoreCase("quit")){
            new ViewProduct();
        }
    }

    private static void showListProduct(){
        System.out.println("======ID======NAME======COUNTRY========PRICE========");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println("===="+productList.get(i).getId()+"===="+productList.get(i).getName()+"===="+productList.get(i).getCountry()
                    +"===="+productList.get(i).getPrice()+"=====");
        }

    }
}