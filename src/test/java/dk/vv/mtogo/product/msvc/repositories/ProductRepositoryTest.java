package dk.vv.mtogo.product.msvc.repositories;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import dk.vv.mtogo.product.msvc.pojos.Product;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@QuarkusTest
@QuarkusTestResource(value = ProductRepositoryTestResource.class, restrictToAnnotatedClass = true)
public class ProductRepositoryTest {

    @Inject
    @Named("productRepo")
    ProductRepository productRepository;

    @Inject
    EntityManager entityManager;

    @Test
    @Transactional
    void canQueryDbRecords() {
        var list = productRepository.listAll();


        Assertions.assertEquals(11, list.size());
    }
}
