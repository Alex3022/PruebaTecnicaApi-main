package co.com.projectBase.stepdefinition;

import co.com.projectBase.model.BodyEmpleado;
import co.com.projectBase.model.ResponseDataEmpleado;
import co.com.projectBase.questions.ValidarInformacionId;
import co.com.projectBase.task.CrearEmpleado;
import co.com.projectBase.utils.DataManager;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.projectBase.stepdefinition.HooksAPI.actor;
import static co.com.projectBase.stepdefinition.HooksAPI.environmentVariables;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CreadorEmpleadosStepDefinition {

    private BodyEmpleado body;
    private ResponseDataEmpleado bodyResponse;
    @Dado("que quiero crear a un empleado")
    public void queQuieroCrearAUnEmpleado() {
        body = DataManager.getDataEmpleado();
        bodyResponse = DataManager.getDataResponseEmpleado();
    }
    @Cuando("haga un llamado a la api de crear")
    public void hagaUnLlamadoALaApiDeCrear() {
        actor.attemptsTo(
                CrearEmpleado.call(environmentVariables.getProperty("api.crear"), body)
        );
    }
    @Entonces("recibo la informacion creada")
    public void reciboLaInformacionCreada() {
        actor.should(
                seeThat(ValidarInformacionId.verifyWith(bodyResponse), is(true))
        );
    }
}
