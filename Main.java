package Clinica;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("DIGITE O VALOR");
		
		int valor = sc.nextInt();
		switch (valor) {
			case 1:
				System.out.println("PROGRAMA INICIADO");
				break;
			default:
				System.out.println("PROGRAMA ENCERRADO");
				sc.close();
				System.exit(0);
				break;
				
		}
	}

}
