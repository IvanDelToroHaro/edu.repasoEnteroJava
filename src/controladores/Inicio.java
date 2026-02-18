package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Cliente;
import servicios.Menu;

public class Inicio {

	public static Scanner sc = new Scanner(System.in);
	public static long ultimoIdCliente = 1;
	public static ArrayList<Cliente> listaUsuarios = new ArrayList<>();
	public static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
	public static Cliente sesionIniciada;

	public static void main(String[] args) {
		Menu menu = new Menu();
		
		menu.accionarMenuPrincipal();
	}
}