package servicios;

import controladores.Inicio;
import entidades.Cliente;

public class SubMenuCliente implements MenuInterfaz {

	@Override
	public byte mostrarMenuYElegirOpcion() {

		System.out.println("╔═════════════════════╗");
		System.out.println("║   SUBMENU CLIENTE   ║");
		System.out.println("╠═════════════════════╣");
		System.out.println("║ 0. Volver al menu   ║");
		System.out.println("║ 1. Registro cliente ║");
		System.out.println("║ 2. Acceso cliente   ║");
		System.out.println("╚═════════════════════╝");
		return Inicio.sc.nextByte();
	}

	public void accionarSubMenuCliente() {

		boolean esCerradoSubMenu = false;
		byte opcionSubMenu;

		do {
			opcionSubMenu = mostrarMenuYElegirOpcion();

			switch (opcionSubMenu) {
			case 0:
				esCerradoSubMenu = true;
				break;
			case 1:
				nuevoCliente();
				break;
			default:
				System.out.println("No existe la opción elegida.");
			}

		} while (!esCerradoSubMenu);

	}

	public void nuevoCliente() {

		Cliente nuevoCliente = new Cliente(0, null, null, null, null, null, null, null, false);
		
		String dni;
		boolean dniValido = false;
		
		do {
			Inicio.sc.nextLine(); // Consumir el salto de línea pendiente
			System.out.println("Introduzca su DNI (12345678A)");
			dni = Inicio.sc.nextLine().toUpperCase();

			dniValido = validarDNI(dni);
			if (dniValido) {
				System.out.println("DNI válido");
			} else {
				System.out.println("DNI incorrecto");
			}
		} while (!dniValido); // Bucle hasta que el DNI sea válido
		nuevoCliente.setDniCliente(dni);
		
		System.out.println("Introduzca su nombre completo (Nombre Apellido1 Apellido2)");
		String nombreEntero = Inicio.sc.nextLine();
		String[] nombreDividido = nombreEntero.split(" ");
		System.out.println(nombreEntero);
		nuevoCliente.setNombreCliente(nombreDividido[0]);
		nuevoCliente.setApellido1Cliente(nombreDividido[1]);
		nuevoCliente.setApellido2Cliente(nombreDividido[2]);

		/*System.out.println("");
		Inicio.sc.next();*/

		// Añadir cliente nuevo
		Inicio.listaClientes.add(nuevoCliente);

	}

	public static boolean validarDNI(String dni) {
		if (dni.length() != 9) {
			return false;
		}

		int numero = Integer.parseInt(dni.substring(0, 8));
		char letra = dni.charAt(8);

		int resto = numero % 23;
		char letraCorrecta = Inicio.LETRAS.charAt(resto);

		return letra == letraCorrecta;
	}

}