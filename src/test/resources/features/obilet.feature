@obilet
Feature: Kullanici mobile browser uzerinden testlerini gerceklestirir

  Scenario: Kullanici O bilet sayfasindaki gorevleri yerine getirir
    Given Kullanici "https://www.obilet.com/en" adresine gider
    When Kullanici dili Turkce olarak secer
    And Kullanici para birimi olarak TL'yi secer
    And Kullanici "Otobüs Ara" butonuna tiklar
    Then Gelen bilet fiyatlarinin "TL" oldugu dogrulanir
