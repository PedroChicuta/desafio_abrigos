package csvOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.products.Alimento;
import entities.products.Higiene;
import entities.products.Item;
import entities.products.Roupa;
import products.enums.ProdutoDeHigiene;
import products.enums.Tamanho;
import products.enums.UnidadesDeMedida;


public class AdicionarItem {
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);
	private File caminho;
	public AdicionarItem(String caminho) {
		setFile(caminho);
	}
	public List<Item> AdicionarCsv(){
		List<Item> itens = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			br.readLine();
			System.out.println("Tipo de produto que será adicionado:");
			System.out.println("1.Roupa \n2.ProdutoDeHigiene \n3.Alimento");
			int op = sc.nextInt();
			while(br.ready()) {
				String linha = br.readLine();
				String[] linhaSplited = linha.split(",");
				Item obj = null;
				if(op == 1) {
					obj = new Roupa(linhaSplited[0], linhaSplited[1].charAt(0), Tamanho.valueOf(Integer.parseInt(linhaSplited[2])));
				}
				else if(op == 2) {
					obj = new Higiene(linhaSplited[0],ProdutoDeHigiene.valueOf(Integer.parseInt(linhaSplited[1])));
				}
				else if(op == 3) {
					obj = new Alimento(linhaSplited[0], Integer.parseInt(linhaSplited[1]), UnidadesDeMedida.valueOf(Integer.parseInt(linhaSplited[2])),
							LocalDate.parse(linhaSplited[3], fmt));
				}
				itens.add(obj);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		itens.removeIf(p-> p == null);
		return itens;
	}
	private void setFile(String path) {
		File f = new File(path);
		caminho = f;
	}
}
