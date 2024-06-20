package org.example.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends BasePage {
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnOpenNewAccountLink() {
        WebElement openNewAccountLink = driver.findElement(By.xpath("//*[@href=\"openaccount.htm\"]"));
        openNewAccountLink.click();
    }

    public void selectTypeOfAccount(String text) {
        WebElement accountType = driver.findElement(By.xpath("//select[@id='type']"));
        Select select = new Select(accountType);
        select.selectByVisibleText(text);
    }

    public void selectFromWhatAccountToTransferMoney(String text) {
        WebElement transferAccount = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
        Select select = new Select(transferAccount);
        select.getFirstSelectedOption();
    }

    public void clickOpenNewAccount() {
        WebElement openNewAccountButton = driver.findElement(By.xpath("//input[@value='Open New Account']"));
        openNewAccountButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String isTextPresent() {
        WebElement text = driver.findElement(By.xpath("//*[@id='openAccountResult']/h1[1]"));
        return text.getText();
    }
}
