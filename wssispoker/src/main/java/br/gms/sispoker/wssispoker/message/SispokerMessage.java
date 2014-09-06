package br.gms.sispoker.wssispoker.message;


public class SispokerMessage {
	
	private String mensagem;
	
	public SispokerMessage(String mensagem) {
		this.mensagem = mensagem;
	}

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
