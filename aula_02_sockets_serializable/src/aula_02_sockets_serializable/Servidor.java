package aula_02_sockets_serializable;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class Servidor {
	
	private ServerSocket soquete_servidor;

	public Servidor(int porta) throws Exception {
		super();
		this.soquete_servidor = new ServerSocket(porta);
	}
	
	public void finalizar() throws IOException {
		this.soquete_servidor.close();
	}
	
	public static void main(String[] args) throws Exception {
		Servidor servidor = new Servidor(15500);
		Socket soquete_cliente = null;
		try {
			soquete_cliente = servidor.soquete_servidor.accept();
			new Thread( new TrataCliente(soquete_cliente)).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
