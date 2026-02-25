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
					if (Inicio.sesionIniciada.getRol().equalsIgnoreCase("empleado")) {
						subMenuEmpleado.accionarSubMenuEmpleado();
						String log = "El empleado accede al menu empleado";
						Inicio.escribirConsoleLogGeneral(log);
					} else {
						System.out.println("No tiene acceso");
					}
				} catch (Exception e) {
					System.out.println("No tiene acceso, debe iniciar sesion como empleado");
					String log2 = "Alguien no autorizado intenta acceder al menu empleado";
					Inicio.escribirConsoleLogGeneral(log2);
					SubMenuCliente.accederCliente();
				}
				break;
			case 2:
				subMenuCliente.accionarSubMenuCliente();
				break;
			case 3:
				try {
					if (Inicio.sesionIniciada.getIdCliente() > 0) {
						System.out.println("¿Está seguro de que quiere cerrar sesión? ('Si' o 'No')");
						String confirmacion = Inicio.sc.next();

						if (confirmacion.equalsIgnoreCase("Si")) {
							Inicio.comprobarTamanoLog(Inicio.sesionIniciada.getDniCliente()+".log");
							Inicio.sesionIniciada = clienteVacio;
							System.out.println("Sesión Cerrada");
						} else {
							System.out.println("No se ha cerrado sesion, volviendo al Menu");
						}
					} else {
						System.out.println("No se ha iniciado sesion");
					}
				} catch (Exception e) {
					System.out.println("No se ha iniciado sesion");
				}
				break;
			default:
				System.out.println("No existe la opción elegida.");
			}

		} while (!esCerradoMenuPrincipal);
	}
}