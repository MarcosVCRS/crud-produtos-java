package br.com.vinipaes;

import br.com.vinipaes.exception.ProductInvalidException;
import br.com.vinipaes.exception.ProductNotFoundException;
import br.com.vinipaes.model.Product;
import br.com.vinipaes.repository.ProductRepository;
import br.com.vinipaes.service.ProductService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRepository repository = new ProductRepository();
        ProductService service = new ProductService(repository);

        int option = -1;

        while (option != 0) {
            showMenu();
            option = readInt(scanner, "Escolha uma opcao: ");

            switch (option) {
                case 1:
                    registerProduct(scanner, service);
                    break;
                case 2:
                    service.listAllProducts();
                    break;
                case 3:
                    searchProduct(scanner, service);
                    break;
                case 4:
                    updateProductPrice(scanner, service);
                    break;
                case 5:
                    deleteProduct(scanner, service);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("===== CRUD DE PRODUTOS =====");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar todos os produtos");
        System.out.println("3 - Buscar produto por ID");
        System.out.println("4 - Atualizar preco");
        System.out.println("5 - Deletar produto");
        System.out.println("0 - Sair");
        System.out.println("============================");
    }

    private static void registerProduct(Scanner scanner, ProductService service) {
        try {
            int id = readInt(scanner, "ID: ");
            scanner.nextLine();

            System.out.print("Nome: ");
            String name = scanner.nextLine();

            System.out.print("Categoria: ");
            String category = scanner.nextLine();

            double price = readDouble(scanner, "Preco: ");
            int stockQuantity = readInt(scanner, "Quantidade em estoque: ");

            Product product = new Product(name, id, category, price, stockQuantity);
            service.createProduct(product);

            System.out.println("Produto cadastrado com sucesso.");
        } catch (ProductInvalidException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    private static void searchProduct(Scanner scanner, ProductService service) {
        try {
            int id = readInt(scanner, "Informe o ID do produto: ");
            Product product = service.searchProduct(id);
            System.out.println(product.exibir());
        } catch (ProductNotFoundException e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
    }

    private static void updateProductPrice(Scanner scanner, ProductService service) {
        try {
            int id = readInt(scanner, "Informe o ID do produto: ");
            double newPrice = readDouble(scanner, "Informe o novo preco: ");

            service.updatePrice(id, newPrice);

            System.out.println("Preco atualizado com sucesso.");
        } catch (ProductNotFoundException | ProductInvalidException e) {
            System.out.println("Erro ao atualizar preco: " + e.getMessage());
        }
    }

    private static void deleteProduct(Scanner scanner, ProductService service) {
        try {
            int id = readInt(scanner, "Informe o ID do produto: ");
            service.delete(id);

            System.out.println("Produto deletado com sucesso.");
        } catch (ProductNotFoundException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
    }

    private static int readInt(Scanner scanner, String message) {
        System.out.print(message);

        while (!scanner.hasNextInt()) {
            System.out.println("Valor invalido. Digite um numero inteiro.");
            scanner.next();
            System.out.print(message);
        }

        return scanner.nextInt();
    }

    private static double readDouble(Scanner scanner, String message) {
        System.out.print(message);

        while (true) {
            String value = scanner.next().replace(",", ".");

            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero decimal.");
                System.out.print(message);
            }
        }
    }
}
