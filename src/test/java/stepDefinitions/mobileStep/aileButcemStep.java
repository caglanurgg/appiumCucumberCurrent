package stepDefinitions.mobileStep;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AileButcemPage;
import utilities.Driver;
import utilities.ReusableMethods;

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
    public void kullanicinin_basarili_sekilde_giris_yaptigi_dogrulanir()  {
        Assert.assertTrue(page.girisYapildiYazisi.isDisplayed());
    }

    @When("Kullanici sol menuden {int} {int} {string} bolumune gider")
    public void kullanici_sol_menuden_bolumune_gider(int x1Koordinati, int y1Koordinati, String menuSecenekler) throws InterruptedException {
        ReusableMethods.wait(4);
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

    @Given("Kullanici anasayfadaki arti butonuna tiklar")
    public void kullanici_anasayfadaki_arti_butonuna_tiklar() throws InterruptedException {
        page.plusButton.click();
        Thread.sleep(1000);
    }

    @When("{string} butonuna text uzerinden tiklar")
    public void butonuna_text_uzerinden_tiklar(String eklemeSecenekleri) {
        ReusableMethods.scrollWithUiScrollableAndClick(eklemeSecenekleri);
    }

    @When("{string} sayfasinda aciklama kismina {string} degeri girer")
    public void sayfasinda_aciklama_kismina_degeri_girer(String sayfaBilgisi,String aciklamaDegeri) {
        page.aciklamaKutusu.sendKeys(aciklamaDegeri);
    }

    @When("{string} sayfasinda Gelir Tipi olarak {string} secilir")
    public void sayfasinda_gelir_tipi_olarak_secilir(String sayfaBilgisi,String gelirTipi) throws InterruptedException {
        page.gelirTipiKutusu.click();
        Thread.sleep(2000);
        ReusableMethods.scrollWithUiScrollableAndClick(gelirTipi);
    }

    @When("{string} sayfasinda Kategori olarak {string} secilir")
    public void sayfasinda_kategori_olarak_secilir(String sayfaBilgisi,String kategori) throws InterruptedException {
        page.kategoriKutusu.click();
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick(kategori);
        Thread.sleep(2000);
    }

    @When("{string} sayfasinda Tarih belirlemesi yapar ve kac ay ilerleme olarak {int} secimi, gun olarak {string} girer")
    public void sayfasinda_tarih_belirlemesi_yapar_ve_kac_ay_ilerleme_olarak_secimi_gun_olarak_girer(String sayfaBilgisi,int forBitis,String gun) {
        page.tarihKaydirmaMethodu(forBitis,gun);
    }

    @When("{string} sayfasinda Tutar bilgisi olarak {string} girer")
    public void sayfasinda_tutar_bilgisi_olarak_girer(String sayfaBilgisi, String tutar) {
        page.tutarKutusu.sendKeys(tutar);
    }

    @Then("Gelirin basariyla eklendigini dogrular")
    public void gelirin_basariyla_eklendigini_dogrular() {
        Assert.assertTrue( page.gelirEklediText.isDisplayed());
    }

    @When("{string} sayfasinda Gelir Periyodu olarak {string} secilir")
    public void sayfasinda_gelir_periyodu_olarak_secilir(String sayfaBilgisi, String gelirPeriyodu) {
        page.gelirPeriyodu.click();
        ReusableMethods.scrollWithUiScrollableAndClick(gelirPeriyodu);
    }



}
