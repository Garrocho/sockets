package aula_03_sockets_multicliente;

import java.net.Socket;
import java.util.ArrayList;
import java.net.ServerSocket;
import java.io.IOException;

public class Servidor {
	
	private ServerSocket soquete_servidor;
	private ArrayList<Mensagem> mensagens;

	public Servidor(int porta) throws Exception {
		super();
		this.soquete_servidor = new ServerSocket(porta);
		this.mensagens = new ArrayList<Mensagem>();
	}
	
	public void finalizar() throws IOException {
		this.soquete_servidor.close();
	}
	
	public static void main(String[] args) throws Exception {
		Servidor servidor = new Servidor(15500);
		Socket soqueteCliente = null;
		while (true) {
			try {
				soqueteCliente = servidor.soquete_servidor.accept();
				new Thread( new TrataCliente(soqueteCliente, servidor.mensagens)).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
