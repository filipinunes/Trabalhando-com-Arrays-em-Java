import javax.swing.JOptionPane;
public class exerc�cioA2 {

	public static void main(String[] args) {
		/*
		 * Escreva um programa que permita armazenar e manipular uma cole��o de numeros
		 * inteiros de 20 elementos. Inicialmente o programa vai pedir ao usuario,
		 * insira os numeros da cole��o. Em seguida, o programa deve mostrar o seguinte
		 * menu MENU
		 * 
		 * 1 Mostrar 
		 * 2 Inverter 
		 * 3 Ordenar crescente 
		 * 4 Ordenar decrescente 
		 * 5 fatorialmenor 
		 * 6 Posi��o do maior 
		 * 7 Qtde de primos 
		 * 9 Vazar
		 * Se op��o 1 for selecionada, o programa mostra a cole��o na situa��o em que se encontra e apresenta o menu; 
		 * Se a op��o 2 for selecionada, o programa inverte a ordem dos elementos, de tal forma que o primeiro passa a ser o ultimo, e assim sucessivamente e reapresenta o menu; 
		 * se a op��o 3 for selecionada, o programa ordena a cole��o em ordem crescente e reapresenta o menu;
		 * se a op��o 4 for selecionada, o programa ordena a cole��o em ordem decrescente e reapresenta o menu;
		 * se a op��o 5 for selecionada , o programa calcula e mostra o FATORIAL DO menor elemento da cole��o e reapresenta o menu;
		 * se a op��o 6 for selecionada, o programa diz em que posi��o do vetor est� o maior elemento e reapresenta o menu;
		 * se a op��o 7 for selecionada, o programa diz quantos primos existem na cole��o e reapresenta o menu;
		 * se a op��o 9 for selecionada, o programa encerra;
		 * observa��o: o programa s� pode declarar e usar um �nico array
		 */

		int[] collection = new int[20];
		int range = collection.length;
		int option = 0;
		String input;

		// Popula o array colection
		for (int i = 0; i < range; i++) {
			input = JOptionPane.showInputDialog("Digite os n�meros da cole��o.");
			collection[i] = Integer.parseInt(input);
		}

		// Mostra um menu at� que o usu�rio decida parar o programa
		do {
			input = JOptionPane.showInputDialog(
					"Escolha uma a��o:" 
							+ "\n1: Mostrar a cole��o." 
							+ "\n2: Inverter a ordem da cole��o." 
							+ "\n3: Organizar a cole��o em ordem Crescente."
							+ "\n4: Organizar a cole��o em ordem Decrescente." 
							+ "\n5: Fatorial do menor n�mero da cole��o."
							+ "\n6: Mostrar a posi��o do maior n�mero da cole��o."
							+ "\n7: Mostrar quantos numeros primos existem na cole��o." 
							+ "\n9: Encerrar");

			option = Integer.parseInt(input);

			switch (option) {
			case 1:// Imprime situa��o atual do array
				System.out.println("-------------------------------------------------------");
				for (int i = 0; i < range; i++) {
					System.out.print(collection[i] + " ");
					if (i == (range - 1)) {
						System.out.print("\n");
					}
				}
				System.out.println("-------------------------------------------------------");
				break;
			case 2:// Inverte as posi��es do Array

				// Determina o valor onde o la�o deve parar
				int invertRange;
				if (range % 2 == 0) {
					invertRange = range / 2;
				} else {
					invertRange = (range - 1) / 2;
				}
				// Inverte as posi��es do Array
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
			case 5: // Determina o menor n�mero do array e mostra seu fatorial
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

				System.out.println("O menor n�mero da cole��o � " + smaller + " e o seu fatorial �: " + fatSmaller + ".");

				break;

			case 6: // Determina o maior n�mero do array e a sua posi�ao no array
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
				
				System.out.println("O maior n�mero do array � " + biggest + " e a sua posi��o no array � a: " + posBiggest + ".");
				break;
			case 7:
				int prime=0;
				for(int i=0; i<range; i++) {
					if (collection[i] == 2) {
						prime+=1;
					} else {
						int aux = collection[i] - 1;
						boolean primeBoolean = true;
						while (aux >= 2) {
							if ((collection[i] % aux) == 0) {
								primeBoolean = false;
							}
							aux -= 1;
						}
	
						if (primeBoolean == true) {
							prime += 1;
						}
					}
				}
				
				System.out.println("Existem " + prime + " n�meros primos na colecao.");
				break;
			case 9:
				System.out.println("Programa encerrado pelo usu�rio.");
				break;
				
				default:
					System.out.println("Op��o digitada invalida.");;
			}

		} while (option != 9);

	}

}
