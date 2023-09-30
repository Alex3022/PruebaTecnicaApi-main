package co.com.projectBase.stepdefinition;

import co.com.projectBase.model.ResponseDataEmpleado;
import co.com.projectBase.model.ResponseGetId;
import co.com.projectBase.questions.ValidarEmpleadoId;
import co.com.projectBase.questions.ValidarInformacionId;
import co.com.projectBase.task.CrearEmpleado;
import co.com.projectBase.task.ObtenerEmpleadoId;
import co.com.projectBase.utils.DataManager;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.projectBase.stepdefinition.HooksAPI.actor;
import static co.com.projectBase.stepdefinition.HooksAPI.environmentVariables;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ObtenerEmpleadoIdStepDefinition {

     private ResponseGetId bodyResponse;


    @Dado("que quiero obtener informacion del empleado por id")
    public void queQuieroObtenerInformacionDelEmpleadoPorId() {
        bodyResponse = DataManager.getResponseGetId();
    }
    @Cuando("haga un llamado a la api de obtener empleado con id")
    public void hagaUnLlamadoALaApiDeObtenerEmpleadoConId() {
        actor.attemptsTo(
                ObtenerEmpleadoId.call(String.format(environmentVariables.getProperty("api.obtener_id"), 1))
        );
    }
    @Entonces("recibo la informacion del empleado con id")
    public void reciboLaInformacionDelEmpleadoConId() {
        actor.should(
                seeThat(ValidarEmpleadoId.verifyWith(bodyResponse), is(true))
        );
    }

}
