package br.com.java.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que contém as informações de gravação do arquivo de saída para mapeamento da CACHE.
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
	 * contém as informações de cada endereço da CACHE.
	 * valor TAG, número conjunto e posição no bloco.
	 */
	private List<String> infoEnderecos;
	
	public DadosSaidaArquivoCACHE() {
		this.tamanhoCACHE = "";
		this.qtdBitsEndereco = "Número de bits do endereço: ";
		this.qtdBitsBloco = "Número de bits para a posição no bloco: ";
		this.qtdBitsConjunto = "Número de bits para o número do conjunto: ";
		this.qtdBitsTAG = "Número de bits para a TAG: ";
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
