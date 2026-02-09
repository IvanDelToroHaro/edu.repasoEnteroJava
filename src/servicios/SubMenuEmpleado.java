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
			default:
				System.out.println("No existe la opción elegida.");
			}

		} while (!esCerradoSubMenu);
	}

	public void validarCliente() {
		for (Cliente u : Inicio.listaClientes) {
			System.out.println(u.toString());
		}
		
		System.out.println("Introduza el DNI para validar: ");
		String dniParaValidar = Inicio.sc.next();
		
		if (dniParaValidar.equals(u.)) {
			
		}

	}

}
