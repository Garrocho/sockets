package aula_02_sockets_serializable;

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
				Mensagem mensagem_do_cliente = (Mensagem)receber_mensagem();
				Mensagem resposta_ao_cliente = new Mensagem();
				
				resposta_ao_cliente.setNome("Servidor");
				resposta_ao_cliente.setTexto("Ola " + mensagem_do_cliente.getNome() + ", no que posso te ajudar?");
				
				enviar_mensagem(resposta_ao_cliente);
				finalizar();
		}
	}
