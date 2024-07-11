package products;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import entities.CentroDeDistribuicao;
import products.enums.UnidadesDeMedida;

@Entity
@Table(name = "alimentos")
public class Alimento extends Item {
	private static final long serialVersionUID = 1L;
	
	private Integer quantidade;
	
	private Integer unidadeDeMedida;
	private LocalDate validade;
	
	public Alimento(){
	}
	
	public Alimento(String descricao, CentroDeDistribuicao centroDeDistribuicao, Integer quantidade, UnidadesDeMedida unidadeDeMedida, LocalDate validade) {
		super(descricao, centroDeDistribuicao);
		this.quantidade = quantidade;
		setUnidadeDeMedida(unidadeDeMedida);
		this.validade = validade;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public UnidadesDeMedida getUnidadeDeMedida() {
		return UnidadesDeMedida.valueOf(unidadeDeMedida);
	}

	public void setUnidadeDeMedida(UnidadesDeMedida unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida.getCode();
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	
	@Override
	public String toString() {
		return "Alimento [quantidade=" + quantidade + ", UnidadeDeMedida=" + unidadeDeMedida + ", validade=" + validade
				+", descricao = "+ super.getDescricacao()+ "]";
	}
}
