package dk.vv.mtogo.product.msvc.repositories;

import dk.vv.mtogo.product.msvc.pojos.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}
