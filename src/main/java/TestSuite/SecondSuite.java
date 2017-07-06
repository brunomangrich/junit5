
package TestSuite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import Assertions.AssertionExampleTest;
import Assertions.TimeOutExampleTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ AssertionExampleTest.class, TimeOutExampleTest.class })
public class SecondSuite {

}
