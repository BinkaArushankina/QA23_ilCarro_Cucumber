package com.ilCarro.stepDefinitions;

import com.ilCarro.pages.CarPage;
import com.ilCarro.pages.HomePage;
import com.ilCarro.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.Random;

import static com.ilCarro.pages.BasePage.driver;

public class AddCarSteps {

    @And("User clicks on Ok")
    public void click_on_Ok(){
        new LoginPage(driver).clickOnOk();
    }

    @And("User clicks on Let the car work link")
    public void click_on_Let_the_car_work_link(){
        new HomePage(driver).clickOnLetCarWork();
    }

    @And("User enters valid data to add car")
    public void enter_valid_data_to_add_car(){
        int i = new Random().nextInt(1000)+1000;
        new CarPage(driver).enterCarData("BMW","M5","2020","Hybrid",
                "4","C","233-333-" + i,"100","Good car");
    }

    @And("User upload Photo")
    public void upload_Photo(){
        new CarPage(driver).uploadPhoto("C:/Tools/1.jpg");
    }

    @And("User clicks submit button")
    public void click_submit_button(){
        new CarPage(driver).clickOnSubmit();
    }

    @Then("User verifies Add car message")
    public void verify_Add_car_message(){
        new CarPage(driver).assertAddCar();
    }
}
