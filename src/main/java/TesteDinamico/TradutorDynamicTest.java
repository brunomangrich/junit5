
package TesteDinamico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TradutorDynamicTest {

	private Tradutor tadutor;

	@BeforeEach
	public void setUp() {
		this.tadutor = new Tradutor();
	}

	public void translateDynamicTestsRaw() {

		List<String> inPhrases = new ArrayList<>(Arrays.asList("Olá", "Sim", "Não"));
		List<String> outPhrases = new ArrayList<>(Arrays.asList("Hello", "Yes", "No"));
		Collection<DynamicTest> dynamicTests = new ArrayList<>();

		for (int i = 0; i < inPhrases.size(); i++) {

			String phr = inPhrases.get(i);
			String outPhr = outPhrases.get(i);

			// create an test execution
			Executable exec = () -> Assertions.assertEquals(outPhr, this.tadutor.tranlate(phr));

			// create a test display name
			String testName = "Teste tradutor " + phr;
			// create dynamic test
			DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);

			// add the dynamic test to collection
			dynamicTests.add(dTest);
		}
	}

	@Disabled
	// @TestFactory
	public Collection<DynamicTest> traduzirDynamicTestsParaCollection() {

		List<String> frasesPortugues = new ArrayList<>(Arrays.asList("Olá", "Sim", "Não", "Tchau", "Boa noite", "Obrigado"));
		List<String> frasesIngles = new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));

		Collection<DynamicTest> dynamicTests = new ArrayList<>();

		for (int i = 0; i < frasesPortugues.size(); i++) {

			String frasePortugues = frasesPortugues.get(i);
			String fraseIngles = frasesIngles.get(i);

			// cria o executável
			Executable exec = () -> Assertions.assertEquals(fraseIngles, this.tadutor.tranlate(frasePortugues));

			// cria o displayname do teste
			String testName = "Teste traduzir: " + frasePortugues;

			// cria o teste dinamico
			DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);

			// adiciona o teste dinamico para a coleção de testes dinamicos
			dynamicTests.add(dTest);
		}
		return dynamicTests;
	}

	// @Disabled
	@TestFactory
	public Stream<DynamicTest> traduzirDynamicTestsParaStream() {

		List<String> frasesPortugues = new ArrayList<>(Arrays.asList("Olá", "Sim", "Não", "Tchau", "Boa noite", "Obrigado"));
		List<String> frasesIngles = new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));

		return frasesPortugues.stream().map(frase -> DynamicTest.dynamicTest("Teste traduzir: " + frase, () -> {
			int idx = frasesPortugues.indexOf(frase);
			Assertions.assertEquals(frasesIngles.get(idx), this.tadutor.tranlate(frase));
		}));
	}

	// @TestFactory
	public Iterator<DynamicTest> traduzirDynamicTestsParaIterator() {

		List<String> frasesPortugues = new ArrayList<>(Arrays.asList("Olá", "Sim", "Não", "Tchau", "Boa noite", "Obrigado"));
		List<String> frasesIngles = new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));

		return frasesPortugues.stream().map(frase -> DynamicTest.dynamicTest("Teste traduzir: " + frase, () -> {
			int idx = frasesPortugues.indexOf(frase);
			Assertions.assertEquals(frasesIngles.get(idx), this.tadutor.tranlate(frase));
		})).iterator();
	}

	// @TestFactory
	public Iterable<DynamicTest> traduzirDynamicTestsParaIterate() {

		List<String> frasesIngles = new ArrayList<>(Arrays.asList("Olá", "Sim", "Não", "Tchau", "Boa noite", "Obrigado"));
		List<String> frasesPortugues = new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));

		return frasesIngles.stream().map(frase -> DynamicTest.dynamicTest("Teste traduzir: " + frase, () -> {
			int idx = frasesIngles.indexOf(frase);
			Assertions.assertEquals(frasesPortugues.get(idx), this.tadutor.tranlate(frase));
		})).collect(Collectors.toList());
	}

}
