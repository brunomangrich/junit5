
package ParameterResolution;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@ExtendWith(ExecutarAnotacaoParameterResolver.class)
@ExtendWith(AuditarOrdemServicoParameterResolver.class)
public class AuditarOrdemServicoTest {

	@DisplayName("Teste auditar serviço método com sucesso")
	@Tag("tagTeste")
	@Test
	public void auditarServicoComSucesso(TestInfo testInfo, TestReporter testReporter) {
		Assertions.assertEquals("Teste auditar serviço método com sucesso", testInfo.getDisplayName());
		Assertions.assertTrue(testInfo.getTags().contains("tagTeste"));
		HashMap<String, String> values = new HashMap<>();
		values.put("usuario", "bruno.amorim");
		values.put("ano_nascimento", "1990");

		testReporter.publishEntry(values);

		Assertions.assertEquals(1, 1);
	}

	@Test
	public void auditarServicoComObjetoParametro(AuditarOrdemServico auditarOrdemServico) {
		Assertions.assertTrue(auditarOrdemServico.auditar());
	}

	@Test
	public void executarOrdemServicoComAnotacao(@Executar ExecutarOrdemServico executarOrdemServico) {
		Assertions.assertTrue(executarOrdemServico.executar());
	}

}
