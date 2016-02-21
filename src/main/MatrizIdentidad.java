package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrizIdentidad implements Matriz {
	/**
	 * Nº de columnas de la matriz
	 */
	private double columnas;
	/**
	 * Nº de filas de la matriz
	 */
	private double filas;
	/**
	 * Matriz
	 */
	private double[][] matriz;
	/**
	 * Lista con arrays donde cada array corresponde a una fila de la matriz
	 */
	private List<Double[]> fila = new ArrayList<>();
	/**
	 * Lista con arrays donde cada array correspone a una columna de la matriz
	 */
	private List<Double[]> columna = new ArrayList<>();

	public MatrizIdentidad(Matriz m) {
		this.columnas = m.getColumnas();
		this.filas = m.getFilas();
		this.columna = new ArrayList<>();
		this.fila = new ArrayList<>();
		for (int i = 0; i < this.columnas; i++) {
			Double[] a = new Double[(int) this.filas];
			Arrays.fill(a, 0d);
			this.columna.add(a);
		}
		for (int i = 0; i < this.filas; i++) {
			Double[] a = new Double[(int) this.columnas];
			Arrays.fill(a, 0d);
			this.fila.add(a);
		}
		this.matriz = new double[(int) filas][(int) columnas];
		for (int i = 0; i < this.getColumnas(); i++) {
			try {
				this.getMatriz()[i][i] = 1;
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}
			this.columna.get(i)[i] = 1d;
			this.fila.get(i)[i] = 1d;
		}
	}

	@Override
	public void setArrayFilas(Double[] filaNueva, int n) {
		this.fila.set(n, filaNueva);
	}

	@Override
	public List<Double[]> getArrayFilas() {
		return new ArrayList<>(this.fila);
	}

	@Override
	public List<Double[]> getArrayColumnas() {
		return new ArrayList<>(this.columna);
	}

	@Override
	public double getColumnas() {
		return this.columnas;
	}

	@Override
	public double getFilas() {
		return this.filas;
	}

	@Override
	public void mostrarMatriz() {
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	@Override
	public void actualizarMatriz(String modificado) {
		// si se ha modificado fila
		if (modificado.equals("fila")) {
			for (int i = 0; i < this.getFilas(); i++) {
				for (int j = 0; j < this.getColumnas(); j++) {
					if (this.fila.get(i)[j] == null) {
						this.matriz[i][j] = 0;
						continue;
					}
					this.matriz[i][j] = this.fila.get(i)[j];
				}
			}
			for (int i = 0; i < this.getFilas(); i++) {
				for (int j = 0; j < this.getColumnas(); j++) {
					if (this.fila.get(i)[j] == null) {
						this.matriz[i][j] = 0;
						continue;
					}
					this.columna.get(j)[i] = this.fila.get(j)[i];
				}
			}
			// si se ha modificado columna
		} else if (modificado.equals("columna")) {
			for (int i = 0; i < this.getColumnas(); i++) {
				for (int j = 0; j < columna.get(0).length; j++) {
					if (this.columna.get(i)[j] == null) {
						this.matriz[i][j] = 0;
						continue;
					}
					this.matriz[i][j] = this.columna.get(i)[j];
				}
			}
			for (int i = 0; i < columnas; i++) {
				for (int j = 0; j < filas; j++) {
					if (this.columna.get(i)[j] == null) {
						this.matriz[j][i] = 0;
						continue;
					}
					this.fila.get(j)[i] = this.columna.get(i)[j];
				}
			}
		}
	}

	public double[][] getMatriz() {
		return this.matriz;
	}

	@Override
	public MatrizIdentidad getMatrizIdentidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMatrizIdentidad(Matriz m) {
		// TODO Auto-generated method stub

	}

}
