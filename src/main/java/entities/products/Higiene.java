package entities.products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import entities.Abrigo;
import entities.CentroDeDistribuicao;
import products.enums.ProdutoDeHigiene;

@Entity
@Table(name = "produtos_de_higiene")
public class Higiene extends Item{
	private static final long serialVersionUID = 1L;
	
	private Integer produtoDeHigiene;
	
	public Higiene() {
	}
	public Higiene(String descricao , CentroDeDistribuicao centroDeDistribuicao, ProdutoDeHigiene produtoDeHigiene) {
		super(descricao, centroDeDistribuicao);
		setProdutoDeHigiene(produtoDeHigiene);
	}
	public Higiene(String descricao , Abrigo abrigo, ProdutoDeHigiene produtoDeHigiene) {
		super(descricao, abrigo);
		setProdutoDeHigiene(produtoDeHigiene);
	}
	public ProdutoDeHigiene getProdutoDeHigiene() {
		return ProdutoDeHigiene.valueOf(produtoDeHigiene);
	}

	public void setProdutoDeHigiene(ProdutoDeHigiene produtoDeHigiene) {
		if(produtoDeHigiene != null) {
			this.produtoDeHigiene = produtoDeHigiene.getCode();
		}
		
	}

	@Override
	public String toString() {
		return "Higiene [produtoDeHigiene=" + produtoDeHigiene + ", descricao = "+ super.getDescricacao()+"]";
	}
	
}
