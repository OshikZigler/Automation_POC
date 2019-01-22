import PageObject.OnBoardingScreen;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@FixMethodOrder(MethodSorters.JVM)

public class OnBoardingScreenTest extends OnBoardingScreen {

    OnBoardingScreen onBoardingScreen = new OnBoardingScreen();

    @BeforeTest

    public void elementVerification(){
        onBoardingScreen.verifyElementIsDisplayed();
    }

    @Test
    public void clickLogin(){
        onBoardingScreen.clickOnLogin();
    }


}


