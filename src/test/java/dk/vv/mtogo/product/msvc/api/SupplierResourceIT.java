package dk.vv.mtogo.product.msvc.api;

import dk.vv.mtogo.product.msvc.dtos.ProductDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
class SupplierResourceIT {

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
    void when_posting_list_of_products_status_code_should_be_201() {

        // Setup
        ProductDTO productOne = new ProductDTO();
        productOne.setProductName("TestOne");
        productOne.setSupplierId(1);
        productOne.setGrossPrice(BigDecimal.valueOf(100));

        ProductDTO productTwo = new ProductDTO();
        productTwo.setProductName("TestTwo");
        productTwo.setSupplierId(1);
        productTwo.setGrossPrice(BigDecimal.valueOf(200));

        List<ProductDTO> products = List.of(productOne, productTwo);

        // ACT
        given().contentType(ContentType.JSON)
                .body(products)
                .when()
                .post("/api/supplier")

        // ASSERT
                .then()
                .assertThat()
                .statusCode(201);
    }
}