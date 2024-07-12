package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abrigo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome_do_abrigo")
	private String nome;
	private String endereco;
	private String responsavel;
	private String telefone;
	private String email;
	private Integer ocupacao;
	
	public Abrigo(String nome, String endereco, String responsavel, String telefone, String email, Integer ocupacao) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.responsavel = responsavel;
		this.telefone = telefone;
		this.email = email;
		setOcupacao(ocupacao);
	}
	public String getNome() {
		return nome;
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
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(Integer ocupacao) {
		if(ocupacao > 100 || ocupacao < 0) {
			throw new IllegalArgumentException("Porcentagem de ocupação inválida");
		}
		this.ocupacao = ocupacao;
	}
	public Integer getId() {
		return id;
	}
	
}