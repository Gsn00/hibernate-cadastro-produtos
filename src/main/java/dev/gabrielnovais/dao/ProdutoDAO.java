package dev.gabrielnovais.dao;

import dev.gabrielnovais.entities.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDAO extends GenericDAO<Produto, Long> {

	public ProdutoDAO(EntityManager em) {
		super(em, Produto.class);
	}
}
