package stepDefinitions.mobileWeb;

import io.cucumber.java.en.Given;
import utilities.BrowserDriver;

public class mobileBrowserStepDef {

    @Given("Kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String url) {
        BrowserDriver.getBrowserDriver().get(url);
    }

}
