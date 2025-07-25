package org.hepsiburda;

import com.thoughtworks.gauge.Step;
import pages.*;

public class StepImplementation {
    private final HomePage homePage = PageManager.getInstance().getHomePage();
    private final ListPage listPage = PageManager.getInstance().getListPage();
    private final CartPage cartPage = PageManager.getInstance().getCartPage();
    private final LoginPage loginPage = PageManager.getInstance().getLoginPage();


    @Step("hepsiburada ana sayfasına git")
    public void hepsiburdaAnaSayfayaGit() {
        homePage.anasayfayaGit();
    }

    @Step("<searchbox_anasayfa> li elemente tıkla")
    public void elementeTikla(String key) {
        try {
            Thread.sleep(1000);
            homePage.elementeTikla(key);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("<searchbox_inputfield_anasayfa> li elemente <Bilgisayar> değerini yaz")
    public void aramaYap(String key, String text) {
        homePage.aramaAlaninaDegerGir(key, text);
    }

    @Step("<urun_listesi_baslik> li elementin text <Bilgisayar> i doğrula")
    public void elementTextDogrula(String key, String text) {
        listPage.elementTextDogrula(key, text);
    }

    @Step("<third_listItem> li urunu seç ve  tıkla")
    public void urunSecVeTikla(String key) {
        listPage.urunSecVeTikla(key);
    }

    @Step("<selected_item_title> li seçilen ürünün başlığını doğrula")
    public void secilenurUnuDogrula(String key) {
        cartPage.secilenUrunuDogrula(key);
    }

    @Step("<cartProductTitle> li urunun bilgilerini dogrula")
    public void sepetteUrunBilgileriDogrula(String key) {
        cartPage.sepetteUrunuDogrula(key);
    }

    @Step("<email_login>  li elemente <tacabillaki@gmail.com> değerini yaz")
    public void enterEmailAndPassword(String key, String email) {
        loginPage.enterCredentials(key, email);
    }

    @Step("<address_list_address_form> li listeden ilk adresi seç")
    public void ilkAddressSec(String key) {
        cartPage.ilkAdresiSec(key);
    }

    @Step("\"login_btn\" li elemente tıkla \"login_n1e2_exception\" de hata alırsan auth kullan")
    public void signInToSystem(String key, String expKey) {
        loginPage.signInToSystemHandleException(key, expKey);
    }
}
