package com.itera.sel.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class TestScenarios {
    String baseUrl="https://www.demoblaze.com/";
    String sUname="Arijit13";
    String sPwd="basu";
    String sName="Arijit";
    String sCountry="India";
    String sCity="Kolkata";
    String sCard="12345678910111213";
    String sMonth="06";
    String sYear="1989";
    @Test
    //The below test is to check the main flow
    public void TestMainFlow(){
        ActionKeywords a=new ActionKeywords();
        a.navigate(baseUrl);
        String alertText= a.signUp(sUname,sPwd);
        a.login(sUname,sPwd);
        a.selectProducts("Samsung galaxy s6");
        a.selectProducts("Iphone 6 32gb");
        a.selectProducts("Sony vaio i5");
        a.placeOrder();
        a.purchase(sName,sCountry, sCity, sCard,sMonth,sYear);
        a.close();
        System.out.println(alertText);
    }
    //The below test is to check the signup for existing user
    @Test
    public void TestExistingUser(){
       ActionKeywords a=new ActionKeywords();
       String sUname1="Arijit";
       String sPwd1="basu";
               a.navigate(baseUrl);
       String alertText=a.signUp(sUname1,sPwd1);
        System.out.println(alertText);
        a.close();
    }

}
