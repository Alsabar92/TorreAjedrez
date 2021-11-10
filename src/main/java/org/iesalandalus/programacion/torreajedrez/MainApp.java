package org.iesalandalus.programacion.torreajedrez;

public class MainApp {
	private static Torre torre;
	
	public static void main(String[] args) {
		
	
	}

	
	//Métodos
	//Metodo mostrarTorre
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException e){
			System.out.println("ERROR: La torre no está creada.");
		}
	}
}
