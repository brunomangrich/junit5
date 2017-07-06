
package Assumptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssumptionExampleTest {

	@Test
	void testInAllEnvironments() {
		Assumptions.assumingThat("CI".equals(System.getenv("ENV")), () -> {
			// perform these assertions only on the CI server
			Assertions.assertEquals(2, 2);
		});
	}
}
