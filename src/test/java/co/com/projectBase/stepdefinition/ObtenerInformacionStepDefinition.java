package co.com.projectBase.stepdefinition;

import co.com.projectBase.model.ResponseGetAll;
import co.com.projectBase.questions.ValidarObtenerEmpleado;
import co.com.projectBase.task.ObtenerInformacionEm;
import co.com.projectBase.utils.DataManager;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.projectBase.stepdefinition.HooksAPI.actor;
import static co.com.projectBase.stepdefinition.HooksAPI.environmentVariables;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ObtenerInformacionStepDefinition {
    private ResponseGetAll bodyResponse;
    @Dado("que quiero obtener informacion del empleado")
    public void queQuieroObtenerInformacionDelEmpleado() {
        bodyResponse = DataManager.getResponseGetAll();
    }
    @Cuando("haga un llamado a la api de obtener")
    public void hagaUnLlamadoALaApiDeObtener() {
        actor.attemptsTo(
                ObtenerInformacionEm.call(String.format(environmentVariables.getProperty("api.obtener")))
        );
    }
    @Entonces("recibo la informacion del empleado")
    public void reciboLaInformacionDelEmpleado() {
        actor.should(
                seeThat(ValidarObtenerEmpleado.verifyWith(bodyResponse), is(true))
        );
    }
    }

