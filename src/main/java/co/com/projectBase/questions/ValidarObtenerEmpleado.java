package co.com.projectBase.questions;


import co.com.projectBase.model.ResponseGetAll;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ValidarObtenerEmpleado implements Question<Boolean> {

    private final ResponseGetAll bodyResponse;

    public ValidarObtenerEmpleado(ResponseGetAll bodyResponse) {
        this.bodyResponse = bodyResponse;
    }

    public static ValidarObtenerEmpleado verifyWith(ResponseGetAll bodyResponse){
        return new ValidarObtenerEmpleado(bodyResponse);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ResponseGetAll data = SerenityRest.lastResponse().as(ResponseGetAll.class);
        actor.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200),
                Ensure.that(data.getStatus()).isEqualTo(bodyResponse.getStatus()),
                Ensure.that(data.getData()).isNotNull()
        );
        return true;
    }
}

