package br.com.java.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena informações da entrada do arquivo de mapeamento da memória RAM.
 * @author Lucas Laet e Gabriel Vilas.
 *
 */
public class DadosEntradaArquivoRAM {	

	private String tipoMapeamento;
	private String tamanhoRAM;
	private String unidadeMedidaRAM;
	private String bytesPalavra;
	private String qtdPalavrasBloco;
	private String qtdBlocos;
	private String qtdConjuntos;
	private String qtdAcessosMemoria;
	private List<String> enderecosAcesso;
	
	public DadosEntradaArquivoRAM() {
		this.bytesPalavra = "";
		this.enderecosAcesso = new ArrayList<>();
		this.qtdAcessosMemoria = "";
		this.qtdBlocos = "";
		this.qtdConjuntos = "";
		this.qtdPalavrasBloco = "";
		this.tamanhoRAM = "";
		this.tipoMapeamento = "";
		this.unidadeMedidaRAM = "";
	}

	public String getTipoMapeamento() {
		return tipoMapeamento;
	}
	public void setTipoMapeamento(String tipoMapeamento) {
		this.tipoMapeamento = tipoMapeamento;
	}
	public String getTamanhoRAM() {
		return tamanhoRAM;
	}
	public void setTamanhoRAM(String tamanhoRAM) {
		this.tamanhoRAM = tamanhoRAM;
	}
	public String getUnidadeMedidaRAM() {
		return unidadeMedidaRAM;
	}
	public void setUnidadeMedidaRAM(String unidadeMedidaRAM) {
		this.unidadeMedidaRAM = unidadeMedidaRAM;
	}
	public String getBytesPalavra() {
		return bytesPalavra;
	}
	public void setBytesPalavra(String bytesPalavra) {
		this.bytesPalavra = bytesPalavra;
	}
	public String getQtdPalavrasBloco() {
		return qtdPalavrasBloco;
	}
	public void setQtdPalavrasBloco(String qtdPalavrasBloco) {
		this.qtdPalavrasBloco = qtdPalavrasBloco;
	}
	public String getQtdBlocos() {
		return qtdBlocos;
	}
	public void setQtdBlocos(String qtdBlocos) {
		this.qtdBlocos = qtdBlocos;
	}
	public String getQtdConjuntos() {
		return qtdConjuntos;
	}
	public void setQtdConjuntos(String qtdConjuntos) {
		this.qtdConjuntos = qtdConjuntos;
	}
	public String getQtdAcessosMemoria() {
		return qtdAcessosMemoria;
	}
	public void setQtdAcessosMemoria(String qtdAcessosMemoria) {
		this.qtdAcessosMemoria = qtdAcessosMemoria;
	}
	public List<String> getEnderecosAcesso() {
		return enderecosAcesso;
	}
	public void setEnderecosAcesso(List<String> enderecosAcesso) {
		this.enderecosAcesso = enderecosAcesso;
	}
}
