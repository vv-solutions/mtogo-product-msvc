package dk.vv.mtogo.product.msvc.repositories;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@QuarkusTest
public class ProductRepositoryTest {

    @Inject
    @Named("productRepo")
    ProductRepository productRepository;


    @Test
    @Transactional
    void canQueryDbRecords() {

        var list = productRepository.listAll();

        Assertions.assertEquals(11, list.size());
    }
}
