package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

public class Posicion {
	private int fila;
	private char columna;
	
	private final int MIN_FILA=1;
	private final int MAX_FILA=8;
	
	
	//Constructores
	//Constructor con parámetros de entrada
	public Posicion (int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	
	// Constructor copia
	public Posicion (Posicion e) {
		if (e == null)
		{
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		}
		setFila(e.getFila());
		setColumna(e.getColumna());
	}
	
	
	//Getters y Setters
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		if (fila < MIN_FILA || fila > MAX_FILA ) 
		{
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		} else
		{
			this.fila = fila;
		}
	}
	public char getColumna() {
		return columna;
	}
	public void setColumna(char columna) {
		if (columna!='a' && columna!='b' && columna!='c' && columna!='d' && columna!='e' && columna!='f' && columna!='g' && columna!='h' && columna!='A' && columna!='B' && columna!='C' && columna!='D' && columna!='E' && columna!='F' && columna!='G' && columna!='H')
		{
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		} 
		else {
			// Comprobamos si se ha introducido la columna en mayúscula y si es así, la convertimos a minúscula. La opción default mantiene la solución, dado que tenemos validada la entrada desde el if.
			switch (columna) {
				case 'A':
					this.columna='a';
					break;
				case 'B':
					this.columna='b';
					break;
				case 'C':
					this.columna='c';
					break;
				case 'D':
					this.columna='d';
					break;
				case 'E':
					this.columna='e';
					break;
				case 'F':
					this.columna='f';
					break;
				case 'G':
					this.columna='g';
					break;
				case 'H':
					this.columna='h';
					break;
				default:
					this.columna = columna;
					break;
			}
		}	
	}

	//Método hashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}

	//Método toString
	@Override
	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}
	
	
	
}
