package entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "centro_de_distribuicao")
public class CentroDeDistribuicao implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String endereco;
	public CentroDeDistribuicao() {
		
	}
	
	public CentroDeDistribuicao(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco; 
	}

	public String getNome() {
		return nome;
	}
	public Integer getId() {
		return id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
		CentroDeDistribuicao other = (CentroDeDistribuicao) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
