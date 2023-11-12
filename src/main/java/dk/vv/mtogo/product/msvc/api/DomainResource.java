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
    public List<ProductDTO> list(@PathParam("supplierId") int supplierId ) {
        return productRepository.getBySupplierId(supplierId);
    }
//    @GET
//    @Path("/{supplierId}")
//    public Response list(@PathParam("supplierId") int supplierId ) {
//        return Response.ok(productRepository.getBySupplierId(supplierId)).status(200).build();
//    }
}
