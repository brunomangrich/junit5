
package CicloVida;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class JUnit5CicloVidaTest {

	@BeforeAll
	static void beforeAll() {
		// Initialize connection to file.
		System.out.println("@BeforeAll - Executa uma única vez antes de todos os testes da classe.");
	}

	@BeforeEach
	void beforeEach() {
		// Insert some sample data before each test
		System.out.println("@BeforeEach - Executa antes de cada teste da classe.");
	}

	@DisplayName("Teste 1")
	@Test
	void testeUm() {
		System.out.println("Teste 1 executado com sucesso");

	}

	@DisplayName("Teste 2")
	@Test
	void testeDois() {
		System.out.println("Teste 2 executado com sucesso");
	}

	@Test
	@Disabled("Teste não implementado")
	void testeDesabilitado() {
	}

	@AfterEach
	void afterEach() {
		// Reset the file content.
		System.out.println("@AfterEach - Executado após de cada teste da classe.");

	}

	@AfterAll
	static void afterAll() {
		// Closes connection to the file
		System.out.println("@AfterAll - Executado uma única vez após todos os testes da classe.");
	}

}
