package operations;

import java.util.List;

import entities.CentroDeDistribuicao;
import repositories.DbOperations;

public class Centros {
	DbOperations db = new DbOperations();
	
	public List<CentroDeDistribuicao> findAllCentros() {
		return db.getCentroTable();
	}
	public void createCentros() {
		db.addCentro(new CentroDeDistribuicao("Centro de Distribuição Esperança"," Av. Boqueirão, 2450 - Igara, Canoas - RS, 92032-420"));
		db.addCentro(new CentroDeDistribuicao("Centro de Distribuição Prosperidade"," Av. Borges de Medeiros, 1501 – Cidade Baixa, Porto Alegre - RS, 90119-900"));
		db.addCentro(new CentroDeDistribuicao("Centro de Distribuição Reconstrução","R. Dr. Décio Martins Costa, 312 - Vila Eunice Nova, Cachoeirinha - RS, 94920-170"));
	}
}
