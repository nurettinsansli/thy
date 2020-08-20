package com.testinium.thy;

import com.thoughtworks.gauge.Step;
import com.thy.model.SelectorInfo;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Nullable;
import java.util.Calendar;
import java.util.List;


public class StepImplementation extends HookImpl {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<MobileElement> findElements(By by) throws Exception {
        List<MobileElement> webElementList = null;
        try {
            webElementList = appiumFluentWait.until(new ExpectedCondition<List<MobileElement>>() {
                @Nullable
                @Override
                public List<MobileElement> apply(@Nullable WebDriver driver) {
                    List<MobileElement> elements = driver.findElements(by);
                    return elements.size() > 0 ? elements : null;
                }
            });
            if (webElementList == null) {
                throw new NullPointerException(String.format("by = %s Web element list not found", by.toString()));
            }
        } catch (Exception e) {
            throw e;
        }
        return webElementList;
    }

    public MobileElement findElement(By by) throws Exception {
        MobileElement mobileElement;
        try {
            mobileElement = findElements(by).get(0);
        } catch (Exception e) {
            throw e;
        }
        return mobileElement;
    }

    @Step({"<seconds> saniye bekle"})
    public void waitBySecond(int second) {
        try {
            Thread.sleep(second * 1000);
            logger.info(second + "saniye bekliyor.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Step("<id> cookie kabul et.")
    public void acceptCookie(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<id> Book a flight tikla.")
    public void getTicket(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<id> tek yon tikla.")
    public void tekYonUcus(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<id> kalkis havalimani tikla.")
    public void selectDeparture(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<id> kalkis kodu gir.")
    public void departureCode(String id) {
        appiumDriver.findElement(By.id(id)).sendKeys("SAW");
    }

    @Step("<id> havalimani sec.")
    public void selectDepartureAirport(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<id> varis havalimani tikla.")
    public void toAirport(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<id> varis havalimani kodu gir.")
    public void toAirportCode(String id) throws Exception {
        appiumDriver.findElement(By.id(id)).sendKeys("ESB");
    }

    @Step("<id> varis havalimani sec.")
    public void toAirportSelect(String id) throws Exception {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<class> tarih bilgisi al.")
    public void date(String id) {
        String date = appiumDriver.findElement(By.id(id)).getText();
        int tarih = Integer.parseInt(date);
        tarih = tarih + 2;
        date = Integer.toString(tarih);
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(date + " tarih bilgisi");
        appiumDriver.findElement(By.linkText(date)).click();

    }

    public MobileElement findElementByKeyWithoutAssert(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);

        MobileElement mobileElement = null;
        try {
            mobileElement = selectorInfo.getIndex() > 0 ? findElements(selectorInfo.getBy())
                    .get(selectorInfo.getIndex()) : findElement(selectorInfo.getBy());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobileElement;
    }

    @Step("<id> tarih alanina tikla.")
    public void SelectDateView(String id) {
        appiumDriver.findElement(By.id("frDashboard_rlDeparture")).click();
    }

    @Step({"<text> gun sonrayi sec."})
    public void selectDate(int day) {
        day++;
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, day);
        int afterDay = date.get(Calendar.DATE);

        try {
            appiumDriver.findElement(By.xpath("//*[@text='" + afterDay + "']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("<id> done butonuna tikla")
    public void btnDone(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<xpath> adult degerini bir arttir.")
    public void increaseAdult(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("<id> ucus arama butonuna tikla.")
    public void searchFlight(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<xpath> ucus sec.")
    public void selectFlight(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("<xpath> ekonomik ucus sec.")
    public void ecoFlight(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("<id> Continue butonuna tikla.")
    public void btnContinue(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<id> yolcu ekle.")
    public void addPassenger(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<id> ad gir.")
    public void inputName(String id) {
        appiumDriver.findElement(By.id(id)).sendKeys("Test");
    }

    @Step("<id> soyad gir.")
    public void inputSurname(String id) {
        appiumDriver.findElement(By.id(id)).sendKeys("User");
    }

    @Step("<xpath> cinsiyet gir.")
    public void selectGender(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("<id> dogum tarihi gir.")
    public void birthDate(String id) {
        appiumDriver.findElement(By.id(id)).sendKeys("19-08-1985");
    }

    @Step("<id> email gir.")
    public void emailAdress(String id) {
        appiumDriver.findElement(By.id(id)).sendKeys("testuser@gmail.com");
    }

    @Step("<xpath> uyruk sec.")
    public void Nationality(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("<id> tckNo gir.")
    public void tckNo(String id) {
        appiumDriver.findElement(By.id(id)).sendKeys("60393950870");
    }

    @Step("<id> save butonuna tikla.")
    public void btnSave(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<xpath> 2. adult view ac.")
    public void adult2(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("<xpath> 2. yolcu ekle.")
    public void addPassenger2(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("<id> passenger sayfasinda continue butonuna tikla.")
    public void btnPassengerContinue(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<id> hes sayfasinda cancel butonuna tikla.")
    public void btnCancel(String id)
    {
        appiumDriver.findElement(By.id(id)).click();
    }
    @Step("<id> cancel sayfasinda continue butonuna tikla.")
    public void btnCancelContinue(String id)
    {
        appiumDriver.findElement(By.id(id)).click();
    }


}







