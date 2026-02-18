package servicios;

import controladores.Inicio;
import entidades.Cliente;

public class SubMenuEmpleado implements MenuInterfaz {

	@Override
	public byte mostrarMenuYElegirOpcion() {

		System.out.println("╔════════════════════╗");
		System.out.println("║  SUBMENU EMPLEADO  ║");
		System.out.println("╠════════════════════╣");
		System.out.println("║ 0. Volver al menu  ║");
		System.out.println("║ 1. Validar cliente ║");
		System.out.println("║ 2. Borrar cliente  ║");
		System.out.println("║ 3. Mostrar cliente ║");
		System.out.println("║ 4. Asignar rol     ║");
		System.out.println("╚════════════════════╝");
		return Inicio.sc.nextByte();
	}

	boolean salirAMenu = false;

	public void accionarSubMenuEmpleado() {

		boolean esCerradoSubMenu = false;
		byte opcionSubMenu;

		do {
			opcionSubMenu = mostrarMenuYElegirOpcion();

			switch (opcionSubMenu) {
			case 0:
				esCerradoSubMenu = true;
				break;
			case 1:
				validarCliente();
				break;
			case 2:
				borrarCliente();
				if (salirAMenu == true) {
					esCerradoSubMenu = true;
				}
				break;
			case 3:
				mostrarClientes();
				break;
			case 4:
				asignarRol();
				break;
			default:
				System.out.println("No existe la opción elegida.");
			}

		} while (!esCerradoSubMenu);
	}

	public void agregarAdmin() {
		String dniCliente = "99999999R";
		String nombreCliente = "Admin";
		String apellido1Cliente = "Creado";
		String apellido2Cliente = "Auto";
		String nombreCompletoCliente = nombreCliente + apellido1Cliente + apellido2Cliente;
		String emailCliente = "admin";
		String contraseniaCliente = "1234";
		boolean esValidadoCliente = true;
		String rol = "Empleado";
		Cliente admin = new Cliente(dniCliente, nombreCompletoCliente, nombreCliente, apellido1Cliente,
				apellido2Cliente, emailCliente, contraseniaCliente, esValidadoCliente, rol);
		Inicio.listaUsuarios.add(admin);
		//Inicio.sesionIniciada = admin;
	}

	public void validarCliente() {

		for (Cliente u : Inicio.listaUsuarios) {
			if (!u.isEsValidadoCliente()) {
				System.out.println(u.toString());
			}
		}

		boolean control = false;

		System.out.println("Introduza el DNI para validar: ");
		String dniParaValidar = Inicio.sc.next();

		for (Cliente u : Inicio.listaUsuarios) {
			if (dniParaValidar.equals(u.getDniCliente())) {
				u.setEsValidadoCliente(true);
				control = true;
			}
		}

		if (!control) {
			System.out.println("DNI mal introducido");
		}
	}

	Cliente eliminarCliente;

	public void borrarCliente() {

		salirAMenu = false;
		boolean dniValido = false;

		System.out.println("Introduzca el DNI a comprobar");
		String dniIntro = Inicio.sc.next();

		Cliente clienteAEliminar = null;

		for (Cliente u : Inicio.listaUsuarios) {
			if (dniIntro.equals(u.getDniCliente())) {
				System.out.println("DNI encontrado");
				dniValido = true;
				clienteAEliminar = u;
			}
		}

		if (!dniValido) {
			System.out.println("El DNI no existe en la lista");
			return;
		}

		System.out.println("¿Está seguro de que quiere eliminar este cliente? ('Si' o 'No')");
		String confirmacion = Inicio.sc.next();

		if (confirmacion.equalsIgnoreCase("Si")) {
			Inicio.listaUsuarios.remove(clienteAEliminar);
			System.out.println("Cliente eliminado correctamente");
		} else {
			System.out.println("Volviendo al Menu");
		}
	}

	public void mostrarClientes() {
		for (Cliente u : Inicio.listaUsuarios) {
			if (u.isEsValidadoCliente()) {
				System.out.println(u.toString());
			}
		}
	}

	public void asignarRol() {
		for (Cliente u : Inicio.listaUsuarios) {
			if (u.isEsValidadoCliente()) {
				System.out.println(u.toString());
			}
		}

		boolean dniValido = false;
		Cliente usuarioRol = null;
		boolean encontrado = false;

		do {
			System.out.println("A que usuario desea darle un rol? (DNI)");
			String DNIusuarioRol = Inicio.sc.next().toUpperCase();

			dniValido = SubMenuCliente.validarDNI(DNIusuarioRol);
			if (dniValido) {
				System.out.println("DNI válido");
				for (Cliente u : Inicio.listaUsuarios) {
					if (u.getDniCliente().equalsIgnoreCase(DNIusuarioRol)) {
						usuarioRol = u;
						encontrado = true;
						break;
					}
				}

				if (!encontrado) {
					System.out.println("No existe ningún usuario con ese DNI");
					return;
				}
			} else {
				System.out.println("DNI incorrecto");
			}
		} while (!dniValido);
		System.out.println("Que rol le quiere dar al usuario");
		String rolDado = Inicio.sc.next();
		if (rolDado.equalsIgnoreCase("empleado") || rolDado.equalsIgnoreCase("cliente")) {
			System.out.println("Garantizado rol de: " + rolDado.toLowerCase());
			usuarioRol.setRol(rolDado);

		} else {
			System.out.println("Rol no existente");
			return;
		}
	}

}