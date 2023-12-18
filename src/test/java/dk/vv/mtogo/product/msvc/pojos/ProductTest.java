package dk.vv.mtogo.product.msvc.pojos;

import io.cucumber.java.en.Given;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@QuarkusTest
public class ProductTest {



    @Test
    void when_net_price_is_100_then_gross_price_should_be_125() {

        // ARRANGE
        Product product = new Product();
        product.setNetPrice(BigDecimal.valueOf(100));
        // ACT
        product.createGrossPrice();

        // ASSERT
        Assertions.assertEquals(BigDecimal.valueOf(125.00).setScale(2), product.getGrossPrice());
}



    @Test
    void when_net_price_is_50_then_gross_price_should_be_62_point_5() {

        // ARRANGE
        Product product = new Product();
        product.setNetPrice(BigDecimal.valueOf(50));
        // ACT
        product.createGrossPrice();

        // ASSERT
        Assertions.assertEquals(BigDecimal.valueOf(62.50).setScale(2), product.getGrossPrice());
    }

    @Test
    void when_net_price_is_999_then_gross_price_should_be_1248_point_75() {

        // ARRANGE
        Product product = new Product();
        product.setNetPrice(BigDecimal.valueOf(999));
        // ACT
        product.createGrossPrice();

        // ASSERT
        Assertions.assertEquals(BigDecimal.valueOf(1248.75), product.getGrossPrice());
    }


    @Test
    void when_net_price_is_100_point_5_then_gross_price_should_be_125_point_63() {

        // ARRANGE
        Product product = new Product();
        product.setNetPrice(BigDecimal.valueOf(100.5));
        // ACT
        product.createGrossPrice();

        // ASSERT
        Assertions.assertEquals(BigDecimal.valueOf(125.63), product.getGrossPrice());
    }

    @Test
    void when_net_price_is_50_point_7_then_gross_price_should_be_63_point_38() {

        // ARRANGE
        Product product = new Product();
        product.setNetPrice(BigDecimal.valueOf(50.7));
        // ACT
        product.createGrossPrice();

        // ASSERT
        Assertions.assertEquals(BigDecimal.valueOf(63.38), product.getGrossPrice());
    }

    @Test
    void when_net_price_is_999_point_9_then_gross_price_should_be_1249_point_88() {

        // ARRANGE
        Product product = new Product();
        product.setNetPrice(BigDecimal.valueOf(999.9));
        // ACT
        product.createGrossPrice();

        // ASSERT
        Assertions.assertEquals(BigDecimal.valueOf(1249.88), product.getGrossPrice());
    }


    @Test
    void when_net_price_is_minus_100_then_an_error_should_be_thrown() {

        // ARRANGE
        Product product = new Product();
        product.setNetPrice(BigDecimal.valueOf(-100));


        // ACT
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, product::createGrossPrice);


        // ASSERT
        Assertions.assertEquals( "Net price must be zero or greater",exception.getMessage());
    }

     @Test
     void when_net_price_is_minus_100_point_5_then_an_error_should_be_thrown() {
         // ARRANGE
         Product product = new Product();
         product.setNetPrice(BigDecimal.valueOf(-100.5));

         // ACT
         Exception exception = Assertions.assertThrows(IllegalArgumentException.class, product::createGrossPrice);

        // ASSERT
        Assertions.assertEquals("Net price must be zero or greater", exception.getMessage());
     }


     @Test
    void when_net_price_is_0_point_0_then_gross_price_should_be_0_point_0() {

        // ARRANGE
        Product product = new Product();
        product.setNetPrice(BigDecimal.valueOf(0.0));
        // ACT
        product.createGrossPrice();

        // ASSERT
        Assertions.assertEquals(BigDecimal.valueOf(0.00).setScale(2), product.getGrossPrice());
    }



}
