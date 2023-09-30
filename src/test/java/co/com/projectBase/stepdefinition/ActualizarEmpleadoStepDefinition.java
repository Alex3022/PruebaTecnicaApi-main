package co.com.projectBase.stepdefinition;

import co.com.projectBase.model.BodyEmpleado;
import co.com.projectBase.model.ResponseDataEmpleado;
import co.com.projectBase.questions.ValidarInformacionEmpleado;
import co.com.projectBase.task.ActualizarEmpleado;
import co.com.projectBase.utils.DataManager;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.projectBase.stepdefinition.HooksAPI.actor;
import static co.com.projectBase.stepdefinition.HooksAPI.environmentVariables;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
public class ActualizarEmpleadoStepDefinition {

    private BodyEmpleado body;
    private ResponseDataEmpleado bodyResponse;

    @Dado("que quiero actualizar la informacion del empleado")
    public void queQuieroActualizarLaInformacionDelEmpleado() {
        body = DataManager.getDataEmpleado();
        bodyResponse = DataManager.getDataResponseEmpleado();
    }
    @Cuando("haga un llamado a la api de actualizar")
    public void hagaUnLlamadoALaApiDeActualizar() {
        actor.attemptsTo(
                ActualizarEmpleado.call(environmentVariables.getProperty("api.actualizar"), body)
        );
    }
    @Entonces("recibo la informacion actualizada")
    public void reciboLaInformacionActualizada() {
        actor.should(
                seeThat(ValidarInformacionEmpleado.verifyWith(bodyResponse), is(true))
        );
    }
}
