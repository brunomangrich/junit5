
package ParameterResolution;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class AuditarOrdemServicoParameterResolver implements ParameterResolver {

	@Override
	public AuditarOrdemServico resolve(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return new AuditarOrdemServico();
	}

	@Override
	public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return parameterContext.getParameter().getType() == AuditarOrdemServico.class;
	}

}
