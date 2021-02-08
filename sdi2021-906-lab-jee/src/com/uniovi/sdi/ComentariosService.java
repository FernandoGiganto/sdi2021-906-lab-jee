package com.uniovi.sdi;

import java.util.LinkedList;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;


public class ComentariosService {
	
	public List<Comentario> getComentarios(){
		
		List<Comentario> comentarios = new LinkedList<Comentario>();
		ObjectContainer db = null;
		try {
			
			db = Db4oEmbedded.openFile("bdProductos");
			List<Comentario> respuesta = db.queryByExample(Comentario.class);
			comentarios.addAll(respuesta);
			
		}finally {
			db.close();
		}
		return comentarios;
	}
	
	public void setNuevoComentario(Comentario nuevoComentario) {
		ObjectContainer db = null;
		try {
			
			db = Db4oEmbedded.openFile("bdProductos");
			db.store(nuevoComentario);
			
		}finally {
			db.close();
		}
	}

}
