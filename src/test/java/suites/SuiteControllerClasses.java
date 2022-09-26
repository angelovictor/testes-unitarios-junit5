package suites;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectClasses;

import controller.*;

@Suite
@SuiteDisplayName("Suite Controller Testes Classes")
@SelectClasses({
        ClienteControllerTest.class,
        PetsControllerTest.class,
        PetShopControllerTest.class,
        ServicoControllerTest.class,
})
public class SuiteControllerClasses {

}

