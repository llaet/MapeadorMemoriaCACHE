package br.com.java.arquivo;

import java.util.ArrayList;
import java.util.List;

import br.com.java.dto.DadosEntradaArquivoRAM;
import br.com.java.dto.DadosSaidaArquivoCACHE;

/**
 * Classe que escreve em um arquivo.
 * @author Lucas Laet e Gabriel Vilas.
 */
public class EscritorArquivo {


	private List<String> arquivo;
	private DadosEntradaArquivoRAM entrada;
	private DadosSaidaArquivoCACHE saida;
	private StringBuilder sb;

	public EscritorArquivo() {
		this.arquivo = new ArrayList<>();
		this.entrada = new DadosEntradaArquivoRAM();
		this.saida = new DadosSaidaArquivoCACHE();
	}

	public void escreveNovoDocumento(List<String> documento) {
		this.preencheTipoMapeamentoEntrada(documento.get(0));
		this.preencheDadosRAM(documento.get(1));
		this.preencheTamanhoDados(documento.get(2));
		//cria lista com apenas as informações de acessos a memória.
		List<String> novoDocumento = documento.subList(3, documento.size());
		this.preencheEnderecosAcesso(novoDocumento);
	}
	
	/**
	 * Preenche os dados das linhas de arquivos.
	 * @param dados
	 */
	private List<String> preencheDados(String dados) {
		sb = new StringBuilder();
		List<String> listaDados = new ArrayList<>();
		
		for(char caractere : dados.toCharArray()) {			
		
			if (caractere == ' ') {
				// verifica espaço em branco no início da linha
				if (!(sb.toString().isBlank())) {
					listaDados.add(sb.toString());
				}
				// limpa o string builder
				sb.setLength(0);
			} else {
				sb.append(caractere);
			}		
		}
		listaDados.add(sb.toString().strip());
		return listaDados;
	}
	
	/**
	 * Preenche o tipo de mapeamento da RAM.
	 * @param tipoMapeamento
	 */
	private void preencheTipoMapeamentoEntrada(String tipoMapeamento) {
		this.entrada.setTipoMapeamento(tipoMapeamento);
	}
	
	/**
	 * Preenche tamanho e unidade de medida da RAM.
	 * @param dadosRAM
	 */
	private void preencheDadosRAM(String dadosRAM) {
		List<String> dados = this.preencheDados(dadosRAM);
		
		this.entrada.setTamanhoRAM(dados.get(0));
		this.entrada.setUnidadeMedidaRAM(dados.get(1));
	}
	
	/**
	 * Preenche bytes da palavra, qtd palavras bloco, qtd blocos por conjunto, qtd conjuntos e qtd acessos a memória.
	 * @param dadosRAM
	 */
	private void preencheTamanhoDados(String dadosRAM) {
		List<String> dados = this.preencheDados(dadosRAM);
		
		this.entrada.setBytesPalavra(dados.get(0));
		this.entrada.setQtdPalavrasBloco(dados.get(1));
		this.entrada.setQtdBlocos(dados.get(2));
		this.entrada.setQtdConjuntos(dados.get(3));
		this.entrada.setQtdAcessosMemoria(dados.get(4));
	}
	
	/**
	 * Preenche endereços da acesso a memória.
	 * @param dadosRAM
	 */
	private void preencheEnderecosAcesso(List<String> dadosRAM) {		
		this.entrada.setEnderecosAcesso(dadosRAM);
	}
	
}
