package br.furb.grafos.caminhamento_grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Grafo {
	
	private static String rotulos[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	
	public static void main(String[] args) {
	try (BufferedReader br = new BufferedReader(new FileReader("grafo.txt"))) {
			int nVertices = 0;
			int matrizAdjacencia[][] = null;
			String rotulo[] = null;
			String line;
			int nRotulo = 0;			
			while ((line = br.readLine()) != null) {
				if (nVertices == 0) {
					nVertices = Integer.parseInt(line);
					matrizAdjacencia = new int[nVertices][nVertices];
					rotulo = new String[nVertices];
				} else {
					rotulo[nRotulo] = rotulos[nRotulo];
					String[] split = line.split(",");
					int j = 0;
					for (String string : split) {
						int valAresta = Integer.parseInt(string);
						matrizAdjacencia[nRotulo][j] = valAresta;
						j++;
					}
					nRotulo++;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
