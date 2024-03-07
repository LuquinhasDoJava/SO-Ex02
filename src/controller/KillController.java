package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	private String os() {
		return System.getProperty("os.name");
	}

	public void listaProcessos() {
		if (os().contains("Windows")) {
			try {
				Process pr = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream is = pr.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}
				is.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (os().contains("Linux")) {
				try {
					Process pr = Runtime.getRuntime().exec("ps -ef");
					InputStream is = pr.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					String line = br.readLine();
					while (line != null) {
						System.out.println(line);
						line = br.readLine();
					}
					is.close();
					isr.close();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
