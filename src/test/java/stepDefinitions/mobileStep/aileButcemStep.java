package stepDefinitions.mobileStep;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AileButcemPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class aileButcemStep {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AileButcemPage page=new AileButcemPage();

    @Given("Uygulama ilk ekran ayarlari yapilir")
    public void uygulama_ilk_ekran_ayarlari_yapilir() {
       page.ilkEkranAyarlari();
    }

    @Given("Kullanici login sayfasina {string} ulasir")
    public void kullanici_login_sayfasina_ulasir(String girisYap) {
        ReusableMethods.scrollWithUiScrollableAndClick(girisYap);
    }

    @When("{string} ve {string} bilgilerini girerek giris yapar")
    public void kullanici_gecerli_ve_bilgilerini_girerek_giris_yapar(String mail, String password) {
        page.girisYap(mail, password);
    }

    @Then("Kullanicinin basarili sekilde giris yaptigi dogrulanir")
    public void kullanicinin_basarili_sekilde_giris_yaptigi_dogrulanir() {
        Assert.assertTrue(page.girisYapildiYazisi.isDisplayed());
    }

    @When("Kullanici sol menuden {int} {int} {string} bolumune gider")
    public void kullanici_sol_menuden_bolumune_gider(int x1Koordinati, int y1Koordinati, String menuSecenekler) throws InterruptedException {
       ReusableMethods.koordinatTiklamaMethodu(x1Koordinati,y1Koordinati,2000);
       ReusableMethods.scrollWithUiScrollableAndClick(menuSecenekler);
    }

    @When("hesabim sayfasindaki bilgileri degistirerek {string} {string} {string} {string} {string} degisikleri kaydedin ve dogrulayin")
    public void hesabim_sayfasindaki_bilgileri_degistirerek_degisikleri_kaydedin_ve_dogrulayin(String isim, String soyisim, String sehir, String yas, String meslek) {
        page.hesabimBilgileriniDegistirmeVeKaydetme(isim,soyisim,sehir,yas,meslek);
        page.bilgiDegistirmeAssert(isim,soyisim,sehir,yas,meslek);
    }

    @Then("Kullanici uygulamayi kapatir")
    public void kullanici_uygulamayi_kapatir() {
        Driver.quitAppiumDriver();
    }

}
