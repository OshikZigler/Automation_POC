package PageObject;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnBoardingScreen extends Driver {

    //PageObject object
    PageObjects onBoardingScreen;

    //Constructor
    public OnBoardingScreen(){
        super();
        onBoardingScreen = new PageObjects();
        PageFactory.initElements(driver , onBoardingScreen);
    }

    //OnBoardingScreen Elements (com.houzz.app:id/)
    class PageObjects {

        //OBJECTS
        @FindBy(id = "logIn")
        public WebElement loginButton;

        //METHODS
        public boolean validateLoginpage() {
            boolean elements = false;
            if (onBoardingScreen.loginButton.isDisplayed()) {
                elements = true;
            } else {
                elements = false;
            }
            return elements;


        /*public void verifyElementIsDisplayed() {
            commonMethods.verifyElementIsDisplayed(loginButton);
        }

        public void clickOnLogin() {
            loginButton.click();
        }*/

        }
    }

}
