package rikkei.academy.service;

import java.util.List;

public interface IProductService<T> {
    List<T> findAll();
    void save(T t);
    T findAll(int id);
}
