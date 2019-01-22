package Utils;

import io.appium.java_client.android.AndroidDriver;

public class Driver extends Base {

    //Initializing Android driver
    protected AndroidDriver driver;

    public Driver(){
        this.driver = super.getDriver();
    }

}
