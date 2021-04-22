package autoframework.pages.backEnd;

import autoframework.pages.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CartPriceRulePage extends CommonPage {
    String discardSubsequentRules = "div[data-index=\"stop_rules_processing\"] div.admin__actions-switch";
    public void createADiscountRule(String rule) {
        clickButtonByclass("add");
        insertIntoFieldByName("testDiscount","name");
        getDriver().findElement(By.name("website_ids")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        getDriver().findElement(By.name("customer_group_ids")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        insertIntoFieldByName(rule,"discount_amount");
        scrollToAndClick(discardSubsequentRules);
        clickButtonByclass("save");
    }
}
