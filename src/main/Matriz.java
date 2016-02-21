package main;

import java.util.List;

public interface Matriz {
	public void setArrayFilas(Double[] filaNueva, int n);

	public List<Double[]> getArrayFilas();

	public List<Double[]> getArrayColumnas();

	public double getColumnas();

	public double getFilas();
	
	public double[][] getMatriz();

	public void mostrarMatriz();

	public void actualizarMatriz(String modificado);

	public MatrizIdentidad getMatrizIdentidad();

	public void setMatrizIdentidad(Matriz matriz);
}
