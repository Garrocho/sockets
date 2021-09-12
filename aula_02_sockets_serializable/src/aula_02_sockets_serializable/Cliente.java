package aula_02_sockets_serializable;

import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Cliente {
	
	private Socket soquete;
	private ObjectOutputStream saida;
	private ObjectInputStream entrada;
	
	public Cliente(String endereco, int porta) throws Exception {
		super();
		this.soquete = new Socket(endereco, porta);
		this.saida = new ObjectOutputStream(this.soquete.getOutputStream()); 
		this.entrada = new ObjectInputStream(this.soquete.getInputStream());
	}

	public void enviar_mensagem(Object mensagem) throws Exception {
		this.saida.writeObject(mensagem);
	}
	
	public Object receber_mensagem() throws Exception {
		return this.entrada.readObject();
	}
	
	public void finalizar() throws IOException {
		this.soquete.close();
	}
	
	public static void main(String[] args) throws Exception {
		Scanner ler = new Scanner(System.in);
		Cliente cliente = new Cliente("127.0.0.1", 15500);
		Mensagem mensagem = new Mensagem();
		
		System.out.print("Seu Nome: ");
		mensagem.setNome(ler.next());
		
		System.out.print("Sua Mesagem: ");
		mensagem.setTexto(ler.next());
		
		cliente.enviar_mensagem(mensagem);
		Mensagem resposta = (Mensagem)cliente.receber_mensagem();
		System.out.println(resposta.getNome() + ": " + resposta.getTexto());
		cliente.finalizar();
	}
}
