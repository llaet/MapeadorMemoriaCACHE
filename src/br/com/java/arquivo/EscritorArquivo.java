package br.com.java.arquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.java.dto.DadosEntradaArquivoRAM;
import br.com.java.dto.DadosSaidaArquivoCACHE;
import br.com.java.enumeration.MedidaByte;
import br.com.java.mat.CalculoUtil;

/**
 * Classe que escreve em um arquivo.
 * @author Lucas Laet e Gabriel Vilas.
 */
public class EscritorArquivo {

	private DadosEntradaArquivoRAM entrada;
	private DadosSaidaArquivoCACHE saida;
	private StringBuilder sb;

	public EscritorArquivo() {
		this.entrada = new DadosEntradaArquivoRAM();
		this.saida = new DadosSaidaArquivoCACHE();
	}

	public void escreveNovoDocumento(List<String> documento) {
		
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(".\\dados-CACHE.txt"));
			
			this.preencheTipoMapeamentoEntrada(documento.get(0));
			this.preencheDadosRAM(documento.get(1));
			this.preencheTamanhoDados(documento.get(2));
			//cria lista com apenas as informações de acessos a memória.
			List<String> novoDocumento = documento.subList(3, documento.size());
			this.preencheEnderecosAcesso(novoDocumento);
			
			this.preencheTamanhoCACHE(this.entrada.getBytesPalavra(), 
					this.entrada.getQtdPalavrasBloco(), this.entrada.getQtdBlocos(), 
					this.entrada.getQtdConjuntos());
			this.preencheBitsEnderecoCACHE(this.entrada.getTamanhoRAM(), this.entrada.getUnidadeMedidaRAM());
			this.preencheBitsPosicaoCACHE(this.entrada.getBytesPalavra(), this.entrada.getQtdPalavrasBloco());
			this.preencheQtdConjutosCACHE(this.entrada.getQtdConjuntos());
			this.preencheQtdBitsTagCACHE(this.saida.getQtdBitsEndereco(), this.saida.getQtdBitsConjunto(),
					this.saida.getQtdBitsBloco());
			if(entrada.getTipoMapeamento().equals("2")) {
				this.preencheInfoEnderecosComplAssociativoCACHE(this.entrada.getEnderecosAcesso(), this.saida.getQtdBitsBloco(),
						this.saida.getQtdBitsTAG());
			} else {
						this.preencheInfoEnderecosCACHE(this.entrada.getEnderecosAcesso(), this.saida.getQtdBitsBloco(),
					this.saida.getQtdBitsConjunto(), this.saida.getQtdBitsTAG());
			}
			
			escritor.write(saida.getTamanhoCACHE());
			escritor.newLine();
			escritor.write("Número de bits do endereço: " + saida.getQtdBitsEndereco());
			escritor.newLine();
			escritor.write("Número de bits para a posição no bloco: " + saida.getQtdBitsBloco());
			escritor.newLine();
			escritor.write("Número de bits para o número do conjunto: " + saida.getQtdBitsConjunto());
			escritor.newLine();
			escritor.write("Número de bits para a TAG: " + saida.getQtdBitsTAG());
			
			for(String linha : this.saida.getInfoEnderecos()) {
				escritor.newLine();
				escritor.write(linha);
			}
			escritor.close();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, ioe);
		}
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
	 * Preenche bytes da palavra, qtd palavras bloco, qtd blocos por conjunto, qtd conjuntos e
	 *  qtd acessos a memória.
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
	
	private void preencheTamanhoCACHE(String bytesPalavra, 
			String qtdPalavrasBloco, String qtdBlocos, String qtdConjuntos) {
		
		Integer totalBytes = Integer.parseInt(bytesPalavra) * Integer.parseInt(qtdPalavrasBloco) *
				Integer.parseInt(qtdBlocos) * Integer.parseInt(qtdConjuntos);
		
		this.saida.setTamanhoCACHE(CalculoUtil.formataValorByte(totalBytes, 1024) + " " 
				+ MedidaByte.getNomeUnidade(totalBytes));
	}
	
	private void preencheBitsEnderecoCACHE(String tamanhoRAM, String unidadeRAM) {
		
		Integer tamanhoMemRAM = Integer.parseInt(tamanhoRAM);
		
		if(tamanhoMemRAM == 0) {
			this.saida.setQtdBitsEndereco(tamanhoMemRAM.toString());
		} else {
		
			tamanhoMemRAM = CalculoUtil.getTamanhoUnidade(tamanhoMemRAM, unidadeRAM) - 1;		
			String ramBin = Integer.toBinaryString(tamanhoMemRAM);
			Integer tamanhoRAMBin = ramBin.length();
			this.saida.setQtdBitsEndereco(tamanhoRAMBin.toString());
		}
	}
	
	private void preencheBitsPosicaoCACHE(String qtdPalavras, String qtdBlocos) {		
		
		Integer calculo = Integer.parseInt(qtdPalavras) * Integer.parseInt(qtdBlocos);
		
		if(calculo == 0) {
			this.saida.setQtdBitsBloco(calculo.toString());
		} else {

			String bitsPosicaoBin = CalculoUtil.converteBinario(calculo - 1);
			Integer tamanhoBitsPosicao = bitsPosicaoBin.length();
		
			this.saida.setQtdBitsBloco(tamanhoBitsPosicao.toString());
		}
	}
	
	private void preencheQtdConjutosCACHE(String qtdConjuntos) {
		
		Integer calculo = Integer.parseInt(qtdConjuntos) -1;
		
		if(calculo == 0) {
			this.saida.setQtdBitsConjunto(calculo.toString());
		} else {
		
		String qtdConjuntosBin = CalculoUtil.converteBinario(calculo);
		Integer tamanhoQtdConjuntos = qtdConjuntosBin.length();
		
		this.saida.setQtdBitsConjunto(tamanhoQtdConjuntos.toString());
		}
	}
	
	private void preencheQtdBitsTagCACHE(String qtdBitsEndereco, String qtdBitsConjunto, 
			String qtdBitsBloco) {
		
		Integer calculo = Integer.parseInt(qtdBitsEndereco) - 
				(Integer.parseInt(qtdBitsConjunto) + Integer.parseInt(qtdBitsBloco));
		
		this.saida.setQtdBitsTAG(calculo.toString());		
	}
	
	private void preencheInfoEnderecosCACHE(List<String> enderecosAcesso, 
			String posicaoBloco, String numeroConjunto, String bitsTAG) {
		
		List<String> dadosEnderecos = new ArrayList<>();
		
		for(String endereco : enderecosAcesso) {
			
			String binario = CalculoUtil.converteBinario(Integer.parseInt(endereco));
			
			int tamanhoBlocoDesejado = Integer.parseInt(posicaoBloco);
			int tamanhoConjuntoDesejado = Integer.parseInt(numeroConjunto);
			int tamanhoTagDesejado = Integer.parseInt(bitsTAG);
			
			int tamanhoTotalDesejado = tamanhoBlocoDesejado + tamanhoConjuntoDesejado + tamanhoTagDesejado;
			
			if(binario.length() < tamanhoTotalDesejado) {
				binario = CalculoUtil.preencheZeroAEsq(binario, tamanhoTotalDesejado);
			}
			
			Integer tag = Integer.parseInt(binario.substring(0,tamanhoTagDesejado), 2);
			Integer numConjunto = 
					Integer.parseInt(binario.substring(tamanhoTagDesejado, tamanhoTotalDesejado - tamanhoBlocoDesejado), 2);
			Integer numPosicaoBloco = 
					Integer.parseInt(binario.substring(tamanhoTotalDesejado - tamanhoBlocoDesejado, tamanhoTotalDesejado), 2);
			
			dadosEnderecos.add(tag.toString() + " " + numConjunto.toString() + " " + 
					numPosicaoBloco.toString());	
		}
		
		this.saida.setInfoEnderecos(dadosEnderecos);
	}
	
	private void preencheInfoEnderecosComplAssociativoCACHE(List<String> enderecosAcesso, 
			String posicaoBloco, String bitsTAG) {
		
		List<String> dadosEnderecos = new ArrayList<>();
		
		for(String endereco : enderecosAcesso) {
			
			String binario = CalculoUtil.converteBinario(Integer.parseInt(endereco));
			
			int tamanhoBlocoDesejado = Integer.parseInt(posicaoBloco);
			int tamanhoTagDesejado = Integer.parseInt(bitsTAG);
			
			int tamanhoTotalDesejado = tamanhoBlocoDesejado + tamanhoTagDesejado;
			
			if(binario.length() < tamanhoTotalDesejado) {
				binario = CalculoUtil.preencheZeroAEsq(binario, tamanhoTotalDesejado);
			}
			
			Integer tag = Integer.parseInt(binario.substring(0,tamanhoTotalDesejado - tamanhoBlocoDesejado), 2);
			Integer numPosicaoBloco = 
					Integer.parseInt(binario.substring(tamanhoTotalDesejado - tamanhoBlocoDesejado, tamanhoTotalDesejado), 2);
			
			dadosEnderecos.add(tag.toString() + " " + "0" + " " + 
					numPosicaoBloco.toString());	
		}
		
		this.saida.setInfoEnderecos(dadosEnderecos);
	}
	
	
}
