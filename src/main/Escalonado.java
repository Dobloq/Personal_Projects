package main;

public class Escalonado {

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

	public static Matriz multiplicarFila(Matriz m, int fila, int mult) {
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

	public static Matriz sumaMultiploFila(Matriz m, int fila1, int fila2, int mult) {
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

	public static void main(String[] args) {
		Matriz m = new Matriz();
		m = sumaMultiploFila(m, 1, 2, 2);
		m.mostrarMatriz();
	}

}
