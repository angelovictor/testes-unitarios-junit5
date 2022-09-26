package suites;

import controller.ClienteControllerTest;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SuiteDisplayName("Suite Controller Testes Classes")
@SelectClasses({
        ClienteControllerTest.class,
        //Adicionar demais classes e separar por virgula...
})
public class SuiteControllerClasses {

}

