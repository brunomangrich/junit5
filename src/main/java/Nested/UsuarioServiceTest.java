
package Nested;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class UsuarioServiceTest {

	private UsuarioService usuarioService = null;

	@BeforeEach
	public void inicializar() {
		this.usuarioService = new UsuarioService();
	}

	@Test
	public void logoutComSuccesso() {
		long userId = 1L;
		Assertions.assertTrue(this.usuarioService.logout(userId));

	}

	@Test
	public void reiniciarSenhaUsuarioExistente() {
		long userId = 1l;
		Assertions.assertTrue(this.usuarioService.reiniciarSenha(userId));

	}

	@Test
	public void reiniciarSenhaUsuarioNaoExistente() {
		long userId = 5l;
		Assertions.assertFalse(this.usuarioService.reiniciarSenha(userId));

	}

	@Nested
	@DisplayName("Testes Realizar Login")
	class LoginFeature {

		@Test
		void loginUsuarioSenhaCorretos() {
			boolean actual = UsuarioServiceTest.this.usuarioService.login("admin", "senha123");
			Assertions.assertTrue(actual);
		}

		@Test
		void loginUsuarioSenhaIncorretos() {
			boolean actual = UsuarioServiceTest.this.usuarioService.login("admin", "senha123456");
			Assertions.assertFalse(actual);
		}

		@Test
		void loginUsuarioSenhaNull() {
			IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				UsuarioServiceTest.this.usuarioService.login(null, null);
			});
			Assertions.assertEquals("Usuario e senha não devem ser vazio", exception.getMessage());

		}

		@Test
		void loginUsuarioSenhaVazio() {

			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				UsuarioServiceTest.this.usuarioService.login("", "");
			});

		}
	}

	@Nested
	@DisplayName("Testes Alterar Senha")
	class ChangePasswordFeature {

		@Test
		void changePasswordUserExistOldPasswordNewPasswordCorrect() {
			long userId = 1L; // usuário existe
			Assertions.assertTrue(UsuarioServiceTest.this.usuarioService.alterarSenha(userId, "senha123", "senha123456"));
		}

		@Test
		void changePasswordUserNotExist() {
			long userId = 999L; // usuário não existe
			Assertions.assertFalse(UsuarioServiceTest.this.usuarioService.alterarSenha(userId, "senha123", "senha123456"));
		}

		@Test
		void changePasswordUserExistOldPasswordAndNewPasswordEmpty() {
			long userId = 1L; // usuário existe
			Assertions.assertFalse(UsuarioServiceTest.this.usuarioService.alterarSenha(userId, "", ""));
		}

		@Test
		void changePasswordUserExistOldPasswordEqualNewPassword() {
			long userId = 1L; // usuário existe
			Assertions.assertFalse(UsuarioServiceTest.this.usuarioService.alterarSenha(userId, "senha123", "senha123"));
		}
	}
}
