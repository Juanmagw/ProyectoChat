package proyecto.chat.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	public static int leeEntero() {
		Scanner sc= new Scanner(System.in);
		int numero=-1;
		boolean valido=false;
		do {
			try {
				System.out.println("Escriba aquí: ");
				numero=sc.nextInt();
				valido=true;
			}catch(InputMismatchException ex) {
				System.out.println("Número no válido. Vuelve a intentarlo.");
				sc.next();
			}
		}while(!valido);
		return numero;
	}
	
	public static String leeString() {
		Scanner sc= new Scanner(System.in);
		String frase="";
		boolean valido= false;
		do {
			try {
				System.out.println("Escriba aquí: ");
				frase=sc.nextLine();
				valido=true;
			}catch(InputMismatchException ex) {
				System.out.println("Error.");
				sc.nextLine();
			}catch(Exception e) {
				System.out.println("No válido.");
			}
		}while(!valido);
		return frase;
	}

	public static String validaString(){
		String f = "";
		if(f == null){
			System.out.println(f);
		}
		return f;
	}
}
