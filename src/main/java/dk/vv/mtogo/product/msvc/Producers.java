package dk.vv.mtogo.product.msvc;

import dk.vv.mtogo.product.msvc.repositories.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

@ApplicationScoped
public class Producers {

    @Produces
    @Named("productRepo")
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

}
