package com.itera.sel.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActionKeywords {
    public WebDriver driver;

    public ActionKeywords() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }

    public void navigate(String baseURL){

        driver.get(baseURL);
    }


        public String  signUp (String sUname, String sPwd) {

        WebElement signUp = driver.findElement(By.xpath("//a[@id='signin2']"));
        signUp.click();
         try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

        WebElement sModal=driver.findElement(By.xpath("//*[@id=\"signInModal\"]"));
        sModal.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys(sUname);
        sModal.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys(sPwd);
        sModal.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/button[2]")).click();
        sModal.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText=alert.getText();
        alert.accept();
        return alertText;

        




    }


    public void login(String sUname, String sPwd){
        try{
        WebElement logIn= driver.findElement(By.xpath("//*[@id=\"login2\"]"));
        logIn.click();
        try {
                    Thread.sleep(2000);
               } catch (InterruptedException e) {
                    e.printStackTrace();
                }
          //  WebDriverWait wait=new WebDriverWait(driver,20);

        //driver.findElement(By.cssSelector("#logInModal > div:nth-child(1)")).clear();
            WebElement lModal= driver.findElement(By.xpath("//*[@id=\"logInModal\"]"));
        //driver.switchTo().activeElement();
        lModal.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys(sUname);
        lModal.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys(sPwd);
        lModal.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();  ;
              }catch (
              UnhandledAlertException f)     {
                        f.printStackTrace();
                                                     }


    }
    public void addToCart(){
        try{
            try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                driver.findElement(By.cssSelector("a.btn")).click();
                WebDriverWait wait = new WebDriverWait(driver, 500);
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();
                driver.findElement(By.xpath("//*[@id=\"nava\"]")).click();  



        }  catch (UnhandledAlertException f)   {
            f.printStackTrace();
        }
        
    }
    public void selectProducts(String prodName){
        try{

            try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

               WebElement product=driver.findElement(By.partialLinkText(prodName));
               product.click();
            this.addToCart();

        }    catch (UnhandledAlertException f)  {
            f.printStackTrace();
        }
    }
    public void close(){
        driver.close();
    }
    public void placeOrder(){
        try {                                                    
                    Thread.sleep(2000);
                } catch (InterruptedException e) {               
                    e.printStackTrace();                         
                }                                                

        driver.findElement(By.xpath("//*[@id=\"cartur\"]")).click();;
        int itemCount= driver.findElements(By.xpath("//*[@id=\"tbodyid\"]")).size();
        if (itemCount==0){
            System.out.println("Empty Cart, continue shopping");
            driver.findElement(By.xpath("//*[@id=\"nava\"]")).click();
        }
        else{
            System.out.println(itemCount);
            driver.findElement(By.cssSelector("button.btn:nth-child(3)")).click();
            
            
        }

    }

    public void purchase(String sName, String sCountry, String sCity, String sCard, String iMonth, String iYear){
        try {
            try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

         WebElement pModal=driver.findElement(By.xpath("/html/body/div[3]/div/div"));
         pModal.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(sName);
         pModal.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys(sCountry);
         pModal.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(sCity);
         pModal.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys(sCard);
         pModal.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys(iMonth);
         pModal.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys(iYear);
         pModal.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();



        }
              catch(UnhandledAlertException f){
                f.printStackTrace();
            }




    }
}
