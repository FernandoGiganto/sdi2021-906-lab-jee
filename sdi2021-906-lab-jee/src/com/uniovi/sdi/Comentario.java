package com.uniovi.sdi;

public class Comentario {
	
	private String usuario;
	private String comentario;
	
	public Comentario() {}
	
	public Comentario(String usuario,String comentario) {
		this.usuario = usuario;
		this.comentario = comentario;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

}
