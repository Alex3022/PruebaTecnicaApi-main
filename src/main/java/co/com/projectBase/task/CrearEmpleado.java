package co.com.projectBase.task;

import co.com.projectBase.interactions.servicios.CallService;
import co.com.projectBase.model.BodyEmpleado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CrearEmpleado implements Task {

    private final String resource;
    private final BodyEmpleado body;
    public CrearEmpleado(String resource, BodyEmpleado body) {
        this.resource = resource;
        this.body = body;
    }
    public static CrearEmpleado call(String resource, BodyEmpleado body) {
        return new CrearEmpleado(resource, body);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restPost(resource, body)
        );
    }


}
