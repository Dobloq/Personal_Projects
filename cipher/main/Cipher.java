package main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cipher {
	static final Scanner sc = new Scanner(System.in);
	static boolean running = true;
	static Character[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','y','z'};
	static Integer[] numeros = {1,2,3,4,5,6,7,8,9};
	static List<Character> l = Arrays.asList(letras);
	static List<Integer> n = Arrays.asList(numeros);

	public static void main(String[] args) {
		while (running) {
			menu();
		}
	}
	
	private static void menu() {
		System.out.println("-----------Menu----------");
		System.out.println("1: Cifrar");
		System.out.println("2: Descifrar");
		System.out.println("3: Cerrar");
		System.out.println("Eleccion nº: ");
		int choose = sc.nextInt();
		opcion(choose);
	}

	private static void opcion(int choose) {
		String cadena = "";
		sc.nextLine();
		switch (choose) {
		case 1:
			System.out.println("---------Cifrado----------");
			System.out.println("Cadena: ");
			cadena = sc.nextLine();
			cifrar(cadena);
			break;
		case 2:
			System.out.println("--------Descifrado--------");
			System.out.println("Cadena: ");
			cadena = sc.nextLine();
			descifrar(cadena);
			break;
		case 3:
			running = false;
			break;
		}
	}
	
	private static void cifrar(String cadena) {
		String res = "";
		for (Character character : cadena.toCharArray()) {
			if (Character.isDigit(character)) {
				res += n.get((n.indexOf(character)+cadena.indexOf(character)+1%10));
			} else {
				res += l.get((l.indexOf(character)+cadena.indexOf(character)+1%25));
			}
		}
		System.out.println(res);
	}
	
	private static void descifrar(String cadena) {
		String res = "";
	}
}
