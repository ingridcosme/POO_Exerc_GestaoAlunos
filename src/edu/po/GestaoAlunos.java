package edu.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestaoAlunos {
	
	private Scanner scan1 = new Scanner(System.in);
	private int indice;  // Indica em qual posição deve ser guardada a proxima instância de aluno
	private Aluno[] alunos;  // Matriz com 50 alunos

	public GestaoAlunos() {
		this.alunos = new Aluno[50];
	}
	
	public void criar(long id, Date nascimento, String ra, String nome) {
		Aluno aluno = new Aluno();
		
		aluno.setId(id);
		aluno.setNascimento(nascimento);
		aluno.setNome(nome);
		aluno.setRa(ra);
		
		this.alunos[indice] = aluno;
		indice++;
	}
	
	public void atualizar() throws ParseException {
		System.out.println("Por favor, digite o RA do aluno: ");
		String raProcurado = scan1.nextLine();
		
		int indiceProcurado = 0;
		for(Aluno aluno: this.alunos) {
			if(aluno.getRa() != null) {
				if(aluno.getRa().equals(raProcurado)) {
					break;
				} else {
					System.out.println("RA não encontrado");
				}
				indiceProcurado++;
			}
		}
		
		System.out.println("Por favor, digite o novo NOME do aluno: ");
		String novoNome = scan1.nextLine();
		alunos[indiceProcurado].setNome(novoNome);
		
		System.out.println("Por favor, digite a nova DATA DE NASCIMENTO do aluno: ");
		String novoNascimento = scan1.nextLine();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date data = formato.parse(novoNascimento);
		alunos[indiceProcurado].setNascimento(data);
	}
	
	public void excluir() {
		String continuar = "S";
		while(continuar.equalsIgnoreCase("S")) {
			System.out.println("Por favor, digite o RA do aluno a ser excluído: ");
			String raProcurado = scan1.nextLine();
			
			for(Aluno aluno: this.alunos) {
				if(aluno.getRa() != null) {
					if(aluno.getRa().equals(raProcurado)) {
						aluno.setId(0);
						aluno.setNascimento(null);
						aluno.setNome(null);
						aluno.setRa(null);
						break;
					} else {
						System.out.println("RA não encontrado");
					}
				}
			}
			
			System.out.println("Deseja excluir mais um aluno? S/N ");
			continuar = scan1.nextLine();
		}
	}
	
	public void exibir() {
		System.out.println("Por favor, digite o RA do aluno: ");
		String raProcurado = scan1.nextLine();
		
		for(Aluno aluno: this.alunos) {
			if(aluno.getRa() != null) {
				if(aluno.getRa().equals(raProcurado)) {
					System.out.println("\n==========================");
					System.out.println(aluno);
					System.out.println("\n==========================\n");
					break;
				} else {
					System.out.println("RA não encontrado");
				}
			}
		}
	}
	
}
