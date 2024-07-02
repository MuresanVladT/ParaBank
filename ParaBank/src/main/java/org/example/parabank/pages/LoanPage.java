package org.example.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoanPage extends BasePage {
    public LoanPage(WebDriver driver) {
        super(driver);
    }

    public void clickRequestLoanLink(){
        WebElement requestLoanLink = driver.findElement(By.xpath("//*[@href=\"requestloan.htm\"]"));
        requestLoanLink.click();
    }

    public void enterLoanAmount(String loanAmount){
        WebElement loanAmountField = driver.findElement(By.xpath("//*[@id='amount']"));
        loanAmountField.sendKeys(loanAmount);
    }

    public void enterDownPayment(String downPayment){
        WebElement downPaymentField = driver.findElement(By.xpath("//*[@id='downPayment']"));
        downPaymentField.sendKeys(downPayment);
    }

    public void selectFromAccount(){
        WebElement fromAccount = driver.findElement(By.xpath("//*[@id='fromAccountId']"));
        Select selectFromAccount = new Select(fromAccount);
        selectFromAccount.getFirstSelectedOption();
    }

    public void clickApplyNow(){
        WebElement applyNowButton = driver.findElement(By.xpath("//*[@value=\"Apply Now\"]"));
        applyNowButton.click();
    }

    public void waitForLoanStatus(String expectedMessage, int timeout){
        seleniumUtils.waitForElementText(By.xpath("//*[@id='loanStatus']"), "Approved", 10);
    }

    public String isTextPresent(){
        WebElement text = driver.findElement(By.xpath("//*[@id='loanStatus']"));
        return text.getText();
    }
}
