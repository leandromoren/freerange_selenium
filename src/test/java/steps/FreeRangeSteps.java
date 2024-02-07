package steps;

import java.util.List;

import org.testng.asserts.SoftAssert;

import java.util.Arrays;

import io.cucumber.java.en.*;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

public class FreeRangeSteps {
    SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos coursesPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();
    
    @Given("Navego a www.freerangetester.com")
    public void goToFreeRangeTester() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("Voy a {word} usando la barra de navegacion")
    public void goToSectionUsingNav(String section) {
        landingPage.clickOnSectionNavBar(section);
    }

    @And("Selecciono introduccion al testing")
    public void navigateToIntroduction() {
        coursesPage.clickFundamentosTestingLink();
        fundamentosPage.clickIntroduccionAlTestingLink();
    }

    @When("Selecciono Elegir Plan")
    public void selectElegirPlan() {
        landingPage.clickOnElegirUnPlanButton();
    }

    @Then("^(?:Puedo|El cliente puede) validar las opciones in el checkout page$")
    public void validateOptionsInCheckoutPage() {
        List<String> lista = registro.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList(
            "Academia: $16.99 / mes \u2022 11 productos", 
            "Academia: $176 / a\u00F1o \u2022 11 productos",
            "Free: Gratis \u2022 1 producto");
        soft.assertEquals(listaEsperada, lista);
    }
}