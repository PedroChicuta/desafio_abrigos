package application;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import db.DbOperations;
import entities.CentroDeDistribuicao;
import products.Alimento;
import products.Higiene;
import products.Roupa;
import products.enums.ProdutoDeHigiene;
import products.enums.Tamanho;
import products.enums.UnidadesDeMedida;

public class Main {

	public static void main(String[] args){
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataS = "22/04/2018";
		LocalDate d = LocalDate.parse(dataS, fmt);
		System.out.println(d);
		
		CentroDeDistribuicao centro1 = new CentroDeDistribuicao("Centro de Distribuição Prosperidade", "Av. Borges de Medeiros, 1501 – Cidade Baixa, Porto Alegre - RS, 90119-900");
		CentroDeDistribuicao centro2 = new CentroDeDistribuicao("Centro de Distribuição Esperança", "Av. Boqueirão, 2450 - Igara, Canoas - RS, 92032-420");
		CentroDeDistribuicao centro3 = new CentroDeDistribuicao("Centro de Distribuição Reconstrução", "R. Dr. Décio Martins Costa, 312 - Vila Eunice Nova, Cachoeirinha - RS, 94920-170");
		
		Roupa i11 = new Roupa("Casaco",centro1, 'F', Tamanho.M);
		Roupa i12 = new Roupa("Calça",centro1, 'M', Tamanho.P);
		Roupa i13= new Roupa("Camiseta",centro1, 'M', Tamanho.G);
		Roupa i14 = new Roupa("Camiseta",centro1, 'F', Tamanho.PP);
		Roupa i15 = new Roupa("Camiseta",centro1, 'F', Tamanho.PP);
		Roupa i16 = new Roupa("Camiseta",centro1, 'F', Tamanho.PP);
		Roupa i17 = new Roupa("Camiseta",centro1, 'F', Tamanho.PP);
		Roupa i18 = new Roupa("Camiseta",centro1, 'F', Tamanho.PP);
		Roupa i19 = new Roupa("Camiseta",centro1, 'F', Tamanho.PP);
		Roupa i20 = new Roupa("Camiseta",centro1, 'F', Tamanho.PP);
		
		
		Higiene i21 = new Higiene("Colgate",centro1, ProdutoDeHigiene.PASTA_DE_DENTES);
		Higiene i22= new Higiene("Dove",centro1, ProdutoDeHigiene.SABONETE);
		Higiene i23 = new Higiene("Colgate",centro1, ProdutoDeHigiene.ESCOVA_DE_DENTES);
		Higiene i24 = new Higiene("Colgate",centro1, ProdutoDeHigiene.PASTA_DE_DENTES);
		Higiene i25 = new Higiene("Colgate",centro1, ProdutoDeHigiene.PASTA_DE_DENTES);
		Higiene i26 = new Higiene("Dove",centro1, ProdutoDeHigiene.SABONETE);
		Higiene i27 = new Higiene("Colgate",centro1, ProdutoDeHigiene.ESCOVA_DE_DENTES);
		Higiene i28 = new Higiene("Colgate",centro1, ProdutoDeHigiene.PASTA_DE_DENTES);
		Higiene i29 = new Higiene("Colgate",centro1, ProdutoDeHigiene.PASTA_DE_DENTES);
		Higiene i30 = new Higiene("Dove",centro1, ProdutoDeHigiene.SABONETE);
		
		
		
		
		Alimento i1 = new Alimento("Arroz",centro1, 2, UnidadesDeMedida.KG, d);
		Alimento i2 = new Alimento("Agua",centro1, 5, UnidadesDeMedida.L, d);
		Alimento i3 = new Alimento("Macarrão",centro1, 2000, UnidadesDeMedida.G, d);
		Alimento i4 = new Alimento("Feijão",centro1, 500, UnidadesDeMedida.G, d);
		Alimento i5 = new Alimento("Arroz",centro1, 2, UnidadesDeMedida.KG, d);
		Alimento i6 = new Alimento("Suco de uva",centro1, 2, UnidadesDeMedida.L, d);
		Alimento i7 = new Alimento("Refrigerante",centro1, 2, UnidadesDeMedida.L, d);
		Alimento i8 = new Alimento("Macaxeira",centro1, 2, UnidadesDeMedida.KG, d);
		Alimento i9 = new Alimento("Fava",centro1, 2, UnidadesDeMedida.KG, d);
		Alimento i10 = new Alimento("Macarrao",centro1, 2, UnidadesDeMedida.KG, d);
		
		
		Alimento i101= new Alimento("Feijão",centro1, 2, UnidadesDeMedida.KG, d);
		Alimento i102= new Alimento("Cuscuz",centro1, 2, UnidadesDeMedida.KG, d);
		Alimento i100 = new Alimento("BATATA",centro1, 2, UnidadesDeMedida.KG, d);
		
		DbOperations db = new DbOperations();
		db.addCentro(centro1);
		db.addCentro(centro2);
		db.addCentro(centro3);
		db.addAlimento(i1);
		db.addAlimento(i2);
		db.addAlimento(i3);
		db.addAlimento(i4);
		db.addAlimento(i5);
		db.addAlimento(i6);
		db.addAlimento(i7);
		db.addAlimento(i8);
		db.addAlimento(i9);
		db.addAlimento(i10);
		db.addRoupa(i11);
		db.addRoupa(i12);
		db.addRoupa(i13);
		db.addRoupa(i14);
		db.addRoupa(i15);
		db.addRoupa(i16);
		db.addRoupa(i17);
		db.addRoupa(i18);
		db.addRoupa(i19);
		db.addRoupa(i20);
		db.addHigiene(i21);
		db.addHigiene(i22);
		db.addHigiene(i23);
		db.addHigiene(i24);
		db.addHigiene(i25);
		db.addHigiene(i26);
		db.addHigiene(i27);
		db.addHigiene(i28);
		db.addHigiene(i29);
		db.addHigiene(i30);
	
		
		db.closeEntityManager();
		
	}

}
 