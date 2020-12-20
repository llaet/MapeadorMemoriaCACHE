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
		if(valor / 1000 == valor) {
			
			if(valor < 10000) {
				return valor.toString().substring(1);
			} else if(valor < 100000) {
				return valor.toString().substring(2);
			}
			return valor.toString().substring(3);
			
			//verifica se n�mero est� na casa dos milh�es.
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
