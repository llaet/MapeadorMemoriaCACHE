package br.com.java.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cont�m as informa��es de grava��o do arquivo de sa�da para mapeamento da CACHE.
 * @author Lucas Laet e Gabriel Vilas.
 *
 */
public class DadosSaidaArquivoCACHE {

	private String tamanhoCACHE;
	private String qtdBitsEndereco;
	private String qtdBitsBloco;
	private String qtdBitsConjunto;
	private String qtdBitsTAG;
	/**
	 * cont�m as informa��es de cada endere�o da CACHE.
	 * valor TAG, n�mero conjunto e posi��o no bloco.
	 */
	private List<String> infoEnderecos;
	
	public DadosSaidaArquivoCACHE() {
		this.tamanhoCACHE = "";
		this.qtdBitsEndereco = "N�mero de bits do endere�o: ";
		this.qtdBitsBloco = "N�mero de bits para a posi��o no bloco: ";
		this.qtdBitsConjunto = "N�mero de bits para o n�mero do conjunto: ";
		this.qtdBitsTAG = "N�mero de bits para a TAG: ";
		this.infoEnderecos = new ArrayList<>();
	}

	public String getTamanhoCACHE() {
		return tamanhoCACHE;
	}

	public void setTamanhoCACHE(String tamanhoCACHE) {
		this.tamanhoCACHE = tamanhoCACHE;
	}

	public String getQtdBitsEndereco() {
		return qtdBitsEndereco;
	}

	public void setQtdBitsEndereco(String qtdBitsEndereco) {
		this.qtdBitsEndereco.concat(qtdBitsEndereco);
	}

	public String getQtdBitsBloco() {
		return qtdBitsBloco;
	}

	public void setQtdBitsBloco(String qtdBitsBloco) {
		this.qtdBitsBloco.concat(qtdBitsBloco);
	}

	public String getQtdBitsConjunto() {
		return qtdBitsConjunto;
	}

	public void setQtdBitsConjunto(String qtdBitsConjunto) {
		this.qtdBitsConjunto.concat(qtdBitsConjunto);
	}

	public String getQtdBitsTAG() {
		return qtdBitsTAG;
	}

	public void setQtdBitsTAG(String qtdBitsTAG) {
		this.qtdBitsTAG.concat(qtdBitsTAG);
	}

	public List<String> getInfoEnderecos() {
		return infoEnderecos;
	}

	public void setInfoEnderecos(String infoEndereco) {
		this.infoEnderecos.add(infoEndereco);
	}
}
