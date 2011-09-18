package br.com.wbotelhos.unit.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import br.com.wbotelhos.controller.IndexController;

public class IndexControllerTest {

	private IndexController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new IndexController();
	}

	@Test
	public void deveriaIndex() {
		// given

		// when
		controller.index();

		// then
	}

}