package com.wbotelhos.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;

import com.wbotelhos.model.Usuario;

/**
 * @author Washington Botelho
 * @artigo http://wbotelhos.com.br/2010/04/07/controle-de-login-com-vraptor-3
 */

@Component
public class UsuarioDao {

	private EntityManager manager;

	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	public Usuario login(String email, String senha) throws Exception {
		try {
			Query query = manager.createQuery("from Usuario u where u.email = :email and u.senha = :senha");
			query.setParameter("email", email);
			query.setParameter("senha", senha);
			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			throw new Exception("Usu�rio ou senha incorreta!", e);
		} catch (NonUniqueResultException e) {
			throw new Exception("Erro! Usu�rio duplicado.", e);
		} catch (Exception e) {
			throw new Exception("N�o foi poss�vel acessar o sistema!", e);
		}
	}

}