package aula_02_sockets_serializable;

import java.io.Serializable;

public class Mensagem implements Serializable {
	private String nome;
	private String mensagem;
	
	public Mensagem(String nome, String mensagem) {
		super();
		this.nome = nome;
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "Mensagem [nome=" + nome + ", mensagem=" + mensagem + "]";
	}
	
}

