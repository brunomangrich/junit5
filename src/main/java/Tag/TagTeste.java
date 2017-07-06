
package Tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@Tag("service")
public class TagTeste {

	@Test
	@Tag("slow")
	public void testeUm() {
	}

	@Test
	@Tag("fast")
	public void testeDois() {
	}

	@Test
	@Tag("slow")
	public void testeTres() {
	}

	@Test
	@Tag("fast")
	public void testeQuatro() {
	}
}
