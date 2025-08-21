package casasBahia;

import java.util.InputMismatchException;
import java.util.Scanner;

import excecoes.PrecoInvalidoException;
import excecoes.CodigoInvalidoException;
import excecoes.RemoverInvalidoException;
import excecoes.DefaultInvalidoException;

public class Main {
	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		Scanner scan = new Scanner(System.in);
		
		int opcao = 0;
		
		do {
			System.out.println("---Menu----");
			System.out.println("1- Adicionar");
			System.out.println("2- Listar");
			System.out.println("3- Buscar");
			System.out.println("4- Remover");
			System.out.println("5- Sair");
			System.out.print("Digite sua opção: ");
			
			try {
				opcao = scan.nextInt();
				scan.nextLine();
				
				switch (opcao) {
				case 1:
					try {
						sistema.adicionarProduto(scan);										
					} catch (PrecoInvalidoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					sistema.listarProdutos();
					break;
				// Exceptions Novo para opção 3
				case 3:
					try {sistema.buscarProduto(scan);
					} catch (CodigoInvalidoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
				// Exceptions Novo para opção 4
					try {sistema.removerProduto(scan);
					} catch (RemoverInvalidoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					System.out.println("Saindo do Sistema!");
					break;
				// Exceptions Novo para opção Default
				default:
					throw new DefaultInvalidoException("Opção inválida! Por favor, escolha uma opção válida.");
				}
			} catch (InputMismatchException e) {
				scan.nextLine(); 
				System.out.println("Entrada inválida! Por favor, digite um número.");
				
			} catch (DefaultInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
		} while (opcao != 5);	
	}
}