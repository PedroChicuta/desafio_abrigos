package products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import entities.CentroDeDistribuicao;
import products.enums.Tamanho;

@Entity
@Table(name="roupas")
public class Roupa extends Item{
	private static final long serialVersionUID = 1L;
	
	
	private char Genero;
	private Integer tamanho;
	
	public Roupa() {
	}
	
	public Roupa(String descricao, CentroDeDistribuicao centroDeDistribuicao, char genero, Tamanho tamanho) {
		super(descricao, centroDeDistribuicao);
		Genero = genero;
		setTamanho(tamanho);
	}

	public char getGenero() {
		return Genero;
	}
	public void setGenero(char genero) {
		Genero = genero;
	}
	public Tamanho getTamanho() {
		return Tamanho.valueOf(tamanho);
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho.getCode();
	}

	@Override
	public String toString() {
		return "Roupa [Genero=" + Genero + ", tamanho=" + tamanho + ", descricao = "+ super.getDescricacao()+"]";
	}
	
	
}
