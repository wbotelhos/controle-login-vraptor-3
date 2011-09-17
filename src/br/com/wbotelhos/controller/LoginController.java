package br.com.wbotelhos.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.wbotelhos.annotation.Public;
import br.com.wbotelhos.business.LoginBusiness;
import br.com.wbotelhos.component.UserSession;
import br.com.wbotelhos.model.Usuario;

/**
 * @author Washington Botelho
 * @article http://wbotelhos.com.br/2010/04/07/controle-de-login-com-vraptor-3
 */

@Resource
public class LoginController {

	private Result result;
	private UserSession userSession;
	private LoginBusiness business;

	public LoginController(Result result, UserSession userSession, LoginBusiness business) {
		this.result = result;
		this.userSession = userSession;
		this.business = business;
	}

	@Public
	@Get("/login")
	public void login() {

	}

	@Public
	@Post("/autenticar")
	public void autenticar(Usuario usuario) {
		Usuario user = business.autenticar(usuario.getEmail(), usuario.getSenha());

		if (user != null) {
			userSession.setUser(user);

			result.redirectTo(IndexController.class).index();
		} else {
			result.include("error", "E-mail ou senha incorreta!").redirectTo(this).login();
		}
	}

	@Get("/logout")
	public void logout() {
		userSession.logout();
		result.redirectTo(this).login();
	}

}