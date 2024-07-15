package csvOperations;

import java.util.List;
import java.util.Scanner;

import entities.Abrigo;
import entities.products.Item;
import repositories.DbOperations;

public class RegistroEmAbrigo {
	private DbOperations db = new DbOperations();
	private Scanner sc = new Scanner(System.in);

	public void RegistrarEmAbrigo() {
		List<Abrigo> abrigos =  db.getAbrigoTable();
		System.out.print("Id do Abrigo:");
		int id = sc.nextInt();
		for (Abrigo abrigo : abrigos) {
			if (id == abrigo.getId()) {
				sc.nextLine();
				System.out.println("Caminho:");
				String caminho = sc.nextLine();
				AdicionarItem adicionarItem = new AdicionarItem(caminho);
				List<Item> ItensNoArquivo = adicionarItem.AdicionarCsv();
				ItensNoArquivo.forEach(p->p.setAbrigo(db.findAbrigo(id)));
				ItensNoArquivo.forEach(p->db.addItem(p));
				System.out.println("Feito!");
			}
		}
	}
}
