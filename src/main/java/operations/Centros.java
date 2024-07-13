package operations;

import java.util.List;

import entities.CentroDeDistribuicao;
import repositories.DbOperations;

public class Centros {
	DbOperations db = new DbOperations();
	
	public List<CentroDeDistribuicao> findAllCentros() {
		return db.getCentroTable();
	}
}
