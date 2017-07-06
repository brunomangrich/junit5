
package ParameterResolution;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.util.ReflectionUtils;

public class ExecutarAnotacaoParameterResolver implements ParameterResolver {

	@Override
	public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext) {
		return parameterContext.getParameter().isAnnotationPresent(Executar.class);
	}

	@Override
	public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext) {
		return ReflectionUtils.newInstance(parameterContext.getParameter().getType());
	}
}
