package autoframework.steps.backEnd;

import autoframework.pages.backEnd.CartPriceRulePage;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CartPriceRuleStepdefs {
    @Steps
    CartPriceRulePage cartPriceRulePage;
    @When("^Create a \"([^\"]*)\" discount rule$")
    public void createADiscountRule(String rule) throws Throwable {
        cartPriceRulePage.createADiscountRule(rule);
    }

}
