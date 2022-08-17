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
        new ViewProduct();
    }
    ViewProduct(){
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
                formSearchProduct();
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
        showListProduct();
        System.out.println("Enter quit to exit");
        String exitSelect = Config.scanner().nextLine();
        if (exitSelect.equalsIgnoreCase("quit")){
            new ViewProduct();
        }
    }
    private static void formShowListProduct(){
        showListProduct();
        System.out.println("Enter quit to exit");
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
    private static void formSearchProduct(){
        System.out.println("Enter ID Product");
        int idProduct = Config.scanner().nextInt();
        List<Product> products = productController.searchProduct(idProduct);
        if (productController.searchProduct(idProduct) != null){
            System.out.println("ID doesn't not exist");
            System.out.println("Enter quit to exit");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")){
                new ViewProduct();
            }
        }else {
            System.out.println("======ID======NAME======COUNTRY========PRICE=======");
            for (int i = 0; i < products.size(); i++) {
                System.out.println("===="+products.get(i).getId()+"===="+products.get(i).getName()+"===="+products.get(i).getCountry()
                        +"===="+products.get(i).getPrice()+"=====");
                productController.showProduct();
            }
            System.out.println("Enter quit to exit");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")){
                new ViewProduct();
            }
        }

    }
}