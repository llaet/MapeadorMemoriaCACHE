package br.com.java.mat;

public class CalculoUtil {

	public CalculoUtil(){}
	
	/**
	 * Formata n�mero para o formato: se 35200 > 35
	 * @param valor
	 * @param valorMaximo
	 * @return n�mero formatado.
	 */
	public static String formataValorByte(Integer valor, Integer valorMaximo) {
		
		if(valor <= valorMaximo) {
			return valor.toString();
		}
		
		//verifica se n�mero est� na casa dos milhares.
		if(valor < 1000000) {
			Integer calculo = valor / 1000;
			return calculo.toString();		
			//verifica se n�mero est� na casa dos milh�es.
		} else if(valor < 1000000000) {
			Integer calculo = valor / 1000000;
			return calculo.toString();	
		}
		return valor.toString();
	}
	
	/**
	 * filtra tamanho m�ximo da unidade pelo nome.
	 * @param nomeUnidade
	 * @return tamanho m�ximo da unidade.
	 */
	public static Integer getTamanhoUnidade(int tamanhoUnidade, String nomeUnidadeRAM) {
		
		switch(nomeUnidadeRAM) {
			case "KB":
				return tamanhoUnidade * 1024;
			case "MB":
				return tamanhoUnidade * 1024 * 1024;
			case "GB":
				return tamanhoUnidade * 1024 * 1024 * 1024;
			default:
				return tamanhoUnidade;
		}
	}
	
	public static String converteBinario(Integer valor) {
		return Integer.toBinaryString(valor);
	}
	
	public static String preencheZeroAEsq(String binario, Integer tamanhoDesejado) {
		
		int tamanho = binario.length();
		
		while(tamanho < tamanhoDesejado) {
			binario = "0" + binario;
			tamanho++;
		}
		return binario;
	}
}
