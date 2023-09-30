package co.com.projectBase.interactions.servicios;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class GetWHStatusVerification extends RestInteraction {
    private Map<String, Object> headers;
    private String resource;

    public GetWHStatusVerification(String resource, Map<String, Object> headers) {
        this.headers = headers;
        this.resource = resource;
    }

    @Step("{0} executes a GET on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .get(as(actor).resolve(resource))
                .then().statusCode(200);
    }
}
