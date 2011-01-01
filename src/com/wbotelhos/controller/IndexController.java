package com.wbotelhos.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

/**
 * @author Washington Botelho
 * @artigo http://wbotelhos.com.br/2010/04/07/controle-de-login-com-vraptor-3
 */

@Resource
public class IndexController {

	@Get
	@Path("/")
	public void index() {
	}

}