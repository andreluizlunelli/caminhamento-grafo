package br.furb.grafos.caminhamento_grafo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

	public static String readTxt(String string) {
		File file = new File(string);
		String _return = null;
        try {
            _return = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return _return;
	}
	
	public static void writeTxt(String string, String content) {
        try {
        	File file = new File(string);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void removeFile(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

}
