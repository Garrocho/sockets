package aula_01_sockets_tcp;

import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TrataCliente {
		
	private Socket soquete_cliente;
	private ObjectOutputStream saida;
	private ObjectInputStream entrada;

	public TrataCliente(Socket soquete_cliente) throws Exception {
		super();
		this.soquete_cliente = soquete_cliente;
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
	}
	
	public void iniciar() throws Exception {
		String mensagem = (String)receber_mensagem();
		System.out.println("Mensagem do Cliente: " + mensagem);
		enviar_mensagem("Ola, eu sou o servidor!");
		finalizar();
	}
}
