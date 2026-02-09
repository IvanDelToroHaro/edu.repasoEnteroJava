package servicios;

import controladores.Inicio;

public class Menu implements MenuInterfaz {

	private SubMenuEmpleado subMenuEmpleado = new SubMenuEmpleado();
	private SubMenuCliente subMenuCliente = new SubMenuCliente();

	@Override
	public byte mostrarMenuYElegirOpcion() {
		
		System.out.println("╔═════════════════════╗");
		System.out.println("║         MENU        ║");
		System.out.println("╠═════════════════════╣");
		System.out.println("║ 0. Salir            ║");
		System.out.println("║ 1. Versión Empleado ║");
		System.out.println("║ 2. Versión Cliente  ║");
		System.out.println("╚═════════════════════╝");

		System.out.print("Seleccione una opción: ");
		return Inicio.sc.nextByte();
	}

	public void accionarMenuPrincipal() {

		boolean esCerradoMenuPrincipal = false;
		byte opcionMenuPrincipal;

		do {
			opcionMenuPrincipal = mostrarMenuYElegirOpcion();

			switch (opcionMenuPrincipal) {
			case 0:
				esCerradoMenuPrincipal = true;
				break;
			case 1:
				subMenuEmpleado.accionarSubMenuEmpleado();
				break;
			case 2:
				subMenuCliente.accionarSubMenuCliente();
				break;
			default:
				System.out.println("No existe la opción elegida.");
			}

		} while (!esCerradoMenuPrincipal);
	}
}
