package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Formulario {
	public static Scanner sc = new Scanner(System.in);

	public static String datosPersonales() {
		System.out.println("Introduzca el nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduzca los apellidos");
		String apellidos = sc.nextLine();
		System.out.println("Introduzca el DNI");
		String DNI = sc.nextLine();
		System.out.println("Introduzca el email");
		String email = sc.nextLine();
		return nombre + ";" + apellidos + ";" + DNI.substring(0, DNI.length() - 1) + ";" + DNI.charAt(DNI.length() - 1)
				+ ";" + email + ";";
	}

	public static String datosUsuario() {
		System.out.println("Introduzca su nick");
		String nick = sc.nextLine();
		System.out.println("Introduzca la contraseña");
		String pass = sc.nextLine();
		return nick + ";" + pass;
	}

	public static void guardarDatos(String[] str) {
		FileWriter f = null;
		PrintWriter pw = null;
		try {
			f = new FileWriter("prueba.txt");
			pw = new PrintWriter(f);
			for (int i = 0; i < str.length; i++) {
				pw.append(str[i]);
				pw.append("\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (null != f) {
					f.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static String[] cargarDatos() {
		String a = datosPersonales().concat(datosUsuario());
		String[] s = a.split(";");
		return s;
	}

	public static void main(String[] args) {
		guardarDatos(cargarDatos());
	}

}
