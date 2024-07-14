package operations;

import java.util.Scanner;

import entities.Abrigo;
import repositories.DbOperations;

/*
 * Registro de Abrigos
Registro de abrigos aptos a receber as doações: cadastro, leitura, edição e exclusão de
abrigos.
Deverá ser armazenado o nome, endereço, responsável, telefone e email de contato,
capacidade e ocupação (%) de cada abrigo.
Todos os dados inseridos devem passar por uma validação.
 Ao buscar um abrigo, além dos dados acima, deve-se listar a quantidade de cada item
recebido pelo abrigo.

 * */
public class RegistroDeAbrigo {
	Scanner sc = new Scanner(System.in);
	DbOperations db = new DbOperations();

	public void menu() {
		System.out.println("Escolha uma operação:");
		System.out.println("1.Cadastro \n2.Ler Abrigos \n3.Editar Abrigo \n4.Excluir abrigo");
		System.out.print("Opção:");
		int op = sc.nextInt();
		switch (op) {
		case 1:
			cadastrar();
			break;
		case 2:
			ler();
			break;
		case 3:
			editar();
			break;
		case 4:
			excluir();
		default:
			throw new Error("Opção inválida");
		}
		
	}

	private void excluir() {
		System.out.println("--- Excluir Abrigo ---");
		System.out.print("Id do abrigo que será excluido:");
		int id = sc.nextInt();
		db.deleteAbrigo(db.findAbrigo(id));
	}

	private void editar() {
		System.out.println("--- Editar abrigo ---");
		System.out.print("Id do abrigo:");
		int id = sc.nextInt();
		Abrigo abrigo = db.findAbrigo(id);
		System.out.println("Qual propriedade será alterada:");
		System.out.println("1.Nome \n2.Endereço \n3.Responsável \n4.Telefone \n5.email de contato "
				+ "\n6.capacidade maxima \n7.ocupação (%)");
		System.out.print("Opção:");
		Integer op = sc.nextInt();
		switch (op) {
		case 1:
			System.out.println("Novo nome:");
			String nome = sc.nextLine();
			abrigo.setNome(nome);
			break;
		case 2:
			System.out.println("Novo Endereço:");
			String endereco = sc.nextLine();
			abrigo.setEndereco(endereco);
			break;
		case 3:
			System.out.println("Novo Responsável:");
			String responsavel = sc.nextLine();
			abrigo.setResponsavel(responsavel);
			break;
		case 4:
			System.out.println("Novo telefone:");
			String telefone = sc.nextLine();
			abrigo.setTelefone(telefone);
			break;
		case 5:
			System.out.println("Novo email:");
			String email = sc.nextLine();
			abrigo.setEmail(email);
			break;
		case 6:
			System.out.println("Nova Ocupação máxima:");
			int ocupacaoMax = sc.nextInt();
			abrigo.setCapacidadeMaxima(ocupacaoMax);
			break;
		case 7:
			System.out.println("Nova porcentagem ocupada:");
			int ocupacaoPer = sc.nextInt();
			abrigo.setOcupacao(ocupacaoPer);
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
		db.atualizarAbrigo(abrigo);
	}

	private void ler() {
		System.out.println("---Ler Abrigos---");
		db.getAbrigoTable().forEach(p -> System.out.println(p));
	}

	private void cadastrar() {
		System.out.println("----Cadastro de novo abrigo----");
		System.out.println("Nome do abrigo:");
		sc.nextLine();
		String nomea = sc.nextLine();
		System.out.print("Endereço do abrigo:");
		String endereco = sc.nextLine();
		System.out.println("Nome do Responsável:");
		String nomer = sc.nextLine();
		System.out.print("Telefone do abrigo:");
		String telefone = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Capacidade de ocupação:");
		Integer capacidadeMaxima = sc.nextInt();
		System.out.print("Ocupação atual(%):");
		Integer ocupacao = sc.nextInt();
		db.addAbrigo(new Abrigo(nomea, endereco, nomer, telefone, email, capacidadeMaxima, ocupacao));
	}
}
