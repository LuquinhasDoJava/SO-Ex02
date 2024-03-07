package view;

import java.util.Scanner;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController kc = new KillController();
		Scanner sc = new Scanner(System.in);
		kc.listaProcessos();
		kc.mataPid(sc.nextInt());

	}

}
