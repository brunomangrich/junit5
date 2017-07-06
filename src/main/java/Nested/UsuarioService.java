
package Nested;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.platform.commons.util.StringUtils;

public class UsuarioService {

	public boolean login(String usuario, String senha) {
		if (StringUtils.isBlank(usuario) || StringUtils.isBlank(senha)) {
			throw new IllegalArgumentException("Usuario e senha não devem ser vazio");
		} else if (usuario.equals("admin") && senha.equals("senha123")) {
			return true;
		}
		return false;
	}

	public boolean alterarSenha(long usuarioID, String senhaAntiga, String senhaNova) {
		if (usuarioID == 1 && StringUtils.isNotBlank(senhaNova) && StringUtils.isNotBlank(senhaNova) && !senhaNova.equals(senhaAntiga)) {
			return true;
		}
		return false;
	}

	public boolean reiniciarSenha(long usuarioID) {
		List<Long> existingUsers = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
		if (existingUsers.contains(usuarioID)) {
			return true;
		}
		return false;
	}

	public boolean logout(long usuarioID) {
		List<Long> existingUsers = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
		if (existingUsers.contains(usuarioID)) {
			// faz qualquer coisa
		}
		return true;
	}
}
