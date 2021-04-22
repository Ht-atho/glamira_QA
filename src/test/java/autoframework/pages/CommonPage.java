package autoframework.pages;

import autoframework.service.TestDataService;
import junit.framework.TestCase;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class CommonPage extends PageObject {
    public static WebDriver driver;
    By msgItem = By.cssSelector(".page.messages");
    By cookieAccept = By.className("m-accept");


    public void waitAboutSeconds(int second)  {
        try {
            Thread.sleep(second * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    boolean isElementPresent(WebElement element, int timeout){
        WebDriverWait wait;
        try{
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public void loginAdminPageWithAnd(String Page, String account, String password) {
        this.gotoUrl(Page);
        insertIntoField(account,"#username");
        insertIntoField(password,"#login");
        clickButtonByclass("action-login");
    }
    public void iClickButtonHasText(String buttontext) {
        ArrayList<WebElement> List = new ArrayList<>(getDriver().findElements(By.className("header-panel-right")));
        ArrayList<WebElement> list = new ArrayList<>(getDriver().findElements(By.className("header-content-wrap")));
        ArrayList<WebElement> listButtonAdmin = new ArrayList<>(getDriver().findElements(By.className("action-default")));
        ArrayList<WebElement> listButtonHomePage = new ArrayList<>(getDriver().findElements(By.className("authorization-text")));

        ArrayList<WebElement> bigList = new ArrayList<>();
        bigList.addAll(list);
        bigList.addAll(List);
        bigList.addAll(listButtonAdmin);

        for (WebElement webElement : bigList) {
            if (webElement.getText().equalsIgnoreCase(buttontext)) {
                System.out.println("Click button nay: " + webElement.getText());
                webElement.click();
                break;
            }
        }
    }
    public void clickButtonById(String idButton) {
        String idElement = TestDataService.properties.getProperty(idButton);
        if (idElement == null) {
            idElement = idButton;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.id(idElement));
        Element.click();
    }
    public void clickButtonByclass(String classButton) {
        String classElement = TestDataService.properties.getProperty(classButton);
        if (classElement == null) {
            classElement = classButton;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.className(classElement));
        Element.click();
        System.out.println("click button has classname: "+classButton);

    }

    public void waitUntilDisplayButtonHasText(String buttontext) {
        ArrayList<WebElement> headerPanelRightBtnList = new ArrayList<>(getDriver().findElements(By.className("header-panel-right")));
        for (WebElement webElement : headerPanelRightBtnList) {
            if (webElement.getText().equalsIgnoreCase(buttontext)) {
                System.out.println(buttontext + " is displayed");
                System.out.println("click Place Order");
            }
        }
    }
    public void waitUntilDisplayElementByXpath(String element) {
        String xpathElement = TestDataService.properties.getProperty(element);
        if (xpathElement == null) {
            xpathElement = element;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathElement)));
    }
    public void clickButtonByXpath(String xpathButton) {
        String xpathElement = TestDataService.properties.getProperty(xpathButton);
        if (xpathElement == null) {
            xpathElement = xpathButton;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.xpath(xpathElement));
        Element.click();
    }
    public void insertIntoFieldByXpath(String text, String xpath) {
        String xpathElement = TestDataService.properties.getProperty(xpath);
        if (xpathElement == null) {
            xpathElement = xpath;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = driver.findElement(By.xpath(xpathElement));
        Element.click();
        Element.sendKeys(text);
    }
    public void insertIntoFieldById(String text, String id) {
        String textInsert = TestDataService.properties.getProperty(text);
        if (textInsert == null) {
            textInsert = text;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.id(id));
        Element.click();
        System.out.println(" Insert "+ text+ " into " + id);
        Element.sendKeys(textInsert);
    }
    public void insertIntoFieldByName(String text, String name) {
        String insertText = TestDataService.properties.getProperty(text);
        if (insertText == null) {
            insertText = text;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.name(name));
        Element.sendKeys(insertText);
        System.out.println(" Insert: "+ text+ ", into field : " + name);
    }
    public void gotoUrl(String url) {
        String urlInPro = TestDataService.properties.getProperty(url);
        if (urlInPro == null) {
            urlInPro = url;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().get(urlInPro);
        System.out.println("go to the " + urlInPro);
//        Alert alert = driver.switchTo().alert();
//        alert.accept();

    }
    public void checkURl(String expectUrl)  {

        String ExpectUrl = TestDataService.properties.getProperty(expectUrl);
        if (ExpectUrl == null) {
            ExpectUrl = expectUrl;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(ExpectUrl, getDriver().getCurrentUrl());
    }

    public void getMsgItem(String expectMsg){
        System.out.println("show actual msg:" +getDriver().findElement(msgItem).getText());
        Assert.assertEquals(expectMsg,getDriver().findElement(msgItem).getText());
    }
    public void acceptCookie(){
        getDriver().findElement(cookieAccept).click();
    }

    public void showErrorMessageForBlankById(String id, String msg) {
        WebElement Element = getDriver().findElement(By.id(id));
        System.out.println("show message: "+ Element.getText());
        Assert.assertEquals(msg,Element.getText());

    }
    public void showErrorMessageForBlankByClass(String clname, String msg) {
        String clnameElement = TestDataService.properties.getProperty(clname);
        if (clnameElement == null) {
            clnameElement = clname;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.className(clnameElement));
        System.out.println("show message: "+ Element.getText());
        Assert.assertEquals(msg,Element.getText());

    }
    public void waitAboutSecond(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void click(String button) {
        System.out.println("check ");
        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            System.out.println("check2");
            cssSelector = button;
            System.out.println(cssSelector);
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebDriverWait waiter = new WebDriverWait(getDriver(), 15);
        WebElement el = waiter.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        el.click();
        System.out.println("clicked");
        waitAboutSecond(3);
    }
    public void insertIntoField(String text, String fieldName) {
        String cssSelector = TestDataService.properties.getProperty(fieldName);
        String inputTxt = TestDataService.properties.getProperty(text);
        if (cssSelector == null) {
            cssSelector = fieldName;
        }
        if (inputTxt == null) {
            inputTxt = text;
        }
        WebDriverWait wait = new WebDriverWait(getDriver(),15);
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
        el.clear();
        el.sendKeys(inputTxt);
//        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(inputTxt);
        System.out.println("Insert "+ text + " into "+fieldName);
    }
    public void scrollToAndClick(String button) {
        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            cssSelector = button;
        }
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebElement Element = getDriver().findElement(By.cssSelector(cssSelector));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", Element);
        Element.click();
        System.out.println("scroll and click button"+ button);
    }
    public void assertMsg (String expectedMsg, String msgLocator){
        String expectedMess = TestDataService.properties.getProperty(expectedMsg);
        if (expectedMess == null){
            expectedMess = expectedMsg;
        }
        String msglct = TestDataService.properties.getProperty(msgLocator);
        if (msglct == null){
            msglct = msgLocator;
        }
        assertEquals(expectedMess, getDriver().findElement(By.cssSelector(msglct)).getText());
    }
    public void redirectToLink(String url) {
        String urlName = TestDataService.properties.getProperty(url);
        if (urlName == null) {
            urlName = url;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String realUrl = getDriver().getCurrentUrl();
        assertEquals(urlName, realUrl);
    }
    public void selectOption(String element, String selectObject){
        String elCssSelector = TestDataService.properties.getProperty(element);
        if (elCssSelector == null) {
            elCssSelector = element;
        }
        String selectedText = TestDataService.properties.getProperty(selectObject);
        if (selectedText == null) {
            selectedText = selectObject;
        }
        Select selector = new Select(getDriver().findElement(By.cssSelector(elCssSelector)));
        selector.selectByValue(selectedText);
        System.out.println("Click on button " + element);
        System.out.println("Then select " + selectObject);


    }
    public void validateInformation(String element, String expectedInfo) {

        String cssSelector = TestDataService.properties.getProperty(element);
        if (cssSelector == null){
            cssSelector = element;
        }
        String expectedText = TestDataService.properties.getProperty(expectedInfo);
        if (expectedText == null) {
            expectedText = expectedInfo;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement el = getDriver().findElement(By.cssSelector(cssSelector));
        String actualInfo = el.getText();


        if (actualInfo == null) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
            actualInfo = javascriptExecutor.executeScript("return arguments[0].value", el).toString();;

        }
        System.out.println(el);
        System.out.println(el.isDisplayed());
        System.out.println(actualInfo);
        System.out.println(expectedText);
        boolean validation = actualInfo.toLowerCase().contains(expectedText.toLowerCase());
        assertEquals(true, validation);


//        assertEquals(expectedText.toLowerCase(), actualInfo.toLowerCase());



    }
    public void hoverThenClickOn(String arg0, String arg1) {
        String elToHoverLocator = TestDataService.properties.getProperty(arg0);
        if (elToHoverLocator == null) {
            elToHoverLocator = arg0;
        }
        String elToClickLocator = TestDataService.properties.getProperty(arg1);
        if (elToClickLocator == null) {
            elToClickLocator = arg1;
        }


        WebElement elToHover = getDriver().findElement(By.cssSelector(elToHoverLocator));

        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";


        ((JavascriptExecutor) getDriver()).executeScript(javaScript, elToHover);

        WebElement elToClick = getDriver().findElement(By.cssSelector(elToClickLocator));


        ((JavascriptExecutor) getDriver()).executeScript(javaScript, elToClick);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        elToClick.click();


    }
    public void waitUntilElementDisapear(String arg0) {
        String elCSSlocator = TestDataService.properties.getProperty(arg0);
        if (elCSSlocator == null) {
            elCSSlocator = arg0;
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(elCSSlocator)));
        System.out.println("check wait element disapear");


    }
    String theFirstItemLocator = "table.data-grid tbody tr:nth-of-type(1) input";
    String loadingMaskLocator = "div.loading-mask";
    String confirmBtnLocator = "div.modal-inner-wrap button.action-accept";
    String messageLocator = "div.messages div div";
    public void chooseAnItem() {
        waitAboutSecond(3);
        waitUntilElementDisapear(loadingMaskLocator);
        getDriver().findElement(By.cssSelector(theFirstItemLocator)).click();
    }
    public void validateResultMsg(String message) {
        validateInformation(messageLocator,message);
    }
    public void InputText(String text, String element){
        String orderID = TestDataService.properties.getProperty(text);
        if (orderID == null) {
            orderID = text;
        }
        String expectedText = TestDataService.properties.getProperty(element);
        if (expectedText == null) {
            expectedText = element;
        }
        getDriver().findElement(By.xpath(element)).clear();

        getDriver().findElement(By.xpath(element)).sendKeys("\n" + orderID+ Keys.ENTER);
        waitAboutSecond(10);
    }
}




