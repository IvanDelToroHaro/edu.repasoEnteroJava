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
			default:
				System.out.println("No existe la opción elegida.");
			}

		} while (!esCerradoSubMenu);
	}

	public void validarCliente() {
		for (Cliente u : Inicio.hashMapClientes.values()) {
			if (u.isEsValidadoCliente() == false) {
				System.out.println(u.toString());
			}
		}
		boolean control = false;
		System.out.println("Introduza el DNI para validar: ");
		String dniParaValidar = Inicio.sc.next();
		for (Cliente u : Inicio.hashMapClientes.values()) {
			if (dniParaValidar.equals(u.getDniCliente())) {
				u.setEsValidadoCliente(true);
				control = true;
			}
		}
		if (control == false) {
			System.out.println("DNI mal introducido");
		}
	}

	Cliente eliminarCliente;

	public void borrarCliente() {
		salirAMenu=false;
		boolean dniValido = false;
		System.out.println("Introduzca el DNI a comprobar");
		String dniIntro = Inicio.sc.next();
		SubMenuCliente.validarDNI(dniIntro);

		for (Cliente u : Inicio.hashMapClientes.values()) {
			if (dniIntro.equals(u.getDniCliente())) {
				System.out.println("DNI encontrado");
				dniValido = true;
				System.out.println("Volviendo al Menu");
				salirAMenu = true;
				eliminarCliente = u;
			}
		}
		if (dniValido == false) {
			System.out.println("El DNI no existe en la lista");
			salirAMenu = true;
		} else {
			System.out.println("¿Esta seguro de que quiere eliminar este cliente? ('Si' o 'No')");
			String confirmacion = Inicio.sc.next();
			if (confirmacion.equalsIgnoreCase("Si")) {
				Inicio.hashMapClientes.remove(eliminarCliente);
				System.out.println("Cliente eliminado correctamente");
			} else {
				System.out.println("Volviendo al Menu");
				salirAMenu = true;
			}
		}

	}

	public void mostrarClientes() {
		for (Cliente u : Inicio.hashMapClientes.values()) {
			if (u.isEsValidadoCliente() == true) {
				System.out.println(u.toString());
			}
		}
	}
}