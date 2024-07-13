package repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Abrigo;
import entities.CentroDeDistribuicao;
import entities.products.Alimento;
import entities.products.Higiene;
import entities.products.Item;
import entities.products.Roupa;

public class DbOperations {
	static private EntityManager em = null;
	static private EntityManagerFactory emf = null;
	
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
	private void addItem(Item produto) {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}
	/*
	 * Metodos que busca os itens no banco de dados e salva em ArraysList
	 */
	
	private List<Alimento> getAlimentoTable() {
		List<Alimento> itens = new ArrayList<>();
		itens = em.createQuery("SELECT p FROM Alimento p", Alimento.class).getResultList();
		return itens;
	}
	public List<CentroDeDistribuicao> getCentroTable() {
		List<CentroDeDistribuicao> itens = new ArrayList<>();
		itens = em.createQuery("SELECT p FROM CentroDeDistribuicao p", CentroDeDistribuicao.class).getResultList();
		return itens;
	}
	private List<Higiene> getHigieneTable() {
		List<Higiene> itens = new ArrayList<>();
		itens = em.createQuery("SELECT h FROM Higiene h", Higiene.class).getResultList();
		return itens;
	}
	private List<Roupa> getRoupaTable() {
		List<Roupa> itens = new ArrayList<>();
		itens = em.createQuery("SELECT r FROM Roupa r", Roupa.class).getResultList();
		return itens;
	}
	
	public List<Alimento> findAlimentoByCentro(CentroDeDistribuicao centroDeDistribuicao) {
		List<Alimento> arr = getAlimentoTable();
		arr.removeIf(p->(p.getCentroDeDistribuicao().equals(centroDeDistribuicao)) == false);
		return arr;
	}
	public List<Higiene> findHigieneByCentro(CentroDeDistribuicao centroDeDistribuicao) {
		List<Higiene> arr = getHigieneTable();
		arr.removeIf(p->(p.getCentroDeDistribuicao().equals(centroDeDistribuicao)) == false);
		return arr;
	}
	public List<Roupa> findRoupaByCentro(CentroDeDistribuicao centroDeDistribuicao) {
		List<Roupa> arr = getRoupaTable();
		arr.removeIf(p->(p.getCentroDeDistribuicao().equals(centroDeDistribuicao)) == false);
		return arr;
	}
	public void cadastrarAlimentoAoCentro(Alimento produto) {
		List<Alimento> alimentos =getAlimentoTable();
		alimentos.removeIf(p-> p.getCentroDeDistribuicao() == null);
		if (alimentos.size() >= 10) {
			throw new IllegalArgumentException("Já existem 10 itens cadastrados no centro de Ditribuição");
		} else {
			addItem(produto);
		}
	}
	public void cadastrarHigieneAoCentro(Higiene produto) {
		List<Higiene> alimentos =getHigieneTable();
		alimentos.removeIf(p-> p.getCentroDeDistribuicao() == null);
		if (alimentos.size() >= 10) {
			throw new IllegalArgumentException("Já existem 10 itens cadastrados no centro de Ditribuição");
		} else {
			addItem(produto);
		}
	}
	public void cadastrarRoupaAoCentro(Roupa produto) {
		List<Roupa> alimentos =getRoupaTable();
		alimentos.removeIf(p-> p.getCentroDeDistribuicao() == null);
		if (alimentos.size() >= 10) {
			throw new IllegalArgumentException("Já existem 10 itens cadastrados no centro de Ditribuição");
		} else {
			addItem(produto);
		}
	}
	public Alimento findAlimento(Integer n) {
		return em.find(Alimento.class, n);
	}
	public Higiene findHigiene(Integer n) {
		return em.find(Higiene.class, n);
	}
	public Roupa findRoupa(Integer n) {
		return em.find(Roupa.class, n);
	}

	public void addCentro(CentroDeDistribuicao centro) {
		em.getTransaction().begin();
		em.persist(centro);
		em.getTransaction().commit();
	}
	public CentroDeDistribuicao findCentro(Integer id) {
		return em.find(CentroDeDistribuicao.class, id);
	}
	public void addAbrigo(Abrigo abrigo) {
		em.getTransaction().begin();
		em.persist(abrigo);
		em.getTransaction().commit();
	}
	public void deleteProduto(Item produto) {
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}
	public void AtualizarRoupa(Roupa roupa) {
		em.getTransaction().begin();
		em.merge(roupa);
		em.getTransaction().commit();
	}
	public void AtualizarHigiene(Higiene higiene) {
		em.getTransaction().begin();
		em.merge(higiene);
		em.getTransaction().commit();
	}
	public void AtualizarAlimento(Alimento alimento) {
		em.getTransaction().begin();
		em.merge(alimento);
		em.getTransaction().commit();
	}
	
}
