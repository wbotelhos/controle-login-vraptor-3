package com.wordpress.wbotelhos.util;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

import com.wordpress.wbotelhos.model.Usuario;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.wordpress.com/2010/04/07/controle-de-login-com-vraptor-3
 */

@Component
@SessionScoped
public class SessionUser {

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}