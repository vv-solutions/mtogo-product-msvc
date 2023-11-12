package dk.vv.mtogo.product.msvc.api;

import dk.vv.mtogo.product.msvc.dtos.ProductDTO;
import dk.vv.mtogo.product.msvc.pojos.Product;
import dk.vv.mtogo.product.msvc.repositories.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/api/supplier")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class SupplierResource {

    @Inject
    ProductRepository productRepository;

    public SupplierResource(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @POST
    @Transactional
    public Response createProduct(List<ProductDTO> productDTOS) {

        //Convert DTOs to products
        List<Product> products = productDTOS.stream().map(Product::new).collect(Collectors.toList());

        //Set net prices on products
        products.forEach(Product::createNetPrice);

        //Persist products
        productRepository.persist(products);


        return Response.ok().status(201).build();
    }

}
