package br.com.java.enumeration;

/**
 * Classe que contém a relação das grandezas de bytes.
 * @author Lucas Laet e Gabriel Vilas.
 */
public enum MedidaByte {

	B(0,1023,"B"), KB(1024,1048575,"KB"), MB(1048576,1073741823,"MB"), GB(1073741824,Integer.MAX_VALUE,"GB");
	
	private Integer inicioTamanhoBytes;
	private Integer fimTamanhoBytes;
	private String nomeUnidade;
	
	MedidaByte(Integer inicioTamanhoBytes, Integer fimTamanhoBytes, String nomeUnidade){
		this.inicioTamanhoBytes = inicioTamanhoBytes;
		this.fimTamanhoBytes = fimTamanhoBytes;
		this.nomeUnidade = nomeUnidade;
	}

	public Integer getInicioTamanhoBytes() {
		return inicioTamanhoBytes;
	}

	public Integer getFimTamanhoBytes() {
		return fimTamanhoBytes;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	/**
	 * Filtra qual a unidade de medida é proporcional a quantidade de bytes.
	 * @param bytes
	 * @return o nome da unidade de medida.
	 */
	static String getNomeUnidade(Integer bytes) {
				
		for(MedidaByte medida : MedidaByte.values()) {
			
			if(bytes >= medida.getInicioTamanhoBytes() && bytes <= medida.getFimTamanhoBytes()) {
				return medida.getNomeUnidade();
			}
		}
		return "";
	}
	
}
