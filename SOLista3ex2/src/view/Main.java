package view;

import controller.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String nome;
		int pid;
		Scanner scanner = new Scanner(System.in);
		KillController kill = new KillController();

		kill.ListaProcessos();

		System.out.println("Digite um pid para matar um processo: ");
		pid = scanner.nextInt();

		System.out.print("Digite um nome de processo para matar: ");
		nome = scanner.next();

		kill.MataNome(nome);
		kill.MataPid(pid);

		System.out.println("Processos mortos, fim do progama");

		scanner.close();
	}

}
