package org.example.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage extends BasePage {
    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTransferFundsLink() {
        WebElement transferFundsLink = driver.findElement(By.xpath("//*[@href=\"transfer.htm\"]"));
        transferFundsLink.click();
    }

    public void transferAmount(String amount) {
        WebElement amountField = driver.findElement(By.xpath("//input[@name=\"input\"]"));
        amountField.sendKeys(amount);
    }

    public void selectFromAccount() {
        WebElement fromAccount = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
        Select selectFromAccount = new Select(fromAccount);
        selectFromAccount.getFirstSelectedOption();
    }

    public void selectToAccount(String account) {
        WebElement toAccount = driver.findElement(By.xpath("//select[@id='toAccountId']"));
        Select selectToAccount = new Select(toAccount);
        selectToAccount.selectByVisibleText(account);
    }

    public void clickTransfer() {
        WebElement transferButton = driver.findElement(By.xpath("//input[@value=\"Transfer\"]"));
        transferButton.click();
    }

    public void waitForConfirmationMessage(String expectedMessage, int timeout){
        seleniumUtils.waitForElementText(By.xpath("//h1[normalize-space()='Transfer Complete!']"), "Transfer Complete!", 10);
    }

    public String isTextPresent() {
        WebElement text = driver.findElement(By.xpath("//h1[normalize-space()='Transfer Complete!']"));
        return text.getText();
    }
}
