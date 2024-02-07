package pages;

public class PaginaPrincipal extends BasePage{

    private String sectionLink = "//nav[@aria-label='Main']//a[normalize-space()='%s']";
    private String elegirUnPlan = "//a[normalize-space()='Elegir Plan']";

    public PaginaPrincipal() {
        super(driver); // llama al constructor de la clase padre
    }
    
    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com/");
    }

    /*
    * Este código Java define un método clickOnSectionNavBar que toma una sección como entrada. 
    * Crea un XPath usando el formato sectionLink y la entrada sección, 
    * luego hace clic en el elemento con ese XPath
    */
    public void clickOnSectionNavBar(String section) {
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

    public void clickOnElegirUnPlanButton() {
        clickElement(elegirUnPlan);
    }
}
