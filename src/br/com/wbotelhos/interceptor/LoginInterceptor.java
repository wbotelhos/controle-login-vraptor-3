package br.com.wbotelhos.interceptor;

import java.util.Arrays;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.wbotelhos.controller.LoginController;
import br.com.wbotelhos.util.UserSession;

/**
 * @author Washington Botelho
 * @artigo http://wbotelhos.com.br/2010/04/07/controle-de-login-com-vraptor-3
 */

@Intercepts
public class LoginInterceptor implements Interceptor {

	private Result result;
	private UserSession userSession;

	public LoginInterceptor(Result result, UserSession userSession) {
		this.result = result;
		this.userSession = userSession;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean accepts(ResourceMethod method) {
		return !Arrays.asList(LoginController.class).contains(method.getMethod().getDeclaringClass());
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) {
		if (userSession.getUsuario() != null) {
			stack.next(method, resourceInstance);
		} else {
			result.redirectTo(LoginController.class).login();
		}
	}

}