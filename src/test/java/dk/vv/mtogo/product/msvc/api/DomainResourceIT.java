package dk.vv.mtogo.product.msvc.api;

import dk.vv.mtogo.product.msvc.dtos.ProductDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
class DomainResourceIT {

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
    void when_getting_list_of_products_with_supplier_id_1_status_code_should_be_200_and_size_of_list_should_be_4(){

        //ACT
        List<ProductDTO> products = given().when()
                .get("/api/product/1")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("",ProductDTO.class);

        // ASSERT
        Assertions.assertEquals(4,products.size());


    }


    @Test
    void when_getting_list_of_4_product_ids_then_status_code_should_be_200_and_size_of_list_should_be_4(){

        List<Integer> ids = List.of(1,2,3,4);

        //ACT
        List<ProductDTO> products = given()
                .contentType(ContentType.JSON)
                .body(ids)
                    .when()
                    .post("/api/product")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract()
                    .body()
                    .jsonPath()
                    .getList("",ProductDTO.class);

        // ASSERT
        Assertions.assertEquals(4,products.size());


    }
}