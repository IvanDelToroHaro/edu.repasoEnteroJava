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

	boolean salirAMenu = false;

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
			case 2:
				accederCliente();
				if (salirAMenu == true) {
					esCerradoSubMenu = true;
				}
				break;
			default:
				System.out.println("No existe la opción elegida.");
			}

		} while (!esCerradoSubMenu);

	}
	
	public void nuevoCliente() {

		String dni;
		boolean dniValido = false;

		do {
			System.out.println("Introduzca su DNI (12345678A)");
			dni = Inicio.sc.next().toUpperCase();

			dniValido = validarDNI(dni);
			if (dniValido) {
				System.out.println("DNI válido");
			} else {
				System.out.println("DNI incorrecto");
			}
		} while (!dniValido); // Bucle hasta que el DNI sea válido
		String dniCliente = dni;

		Inicio.sc.nextLine();
		System.out.println("Introduzca su nombre completo (Nombre Apellido1 Apellido2)");
		String nombreEntero = Inicio.sc.nextLine();
		String[] nombreDividido = nombreEntero.split(" ");
		String nombreCliente = nombreDividido[0];
		String apellido1Cliente = nombreDividido[1];
		String apellido2Cliente = nombreDividido[2];

		System.out.println("Introduzca su email");
		String emailCliente = Inicio.sc.nextLine();

		System.out.println("Introduzca su contraseña");
		String contraseñaCliente = Inicio.sc.nextLine();

		Cliente nuevoCliente = new Cliente(dniCliente, null, nombreCliente, apellido1Cliente, apellido2Cliente,
				emailCliente, contraseñaCliente, false, null);

		// Añadir cliente nuevo
		Inicio.listaUsuarios.add(nuevoCliente);
		System.out.println(nuevoCliente.toString1());

	}

	// Parte de nuevoCliente
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

	public void accederCliente() {
		int i = 0;
		salirAMenu = false;
		boolean sesionValida = false;
		do {
			System.out.println("Introduzca su email");
			String validarEmail = Inicio.sc.next();

			System.out.println("Introduzca su contraseña");
			String validarContrasenia = Inicio.sc.next();

			for (Cliente u : Inicio.listaUsuarios) {
				if (validarEmail.equals(u.getEmailCliente()) && validarContrasenia.equals(u.getContraseniaCliente())
						&& u.isEsValidadoCliente() == true) {
					System.out.println("INICIO DE SESIÓN CORRECTO");
					System.out.println("Volviendo al Menu");
					salirAMenu = true;
					sesionValida = true;
					Inicio.sesionIniciada = u;
				}
			}

			if (sesionValida == false) {
				System.out.println("Error en los campos introducidos");
				System.out.println("Volviendo al Menu");
				salirAMenu = true;
			}
			i++;
			if (i == 3 && sesionValida == false) {
				System.out.println("Se acabaron los intentos");
			}
		} while (i < 3 && !salirAMenu);
	}
}