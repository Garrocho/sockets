package aula_01_sockets_tcp;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Servidor {
	
	private ServerSocket soquete_servidor;
	private Socket soquete_cliente;
	private ObjectOutputStream saida;
	private ObjectInputStream entrada;

	public Servidor(int porta) throws Exception {
		super();
		this.soquete_servidor = new ServerSocket(porta);
	}
	
	public void aguardar_cliente() throws Exception {
		this.soquete_cliente = this.soquete_servidor.accept();
		this.saida = new ObjectOutputStream(this.soquete_cliente.getOutputStream()); 
		this.entrada = new ObjectInputStream(this.soquete_cliente.getInputStream());
	}

	public void enviar_mensagem(Object mensagem) throws Exception {
		this.saida.writeObject(mensagem);
	}
	
	public Object receber_mensagem() throws Exception {
		return this.entrada.readObject();
	}
	
	public void finalizar() throws IOException {
		this.soquete_cliente.close();
		this.soquete_servidor.close();
	}
	
	public static void main(String[] args) throws Exception {
		Servidor servidor = new Servidor(15500);
		servidor.aguardar_cliente();
		String mensagem = (String)servidor.receber_mensagem();
		System.out.println("Mensagem do Cliente: " + mensagem);
		servidor.enviar_mensagem("Ola, eu sou o servidor!");
		servidor.finalizar();
	}
}
