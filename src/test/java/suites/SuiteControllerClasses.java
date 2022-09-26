package suites;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectClasses;

import controller.*;

@Suite
@SuiteDisplayName("Suite Controller Testes Classes")
@SelectClasses({
        ClienteControllerTest.class,
        PetShopControllerTest.class,
        //Adicionar demais classes e separar por virgula...
})
public class SuiteControllerClasses {

}

