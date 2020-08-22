# Proje
Bu projenin amacı mobil platformda test otomasyon geliştirmek. Türk Hava Yolları mobil uygulaması seçilmiştir. <br>
Programming Languge: Java<br>
Build Automation Tool: Maven<br>
Test automation framework: Gauge<br>
Automation tool: Appium<br>


# thy
Proje senaryosu<br>
-Uygulamanın ana sayfası açılır.<br>
-Tek yön seçilir.<br>
-Kalkış havalimanı girilir.<br>
-Varış havalimanı girilir.<br>
-2 gün sonrasına gidiş tarihi seçilir.<br>
-2 adet yetişkin seçilir.<br>
-Bilet aramaya tıklanır.<br>
-Herhangi bir uçuşun ekonomi uçuşu seçilir.<br>
-Devam edilir.<br>
-Yolcuların bilgileri girilir.<br>
-Devam edilir.<br>
-Hes sayfasında cancel edilir.<br>

Not: Android api28 android 9.0 simulatoründe test edilmiştir.
Gerçek cihazda çalışmak isteyenler usb hata ayıklama modunu aktif bir şekilde usb bağlantısı yapılıp. Sonra gerekli desire capabilitiesler verildiğinde çalışacaktır.
<br>Gerekli komutlar<br>
-adb devices<br><br>
-adb shell                                             
-dumpsys window windows | grep -e 'mCurrentFocus'<br>

TODO<br>
-Uçuş bilgilerinin geldiği kontrol edilir.<br>
-Dinamik platform hookImp classına dahil edilmesi.<br>
