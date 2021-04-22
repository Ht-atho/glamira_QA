package autoframework.steps.backEnd;

import autoframework.pages.backEnd.ProductionRequestPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProductionRequestStepdefs {
    @Steps
    ProductionRequestPage productionRequestPage;
    @And("^Filter items match pre-condition for starting pProduction$")
    public void filterItemsMatchPreConditionForStartingPProduction() {
        productionRequestPage.filterItemsMatchPreConditionForStartingPProduction();
    }
    @And("^Take action Start production$")
    public void takeActionStartProduction() {
        productionRequestPage.takeActionStartProduction();

    }

    @And("^Click on Create for in stock items button$")
    public void clickOnCreateForInStockItemsButton() {
        productionRequestPage.clickOnCreateForInStockItemsButton();
    }



    @And("^Input information \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" then click Save$")
    public void inputInformationThenClickSave(String itemQty, String itemSKU, String itemName, String price){
        productionRequestPage.inputInformationThenClickSave(itemQty, itemSKU, itemName, price);
    }

    @When("^Enter \"([^\"]*)\" to scan barcode box$")
    public void enterToScanBarcodeBox(String barcode){
        productionRequestPage.enterToScanBarcodeBox(barcode);
    }

    @And("^Choose the item$")
    public void chooseTheItem() {
        productionRequestPage.chooseTheItem();
    }

    @And("^Take action \"([^\"]*)\"$")
    public void takeAction(String action) {
        productionRequestPage.takeAction(action);
    }
}
