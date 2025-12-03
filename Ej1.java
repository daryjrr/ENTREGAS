package examen;
import java.util.Random;
import java.util.Scanner;


class dniInvalidoException extends Exception {
    public dniInvalidoException(String mensaje) {
        super(mensaje);
    }
}

public class Ej1 {	

static String leerDni() {
	
	Scanner sc =new Scanner (System.in);
	System.out.print("Introduce un DNI (8 números y una letra): ");
	String dni = sc.next();
	
	if (dni.length() !=9 || !dni.matches("^[0-9]{8}[a-zA-Z]$")) {
		try {
			throw new dniInvalidoException ("DNI inválido: debe tener 8 números y una letra.");
		} catch (dniInvalidoException e) {
			System.out.println(e.getMessage());
		}
		return leerDni();
	}
	
	return dni;
}
	


static String cambiarDigito(String dni, int posicion, char nuevoValor) {
	
	char letra= Character.toUpperCase(dni.charAt(8));
	
	if (!Character.isDigit(nuevoValor)) {
		System.out.println("Error: el nuevo valor debe ser un dígito.");
		return dni;
	}
	else {
		char[] dniArray = dni.toCharArray();
		int numero = posicion - 1;
		
		if (numero <0 || numero > 7) {
			System.out.println("Posición inválida (1-8).");
			return dni;
		}
		dniArray[numero]= nuevoValor;
		dniArray[8] =letra;
		
		return new String (dniArray);
	}
}



	public static void main(String[] args) {
		String dni = leerDni();
		System.out.println("DNI original: " + dni);
		
		String dniNuevo = cambiarDigito(dni, 1, '1');
		System.out.println("DNI modificado: " + dniNuevo);
	}
}
