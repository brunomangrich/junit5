
package Assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssertionExampleTest {

	@Test
	public void converterParaDoubleComSucesso() {
		String ano = "2017";
		Double anoEsperado = Double.valueOf(ano);
		Double anoConvertido = StringUtils.convertToDouble(ano);
		//Todas as assertion são executadas, qualquer uma que falha será notificada junto.
		Assertions.assertAll("Fazer diversos asserts com Java 8", () -> {
			Assertions.assertNotNull(anoConvertido, () -> "O ano convertido é NULL");
			Assertions.assertEquals(anoEsperado, anoConvertido, () -> "O ano esperado é " + anoEsperado + " enquanto o convertido é:" + anoConvertido);
		});
	}

	@Test
	public void converterParaDoubleLancandoExcecao() {
		String ano = "teste"; //Valor não numérico a ser convertido
		Assertions.assertThrows(NumberFormatException.class, () -> {
			StringUtils.convertToDouble(ano);
		});
	}
}
