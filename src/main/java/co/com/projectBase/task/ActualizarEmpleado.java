package co.com.projectBase.task;

import co.com.projectBase.interactions.servicios.CallService;
import co.com.projectBase.model.BodyEmpleado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ActualizarEmpleado implements Task {
    private final String resource;
    private final BodyEmpleado body;
    public ActualizarEmpleado(String resource, BodyEmpleado body) {
        this.resource = resource;
        this.body = body;
    }

    public static ActualizarEmpleado call(String resource, BodyEmpleado body) {
        return new ActualizarEmpleado(resource, body);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restPut(resource, body)
        );
    }
}
