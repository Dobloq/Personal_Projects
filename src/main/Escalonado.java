package main;

import java.util.Scanner;

public class Escalonado {
	static Scanner sc = new Scanner(System.in);

	public static Matriz cambioFila(Matriz m, int fila1, int fila2) {
		// se resta uno para que se pueda meter el numero normal de fila y no
		// interfiera con el array que empieza en 0
		int uno = fila1 - 1;
		int dos = fila2 - 1;
		// se guarda la fila uno en tmp
		Double[] tmp = m.getArrayFilas().get(uno);
		// en el lugar de la fila uno se coloca la fila dos
		m.setArrayFilas(m.getArrayFilas().get(dos), uno);
		// en el lugar de la fila dos se coloca tmp = fila uno
		m.setArrayFilas(tmp, dos);
		// se actualiza para que los cambios hechos en "fila" afecten a toda la
		// matriz
		m.actualizarMatriz("fila");
		return m;
	}

	public static Matriz multiplicarFila(Matriz m, int fila, double mult) {
		// se resta uno para que se pueda meter el numero normal de fila y no
		// interfiera con el array que empieza en 0
		int uno = fila - 1;
		// se guarda la fila que se quiere multiplicar en tmp
		Double[] tmp = m.getArrayFilas().get(uno);
		// por cada numero de la fila se guarda en esa posicion el numero de esa
		// posicion por el numero dado
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = tmp[i] * mult;
		}
		// en el lugar donde estaba la fila se coloca la nueva
		m.setArrayFilas(tmp, uno);
		// se actualiza para que los cambios hechos en "fila" afecten a toda la
		// matriz
		m.actualizarMatriz("fila");
		return m;
	}

	public static Matriz sumaMultiploFila(Matriz m, int fila1, int fila2, double mult) {
		// se resta uno para que se pueda meter el numero normal de fila y no
		// interfiera con el array que empieza en 0
		int uno = fila1 - 1;
		int dos = fila2 - 1;
		// se guarda la fila que se multiplica en una variable temporal porque
		// durante el proceso se modifica
		Double[] tmp = m.getArrayFilas().get(dos).clone();
		// se multiplica la fila dos por el numero dado
		m = multiplicarFila(m, fila2, mult);
		// se crea un array para almacenar la suma de ambas filas
		Double[] suma = new Double[m.getArrayFilas().get(0).length];
		// por cada numero en la fila se suma los dos numeros de las filas
		for (int i = 0; i < m.getColumnas(); i++) {
			suma[i] = m.getArrayFilas().get(uno)[i] + m.getArrayFilas().get(dos)[i];
		}
		// se almacena la suma en la posicion de la primera fila
		m.setArrayFilas(suma, uno);
		// se reestablece la fila dos que habia sido modificada durante el
		// proceso
		m.setArrayFilas(tmp, dos);
		// se actualiza para que los cambios hechos en "fila" afecten a toda la
		// matriz
		m.actualizarMatriz("fila");
		return m;
	}

	// a11 != 0
	public static Matriz caso1(Matriz m) {
		for (int i = 1; i < m.getFilas(); i++) {
			m = sumaMultiploFila(m, i, 1, -(m.getMatriz()[i][1] / m.getMatriz()[1][1]));
		}
		m.actualizarMatriz("fila");
		return m;
	}

	// a11 = 0 pero existe ak1 != 0
	public static Matriz caso2(Matriz m) {
		for (int i = 1; i < m.getFilas(); i++) {
			if (m.getMatriz()[i][0] == 0) {
				continue;
			}
			if (m.getMatriz()[i][0] != 0) {
				m = cambioFila(m, i, 1);
			}
		}
		m.actualizarMatriz("fila");
		return m;
	}

	// ak1 = 0, k = 1,...,m
	public static Matriz caso3(Matriz m) {
		// true significa que toda la fila son 0
		boolean tmp = true;
		for (int i = 0; i < m.getFilas(); i++) {
			if (m.getMatriz()[i][0] != 0) {
				tmp = false;
			}
		}
		if (tmp == true) {
			m.getArrayFilas().remove(0);
		}
		m.actualizarMatriz("fila");
		return m;
	}

	public static void operaciones(Matriz m) {
		m.mostrarMatriz();
		System.out.println("Operacion a realizar");
		System.out.println("Cambio de fila, 1");
		System.out.println("Multiplicacion de fila, 2");
		System.out.println("Suma de dos filas multiplicando la segunda por un numero, 3");
		System.out.println("Mostrar matriz identidad, 4");
		int respuesta = sc.nextInt();
		switch (respuesta) {
		case 1:
			System.out.println("Nº de primera fila");
			int fila1 = sc.nextInt();
			System.out.println("Nº de segunda fila");
			int fila2 = sc.nextInt();
			m = cambioFila(m, fila1, fila2);
			MatrizIdentidad mTemp = m.getMatrizIdentidad();
			m.setMatrizIdentidad(cambioFila(mTemp, fila1, fila2));
			m.getMatrizIdentidad().actualizarMatriz("fila");
			break;
		case 2:
			System.out.println("Nº de fila");
			int fila = sc.nextInt();
			System.out.println("Nº para multiplicar");
			double n = sc.nextDouble();
			m = multiplicarFila(m, fila, n);
			mTemp = m.getMatrizIdentidad();
			m.setMatrizIdentidad(multiplicarFila(mTemp, fila, n));
			m.getMatrizIdentidad().actualizarMatriz("fila");
			break;
		case 3:
			System.out.println("Nº de primera fila");
			fila1 = sc.nextInt();
			System.out.println("Nº de segunda fila");
			fila2 = sc.nextInt();
			System.out.println("Nº para multiplicar la segunda fila");
			n = sc.nextDouble();
			m = sumaMultiploFila(m, fila1, fila2, n);
			mTemp = m.getMatrizIdentidad();
			m.setMatrizIdentidad(sumaMultiploFila(mTemp, fila1, fila2, n));
			m.getMatrizIdentidad().actualizarMatriz("fila");
			break;
		case 4:
			m.getMatrizIdentidad().mostrarMatriz();
			break;
		default:
			break;
		}
		operaciones(m);
	}

	public static void main(String[] args) {
		MatrizImpl m = new MatrizImpl();
		operaciones(m);
		m.mostrarMatriz();
	}

}
