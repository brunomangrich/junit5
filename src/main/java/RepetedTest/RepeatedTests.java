
package RepetedTest;

import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class RepeatedTests {

	private final Logger logger = Logger.global; // ...

	@BeforeEach
	void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		int voltaAtual = repetitionInfo.getCurrentRepetition();
		int totalVolta = repetitionInfo.getTotalRepetitions();
		String nomeMetodo = testInfo.getTestMethod().get().getName();
		this.logger.info(String.format("Executando a repetição %d de %d do método %s", //
			voltaAtual, totalVolta, nomeMetodo));
	}

	@RepeatedTest(10)
	void repetirTeste() {
		// ...
	}

	@RepeatedTest(5)
	void repetirTesteComInformacao(RepetitionInfo repetitionInfo) {
		Assertions.assertEquals(5, repetitionInfo.getTotalRepetitions());
	}

	@RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	@DisplayName("Repeat!")
	void repeticaoTesteObtendoDisplayName(TestInfo testInfo) {
		Assertions.assertEquals(testInfo.getDisplayName(), "Repeat! 1/1");
	}

	@RepeatedTest(value = 5, name = "Repetindo {currentRepetition} de {totalRepetitions}")
	void repeticaoTesteEmPortugues() {
		// ...
	}

}
