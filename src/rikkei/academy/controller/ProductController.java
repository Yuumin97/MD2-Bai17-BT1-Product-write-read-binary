package rikkei.academy.controller;

import rikkei.academy.model.Product;
import rikkei.academy.service.IProductService;
import rikkei.academy.service.ProductServiceMPL;

import java.util.List;

public class ProductController {
    public IProductService productService = new ProductServiceMPL();
    public List<Product> showProduct(){
        return productService.findAll();
    }
    public void createProduct(Product product){
        productService.save(product);
    }
}
