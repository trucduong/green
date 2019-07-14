package com.green.sale.dao;

import java.util.ArrayList;
import java.util.List;

import com.green.sale.entity.Product;

public class ProductDao {
    public Product find(int code) {
        return null;
    }

    public List<Product> findAll() {
        // học viên thực hiện phần này
        List<Product> list = new ArrayList<>();

        return list;
    }
    
    public List<Product> findByCategory(int categoryCode) {
        // học viên thực hiện phần này
        List<Product> list = new ArrayList<>();

        return list;
    }
    
    public List<Product> findByNameAndCategory(String name, Integer category) {
        List<Product> list = new ArrayList<>();

        // học viên thực hiện phần này
        // tìm gần đúng theo product name và tìm chính xác theo category
        // ... where name like %<name>% and category_code = <category>
        
        // Lưu lý: kiểm tra biến "name" và "category" để tạo câu truy vấn phù hợp  
        
        return list;
    }

    public boolean insert(Product product) {
        // học viên thực hiện phần này
        boolean result = false;

        return result;
    }

    public boolean update(int code, Product product) {
        // học viên thực hiện phần này
        boolean result = false;

        return result;
    }

    public boolean delete(int code) {
        // học viên thực hiện phần này
        boolean result = false;

        return result;
    }
}
