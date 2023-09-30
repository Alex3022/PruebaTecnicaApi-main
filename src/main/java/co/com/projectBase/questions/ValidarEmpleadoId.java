package co.com.projectBase.questions;


import co.com.projectBase.model.ResponseGetId;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ValidarEmpleadoId implements Question<Boolean> {
    private final ResponseGetId bodyResponse;

    public ValidarEmpleadoId(ResponseGetId bodyResponse) {
        this.bodyResponse = bodyResponse;
    }

    public static ValidarEmpleadoId verifyWith(ResponseGetId bodyResponse){
        return new ValidarEmpleadoId(bodyResponse);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ResponseGetId data = SerenityRest.lastResponse().as(ResponseGetId.class);
        actor.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200),
                Ensure.that(data.getStatus()).isEqualTo(bodyResponse.getStatus()),
                Ensure.that(data.getData().getId()).isNotNull(),
                Ensure.that(data.getData().getEmployeeName()).isEqualTo(bodyResponse.getData().getEmployeeName()),
                Ensure.that(data.getData().getEmployeeSalary()).isEqualTo(bodyResponse.getData().getEmployeeSalary()),
                Ensure.that(data.getData().getEmployeeAge()).isEqualTo(bodyResponse.getData().getEmployeeAge()),
                Ensure.that(data.getData().getProfileImage()).isEqualTo(bodyResponse.getData().getProfileImage())


        );
        return true;
    }
}

