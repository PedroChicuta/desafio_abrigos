package operations;

import java.util.List;
import java.util.Scanner;

import entities.Abrigo;
import entities.CentroDeDistribuicao;
import entities.products.Alimento;
import entities.products.Higiene;
import entities.products.Roupa;
import repositories.DbOperations;

public class OrdemDePedido {
	Scanner sc = new Scanner(System.in);
	DbOperations db = new DbOperations();
	List<CentroDeDistribuicao> centros = db.getCentroTable();
	CentroDeDistribuicao centro1 = centros.get(0);
	CentroDeDistribuicao centro2 = centros.get(1);
	CentroDeDistribuicao centro3 = centros.get(2);

	public void menu() {
		System.out.println("--- Ordem de pedido ---");
		System.out.print("Id do abrigo que deseja os itens:");
		int abrigoId = sc.nextInt();
		Abrigo abrigo = db.findAbrigo(abrigoId);
		System.out.println("Tipo de item desejado:");
		System.out.println("1.Roupa \n2.Higiene \n3.Alimentos");
		System.out.print("Opção:");
		int op = sc.nextInt();
		if (op == 1) {
			PedidoRoupa(abrigo);
		}

		if (op == 2){
			PedidoHigiene(abrigo);
		}
		if (op == 3) {
			PedidoAlimentos(abrigo);
		}
	}
	private void PedidoRoupa(Abrigo abrigo) {
		System.out.println("Quantidade de Roupas necessárias:");

		int requisicao = sc.nextInt();
		List<Roupa> alimentosCentro1 = db.findRoupaByCentro(centro1);
		List<Roupa> alimentosCentro2 = db.findRoupaByCentro(centro2);
		List<Roupa> alimentosCentro3 = db.findRoupaByCentro(centro3);
		System.out.println(
				"ID:" + centro1.getId() + ", " + centro1.getNome() + "=>" + alimentosCentro1.size() + " Roupas");
		System.out.println(
				"ID:" + centro2.getId() + ", " + centro2.getNome() + "=>" + alimentosCentro2.size() + " Roupas");
		System.out.println(
				"ID:" + centro3.getId() + ", " + centro3.getNome() + "=>" + alimentosCentro3.size() + " Roupas");
		System.out.println("id do centro:");
		int idCentro = sc.nextInt();
		List<Roupa> itensEmCentro = db.findRoupaByCentro(db.findCentro(idCentro));
		if (itensEmCentro.size() <= requisicao) {
			for (Roupa r : itensEmCentro) {
				r.setAbrigo(abrigo);
				db.AtualizarRoupa(r);
			}
		} else {
			for (int i = 0; i < requisicao; i++) {
				Roupa a = itensEmCentro.get(i);
				System.out.println(a);
				a.setAbrigo(abrigo);
				db.AtualizarRoupa(a);
			}
		}
	}
	public void PedidoHigiene(Abrigo abrigo) {
		System.out.println("Quantidade de Produtos de Higiene necessários:");
		int requisicao = sc.nextInt();
		List<Higiene> higieneCentro1 = db.findHigieneByCentro(centro1);
		List<Higiene> higieneCentro2 = db.findHigieneByCentro(centro2);
		List<Higiene> higieneCentro3 = db.findHigieneByCentro(centro3);
		
		System.out.println(
				"ID:" + centro1.getId() + ", " + centro1.getNome() + "=>" + higieneCentro1.size() + "Produtos de Higiene");
		System.out.println(
				"ID:" + centro2.getId() + ", " + centro2.getNome() + "=>" + higieneCentro2.size() + "Produtos de Higiene");
		System.out.println(
				"ID:" + centro3.getId() + ", " + centro3.getNome() + "=>" + higieneCentro3.size() +"Produtos de Higiene");
		System.out.print("centro doador:");
		int idCentro = sc.nextInt();
		List<Higiene> itensEmCentro = db.findHigieneByCentro(db.findCentro(idCentro));
		if (itensEmCentro.size() <= requisicao) {
			for (Higiene a : itensEmCentro) {
				a.setAbrigo(abrigo);
			}
		} else {
			for (int i = 0; i < requisicao; i++) {
				Higiene a = db.getHigieneTable().get(i);
				a.setAbrigo(abrigo);
				db.AtualizarHigiene(a);
			}
		}
	}
	public void PedidoAlimentos(Abrigo abrigo) {
		System.out.println("Quantidade de alimentos necessários:");
		int requisicao = sc.nextInt();
		List<Alimento> alimentosCentro1 = db.findAlimentoByCentro(centro1);
		List<Alimento> alimentosCentro2 = db.findAlimentoByCentro(centro2);
		List<Alimento> alimentosCentro3 = db.findAlimentoByCentro(centro3);
		System.out.println(
				"ID:" + centro1.getId() + ", " + centro1.getNome() + "=>" + alimentosCentro1.size() + "Alimentos");
		System.out.println(
				"ID:" + centro2.getId() + ", " + centro2.getNome() + "=>" + alimentosCentro2.size() + "Alimentos");
		System.out.println(
				"ID:" + centro3.getId() + ", " + centro3.getNome() + "=>" + alimentosCentro3.size() + "Alimentos");
		System.out.print("centro doador:");
		int idCentro = sc.nextInt();
		List<Alimento> itensEmCentro = db.findAlimentoByCentro(db.findCentro(idCentro));
		if (itensEmCentro.size() <= requisicao) {
			for (Alimento a : itensEmCentro) {
				a.setAbrigo(abrigo);
			}
		} else {
			for (int i = 0; i < requisicao; i++) {	
				Alimento a = db.getAlimentoTable().get(i);
				a.setAbrigo(abrigo);
				db.AtualizarAlimento(a);
			}
		}
	}

}
