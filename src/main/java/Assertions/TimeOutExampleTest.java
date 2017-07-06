
package Assertions;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TimeOutExampleTest {

	@DisplayName("A execução não deve exceder 15 segundos.")
	@Test
	void tempoLimite15Segundos() {
		TimeOutExample timeOutExample = new TimeOutExample();
		Assertions.assertTimeout(Duration.ofSeconds(15), () -> {
			timeOutExample.aguardarDezSegundos();
		});
	}

	@DisplayName("A execução não deve exceder 5 segundos.")
	@Test
	public void tempoLimite5Segundos() {
		TimeOutExample timeOutExample = new TimeOutExample();
		Assertions.assertTimeout(Duration.ofSeconds(5), () -> {
			timeOutExample.aguardarDezSegundos();
		}, "A execução do método levou mais do que 5 segundos.");
	}

	@DisplayName("A execução não deve exceder 15 segundos. Caso exceda deve ser abortada.")
	@Test
	public void tempoLimite15SegundosComPreemptive() {
		TimeOutExample timeOutExample = new TimeOutExample();
		Assertions.assertTimeoutPreemptively(Duration.ofSeconds(15), () -> {
			timeOutExample.aguardarVinteSegundos();
		}, () -> "A execução do método levou mais do que 15 segundos e foi abortada.");
	}
}
