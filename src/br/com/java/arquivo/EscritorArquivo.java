package br.com.java.arquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Classe que escreve em um arquivo.
 * @author Lucas Laet e Gabriel Vilas.
 */
public class EscritorArquivo {


	private List<String> arquivo;

	public EscritorArquivo() {
		this.arquivo = new ArrayList<>();
	}

	public void writeDecodedTextDocument() {
		try {
			BufferedWriter escritorArquivo = new BufferedWriter(new FileWriter(".\\dados-CACHE.txt"));
			/**
			for (String line : decodedInstructions) {
				fileWriter.write(line);
				fileWriter.newLine();
			}
			**/
			escritorArquivo.close();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, ioe);
		}
	}
}
