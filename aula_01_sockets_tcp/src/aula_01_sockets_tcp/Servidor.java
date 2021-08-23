package aula_01_sockets_tcp;

import java.net.*;
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
		Socket soquete_cliente = servidor.soquete_servidor.accept();
		TrataCliente trata_cliente = new TrataCliente(soquete_cliente);
		trata_cliente.iniciar();
		servidor.finalizar();
	}
}