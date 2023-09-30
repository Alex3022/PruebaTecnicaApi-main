package co.com.projectBase.questions;

import co.com.projectBase.model.ResponseDataEmpleado;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ValidarInformacionId implements Question<Boolean> {

    private final ResponseDataEmpleado bodyResponse;

    public ValidarInformacionId(ResponseDataEmpleado bodyResponse) {
        this.bodyResponse = bodyResponse;
    }

    public static ValidarInformacionId verifyWith(ResponseDataEmpleado bodyResponse){
        return new ValidarInformacionId(bodyResponse);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ResponseDataEmpleado data = SerenityRest.lastResponse().as(ResponseDataEmpleado.class);
        actor.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200),
                Ensure.that(data.getStatus()).isEqualTo(bodyResponse.getStatus()),
                Ensure.that(data.getData().getName()).isEqualTo(bodyResponse.getData().getName()),
                Ensure.that(data.getData().getAge()).isEqualTo(bodyResponse.getData().getAge()),
                Ensure.that(data.getData().getId()).isNotNull()
        );
        return true;
    }
}
