
package TesteDinamico;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TradutorStaticTest {

	private Tradutor tradutor;

	@BeforeEach
	public void inicializar() {
		this.tradutor = new Tradutor();
	}

	@Test
	public void traduzirOlaTeste() {
		Assertions.assertEquals("Olá", this.tradutor.tranlate("Hello"));
	}

	@Test
	public void traduzirSimTeste() {
		Assertions.assertEquals("Sim", this.tradutor.tranlate("Yes"));
	}

	@Test
	public void TraduzirNaoTeste() {
		Assertions.assertEquals("Não", this.tradutor.tranlate("No"));
	}
}
