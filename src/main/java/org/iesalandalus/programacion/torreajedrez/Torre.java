package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

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
	
	//Constructor con entrada de color
	public Torre(Color color) {
		setColor(color);
		if (color.equals(Color.BLANCO))
		{
			setPosicion(new Posicion(1,'h'));
		} else
		{
			setPosicion(new Posicion(8,'h'));
		}
	}
	
	//Constructor con parámetros de entrada de Color y Columna
	public Torre(Color color, char columna) {
		setColor(color);
		
		if (columna=='A' || columna=='H' || columna=='a' || columna == 'h') 
		{
			if (color==Color.BLANCO) 
			{
				setPosicion(new Posicion(1,columna));
			} else
			{
				setPosicion(new Posicion(8,columna));
			}
		} else
			throw new IllegalArgumentException("ERROR: Columna no válida.");
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
	
	//Métodos
	//Métodos
	//Método mover
	public void mover (Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (pasos < 1) 
		{
			throw new IllegalArgumentException("ERROR: Los pasos no pueden ser 0 o negativo");
		} else if (direccion==null)
		{
			throw new NullPointerException("ERROR: La dirección no puede ser nula");
		}
		switch (direccion) {
			case ARRIBA:
				if (color==Color.NEGRO)
				{
					try {
						setPosicion(new Posicion(posicion.getFila() -pasos , posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: La ficha sale del tablero");
					}
				} else
				{
					try {
						setPosicion(new Posicion(posicion.getFila() +pasos , posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: La ficha sale del tablero");
					}
				}
			break;
			case ABAJO:
				if (color==Color.NEGRO)
				{
					try {
						setPosicion(new Posicion(posicion.getFila() +pasos , posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: La ficha sale del tablero");
					}
				} else
				{
					try {
						setPosicion(new Posicion(posicion.getFila() -pasos , posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: La ficha sale del tablero");
					}
				}
			break;
			case IZQUIERDA:
				if (color==Color.NEGRO)
				{
					try {
						setPosicion(new Posicion(posicion.getFila() , (char)(posicion.getColumna() +pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: La ficha sale del tablero");
					}
				} else
				{
					try {
						setPosicion(new Posicion(posicion.getFila() , (char)(posicion.getColumna() -pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: La ficha sale del tablero");
					}
				}
			break;
			case DERECHA:
				if (color==Color.NEGRO)
				{
					try {
						setPosicion(new Posicion(posicion.getFila() , (char)(posicion.getColumna() -pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: La ficha sale del tablero");
					}
				} else
				{
					try {
						setPosicion(new Posicion(posicion.getFila() , (char)(posicion.getColumna() +pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: La ficha sale del tablero");
					}
				}
			break;
			default:
				throw new NullPointerException("ERROR: La dirección no puede ser nula");
		}
	}
	
	//Método de enroque
	public void enrocar (Direccion direccion) {
		switch (direccion) {
		case ENROQUE_CORTO:
			if (posicion.getColumna()=='H' && (posicion.getFila()==1 || posicion.getFila()==8))
			{
				setPosicion(new Posicion(posicion.getFila(),'F'));
			}
			break;
		case ENROQUE_LARGO:
			if (posicion.getColumna()=='A' && (posicion.getFila()==1 || posicion.getFila()==8))
			{
				setPosicion(new Posicion(posicion.getFila(),'D'));
			}
			break;
			default:
				throw new NullPointerException("ERROR: La direcci�n no puede ser nula");
		}
	}
	
	//Metodos hashCade y equals
	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torre other = (Torre) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}
	
	// Método toString
	@Override
	public String toString() {
		return "Torre [color=" + color + ", posicion=" + posicion + "]";
	}
}