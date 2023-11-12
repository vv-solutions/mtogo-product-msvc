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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/api/product")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class DomainResource {

    @Inject
    ProductRepository productRepository;


    public DomainResource(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GET
    @Path("/{supplierId}")
    @Operation(summary = "Get products", description = "Returns a list of products by sending a supplier id")
    public List<ProductDTO> getProductsBySupplierId(@PathParam("supplierId") int supplierId ) {
        return productRepository.getBySupplierId(supplierId);
    }


    @POST
    @Operation(summary = "Get products", description = "Returns a list of products by sending a list of product id's")
    public List<ProductDTO> getProductsById(List<Integer> productIds ) {
        return productIds.stream().map(id -> new ProductDTO(productRepository.findById(Long.valueOf(id)))).collect(Collectors.toList());
    }


//    @GET
//    @Path("/{supplierId}")
//    public Response list(@PathParam("supplierId") int supplierId ) {
//        return Response.ok(productRepository.getBySupplierId(supplierId)).status(200).build();
//    }
}
