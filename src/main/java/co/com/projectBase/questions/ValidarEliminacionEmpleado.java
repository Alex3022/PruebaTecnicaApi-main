package co.com.projectBase.questions;


import co.com.projectBase.model.DeleteResponseData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ValidarEliminacionEmpleado implements Question<Boolean> {


    private final DeleteResponseData bodyResponse;

    public ValidarEliminacionEmpleado(DeleteResponseData bodyResponse) {
        this.bodyResponse = bodyResponse;
    }

    public static ValidarEliminacionEmpleado verifyWith(DeleteResponseData bodyResponse){
        return new ValidarEliminacionEmpleado(bodyResponse);
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        DeleteResponseData data = SerenityRest.lastResponse().as(DeleteResponseData.class);
        actor.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200),
                Ensure.that(data.getStatus()).isEqualTo(bodyResponse.getStatus()),
                Ensure.that(data.getData()).isEqualTo(bodyResponse.getData())

        );
        return true;
    }
}
