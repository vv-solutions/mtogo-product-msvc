package dk.vv.mtogo.product.msvc.pojos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NetPriceStepDefs {
    private Product product = new Product();

    private List<Exception> exceptions;

    @Given("I have a gross price of {bigdecimal}")
    public void iHaveAGrossPriceOf(BigDecimal arg0) {
        exceptions = new ArrayList<>();

        this.product.setGrossPrice(arg0);

    }

    @When("I calculate the net price")
    public void iCalculateTheNetPrice() {
        try{
            this.product.createNetPrice();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }

    @Then("I should get a net price of {bigdecimal}")
    public void iShouldGetANetPriceOf(BigDecimal arg0) {
        Assertions.assertEquals(arg0, this.product.getNetPrice());
    }

    @Then("I should get this error message {string}")
    public void iShouldGetAnErrorMessage(String arg0) {
        Assertions.assertFalse(exceptions.isEmpty());
        Assertions.assertEquals(arg0,exceptions.get(0).getMessage());
    }


}
