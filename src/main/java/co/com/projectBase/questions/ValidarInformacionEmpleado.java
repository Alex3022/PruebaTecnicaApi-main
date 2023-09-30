package co.com.projectBase.questions;

import co.com.projectBase.model.ResponseDataEmpleado;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;


public class ValidarInformacionEmpleado implements Question<Boolean> {

    private final ResponseDataEmpleado bodyResponse;

    public ValidarInformacionEmpleado(ResponseDataEmpleado bodyResponse) {
        this.bodyResponse = bodyResponse;
    }

    public static ValidarInformacionEmpleado verifyWith(ResponseDataEmpleado bodyResponse){
        return new ValidarInformacionEmpleado(bodyResponse);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ResponseDataEmpleado data = SerenityRest.lastResponse().as(ResponseDataEmpleado.class);
        actor.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200),
                Ensure.that(data.getStatus()).isEqualTo(bodyResponse.getStatus()),
                Ensure.that(data.getData().getName()).isEqualTo(bodyResponse.getData().getName())
        );
        return true;
    }
}
