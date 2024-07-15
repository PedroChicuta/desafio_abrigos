package application;

import java.util.List;

import java.util.Scanner;

import csvOperations.RegistroViaCSV;
import entities.CentroDeDistribuicao;
import operations.Centros;
import operations.OrdemDePedido;
import operations.RegistroDeAbrigo;
import operations.RegistroDeDoação;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Centros centrosOp = new Centros();
		List<CentroDeDistribuicao> centrosDeDistribuicao = centrosOp.findAllCentros();
		CentroDeDistribuicao centro1 = centrosDeDistribuicao.get(0);
		CentroDeDistribuicao centro2 = centrosDeDistribuicao.get(1);
		CentroDeDistribuicao centro3 = centrosDeDistribuicao.get(2);
		
		while (true) {
			System.out.println("------------- Escolha uma operação -------------");
			System.out.println("1.Registro de doações");
			System.out.println("2.Registro de abrigo");
			System.out.println("3.Ordem de pedidos");
			System.out.println("4.Registrar doação via CSV");
			System.out.print("Digite uma opção(0 para sair):");
			int op = scanner.nextInt();
			if (op == 0) {
				break;
			} else {
				switch (op) {
				case 1:
					RegistroDeDoação registroDeDoação = new RegistroDeDoação();
					System.out.println("Escolha o centro em que você irá realizar a operação:");
					System.out.println("1." + centro1.getNome() + "\n" + "2." + centro2.getNome() + "\n" + "3."
							+ centro3.getNome());
					System.out.print("Centro desejado:");
					int centros = scanner.nextInt();
					registroDeDoação.menu(centros);
					break;
				case 2:
					RegistroDeAbrigo registroDeAbrigo = new RegistroDeAbrigo();
					registroDeAbrigo.menu();
					break;
				case 3:
					OrdemDePedido ordemDePedido = new OrdemDePedido();
					ordemDePedido.menu();
					break;
				case 4:
					RegistroViaCSV registro = new RegistroViaCSV();
					registro.Menu();
					break;
				default:
					System.out.println("Opção inválida");				
					}
			}
		}
		scanner.close();
		System.out.println("end");
	}

}
