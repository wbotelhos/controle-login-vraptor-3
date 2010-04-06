package com.wordpress.wbotelhos.interceptor;

import static br.com.caelum.vraptor.view.Results.logic;

import java.util.Arrays;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

import com.wordpress.wbotelhos.controller.LoginController;
import com.wordpress.wbotelhos.util.SessionUser;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.wordpress.com/2010/04/06/controle-de-login-com-vraptor-3
 */

@Intercepts
public class LoginInterceptor implements Interceptor {

	private Result result;
	private SessionUser sessionUser;

	public LoginInterceptor(Result result, SessionUser sessionUser) {
		this.result = result;
		this.sessionUser = sessionUser;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean accepts(ResourceMethod method) {
		return !Arrays.asList(LoginController.class).contains(method.getMethod().getDeclaringClass());
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) {
		if (sessionUser.getUsuario() != null) {
			stack.next(method, resourceInstance);
		} else {
			result.use(logic()).redirectTo(LoginController.class).login();
		}
	}

}