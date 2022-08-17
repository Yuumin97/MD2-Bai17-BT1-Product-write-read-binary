package rikkei.academy.service;

import rikkei.academy.model.Product;

import java.util.List;

public interface IProductService<T> {
    List<T> findAll();
    void save(T t);
    List<Product> findById(int id);
}
