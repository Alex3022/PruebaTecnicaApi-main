package co.com.projectBase.task;

import co.com.projectBase.interactions.servicios.CallService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ObtenerEmpleadoId implements Task {

    private final String resource;

    public ObtenerEmpleadoId(String resource) {
        this.resource = resource;

    }
    public static ObtenerEmpleadoId call(String resource) {
        return new ObtenerEmpleadoId(resource );
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restGet(resource)
        );
    }
}
