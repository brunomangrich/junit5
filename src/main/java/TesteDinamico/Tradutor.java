
package TesteDinamico;

import org.junit.platform.commons.util.StringUtils;

public class Tradutor {

	public String tranlate(String text) {
		if (StringUtils.isBlank(text)) {
			throw new IllegalArgumentException("O texto a ser traduzido não pode ser vazio.");
		}
		if ("Olá".equalsIgnoreCase(text)) {
			return "Hello";

		} else if ("Sim".equalsIgnoreCase(text)) {
			return "Yes";

		} else if ("Não".equalsIgnoreCase(text)) {
			return "No";

		} else if ("Tchau".equalsIgnoreCase(text)) {
			return "Goodbye";

		} else if ("Boa noite".equalsIgnoreCase(text)) {
			return "Good night";

		} else if ("Obrigado".equalsIgnoreCase(text)) {
			return "Thank you";
		} else {
			return "Não encontrado";
		}
	}
}
