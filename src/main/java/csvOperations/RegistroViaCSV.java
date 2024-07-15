package csvOperations;

import java.util.Scanner;

public class RegistroViaCSV {
	private Scanner sc = new Scanner(System.in);
	public void Menu() {
		System.out.println("Escolha para onde deseja enviar:");
		System.out.println("1.Centro de distribuição");
		System.out.println("2.Abrigo");
		System.out.print("Opção:");
		int op = sc.nextInt();
		if(op == 1) {
			RegistroEmCentro rc = new RegistroEmCentro();
			rc.RegistraEmCentro();
		}
		else {
			RegistroEmAbrigo ra = new RegistroEmAbrigo();
			ra.RegistrarEmAbrigo();
		}
	}
}
