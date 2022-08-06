package me.java.spring.venda.config.validacao;

public class ErroFormulario {
	// mostrar o campo e a mensagem de erro:
	private String campo;
	private String erro;
	
	public ErroFormulario(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
	public String getCampo() {
		return campo;
	}
	public String getErro() {
		return erro;
	}
	
	
	
}
