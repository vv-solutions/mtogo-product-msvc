package dk.vv.mtogo.product.msvc.repositories;


import dk.vv.common.data.transfer.objects.product.ProductDTO;
import dk.vv.mtogo.product.msvc.pojos.Product;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;


public class ProductRepository implements PanacheRepository<Product> {

    public List<ProductDTO> getBySupplierId(int supplierId) {
        return find("select p from Product p where p.supplierId = ?1 ",supplierId)
                .list()
                .stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
    }

}
