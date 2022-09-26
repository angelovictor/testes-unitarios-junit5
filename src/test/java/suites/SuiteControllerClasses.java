package suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import controller.*;

@Suite
@SuiteDisplayName("Suite Controller Testes Classes")
@SelectClasses({
        ClienteControllerTest.class,
        //Adicionar demais classes e separar por virgula...
})
public class SuiteClassesController {

}

