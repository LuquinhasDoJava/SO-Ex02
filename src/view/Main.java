package view;

import java.util.Scanner;

import controller.KillController;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		KillController kc = new KillController();
		
		int x = 0;
		do {
			System.out.println("========================================");
			System.out.println("|            Menu Inicial              |");
			System.out.println("+======================================+");
			System.out.println("|1 - Mostrar processos                 |");
			System.out.println("|2 - Matar por PID                     |");
			System.out.println("|3 - Matar por Nome                    |");
			System.out.println("|9 - Para encerrar aplicação           |");
			System.out.println("========================================");
			System.out.print("Digite aqui:");
			x = sc.nextInt();
			switch(x) {
			case 1:
				kc.listaProcessos();
				break;
			case 2:
				System.out.print("Digite um PID:");
				kc.mataPid(sc.nextInt());
				break;
			case 3:
				System.out.print("Digite o nome do programa:");
				String a = sc.next();
				kc.mataNome(a);
				break;
			case 9:
				System.err.println("Fim do programa!");
				break;
			default:
				System.err.println("Numero invalido!");
			}
			sc.nextLine();
			System.out.println("Tecle 'ENTER' para continuar.");
			sc.nextLine();
		}while(x!=9);
		sc.close();
	}

}