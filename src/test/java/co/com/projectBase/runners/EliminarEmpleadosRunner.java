package co.com.projectBase.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/eliminarEmpleados.feature"},
        glue = {"co.com.projectBase.stepdefinition"}
)

public class EliminarEmpleadosRunner {
}
