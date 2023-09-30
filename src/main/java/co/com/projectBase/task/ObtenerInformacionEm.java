package co.com.projectBase.task;

import co.com.projectBase.interactions.servicios.CallService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ObtenerInformacionEm implements Task {

    private final String resource;

    public ObtenerInformacionEm(String resource) {
        this.resource = resource;

    }
    public static ObtenerInformacionEm call(String resource) {
        return new ObtenerInformacionEm(resource );
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restGet(resource)
        );
    }

}
