package co.com.projectBase.stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static co.com.projectBase.utils.Constants.getAPIUrl;

public class HooksAPI {

    public static Actor actor;
    public static EnvironmentVariables environmentVariables;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("como {string} quiero usar la pagina Dummy")
    public void comoQuieroUsarLaPetStoreApi(String string) {
        actor = Actor.named(string);
        String apiUrl = environmentVariables.optionalProperty("api.url").orElse(getAPIUrl("url"));
        actor.whoCan(CallAnApi.at(apiUrl));
    }
}

