package br.com.vinipaes.repository;

import br.com.vinipaes.model.Product;

import java.util.ArrayList;

public class ProductRepository {

    private ArrayList<Product> products = new ArrayList<>();

    public void save(Product product) {
        products.add(product);
    }

    public ArrayList<Product> findAll(){
        return products;
    }

    public Product findById(int id){
       for(Product p : products){
           if(p.getId() == id){
               return p;
           }
       }
       return null;
    }

    public void delete(int id){
        Product product = findById(id);

        if(product != null){
            products.remove(product);
        }
    }

    public void update(Product product){
        for(int i =0; i <products.size(); i++){
             Product currentProduct = products.get(i);
             if(currentProduct.getId() == product.getId()){
                 products.set(i, product);
                 return;
             }
        }
    }
}
