package org.example.tests;

import org.example.pages.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;


public class EndToEndTest extends BaseTest {
    private static String ALERT_MESSAGE = "El correo electrónico o la contraseña son incorrectos. Intentalo de nuevo.";
    private static String ALERT_MESSAGE_EMAIL = "Ingresá una dirección de correo electrónico válida";
    private static String ALERT_CHARACTERS_PASS = "Tiene entre 8 y 64 caracteres";
    private static String ALERT_DESTINO = "Seleccioná un destino";
    private static String ALERT_HEADING = "Para continuar, corregí el error a continuación.";
    private static String SALUDO_USUARIO = "Hola, Automation";
    private static String EMAIL_USER = "automation.testing1986@gmail.com";
    private static String TEXT_BOTON_MIS_VIAJES = "Iniciar sesión o crear una cuenta";
    private static String TEXTO_RESERVA_SPAN = "¿No encontrás tu reserva? Buscala con el número de itinerario.";
    private static String TEXTO_SIN_VIAJE_PROGRAMADO = "no tenés ningún viaje programado. ¿Adónde querés ir?";
    private static String MENSAJE_NO_RESERVAS = "No tienes reservaciones";

    @Test
    public void IniciarSesionConEmailInexistente() throws InterruptedException {
        //driver.get("https://ar.hoteles.com/");
        logger = Logger.getLogger("EndToEndTest");

        HotelesHomePage hotelesHomePage = new HotelesHomePage(driver);
        IniciarSesionPage iniciarSesionPage = new IniciarSesionPage(driver);

        hotelesHomePage.clickIniciarSesionMenu();
        hotelesHomePage.clickIniciarSesionModal();


        logger.info("buttons is not enabled");
        Assert.assertFalse(iniciarSesionPage.isBotonHabilitado());

        logger.info("buttons is displayed");
        Assert.assertTrue(iniciarSesionPage.isBotonMostrado());

        iniciarSesionPage.completarFormulario("invalid@gmail.com", "fakepass");
        iniciarSesionPage.clickIniciarSesion();

        Assert.assertEquals(ALERT_MESSAGE, iniciarSesionPage.getMensajeAlerta());
    }

    @Test
    public void IniciarSesionConEmailFormatoInvalido() throws InterruptedException {
        HotelesHomePage hotelesHomePage = new HotelesHomePage(driver);
        IniciarSesionPage iniciarSesionPage = new IniciarSesionPage(driver);

        hotelesHomePage.clickIniciarSesionMenu();
        hotelesHomePage.clickIniciarSesionModal();

        iniciarSesionPage.completarFormulario("invalidformat", "@realfakePass");
        //iniciarSesionPage.clickIniciarSesion();

        Assert.assertEquals(ALERT_MESSAGE_EMAIL, iniciarSesionPage.getMensajeAlertaEmailFormatoInvalido());
        Assert.assertFalse(iniciarSesionPage.isSubmitButtonDisabled());
    }

    @Test
    public void RegistrarEmailConPasswordErroneoMenosDe8Caracteres() throws InterruptedException {
        HotelesHomePage hotelesHomePage = new HotelesHomePage(driver);
        RegistrarsePage registrarsePage = new RegistrarsePage(driver);

        hotelesHomePage.clickIniciarSesionMenu();
        hotelesHomePage.clickRegistrarseModal();

        registrarsePage.completeRegisterForm("user@testing.com", "Jonathan", "Brull Schroeder", "weak123");

        Assert.assertEquals(ALERT_CHARACTERS_PASS, registrarsePage.obtenerRequerimientoCaracteres());
        Assert.assertFalse(registrarsePage.isContinuarButtonDisabled());
        Assert.assertTrue(registrarsePage.isContinuarButtonMostrado());

    }

    @Test
    public void BuscarAlojamientoDestinoCordobaSatistactoriamente() throws InterruptedException {
        HotelesHomePage hotelesHomePage = new HotelesHomePage(driver);
        HotelesResultadosPage hotelesResultadosPage = new HotelesResultadosPage(driver);

        hotelesHomePage.ingresarDestino("Cordoba Argentina");
        Thread.sleep(500);
        hotelesHomePage.presionarFlechaAbajoYEnter();

        hotelesHomePage.ingresarFecha();
        hotelesHomePage.clickBuscar();

        // Busco si está en la busqueda de resultados el Hotel 'NH Córdoba Panorama'

        hotelesResultadosPage.getListaResultados();
        boolean isHotel = hotelesResultadosPage.buscarHotelEnResultadosLista("NH Córdoba Panorama");

        Assert.assertTrue(isHotel);

    }

    @Test
    public void BuscarAlojamientoSinIngresarDestino() {
        HotelesHomePage hotelesHomePage = new HotelesHomePage(driver);
        hotelesHomePage.clickBuscar();

        Assert.assertEquals(ALERT_DESTINO, hotelesHomePage.getMensajeAlertaDestino());
        Assert.assertEquals(ALERT_HEADING, hotelesHomePage.getMensajeAlertaHeading());
    }

    // Happy Path
    @Test
    public void IniciarSesionSatisfactoriamente() throws InterruptedException {
        HotelesHomePage hotelesHomePage = new HotelesHomePage(driver);
        IniciarSesionPage iniciarSesionPage = new IniciarSesionPage(driver);

        hotelesHomePage.clickIniciarSesionMenu();
        hotelesHomePage.clickIniciarSesionModal();

        iniciarSesionPage.completarFormulario("automation.testing1986@gmail.com", "@automation123");
        iniciarSesionPage.clickIniciarSesion();

        hotelesHomePage.clickUsuarioMenu();

        Assert.assertEquals(SALUDO_USUARIO, hotelesHomePage.getSaludoUser());
        Assert.assertEquals(EMAIL_USER, hotelesHomePage.getEmailUserText());
    }

    @Test
    public void CerrarSesionSatisfactoriamente() throws InterruptedException {
        HotelesHomePage hotelesHomePage = new HotelesHomePage(driver);
        IniciarSesionPage iniciarSesionPage = new IniciarSesionPage(driver);

        hotelesHomePage.clickIniciarSesionMenu();
        hotelesHomePage.clickIniciarSesionModal();

        iniciarSesionPage.completarFormulario("automation.testing1986@gmail.com", "@automation123");
        iniciarSesionPage.clickIniciarSesion();

        hotelesHomePage.clickUsuarioMenu();

        hotelesHomePage.clickCerrarSesionMenu();
        if (driver.getCurrentUrl().contains("https://www.hoteles.com/")) {
            System.out.println("Flag 1");
            Assert.assertEquals("Iniciar sesión", hotelesHomePage.getIniciarSesionBetaTexto());
        } else if (driver.getCurrentUrl().contains("https://www.hoteles.com/account/hotelscomrewards.html")) {
            System.out.println("Flag 2");
            Assert.assertEquals("Automation", hotelesHomePage.getAutomationTexto());
        } else if (driver.getCurrentUrl().contains("https://ar.hoteles.com/")) {
            System.out.println("Flag 3");
            Assert.assertEquals("Iniciar sesión", hotelesHomePage.getIniciarSesionTexto());
        }

    }

    @Test
    public void ConsultarMisViajesSinIniciarSesion() {
        logger = Logger.getLogger("EndToEndTest");
        HotelesHomePage homePage = new HotelesHomePage(driver);
        MisViajesPage misViajesPage = new MisViajesPage(driver);

        logger.info("Click Menu Mis Viajes");
        homePage.clickMisViajesMenu();

        Assert.assertEquals(TEXT_BOTON_MIS_VIAJES, misViajesPage.obtenerTextoBotonIniciarSesion());
        Assert.assertEquals(TEXTO_RESERVA_SPAN, misViajesPage.obtenerTextoReservaSpan());
    }

    @Test
    public void ConsultarMisViajeIniciandoSesionSinViajeProgramado() throws InterruptedException {
        HotelesHomePage hotelesHomePage = new HotelesHomePage(driver);
        IniciarSesionPage iniciarSesionPage  = new IniciarSesionPage(driver);
        MisViajesPage misViajesPage = new MisViajesPage(driver);

        hotelesHomePage.clickIniciarSesionMenu();
        hotelesHomePage.clickIniciarSesionModal();

        iniciarSesionPage.completarFormulario("automation.testing1986@gmail.com", "@automation123");
        iniciarSesionPage.clickIniciarSesion();

        hotelesHomePage.clickMisViajesMenu();
        if (driver.getCurrentUrl().contains("https://www.hoteles.com/account/bookingslist.html")){
            Assert.assertEquals(MENSAJE_NO_RESERVAS, misViajesPage.obtenerMensajeReservas());
        }
        //Assert.assertTrue(misViajesPage.obtenerMensajeAlertaNoViajeProgramado().contains(TEXTO_SIN_VIAJE_PROGRAMADO));
        //Assert.assertTrue(misViajesPage.obtenerTextoBotonPlanearViaje().contains("Planear un viaje"));

    }
}
