package br.com.vinipaes.service;

import br.com.vinipaes.exception.ProductInvalidException;
import br.com.vinipaes.exception.ProductNotFoundException;
import br.com.vinipaes.model.Product;
import br.com.vinipaes.repository.ProductRepository;

public class ProductService  {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void createProduct(Product product) throws ProductInvalidException {
        if(product == null) {
            throw new ProductInvalidException("Produto nao pode ser nulo.");
        }

        if(product.getNome() ==  null || product.getNome().isBlank()){
            throw new ProductInvalidException("Nome do produto e obrigatorio.");
        }

        if(product.getPreco() <= 0){
            throw new ProductInvalidException("Preco deve ser maior que zero.");
        }

        if(product.getQuantidadeEstoque()<0){
            throw new ProductInvalidException("Quantidade nao pode ser negativa.");
        }

        repository.save(product);
    }

    public Product searchProduct(int id) throws ProductNotFoundException {
        Product product = this.repository.findById(id);

        if(product == null) {
            throw new ProductNotFoundException("Produto nao encontrado.");
        }
        return product;
    }

    public void listAllProducts(){
        for (Product product : this.repository.findAll()) {
            System.out.println(product.exibir());
        }
    }

    public void updatePrice(int id, double newPrice) throws ProductNotFoundException, ProductInvalidException {

        if(newPrice<=0){
            throw new ProductInvalidException("Preco deve ser maior que zero.");
        }
        Product product = searchProduct(id);
        product.setPreco(newPrice);
        repository.update(product);
    }

    public void delete(int id) throws ProductNotFoundException {
        searchProduct(id);
        repository.delete(id);
    }

}
