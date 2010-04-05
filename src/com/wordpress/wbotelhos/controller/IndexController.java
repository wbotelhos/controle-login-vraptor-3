package com.wordpress.wbotelhos.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.wordpress.com/2010/04/05/controle-de-login-com-vraptor-3
 */

@Resource
public class IndexController {

	@Get
	@Path("/")
	public void index() {
	}

}