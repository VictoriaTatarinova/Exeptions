package ru.netology.ProductManagerJava;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {

        return product.getName().contains(search);
    }

    public void removeById(int id) {
        if (repository.findById(id) == null) {
            throw new NotFoundException("Товара с id " + id + " нет в репозитории");
        } else {
            repository.removeById(id);
        }
     }

}





