package co.com.projectBase.task;

import co.com.projectBase.interactions.servicios.CallService;
import co.com.projectBase.model.BodyEmpleado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class EliminarEmpleado implements Task {

    private final String resource;

    public EliminarEmpleado(String resource) {
        this.resource = resource;
    }

    public static EliminarEmpleado call(String resource) {
        return new EliminarEmpleado(resource);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restDelete(resource)
        );
    }
    }

