package br.com.vinipaes.model;

public class Product {

    private String nome;
    private int id;
    private String categoria;
    private double preco;
    private int quantidadeEstoque;

    public Product(String nome, int id, String categoria, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.id = id;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            return;
        }
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco <= 0){
            return;
        }

        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if(quantidadeEstoque < 0){
            return;
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String exibir() {
        return String.format(
                "ID: %d | Nome: %s | Categoria: %s | Preco: R$ %.2f | Estoque: %d",
                id,
                nome,
                categoria,
                preco,
                quantidadeEstoque
        );
    }

    @Override
    public String toString() {
        return exibir();
    }
}
