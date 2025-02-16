 @aileButcem
    Feature: Aile Butcem uygulamasi fonksiyonlari test edilir

    Scenario: Kullanici hesabini yonetir ve bilgilerini gunceller
      Given Uygulama ilk ekran ayarlari yapilir
      And Kullanici login sayfasina ulasir
      When Kullanici gecerli "email" ve "password" bilgilerini girerek giris yapar
      Then Kullanicinin basarili sekilde giris yaptigi dogrulanir
      When Kullanici sol menuden "Hesabim" bolumune gider
      And Kullanici hesap bilgilerini guncelleyerek degisiklikleri kaydeder
      Then Guncellenmis hesap bilgileri dogrulanir
      And Kullanici uygulamayi kapatir
