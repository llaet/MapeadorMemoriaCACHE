package br.com.java.mat;

public class CalculoUtil {

	public CalculoUtil(){}
	
	/**
	 * Formata número para o formato: se 35200 > 35
	 * @param valor
	 * @param valorMaximo
	 * @return número formatado.
	 */
	public static String formataValorByte(Integer valor, Integer valorMaximo) {
		
		if(valor <= valorMaximo) {
			return valor.toString();
		}
		
		//verifica se número está na casa dos milhares.
		if(valor / 1000 == valor) {
			
			if(valor < 10000) {
				return valor.toString().substring(1);
			} else if(valor < 100000) {
				return valor.toString().substring(2);
			}
			return valor.toString().substring(3);
			
			//verifica se número está na casa dos milhões.
		} else if(valor / 1000000 == valor) {
			
			if(valor < 10000000) {
				return valor.toString().substring(1);
			} else if(valor < 100000000) {
				return valor.toString().substring(2);
			}
			return valor.toString().substring(3);
		}
		return valor.toString().substring(1);
	}
}
