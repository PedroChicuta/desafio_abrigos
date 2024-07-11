package products;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import entities.CentroDeDistribuicao;
@MappedSuperclass
public abstract class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	private String descricacao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="centro_de_distribuicao_id")
	private CentroDeDistribuicao centroDeDistribuicao;
	
	public Item() {
	}
	public Item(String descricacao, CentroDeDistribuicao centroDeDistribuicao) {
		this.setCentroDeDistribuicao(centroDeDistribuicao);
		this.descricacao = descricacao;
	}
	public Integer getId() {
		return id;
	}
	public String getDescricacao() {
		return descricacao;
	}
	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}
	public CentroDeDistribuicao getCentroDeDistribuicao() {
		return centroDeDistribuicao;
	}
	public void setCentroDeDistribuicao(CentroDeDistribuicao centroDeDistribuicao) {
		this.centroDeDistribuicao = centroDeDistribuicao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return id == other.id;
	}	
}
