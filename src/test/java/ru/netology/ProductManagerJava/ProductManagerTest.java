package ru.netology.ProductManagerJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Death on the Nile", 3, "Agatha Christie");
    Product book1 = new Book(2, "The hound of the Baskervilles", 450, "Arthur Conan Doyle");
    Product smartphone = new Smartphone(3, "iPhone 12", 30_000, "Apple");
    Product book3 = new Book(3, "The girl with the dragon tattoo", 0, "Stieg Larsson");
    Product book4 = new Book(7, "Death on the Orient Express", 700, "Agatha Christie");

    @BeforeEach
    public void SetUp() {
        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);
        manager.add(book3);
        manager.add(book4);
    }


    @Test
    void shouldDeleteFoundProduct() {
        manager.removeById(1);
    }

    @Test
    void shouldNotDeleteNotFoundProduct() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.removeById(-1);
        });

    }

    @Test
    public void shouldFindAll() {

        Product[] expected = new Product[]{book, book1, smartphone, book3, book4};
        Product[] actual = manager.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
