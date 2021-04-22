package autoframework.steps;

//import autoTest.pages.CommonPage_L;
import autoframework.pages.CommonPage;
import autoframework.pages.CommonPageL;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CommonStepdefs_L {
    @Steps
    CommonPage nia;
    @When("^Click on \"([^\"]*)\"$")
    public void clickOn(String elLocator)  {
       nia.clickButtonByclass(elLocator);
    }

    @Given("^Go to \"([^\"]*)\"$")
    public void goToUrl(String url) {
        nia.gotoUrl(url);
    }

    @And("^input \"([^\"]*)\" into \"([^\"]*)\"$")
    public void inputInto(String arg0, String arg1) throws Throwable {
        nia.insertIntoField(arg0, arg1);
    }

    @Then("^The \"([^\"]*)\" \"([^\"]*)\" is shown$")
    public void theIsShown(String arg0, String arg1) {
        nia.assertMsg(arg0, arg1);
    }

    @Then("^The site will redirect to \"([^\"]*)\" url$")
    public void theSiteWillRedirectToUrl(String arg0)  {
        nia.redirectToLink(arg0);
    }

    @When("^Click on \"([^\"]*)\" then select \"([^\"]*)\"$")
    public void clickOnThenSelect(String element, String selectObject)  {
        nia.selectOption(element, selectObject);
    }

    @Then("^The \"([^\"]*)\" is \"([^\"]*)\"$")
    public void theIs(String arg0, String arg1) throws Throwable {
        nia.validateInformation(arg0, arg1);
    }

    @Then("^The \"([^\"]*)\" is shown below the \"([^\"]*)\"$")
    public void theIsShownBelowThe(String arg0, String arg1) throws Throwable {
        nia.validateInformation(arg0, arg1);
    }

    @And("^Scroll and click on \"([^\"]*)\"$")
    public void scrollAndClickOn(String arg0) throws Throwable {
        nia.scrollToAndClick(arg0);
    }




    @When("^Move mouse over \"([^\"]*)\" then click on \"([^\"]*)\"$")
    public void moveMouseOverThenClickOn(String arg0, String arg1) throws Throwable {
        nia.hoverThenClickOn(arg0, arg1);
    }


    @And("^Wait until \"([^\"]*)\" disappear then click on \"([^\"]*)\"$")
    public void waitUntilDisappearThenClickOn(String arg0, String arg1) throws Throwable {
        nia.waitUntilElementDisapear(arg0);
        nia.scrollToAndClick(arg1);
    }

    @And("^Choose an item$")
    public void chooseAnItem() {
        nia.chooseAnItem();
    }

    @Then("^The \"([^\"]*)\" Message is shown$")
    public void theMessageIsShown(String message) throws Throwable {
        nia.validateResultMsg(message);
    }

    @Given("^Login \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginWithAnd(String adminPage, String account, String password) throws Throwable {
        nia.loginAdminPageWithAnd(adminPage, account, password);
    }
}

