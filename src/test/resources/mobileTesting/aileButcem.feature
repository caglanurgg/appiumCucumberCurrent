 @aileButcem
    Feature: Aile Butcem uygulamasi fonksiyonlari test edilir
      Background:
        Given Uygulama ilk ekran ayarlari yapilir
        And Kullanici login sayfasina "Giriş Yap" ulasir
        When  "testfort108@gmail.com" ve "t108t108" bilgilerini girerek giris yapar

    Scenario Outline: Kullanici hesabini yonetir ve bilgilerini gunceller

      Then Kullanicinin basarili sekilde giris yaptigi dogrulanir
      When Kullanici sol menuden 102 128 "Hesabım" bolumune gider
      And hesabim sayfasindaki bilgileri degistirerek "<isim>" "<soyisim>" "<sehir>" "<yas>" "<meslek>" degisikleri kaydedin ve dogrulayin
      And Kullanici uygulamayi kapatir

      Examples:
        | isim|soyisim |sehir |yas |meslek |
        |isim1|soyisim1|sehir1|yas1|meslek1|
        |isim2|soyisim2|sehir2|yas2|meslek2|
