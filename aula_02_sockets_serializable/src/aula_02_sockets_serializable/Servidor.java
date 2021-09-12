package aula_02_sockets_serializable;

import java.net.Socket;
import java.util.Scanner;
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
		Scanner ler = new Scanner(System.in);
		Servidor servidor = new Servidor(15500);
		Socket soquete_cliente = null;
		soquete_cliente = servidor.soquete_servidor.accept();
		TrataCliente trataCliente = new TrataCliente(soquete_cliente);
		trataCliente.iniciar();
		servidor.finalizar();
	}
}
