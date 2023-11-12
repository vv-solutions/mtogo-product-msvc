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
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static dk.vv.mtogo.product.msvc.api.ExamplePayloads.NEW_PRODUCTS;

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
    @RequestBody(
            required = true,
            content = @Content(
                    schema = @Schema(implementation = ProductDTO.class, required = true, requiredProperties = {"productName", "description", "grossPrice", "supplierId"}),
                    examples = @ExampleObject(
                            name = "Product",
                            value = NEW_PRODUCTS,
                            summary = "Product",
                            description = "Product"
                    )
            ))
    @Operation(summary = "Create products", description = "Create products by sending a list of products")
    public Response createProducts(List<ProductDTO> productDTOS) {

        //Convert DTOs to products
        List<Product> products = productDTOS.stream().map(Product::new).collect(Collectors.toList());

        //Set net prices on products
        products.forEach(Product::createNetPrice);

        //Persist products
        productRepository.persist(products);


        return Response.ok().status(201).build();
    }

}
