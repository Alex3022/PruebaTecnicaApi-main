package co.com.projectBase.stepdefinition;


import co.com.projectBase.model.DeleteResponseData;
import co.com.projectBase.questions.ValidarEliminacionEmpleado;
import co.com.projectBase.task.EliminarEmpleado;
import co.com.projectBase.utils.DataManager;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;


import static co.com.projectBase.stepdefinition.HooksAPI.actor;
import static co.com.projectBase.stepdefinition.HooksAPI.environmentVariables;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class EliminarEmpleadosStepDefinition {

    private DeleteResponseData bodyResponse;

    @Dado("que quiero eliminar a un empleado")
    public void queQuieroEliminarAUnEmpleado() {
        bodyResponse = DataManager.getDataResponseDelete();
        bodyResponse.setData("10");
    }
    @Cuando("haga un llamado a la api de eliminar")
    public void hagaUnLlamadoALaApiDeEliminar() {
        actor.attemptsTo(
                EliminarEmpleado.call(String.format(environmentVariables.getProperty("api.eliminar"), "10"))
        );
    }
    @Entonces("recibo la informacion ha sido eliminada")
    public void reciboLaInformacionHaSidoEliminada() {
        actor.should(
                seeThat(ValidarEliminacionEmpleado.verifyWith(bodyResponse), is(true))
        );

    }
}
