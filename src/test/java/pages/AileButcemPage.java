package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class AileButcemPage {

    public AileButcemPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)),this);
    }

    @FindBy (xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement emailAdresiBox;

    @FindBy (xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement passwordBox;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[17]")
    public MobileElement girisYapildiYazisi;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement isimBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement soyisimBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public MobileElement sehirBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    public MobileElement yasBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public MobileElement meslekBox;

    public void ilkEkranAyarlari(){
        ReusableMethods.wait(2);
        for (int i = 0; i < 6; i++) {
            ReusableMethods.ekranKaydirmaMethodu(964,979,750,124,979);
        }
    }

    public void girisYap(String mail, String password){
        emailAdresiBox.sendKeys(mail);
        passwordBox.sendKeys(password);
        ReusableMethods.scrollWithUiScrollableAndClick("Giriş Yap");
    }

    public void hesabimBilgileriniTemizleme(){
        isimBox.clear();
        soyisimBox.clear();
        sehirBox.clear();
        yasBox.clear();
        meslekBox.clear();
    }

    public void hesabimBilgileriniDegistirmeVeKaydetme(String isim,String soyisim,String sehir,String yas,String meslek){
        hesabimBilgileriniTemizleme();
        isimBox.sendKeys(isim);
        soyisimBox.sendKeys(soyisim);
        sehirBox.sendKeys(sehir);
        yasBox.sendKeys(yas);
        meslekBox.sendKeys(meslek);
        ReusableMethods.scrollWithUiScrollableAndClick("Kaydet");
    }

    public void bilgiDegistirmeAssert(String isim,String soyisim,String sehir,String yas,String meslek){
        Assert.assertTrue(isimBox.getText().contains(ConfigReader.getProperty(isim)));
        Assert.assertTrue(soyisimBox.getText().contains(ConfigReader.getProperty(soyisim)));
        Assert.assertTrue(sehirBox.getText().contains(ConfigReader.getProperty(sehir)));
        Assert.assertTrue(yasBox.getText().contains(ConfigReader.getProperty(yas)));
        Assert.assertTrue(meslekBox.getText().contains(ConfigReader.getProperty(meslek)));
    }



}
