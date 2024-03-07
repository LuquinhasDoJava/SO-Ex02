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

	public void mataPid(int PID) {
		if (os().contains("Windows")) {
			try {
				String a = ("TASKKILL /PID " + PID);
				Process pr = Runtime.getRuntime().exec(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (os().contains("Linux")) {
			try {
				String a = ("kill -9 " + PID);
				Process pr = Runtime.getRuntime().exec(a);
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}
	
	public void mataNome(String nome) {
		if (os().contains("Windows")) {
			try {
				String a = ("TASKKILL /IM " + nome);
				Process pr = Runtime.getRuntime().exec(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (os().contains("Linux")) {
			try {
				String a = ("pkill -f " + nome);
				Process pr = Runtime.getRuntime().exec(a);
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}
}
