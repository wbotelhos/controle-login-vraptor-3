package com.wordpress.wbotelhos.controller;

import static br.com.caelum.vraptor.view.Results.logic;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.wordpress.wbotelhos.dao.UsuarioDao;
import com.wordpress.wbotelhos.model.Usuario;
import com.wordpress.wbotelhos.util.SessionUser;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.wordpress.com/2010/04/06/controle-de-login-com-vraptor-3
 */

@Resource
public class LoginController {

	private Result result;
	private UsuarioDao usuarioDao;
	private SessionUser sessionUser;

	public LoginController(Result result, UsuarioDao usuarioDao, SessionUser sessionUser) {
		this.result = result;
		this.usuarioDao = usuarioDao;
		this.sessionUser = sessionUser;
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

			sessionUser.setUsuario(user);

			result.use(logic()).redirectTo(IndexController.class).index();
		} catch (Exception e) {
			e.printStackTrace();
			result.use(logic()).redirectTo(getClass()).login();
		}
	}

	@Get
	@Path("/logout")
	public void logout() {
		sessionUser.setUsuario(null);
		result.use(logic()).redirectTo(getClass()).login();
	}

}