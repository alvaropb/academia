package academia.utilidades;

public class Alerta {
	private String mensaje;
	private String tipo;
	
	
	public Alerta(String mensaje, String tipo) {
		super();
		this.mensaje = mensaje;
		this.tipo = tipo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
