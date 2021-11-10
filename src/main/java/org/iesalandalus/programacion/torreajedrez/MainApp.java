package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	private static Torre torre;
	
	public static void main(String[] args) {
		boolean apagado=false;
		int selector;
		do {
			mostrarMenu();
			selector=elegirOpcion();
			ejecutarOpcion(selector);
			mostrarTorre();
			
			if (selector==5) {
				apagado=true;
			}
		} while (apagado=false);
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
	
	//Método elegirColor
	private static Color elegirColor() {
		Color color=null;
		int opcionColor=0;
		do {
			System.out.println("===============");
			System.out.println(" ");
			System.out.println("1. Blancas.");
			System.out.println("2. Negras.");
			System.out.println(" ");
			System.out.print("Elija un color: ");
			opcionColor=Entrada.entero();
		} while (opcionColor!=1 && opcionColor!=2);
		
		switch (opcionColor) {
		case 1:
			color=Color.BLANCO;
			break;
		case 2:
			color=Color.NEGRO;
			break;
		}
		
		return color;
	}
	
	//Método elegirColumnaInicial
	private static char elegirColumnaInicial() {
		char columna = 0;
		
		do {
			System.out.print("Introduzca la columna deseada (A , H): ");
			columna=Entrada.caracter();
		} while (columna!='a' && columna!='A' && columna!='h' && columna!='H');
	
		return columna;
	}
	
	//Método mostrarMenuDirecciones
	private static void mostrarMenuDirecciones() {
		System.out.println("============================");
		System.out.println(" ");
		System.out.println("1. Mover hacia arriba.");
		System.out.println("2. Mover hacia abajo.");
		System.out.println("3. Mover hacia la izquierda.");
		System.out.println("4. Mover hacia la derecha.");
		System.out.println("5. Realizar enroque corto.");
		System.out.println("6. Realizar enroque largo.");
		System.out.println(" ");
		System.out.println("============================");
	}
	
	//Método elegirDireccion
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		int opcionDireccion = 0;
		
		do {
			System.out.println(" ");
			System.out.print("Elija una opción entre las anteriores: ");
		} while (opcionDireccion<1 || opcionDireccion>6);
		
		switch (opcionDireccion) {
		case 1:
			direccion=Direccion.ARRIBA;
			break;
		case 2:
			direccion=Direccion.ABAJO;
			break;
		case 3:
			direccion=Direccion.IZQUIERDA;
			break;
		case 4:
			direccion=Direccion.DERECHA;
			break;
		case 5:
			direccion=Direccion.ENROQUE_CORTO;
			break;
		case 6:
			direccion=Direccion.ENROQUE_LARGO;
			break;
		}
		
		return direccion;
	}
	
	//Método crearTorreDefecto
	private static void crearTorreDefecto() {
		torre=new Torre();
	}
	
	//Método crearTorreColor
	private static void crearTorreColor() {
		torre=new Torre(elegirColor());
	}
	
	//Método crearTorreColorColumna
	private static void crearTorreColorColumna() {
		torre=new Torre(elegirColor(), elegirColumnaInicial());
	}
	
	//Método mover
	private static void mover() {
		Direccion direccion=null;
		int pasos;
		if (torre == null)
		{
			System.out.println("ERROR: No existe torre para mover. Antes debe crear una torre.");
		} else 
		{
			mostrarMenuDirecciones();	
			direccion=elegirDireccion();
			
			System.out.println(" ");
			System.out.print("Introduzca ahora el número de pasos que quiere dar: ");
			pasos = Entrada.entero();
			
			try {
				torre.mover(direccion, pasos);
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	//Método ejecutarOpcion
	private static void ejecutarOpcion(int opcionEjecucion) {
		switch (opcionEjecucion) {
		case 1:
			crearTorreDefecto();
			break;
		case 2:
			crearTorreColor();
			break;
		case 3:
			crearTorreColorColumna();
			break;
		case 4:
			mover();
			break;
		case 5:
			System.out.println("¡Hasta luego!");
			break;
		}
	}
	
}
