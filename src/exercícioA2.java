import javax.swing.JOptionPane;

public class exercícioA2 {
	public static void main(String[] args) {
		/*
		 * Escreva um programa que permita armazenar e manipular uma coleção de numeros
		 * inteiros de 20 elementos. Inicialmente o programa vai pedir ao usuario,
		 * insira os numeros da coleção. Em seguida, o programa deve mostrar o seguinte
		 * MENU
		 * Se opção 1 for selecionada, o programa mostra a coleção na situação em que se encontra e apresenta o menu; 
		 * Se a opção 2 for selecionada, o programa inverte a ordem dos elementos, de tal forma que o primeiro passa a ser o ultimo, e assim sucessivamente e reapresenta o menu; 
		 * se a opção 3 for selecionada, o programa ordena a coleção em ordem crescente e reapresenta o menu;
		 * se a opção 4 for selecionada, o programa ordena a coleção em ordem decrescente e reapresenta o menu;
		 * se a opção 5 for selecionada , o programa calcula e mostra o FATORIAL DO menor elemento da coleção e reapresenta o menu;
		 * se a opção 6 for selecionada, o programa diz em que posição do vetor está o maior elemento e reapresenta o menu;
		 * se a opção 7 for selecionada, o programa diz quantos primos existem na coleção e reapresenta o menu;
		 * se a opção 9 for selecionada, o programa encerra;
		 * observação: o programa só pode declarar e usar um único array
		 */

		int[] collection = new int[20];
		int range = collection.length;
		int option = 0;
		String input;

		// Popula o array colection
		for (int i = 0; i < range; i++) {
			input = JOptionPane.showInputDialog("Digite os números da coleção.");
			collection[i] = Integer.parseInt(input);
		}

		// Mostra um menu até que o usuário decida parar o programa
		do {
			input = JOptionPane.showInputDialog(
					"Escolha uma ação:" 
							+ "\n1: Mostrar a coleção." 
							+ "\n2: Inverter a ordem da coleção." 
							+ "\n3: Organizar a coleção em ordem Crescente."
							+ "\n4: Organizar a coleção em ordem Decrescente." 
							+ "\n5: Fatorial do menor número da coleção."
							+ "\n6: Mostrar a posição do maior número da coleção."
							+ "\n7: Mostrar quantos numeros primos existem na coleção." 
							+ "\n9: Encerrar");

			option = Integer.parseInt(input);

			switch (option) {
			case 1:// Imprime situação atual do array
				System.out.println("-------------------------------------------------------");
				for (int i = 0; i < range; i++) {
					System.out.print(collection[i] + " ");
					if (i == (range - 1)) {
						System.out.print("\n");
					}
				}
				System.out.println("-------------------------------------------------------");
				break;
			case 2:// Inverte as posições do Array

				// Determina o valor onde o laço deve parar
				int invertRange;
				if (range % 2 == 0) {
					invertRange = range / 2;
				} else {
					invertRange = (range - 1) / 2;
				}
				// Inverte as posições do Array
				for (int i = 0; i < (invertRange); i++) {
					int aux = collection[i];
					collection[i] = collection[collection.length - 1 - i];
					collection[collection.length - 1 - i] = aux;
				}
				break;
			case 3: // Organiza o Array em Ordem Crescente
				boolean outOfOrder = true;

				while (outOfOrder == true) {
					boolean hadChange = false;
					for (int i = 0; i < range - 1; i++) {
						int aux = collection[i];
						if (collection[i] > collection[i + 1]) {
							collection[i] = collection[i + 1];
							collection[i + 1] = aux;
							hadChange = true;
						}
					}
					if (hadChange == false) {
						outOfOrder = false;
					}
				}
				break;
			case 4: // Organiza o Array em Ordem Decrescente
				outOfOrder = true;

				while (outOfOrder == true) {
					boolean hadChange = false;
					for (int i = range - 1; i > 0; i--) {
						int aux = collection[i];
						if (collection[i] > collection[i - 1]) {
							collection[i] = collection[i - 1];
							collection[i - 1] = aux;
							hadChange = true;
						}
					}
					if (hadChange == false) {
						outOfOrder = false;
					}
				}
				break;
			case 5: // Determina o menor número do array e mostra seu fatorial
				int fatSmaller = 1;
				int smaller = 0;
				for (int i = 0; i < range; i++) {
					if (i == 0) {
						smaller = collection[i];
					} else if (collection[i] < smaller) {
						smaller = collection[i];
					}
				}

				for (int i = smaller; i > 0; i--) {
					fatSmaller *= i;
				}

				System.out.println("O menor número da coleção é " + smaller + " e o seu fatorial é: " + fatSmaller + ".");

				break;

			case 6: // Determina o maior número do array e a sua posiçao no array
				int biggest = 0, posBiggest = 0;
				for (int i = 0; i < range; i++) {
					if (i == 0) {
						biggest = collection[i];
						posBiggest = i;
					} else if (collection[i] > biggest) {
						biggest = collection[i];
						posBiggest = i;
					}
				}
				
				System.out.println("O maior número do array é " + biggest + " e a sua posição no array é a: " + posBiggest + ".");
				break;
			case 7: //Verifica quantos números primos o Array contém
				int prime=0;
				for(int i=0; i<range; i++) {
					if (collection[i] == 2) {
						prime+=1;
					} else {
						int aux = collection[i] - 1;
						boolean checkPrime = true;
						while (aux >= 2) {
							if ((collection[i] % aux) == 0) {
								checkPrime = false;
							}
							aux -= 1;
						}
	
						if (checkPrime == true) {
							prime += 1;
						}
					}
				}
				
				System.out.println("Existem " + prime + " números primos na colecao.");
				break;
			case 9:
				System.out.println("Programa encerrado pelo usuário.");
				break;
				
				default:
					System.out.println("Opção digitada invalida.");
			}

		} while (option != 9);

	}

}
