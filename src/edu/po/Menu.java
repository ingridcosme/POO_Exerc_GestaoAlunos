package edu.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		GestaoAlunos ga = new GestaoAlunos();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			menu();
			String textoMaiusculo = scan.nextLine().toUpperCase();
		    char letra = textoMaiusculo.charAt(0);

			switch(letra) {
				case 'C':
					try {
						System.out.println("Por favor, digite o ID do aluno: ");
						long id = Long.parseLong(scan.nextLine());
						
						System.out.println("Por favor, digite o RA do aluno: ");
						String ra = scan.nextLine();
						
						System.out.println("Por favor, digite o NOME do aluno: ");
						String nome = scan.nextLine();
						
						System.out.println("Por favor, digite a data de NASCIMENTO do aluno: ");
						String data = scan.nextLine();
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
						Date nascimento = formato.parse(data);
						
						ga.criar(id, nascimento, ra, nome);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					break;
				case 'E':
					ga.exibir();
					break;
				case 'R':
					ga.excluir();
					break;
				case 'A':
					try {
						ga.atualizar();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					break;
				case 'S':
					System.exit(0);
			}
		}
	}
	
	private static void menu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\n=== O QUE VOCÊ DESEJA FAZER? ===\n\n");
		buffer.append("\t(C) Criar\t\n");
		buffer.append("\t(E) Exibir\t\n");
		buffer.append("\t(R) Remover\t\n");
		buffer.append("\t(A) Atualizar\t\n");
		buffer.append("\t(S) Sair\t\n");
		buffer.append("====================================\n\n");

		System.out.println(buffer.toString());
	}

}
