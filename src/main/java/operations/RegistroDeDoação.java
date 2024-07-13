package operations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import entities.CentroDeDistribuicao;
import entities.products.Alimento;
import entities.products.Higiene;
import entities.products.Roupa;
import products.enums.ProdutoDeHigiene;
import products.enums.Tamanho;
import products.enums.UnidadesDeMedida;
import repositories.DbOperations;

public class RegistroDeDoação {
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);
	DbOperations db = new DbOperations();

	public void menu(Integer id) {
		CentroDeDistribuicao centroDeDistribuicao = db.findCentro(id);
		System.out.println("Qual operação você deseja realizar:");
		System.out.println("1.Cadastrar Item \n2.Ler itens \n3.Editar item\n4.Excluir item");
		System.out.print("Opção:");
		int op = sc.nextInt();
		switch (op) {
		case 1:
			cadastrarItem(centroDeDistribuicao);
			System.out.println("Alimento cadastrado com sucesso");
			break;
		case 2:
			lerItens(centroDeDistribuicao);
			break;
		case 3:
			EditarItem(centroDeDistribuicao);
			System.out.println("Item editado!");
			break;
		case 4:
			excluirItem(centroDeDistribuicao);
			System.out.println("Item apagado!");
			break;
		default:
			throw new IllegalArgumentException("Opção inválida");	
		}
	}
	private void excluirItem(CentroDeDistribuicao centroDeDistribuicao) {
		System.out.println("Tipo de item você deseja excluir do centro:");
		System.out.println("1.Roupa \n2.Produtos de Higiene \n3.Alimentos");
		System.out.print("Opção:");
		int op = sc.nextInt();
		System.out.print("Id do produto que será removido:");
		int id = sc.nextInt();
		if(op == 1) {
			db.deleteProduto(db.findRoupa(id));
		}
		if(op == 2) {
			db.deleteProduto(db.findHigiene(id));
		}
		if(op == 3) {
			db.deleteProduto(db.findAlimento(id));
		}
	}

	private void lerItens(CentroDeDistribuicao centroDeDistribuicao) {
		System.out.println("Todos os itens do itens do centro:");
		List<Alimento> alimentos = db.findAlimentoByCentro(centroDeDistribuicao);
		List<Higiene> higiene = db.findHigieneByCentro(centroDeDistribuicao);
		List<Roupa> roupas = db.findRoupaByCentro(centroDeDistribuicao);
		if(alimentos.size()>0) {
			System.out.println("Alimentos:");
			alimentos.stream().forEach(p->System.out.println("ID: "+p.getId()+" -> "+p.getDescricacao()));
		}
		if(higiene.size() > 0) {
			System.out.println("Produto De higiene:");
			higiene.stream().forEach(p->System.out.println("ID: "+p.getId()+" -> "+p.getDescricacao()));
		}
		if(roupas.size()>0) {
			System.out.println("Roupas");
			roupas.stream().forEach(p->System.out.println("ID: "+p.getId()+" -> "+p.getDescricacao()));
		}
	}

	private void cadastrarItem(CentroDeDistribuicao centro) {
		System.out.println("Tipo de item você deseja cadastrar:");
		System.out.println("1.Roupa \n2.Produtos de Higiene \n3.Alimentos");
		System.out.print("Opção:");
		int op = sc.nextInt();
		sc.nextLine();
		System.out.print("Descrição:");
		String descricao = sc.nextLine();
		switch (op) {
		case 1:
			System.out.println("Gênero da roupa:");
			System.out.print("1.Masculino \n2.Feminino \nOpção:");
			int genero = sc.nextInt();
			Character gen = (genero == 1)?'M':'F';
			System.out.print("1.Infantil\n2.PP\n3.P\n4.M\n5.G\n6.GG\nTamanho:");
			int tamanho = sc.nextInt();
			Roupa roupa = new Roupa(descricao, centro, gen , Tamanho.valueOf(tamanho));
			db.cadastrarRoupaAoCentro(roupa);
			System.out.println("Roupa cadastrada com sucesso");
			break;
		case 2:
			System.out.print("1.Sabonete\n"
					+ "2.Escova de dentes\n"
					+ "3.Pasta de dentes\n"
					+ "4.Absorventes\n"
					+ "Tipo do produto:");
			int codigo = sc.nextInt();
			Higiene produtoDeHigiene = new Higiene(descricao, centro, ProdutoDeHigiene.valueOf(codigo));
			db.cadastrarHigieneAoCentro(produtoDeHigiene);
			System.out.println("Produto de higiene cadastrado com sucesso");
			break;
		case 3:
			System.out.print("Quantidade de alimentos:");
			int quantidade = sc.nextInt();
			System.out.print("1.KG \n2.G \n3.L \n4.ML\nEscolha uma unidade de medida:");
			int unidadeDeMedida = sc.nextInt();
			System.out.print("Data de validade(dd/MM/yyyy):");
			sc.nextLine();
			String data = sc.nextLine();
			LocalDate validade = LocalDate.parse(data, fmt);
			Alimento alimento = new Alimento(descricao, centro, quantidade, UnidadesDeMedida.valueOf(unidadeDeMedida), validade);
			db.cadastrarAlimentoAoCentro(alimento);
			break;
 		default:
			break;
		}
	}

	private void EditarItem(CentroDeDistribuicao centroDeDistribuicao) {
		System.out.println("Tipo de item você deseja Editar:");
		System.out.println("1.Roupa \n2.Produtos de Higiene \n3.Alimentos");
		System.out.print("Opção:");
		int op = sc.nextInt();
		System.out.print("ID do item que deseja ser alterado:");
		int id = sc.nextInt();
		if(op == 1){
			atualizarRoupa(id);
		}
		else if(op == 2) {
			atualizarProdutoDeHigiene(id);
		}
		else if(op == 3) {
			atualizarAliemento(id);
		}
	}

	private void atualizarAliemento(Integer id) {
		System.out.println("Propriedades que podem ser alteradas:");
		System.out.println("1.Descrição \n2.Quantidade \n3.Unidade de medida \n4.Data de validade");
		System.out.print("Opção:");
		int op = sc.nextInt();
		Alimento alimento = db.findAlimento(id);
		if(op == 1) {
			System.out.print("Descrição:");
			sc.nextLine();
			String descricao = sc.nextLine();
			alimento.setDescricacao(descricao);
		}
		else if(op == 2) {
			System.out.print("Quantidade:");
			int qnt = sc.nextInt();
			alimento.setQuantidade(qnt);
		}
		else if(op == 3) {
			System.out.print("1.KG \n2.G \n3.L \n4.ML\nEscolha uma unidade de medida:");
			int unidadeDeMedida = sc.nextInt();
			alimento.setUnidadeDeMedida(UnidadesDeMedida.valueOf(unidadeDeMedida));
		}
		else if(op == 4) {
			System.out.print("Nova data de validade:");
			sc.nextLine();
			String dataDeValidade = sc.nextLine();
			alimento.setValidade(LocalDate.parse(dataDeValidade, fmt));
		}
		db.AtualizarAlimento(alimento);
	}

	private void atualizarProdutoDeHigiene(Integer id) {
		System.out.println("Propriedades que podem ser alteradas:");
		System.out.println("1.Descrição \n2.Tipo de produto");
		int op = sc.nextInt();
		Higiene higiene = db.findHigiene(id);
		if(op == 1) {
			System.out.print("Descrição:");
			sc.nextLine();
			String descricao = sc.nextLine();
			higiene.setDescricacao(descricao);
		}
		else if(op == 2) {
			System.out.print("1.Sabonete\n"
					+ "2.Escova de dentes\n"
					+ "3.Pasta de dentes\n"
					+ "4.Absorventes\n"
					+ "Tipo do produto:");
			int codigo = sc.nextInt();
			higiene.setProdutoDeHigiene(ProdutoDeHigiene.valueOf(codigo));
		}
		db.AtualizarHigiene(higiene);
	}
	
	public void atualizarRoupa(Integer id) {
		System.out.println("Propriedades que podem ser alteradas:");
		System.out.println("1.Descricao \n2.Tamanho \nGênero ");
		System.out.print("Opção:");
		int op = sc.nextInt();
		Roupa roupa = db.findRoupa(id);
		
		if(op == 1) {
			System.out.print("Descrição:");
			sc.nextLine();
			String descricao = sc.nextLine();
			roupa.setDescricacao(descricao);
		}
		else if(op == 2) {
			System.out.print("1.Infantil\n2.PP\n3.P\n4.M\n5.G\n6.GG\nTamanho:");
			int tamanho = sc.nextInt();
			roupa.setTamanho(Tamanho.valueOf(tamanho));
		}
		else if(op == 3) {
			System.out.print("1.Masculino \n2.Feminino \nOpção:");
			int genero = sc.nextInt();
			Character gen = (genero == 1)?'M':'F';
			roupa.setGenero(gen);
		}
		db.AtualizarRoupa(roupa);
	}
}
