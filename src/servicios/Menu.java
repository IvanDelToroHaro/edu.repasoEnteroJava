package servicios;

import controladores.Inicio;
import entidades.Cliente;

public class Menu implements MenuInterfaz {

	public SubMenuEmpleado subMenuEmpleado = new SubMenuEmpleado();
	public SubMenuCliente subMenuCliente = new SubMenuCliente();
	
	Cliente clienteVacio = new Cliente();

	@Override
	public byte mostrarMenuYElegirOpcion() {

		System.out.println("╔═════════════════════╗");
		System.out.println("║         MENU        ║");
		System.out.println("╠═════════════════════╣");
		System.out.println("║ 0. Salir            ║");
		System.out.println("║ 1. Versión Empleado ║");
		System.out.println("║ 2. Versión Cliente  ║");
		System.out.println("║ 3. Cerrar Sesión    ║");
		System.out.println("╚═════════════════════╝");

		System.out.print("Seleccione una opción: ");
		return Inicio.sc.nextByte();
	}

	public void accionarMenuPrincipal() {

		subMenuEmpleado.agregarAdmin();
		boolean esCerradoMenuPrincipal = false;
		byte opcionMenuPrincipal;

		do {
			opcionMenuPrincipal = mostrarMenuYElegirOpcion();

			switch (opcionMenuPrincipal) {
			case 0:
				esCerradoMenuPrincipal = true;
				break;
			case 1:
				try {
					if (Inicio.sesionIniciada.getRol().equalsIgnoreCase("empleado")){
						subMenuEmpleado.accionarSubMenuEmpleado();
					}else {
						System.out.println("No tiene acceso");
						return;
					}
				} catch (Exception e) {
					System.out.println("No tiene acceso, debe iniciar sesion como empleado");
					SubMenuCliente.accederCliente();
				}
				break;
			case 2:
				subMenuCliente.accionarSubMenuCliente();
				break;
			case 3:
				Inicio.sesionIniciada=clienteVacio;
				System.out.println("Sesión Cerrada");
				break;
			default:
				System.out.println("No existe la opción elegida.");
			}

		} while (!esCerradoMenuPrincipal);
	}
}