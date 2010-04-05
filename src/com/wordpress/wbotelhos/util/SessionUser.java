package com.wordpress.wbotelhos.util;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

import com.wordpress.wbotelhos.model.Usuario;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.wordpress.com/2010/04/06/controle-de-login-com-vraptor-3
 */

@Component
@SessionScoped
public class SessionUser {

	private static final String CURRENT_USER = "currentUser";
	private HttpSession session;

	public SessionUser(HttpSession session) {
		this.session = session;
	}

	public void setUsuario(Usuario usuario) {
		this.session.setAttribute(CURRENT_USER, usuario);
	}

	public Usuario getUsuario() {
		return (Usuario) this.session.getAttribute(CURRENT_USER);
	}

}