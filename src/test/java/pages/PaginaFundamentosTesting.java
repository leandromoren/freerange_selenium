package pages;

public class PaginaFundamentosTesting extends BasePage{

    private String introduccionAlTestingLink = "//a[normalize-space()='Introducci\u00F3n al Testing de Software' and @href]";

    public PaginaFundamentosTesting() {
        super(driver);
    }
    
    public void clickIntroduccionAlTestingLink() {
        clickElement(introduccionAlTestingLink);
    }
}
