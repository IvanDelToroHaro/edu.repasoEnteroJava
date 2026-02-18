package entidades;

import controladores.Inicio;

public class Cliente {

	//Atributos
	long idCliente;
	String dniCliente;
	String nombreCompletoCliente;
	String nombreCliente;
	String apellido1Cliente;
	String apellido2Cliente;
	String emailCliente;
	String contraseniaCliente;
	boolean esValidadoCliente;
	String rol;

	public Cliente(String dniCliente, String nombreCompletoCliente, String nombreCliente,
			String apellido1Cliente, String apellido2Cliente, String emailCliente,
			String contraseniaCliente, boolean esValidadoCliente, String rol) {

		this.idCliente = Inicio.listaUsuarios.isEmpty() ? 1
				: Inicio.listaUsuarios.get(Inicio.listaUsuarios.size() - 1).getIdCliente() + 1;

		this.dniCliente = dniCliente;
		this.nombreCompletoCliente = apellido1Cliente + " " + apellido2Cliente + ", " + nombreCliente;
		this.nombreCliente = nombreCliente;
		this.apellido1Cliente = apellido1Cliente;
		this.apellido2Cliente = apellido2Cliente;
		this.emailCliente = emailCliente;
		this.contraseniaCliente = contraseniaCliente;
		this.esValidadoCliente = esValidadoCliente;
		this.rol = rol;
	}


	//Getters & Setters
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getNombreCompletoCliente() {
		return nombreCompletoCliente;
	}
	public void setNombreCompletoCliente(String nombreCompletoCliente) {
		this.nombreCompletoCliente = nombreCompletoCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellido1Cliente() {
		return apellido1Cliente;
	}
	public void setApellido1Cliente(String apellido1Cliente) {
		this.apellido1Cliente = apellido1Cliente;
	}
	public String getApellido2Cliente() {
		return apellido2Cliente;
	}
	public void setApellido2Cliente(String apellido2Cliente) {
		this.apellido2Cliente = apellido2Cliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getContraseniaCliente() {
		return contraseniaCliente;
	}
	public void setContraseniaCliente(String contraseniaCliente) {
		this.contraseniaCliente = contraseniaCliente;
	}
	public boolean isEsValidadoCliente() {
		return esValidadoCliente;
	}
	public void setEsValidadoCliente(boolean esValidadoCliente) {
		this.esValidadoCliente = esValidadoCliente;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	//toString
	@Override
	public String toString() {
		return "DNI: " + dniCliente + 
			   "\nNOMBRE: " + nombreCompletoCliente + 
			   "\nESTADO VALIDACION: " + (esValidadoCliente ? "Si" : "No")+
			   "\n%%%%%%%%%";
	}
	
	public String toString1() {
		return "DNI: " + dniCliente + 
			   "\nNOMBRE: " + nombreCompletoCliente + 
			   "\nESTADO VALIDACION: " + (esValidadoCliente ? "Si" : "No")+
			   "\n%%%%%%%%%\n"+"Id cliente:"+idCliente+"ROL: "+rol;
	}
}
