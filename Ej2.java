package examen;
import java.util.Scanner;

public class Ej2 {
static void rellenaEncuesta(String[][] encuesta) {
	Scanner sc = new Scanner(System.in);

	for (int i = 0; i < encuesta.length; i++) {
		System.out.println("Introduce código postal (o 'fin' para terminar): ");
		String codigoPostal = sc.nextLine().toLowerCase();
		if (codigoPostal.equals("fin")) {
			break;
		}
		System.out.println("Introduce edad: ");
		String edad = sc.nextLine();
		System.out.println("Introduce sexo (M/F): ");
		String sexo = sc.nextLine().toUpperCase();
		
		encuesta[i][0] = codigoPostal;
		encuesta[i][1] = edad;
		encuesta[i][2] = sexo;
		
}
}

static void muestraResultados(String[][] encuesta) {
	System.out.println("--- Resultados de la encuesta ---");
	for (int i = 0; i < encuesta.length; i++) {
		if (encuesta[i][0] == null) {
			break;
		}
		System.out.println("Código Postal: " + encuesta[i][0] + ", Edad: " + encuesta[i][1] + ", Sexo: " + encuesta[i][2]);
	}
}

static int calculaMediaEdad(String[][] encuesta, char sexo, int codigoPostal) {
	int suma = 0;
	int contador = 0;
	
	for (int i = 0; i < encuesta.length; i++) {
		int codigo = Integer.parseInt(encuesta[i][0]);
		char sex = encuesta[i][2].charAt(0);
		
		if (codigo == codigoPostal && sex == sexo) {
			suma += Integer.parseInt(encuesta[i][1]);
			contador++;
		}
	}
			return suma / contador;
			}


public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String[][] encuesta = new String[500][3];
	
	rellenaEncuesta(encuesta);
	muestraResultados(encuesta);
	
	System.out.print("Introduce código postal para calcular media de edad: ");
	int codigoPostal = sc.nextInt();
	System.out.print("Introduce sexo (M/F) para calcular media de edad: ");
	char sexo = sc.next().toUpperCase().charAt(0);
	
	int mediaEdad = calculaMediaEdad(encuesta, sexo, codigoPostal);
	
	System.out.println("La media de edad para el código postal " + codigoPostal + " y sexo " + sexo + " es: " + mediaEdad);
	
}
}


