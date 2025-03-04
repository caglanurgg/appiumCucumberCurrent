@aileButcem
    Feature: Aile Butcem uygulamasi fonksiyonlari test edilir
      Background:
        Given Uygulama ilk ekran ayarlari yapilir
        And Kullanici login sayfasina "Giriş Yap" ulasir
        When  "testfort108@gmail.com" ve "t108t108" bilgilerini girerek giris yapar
        Then Kullanicinin basarili sekilde giris yaptigi dogrulanir

    Scenario Outline: Kullanici hesabini yonetir ve bilgilerini gunceller

      When Kullanici sol menuden 102 121 "Hesabım" bolumune gider
      And hesabim sayfasindaki bilgileri degistirerek "<isim>" "<soyisim>" "<sehir>" "<yas>" "<meslek>" degisikleri kaydedin ve dogrulayin
      And Kullanici uygulamayi kapatir

      Examples:
        | isim|soyisim |sehir |yas |meslek |
        |isim1|soyisim1|sehir1|yas1|meslek1|
        |isim2|soyisim2|sehir2|yas2|meslek2|


      Scenario: Kullanici serbest gelir ekler

        Given Kullanici anasayfadaki arti butonuna tiklar
        When "Gelir Ekle" butonuna text uzerinden tiklar
        And "Gelir Ekle" sayfasinda aciklama kismina "T130 Aciklama" degeri girer
        And "Gelir Ekle" sayfasinda Gelir Tipi olarak "Düzensiz" secilir
        And "Gelir Ekle" sayfasinda Kategori olarak "Serbest Gelir" secilir
        And "Gelir Ekle" sayfasinda Tarih belirlemesi yapar ve kac ay ilerleme olarak 3 secimi, gun olarak "8" girer
        And "Gelir Ekle" sayfasinda Tutar bilgisi olarak "15000" girer
        And "Kaydet" butonuna text uzerinden tiklar
        Then Gelirin basariyla eklendigini dogrular
        And Kullanici uygulamayi kapatir


      Scenario: Kullanici maas geliri ekler

        Given Kullanici anasayfadaki arti butonuna tiklar
        When "Gelir Ekle" butonuna text uzerinden tiklar
        And "Gelir Ekle" sayfasinda aciklama kismina "T130 Maas Geliri aciklamasi" degeri girer
        And "Gelir Ekle" sayfasinda Gelir Tipi olarak "Düzenli" secilir
        And "Gelir Ekle" sayfasinda Gelir Periyodu olarak "Aylık" secilir
        And "Gelir Ekle" sayfasinda Kategori olarak "Maaş Geliri" secilir
        And "Gelir Ekle" sayfasinda Tarih belirlemesi yapar ve kac ay ilerleme olarak 2 secimi, gun olarak "29" girer
        And "Gelir Ekle" sayfasinda Tutar bilgisi olarak "60000" girer
        And "Kaydet" butonuna text uzerinden tiklar
        Then Gelirin basariyla eklendigini dogrular
        And Kullanici uygulamayi kapatir


      Scenario: bu seneryo ulasim icin bir gider eklemek icin kullanildi

        Given Kullanici anasayfadaki arti butonuna tiklar
        When "Gider Ekle" butonuna text uzerinden tiklar
        And "Gider Ekle" sayfasinda aciklama kismina "gider eklendi" degeri girer
        And "Gider Ekle" sayfasinda Gelir Tipi olarak "Düzensiz" secilir
        And "Gider Ekle" sayfasinda Kategori olarak "Market" secilir
        And "Gider Ekle" sayfasinda Tarih belirlemesi yapar ve kac ay ilerleme olarak 2 secimi, gun olarak "6" girer
        And "Gider Ekle" sayfasinda Tutar bilgisi olarak "40000" girer
        And "Kaydet" butonuna text uzerinden tiklar
        Then Gelirin basariyla eklendigini dogrular
        And Kullanici uygulamayi kapatir

