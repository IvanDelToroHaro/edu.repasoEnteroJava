package controladores;

import java.util.HashMap;
import java.util.Scanner;

import entidades.Cliente;
import servicios.Menu;

public class Inicio {

	public static Scanner sc = new Scanner(System.in);
	public static long ultimoIdCliente = 1;
	public static HashMap<Long, Cliente> hashMapClientes = new HashMap<Long, Cliente>();
	public static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

	public static void main(String[] args) {
		Menu menu = new Menu();

		menu.accionarMenuPrincipal();
	}

}
