package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	private static Torre torre;
	
	public static void main(String[] args) {
		
	
	}

	
	//Métodos. Deben declararse privados para que no se tenga acceso desde las clases externas.
	//Metodo mostrarTorre
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException e){
			System.out.println("ERROR: La torre no está creada.");
		}
	}
	
	//Método mostrarMenu
	private static void mostrarMenu() {
		System.out.println("=====================================");
		System.out.println("Programa simulador. Torre de Ajedrez.");
		System.out.println("=====================================");
		System.out.println(" ");
		System.out.println("1. Crear una torre por defecto.");
		System.out.println("2. Crear una torre eligiendo su color.");
		System.out.println("3. Crear una torre eligiendo su color y posición inicial.");
		System.out.println("4. Mover la torre.");
		System.out.println("5. Salir.");
	}
	
	//Método elegirOpcion
	private static int elegirOpcion() {
		int opcionMenu;
		System.out.print("Por favor, elija una de las anteriores opciones: ");
		do {
			opcionMenu = Entrada.entero();
		} while (opcionMenu<0 || opcionMenu>5);
		return opcionMenu;	
	}
}
