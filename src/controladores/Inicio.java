package controladores;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
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

	public static void escribirConsoleLogGeneral(String texto) {
		Path ruta = Paths.get("console.log");
		LocalDateTime fechaLogin = LocalDateTime.now();
		DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formateoFechaLogin = fechaLogin.format(formateo);
		try (FileWriter writer = new FileWriter(ruta.toFile(), true)) {
			writer.write(formateoFechaLogin + " " + texto + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void escribirConsoleLogCliente(String texto, String string) {
		Path ruta = Paths.get(string);

		LocalDateTime fechaLogin = LocalDateTime.now();
		DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formateoFechaLogin = fechaLogin.format(formateo);

		try {
			if (!Files.exists(ruta)) {
				Files.createFile(ruta);
			}

			try (FileWriter writer = new FileWriter(ruta.toFile(), true)) {
				writer.write(formateoFechaLogin + " " + texto + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void comprobarTamanoLog(String nombreArchivo) {
		Path ruta = Paths.get(nombreArchivo);

		try {
			if (Files.exists(ruta)) {

				long numeroLineas = Files.lines(ruta).count();

				if (numeroLineas > 50) {
					Files.delete(ruta);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}