package br.com.wbotelhos.unit.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.wbotelhos.annotation.Public;
import br.com.wbotelhos.business.LoginBusiness;
import br.com.wbotelhos.component.UserSession;
import br.com.wbotelhos.controller.LoginController;
import br.com.wbotelhos.model.Usuario;

public class LoginControllerTest {

	private LoginController controller;
	private UserSession userSession = new UserSession();

	@Spy private Result result = new MockResult();

	@Mock private LoginBusiness business;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new LoginController(result, userSession, business);
	}

	@Test
	public void deveriaLogin() {
		// given
		
		// when
		controller.login();

		// then
	}

	@Test
	public void deveriaAutenticar() {
		// given
		Usuario entity = new Usuario();
		entity.setEmail("email@email.com");
		entity.setSenha("senha");

		Mockito.when(business.autenticar(entity.getEmail(), entity.getSenha())).thenReturn(entity);

		// when
		controller.autenticar(entity);

		// then
		verify(business).autenticar(entity.getEmail(), entity.getSenha());

		assertTrue("deve haver usuario na sessao", userSession.isLogged());
		assertEquals("deve ser o usuario correto", entity.getEmail(), userSession.getUser().getEmail());
		assertFalse("nao deve haver mensagem de error", result.included().containsKey("error"));
	}

	@Test
	public void deveriaNaoAutenticar() {
		// given
		Usuario entity = new Usuario();
		entity.setEmail("email@email.com");
		entity.setSenha("senha");

		Mockito.when(business.autenticar(entity.getEmail(), entity.getSenha())).thenReturn(null);

		// when
		controller.autenticar(entity);

		// then
		verify(business).autenticar(entity.getEmail(), entity.getSenha());

		assertFalse("nao deve haver usuario na sessao", userSession.isLogged());
		assertTrue("deve haver mensagem de error", result.included().containsKey("error"));
	}

	@Test
	public void deveriaLogout() {
		// given
		userSession.setUser(new Usuario());

		// when
		controller.logout();

		// then
		assertFalse("nao deve haver usuario na sessao", userSession.isLogged());
	}

	@Test
	public void deveriaEstarAnotadoComPermissaoPublicOMetodoLogin() throws SecurityException, NoSuchMethodException {
		// given
		Class<? extends LoginController> clazz = controller.getClass();
		Method method = clazz.getMethod("login");

		// when
		Public annotation = method.getAnnotation(Public.class);

		// then
		assertNotNull(annotation);
		assertTrue(method.isAnnotationPresent(Public.class));
	}

	@Test
	public void deveriaEstarAnotadoComPermissaoPublicOMetodoAutenticar() throws SecurityException, NoSuchMethodException {
		// given
		Class<? extends LoginController> clazz = controller.getClass();
		Method method = clazz.getMethod("autenticar", Usuario.class);

		// when
		Public annotation = method.getAnnotation(Public.class);

		// then
		assertNotNull(annotation);
		assertTrue(method.isAnnotationPresent(Public.class));
	}

}