package stepDefinitions.mobileWeb;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ObiletPage;
import utilities.BrowserDriver;

public class mobileBrowserStepDef {

    ObiletPage obiletPage = new ObiletPage();

    @Given("Kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String url) throws InterruptedException {
        BrowserDriver.getBrowserDriver().get(url);
        Thread.sleep(1000);
    }

    @When("Kullanici dili Turkce olarak secer")
    public void kullanici_dili_turkce_olarak_secer() throws InterruptedException {
        obiletPage.hamburgerMenu.click();
        obiletPage.languageSelect.click();
        Thread.sleep(2000);
        obiletPage.turkishLanguage.click();
    }

    @When("Kullanici para birimi olarak TL'yi secer")
    public void kullanici_para_birimi_olarak_tl_yi_secer() throws InterruptedException {
        obiletPage.hamburgerMenu.click();
        obiletPage.currencySelect.click();
        Thread.sleep(2000);
        obiletPage.turkishLira.click();
    }

    @When("Kullanici {string} butonuna tiklar")
    public void kullanici_butonuna_tiklar(String otobusAra) {
        Assert.assertTrue(obiletPage.otobusAraButton.getText().contains(otobusAra));
        obiletPage.otobusAraButton.click();
    }

    @Then("Gelen bilet fiyatlarinin {string} oldugu dogrulanir")
    public void gelen_bilet_fiyatlarinin_oldugu_dogrulanir(String expected) {
        Assert.assertTrue(obiletPage.priceText.getText().contains(expected));
    }

}
