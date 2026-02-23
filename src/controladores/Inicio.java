package controladores;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

	public static void escribirArchivo(String texto) {
		Path ruta = Paths.get("console.log");
		LocalDateTime fechaLogin = LocalDateTime.now();
		DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formateoFechaLogin = fechaLogin.format(formateo);
		try (FileWriter writer = new FileWriter(ruta.toFile(), true)) {
			writer.write(formateoFechaLogin+" "+texto + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}