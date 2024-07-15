package csvOperations;

import java.util.List;
import java.util.Scanner;

import entities.CentroDeDistribuicao;
import entities.products.Item;
import operations.Centros;
import repositories.DbOperations;

public class RegistroEmCentro {
	DbOperations db = new DbOperations();
	Centros centros = new Centros();
	List<CentroDeDistribuicao> centrosDeDistribuicao = centros.findAllCentros(); 
	Scanner sc = new Scanner(System.in);
	public void RegistraEmCentro() {
		System.out.print("Id do Centro:");
		int id = sc.nextInt();
		for(CentroDeDistribuicao centro : centrosDeDistribuicao) {
			if(id == centro.getId()) {
				sc.nextLine();
				System.out.println("Caminho:");
				String caminho = sc.nextLine();
				AdicionarItem adicionarItem = new AdicionarItem(caminho);
				List<Item> ItensNoArquivo = adicionarItem.AdicionarCsv();
				ItensNoArquivo.forEach(p->p.setCentroDeDistribuicao(db.findCentro(id)));
				ItensNoArquivo.forEach(p->db.addItem(p));
				System.out.println("Feito!");
			}
		}
	}
}
