package br.com.wbotelhos.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.wbotelhos.dao.UsuarioDao;
import br.com.wbotelhos.model.Usuario;
import br.com.wbotelhos.util.UserSession;

/**
 * @author Washington Botelho
 * @artigo http://wbotelhos.com.br/2010/04/07/controle-de-login-com-vraptor-3
 */

@Resource
public class LoginController {

	private Result result;
	private UsuarioDao usuarioDao;
	private UserSession userSession;

	public LoginController(Result result, UsuarioDao usuarioDao, UserSession userSession) {
		this.result = result;
		this.usuarioDao = usuarioDao;
		this.userSession = userSession;
	}

	@Get
	@Path("/login")
	public void login() {
	}

	@Post
	@Path("/login")
	public void login(Usuario usuario) {
		try {
			Usuario user = usuarioDao.login(usuario.getEmail(), usuario.getSenha());

			userSession.setUsuario(user);

			result.redirectTo(IndexController.class).index();
		} catch (Exception e) {
			e.printStackTrace();
			result.forwardTo(this).login();
		}
	}

	@Get
	@Path("/logout")
	public void logout() {
		userSession.setUsuario(null);
		result.redirectTo(this).login();
	}

}