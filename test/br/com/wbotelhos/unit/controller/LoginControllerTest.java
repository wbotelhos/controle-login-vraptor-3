package br.com.wbotelhos.unit.controller;

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

	@Spy private Result result = new MockResult();

	@Mock private UserSession userSession;
	@Mock private LoginBusiness business;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new LoginController(result, userSession, business);
	}

	@Test
	public void deveriaLogin() {
		
	}

	@Test
	public void deveriaAutenticar() {
		// given
		Usuario entity = new Usuario();
		entity.setEmail("email@email.com");
		entity.setSenha("senha");

		// when
		controller.autenticar(entity);

		// then
		verify(business).autenticar(entity.getEmail(), entity.getSenha());
		assertTrue("nao deve haver error", result.included().containsKey("error"));
	}

	//@Test // TODO: mockar o UserSession.
	public void deveriaLogout() {
		// given
		Usuario user = new Usuario();
		Mockito.when(userSession.getUser()).thenReturn(user);

		// when
		controller.logout();

		// then
		assertTrue("nao deve haver usuario na sessao", userSession.getUser() == null);
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