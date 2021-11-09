package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	// Atributos
	private Color color;
	private Posicion posicion;
	
	
	//Constructores
	//Constructor por defecto
	public Torre() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(8, 'h'));
	}
	
	
	
	// Creamos setters y getters
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		if (color == null)
		{
			throw new NullPointerException("ERROR: Columna no v�lida.");
		}
		this.color = color;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Posicion posicion) { //DUDA
		this.posicion=posicion;
	}
}