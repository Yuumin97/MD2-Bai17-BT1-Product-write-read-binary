package rikkei.academy.service;

import rikkei.academy.config.Config;
import rikkei.academy.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceMPL implements IProductService {
    public static final String PATH_PRODUCT = "D:\\MD2\\Bai17\\BT1\\BT1\\src\\rikkei\\academy\\database\\product.txt";
    public static List<Product> productList = new Config<Product>().readFile(PATH_PRODUCT);


    @Override
    public List findAll() {
        new Config<Product>().writeFile(PATH_PRODUCT,productList);
        return productList;
    }

    @Override
    public void save(Object o) {
        productList.add((Product) o);

    }

    @Override
    public List<Product> findById(int idProduct) {
        List<Product> products =new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (idProduct == productList.get(i).getId()){
                products.add(productList.get(i));
            }

        }
        return products;
    }

}
