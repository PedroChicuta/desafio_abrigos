package db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.CentroDeDistribuicao;
import products.Alimento;
import products.Higiene;
import products.Item;
import products.Roupa;

public class DbOperations {
	private EntityManager em = null;
	private EntityManagerFactory emf = null;
	
	public DbOperations() {
		createEntityManager();
	}
	
	private void createEntityManager() {
		emf = Persistence.createEntityManagerFactory("proj");
		em = emf.createEntityManager();
	}
	
	
	public void closeEntityManager() {
		em.close();
		emf.close();
	}
	/*
	 * Encontra produtos do mesmo tipo do produto colocado no argumento buscando na
	 * db e construindo um arrayList
	 */
	
	private Integer getAlimentoTableSize(Alimento item) {
		List<Alimento> itens = new ArrayList<>();
		itens = em.createQuery("SELECT p FROM Alimento p", Alimento.class).getResultList();
		return itens.size();
	}
	public void addAlimento(Alimento produto) {
		int tamanhoDaDb = getAlimentoTableSize(produto);
		if (tamanhoDaDb >= 10) {
			throw new IllegalArgumentException("Já existem 10 itens cadastrados");
		} else {
			addItem(produto);
		}
	}
	public Alimento findAlimento(Integer n) {
		return em.find(Alimento.class, n);
	}

	
	private Integer getHigieneTableSize(Higiene item) {
		List<Higiene> itens = new ArrayList<>();
		itens = em.createQuery("SELECT h FROM Higiene h", Higiene.class).getResultList();
		return itens.size();
	}
	public void addHigiene(Higiene produto) {
		int tamanhoDaDb = getHigieneTableSize(produto);
		if (tamanhoDaDb >= 10) {
			throw new IllegalArgumentException("Já existem 10 itens cadastrados");
		} else {
			addItem(produto);
		}
	}
	public Higiene findHigiene(Integer n) {
		return em.find(Higiene.class, n);
	}

	private Integer getRoupaTableSize(Roupa item) {
		List<Roupa> itens = new ArrayList<>();
		itens = em.createQuery("SELECT r FROM Roupa r", Roupa.class).getResultList();
		return itens.size();
	}
	
	public void addRoupa(Roupa produto) {
		int tamanhoDaDb = getRoupaTableSize(produto);
		if (tamanhoDaDb >= 10) {
			throw new IllegalArgumentException("Já existem 10 itens cadastrados");
		} else {
			addItem(produto);
		}
	}

	public Roupa findRoupa(Integer n) {
		return em.find(Roupa.class, n);
	}

	private void addItem(Item produto) {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}

	public void addCentro(CentroDeDistribuicao centro) {
		em.getTransaction().begin();
		em.persist(centro);
		em.getTransaction().commit();
	}
	
	

	public void deleteProduto(Item produto) {
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}

	
}