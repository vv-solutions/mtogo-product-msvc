package dk.vv.mtogo.product.msvc.repositories;

import dk.vv.mtogo.product.msvc.pojos.Product;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@QuarkusTest
public class ProductRepositoryTest {

    @Inject
    ProductRepository productRepository;


    @Inject
    protected Flyway flyway;

    @BeforeEach
    public void before() {
        flyway.migrate();
    }


    @AfterEach
    public void restoreDatabase() {
        flyway.clean();
    }

    @Test
//    @TestTransaction
    @Transactional
    void canInsertDbRecords() {

        Product product = new Product();

        product.setSupplierId(1);

        product.setProductName("Test");

        productRepository.persist(product);

        Assertions.assertTrue(product.getId() > 0);
    }

    @Test
    @Transactional
    void canQueryDbRecords() {

        var list = productRepository.listAll();

        Assertions.assertEquals(11, list.size());
    }
}
