package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matriz {
	private double columnas;
	private double filas;
	private double[][] matriz;
	private List<Double[]> fila = new ArrayList<>();
	private List<Double[]> columna = new ArrayList<>();
	static final Scanner sc = new Scanner(System.in);

	public void setArrayFilas(Double[] filaNueva, int n) {
		this.fila.set(n, filaNueva);
	}

	public List<Double[]> getArrayFilas() {
		return new ArrayList<>(this.fila);
	}

	public List<Double[]> getArrayColumnas() {
		return new ArrayList<>(this.columna);
	}

	public double getColumnas() {
		return this.columnas;
	}

	public double getFilas() {
		return this.filas;
	}

	public double[][] getMatriz() {
		return this.matriz;
	}

	// Constructor que crea una nueva matriz
	public Matriz() {
		System.out.println("Numero de filas: ");
		this.filas = sc.nextDouble();
		System.out.println("Numero de columnas: ");
		this.columnas = sc.nextDouble();
		this.matriz = new double[(int) filas][(int) columnas];
		for (int i = 0; i < filas; i++) {
			Double[] a = new Double[(int) columnas];
			for (int j = 0; j < columnas; j++) {
				System.out.println("Numero en la posicion [" + i + "][" + j + "]");
				double tmp = sc.nextDouble();
				a[j] = tmp;
				matriz[i][j] = tmp;
			}
			fila.add(a);
		}
		for (int i = 0; i < this.columnas; i++) {
			Double[] b = new Double[(int) filas];
			for (int j = 0; j < this.filas; j++) {
				b[j] = this.matriz[j][i];
			}
			columna.add(b);
		}
	}

	// Constructor para crear una matriz de un tamaño especifico
	public Matriz(double filas, double columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = new double[(int) filas][(int) columnas];
	}

	// Metodo para mostrar una matriz
	public void mostrarMatriz() {
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	// Metodo para multiplicar dos matrices
	public static void multiplicarMatriz() {
		System.out.println("\t\tInstrucciones");
		System.out.println("Primero se crea una matriz y se rellena");
		System.out.println("Despues se crea la otra matriz que se va a multiplicar");
		System.out.println("Matriz 1");
		Matriz m1 = new Matriz();
		System.out.println("Matriz 2");
		Matriz m2 = new Matriz();
		if (m1.getColumnas() != m2.getFilas()) {
			System.out.println(
					"No se pueden multiplicar dos matrices con distinto numero de columnas y filas respectivamente");
			mostrarMenu();
		} else {
			Matriz m = new Matriz(m1.getFilas(), m2.getColumnas());
			/*
			 * Se repite tantas veces como filas haya en la primera matriz y se
			 * almacena esa fila en "fila" i representa cada fila de la primera
			 * matriz, al igual que cada fila de la matriz final
			 */
			for (int i = 0; i < m1.fila.size(); i++) {
				Double[] fila = m1.fila.get(i);
				/*
				 * Se repite tantas veces como columnas haya en la segunda
				 * matriz y se almacena esa columna en "columna" j representa
				 * las columnas de la segunda matriz, asi como cada columna de
				 * la matriz final
				 */
				for (int j = 0; j < m2.getColumnas(); j++) {
					Double[] columna = m2.columna.get(j);
					int contador = 0;
					/*
					 * Se multiplica cada posicion de "fila" por su respectivo
					 * // en "columna" j2 representa cada posicion de "fila" y
					 * "columna"
					 */
					for (int j2 = 0; j2 < columna.length; j2++) {
						contador += fila[j2] * columna[j2];
					}
					m.matriz[i][j] = contador;
				}
			}
			m.mostrarMatriz();
			mostrarMenu();
		}

	}

	// Metodo para sumar dos matrices
	public static void sumarMatrices() {
		System.out.println("\t\tInstrucciones");
		System.out.println("Primero se crea una matriz y se rellena");
		System.out.println("Despues se crea la otra matriz que se va a sumar");
		System.out.println("Matriz 1");
		Matriz m1 = new Matriz();
		System.out.println("Matriz 2");
		Matriz m2 = new Matriz();
		if (m1.getFilas() != m2.getFilas() || m1.getColumnas() != m2.getColumnas()) {
			System.out.println("No se pueden sumar dos matrices de distinto tamaño");
			mostrarMenu();
		} else {
			Matriz m = new Matriz(m1.getFilas(), m1.getColumnas());
			for (int i = 0; i < m.getFilas(); i++) {
				for (int j = 0; j < m.getColumnas(); j++) {
					m.matriz[i][j] = m1.matriz[i][j] + m2.matriz[i][j];
				}
			}
			m.mostrarMatriz();
			mostrarMenu();
		}
	}

	// Metodo para restar dos matrices
	public static void restarMatrices() {
		System.out.println("\t\tInstrucciones");
		System.out.println("Primero se crea una matriz y se rellena");
		System.out.println("Despues se crea la otra matriz que se va a restar");
		System.out.println("Creacion de la matriz 1");
		Matriz m1 = new Matriz();
		System.out.println("Creacion de la matriz 2");
		Matriz m2 = new Matriz();
		if (m1.getFilas() != m2.getFilas() || m1.getColumnas() != m2.getColumnas()) {
			System.out.println("No se pueden restar dos matrices de distinto tamaño");
			mostrarMenu();
		} else {
			Matriz m = new Matriz(m1.getFilas(), m1.getColumnas());
			for (int i = 0; i < m.getFilas(); i++) {
				for (int j = 0; j < m.getColumnas(); j++) {
					m.matriz[i][j] = m1.matriz[i][j] - m2.matriz[i][j];
				}
			}
			m.mostrarMatriz();
			mostrarMenu();
		}
	}

	// Metodo para dividir una matriz entre un numero
	public static void dividirNumero() {
		System.out.println("\t\tInstrucciones");
		System.out.println("Primero se crea una matriz y se rellena");
		System.out.println("Despues se introduce el numero entre el que se va a dividir la matriz");
		System.out.println("Creacion de la matriz");
		Matriz m = new Matriz();
		System.out.println("Numero entre el que se divide");
		Double n = sc.nextDouble();
		for (int i = 0; i < m.getFilas(); i++) {
			for (int j = 0; j < m.getColumnas(); j++) {
				m.matriz[i][j] = (m.matriz[i][j] / n);
			}
		}
		m.mostrarMatriz();
		mostrarMenu();
	}

	// Metodo para una vez modificadas las filas o las columnas se actualice
	// toda la matriz
	public void actualizarMatriz(String modificado) {
		if (modificado.equals("fila")) {
			for (int i = 0; i < this.getFilas(); i++) {
				for (int j = 0; j < fila.get(0).length; j++) {
					this.matriz[i][j] = this.fila.get(i)[j];
				}
			}
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					this.columna.get(i)[j] = this.fila.get(j)[i];
				}
			}
		} else if (modificado.equals("fila")) {
			for (int i = 0; i < this.getColumnas(); i++) {
				for (int j = 0; j < columna.get(0).length; j++) {
					this.matriz[i][j] = this.columna.get(i)[j];
				}
			}
			for (int i = 0; i < columnas; i++) {
				for (int j = 0; j < filas; j++) {
					this.fila.get(i)[j] = this.columna.get(j)[i];
				}
			}
		}
	}

	public static void mostrarMenu() {
		System.out.println("\n\t\tMenu de la aplicacion");
		System.out.println("Operaciones disponibles");
		System.out.println("Multiplicar dos matrices (1)");
		System.out.println("Sumar dos matrices (2)");
		System.out.println("Restar dos matrices (3)");
		System.out.println("Dividir una matriz entre un numero (4)");
		System.out.println("Cerrar el programa (5)");
		System.out.println("Introduzca el numero de la operacion");
		int operacion = sc.nextInt();
		switch (operacion) {
		case 1:
			multiplicarMatriz();
			break;
		case 2:
			sumarMatrices();
			;
			break;
		case 3:
			restarMatrices();
			;
			break;
		case 4:
			dividirNumero();
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		mostrarMenu();
	}

	// public Matriz clone() {
	// Matriz m = new Matriz(this.getFilas(), this.getColumnas());
	// m.matriz = this.matriz;
	// m.fila = this.getArrayFilas();
	// m.columna = this.getArrayColumnas();
	// return m;
	// }
}
