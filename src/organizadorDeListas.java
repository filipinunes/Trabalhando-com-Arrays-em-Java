import java.util.Random;


public class organizadorDeListas {

	public static void main(String[] args) {
		Random gerador = new Random();
		int numList[] = new int[20];
		int maiorNum=0, menorNum=0, idMenor=0, totImp=0;
		float medPosImp=0, totPosImp=0, numPosImp=0;
		
		
		for(int i=0; i<20; i++) {
			//Gera um n�mero rand�mico
			int num = gerador.nextInt(150);
			numList[i] = num;
			
			//Verifica o maior n�mero do array
			if(i==0) {
				maiorNum = num;
			}else if(num>maiorNum) {
				maiorNum = num;
			}	
			
			//Verifica o menor n�mero do array
			if(i==0) {
				menorNum = num;
			}else if(num<menorNum) {
				menorNum = num;
				idMenor = i;
			}
			
			//Verifica se o n�mero � impar e soma 1 se for
			if((num % 2) != 0) {
				totImp += 1;
			}
			
			//Verifica se a posi��o do n�mero no array � impar
			if((i % 2) != 0) {
				totPosImp += 1;
				numPosImp += num;				
			}
		}
		
		//Imprime o array numlist
		System.out.print("Este � o array original e completo: ");
		for(int i=0; i<20; i++) {
			if(i<19) {
				System.out.print(numList[i] + " ");
				}else if(i==19) {
					System.out.println(numList[i]);
				}
			}
		
		//Reorganiza o array invertendo as posi��es
		for(int i=0; i<=10; i++) {
			int aux = numList[i];
			numList[i] = numList[numList.length - 1 - i];
			numList[numList.length - 1 - i] = aux;
		}
		
		//Imprime o array numlist com as posi��es invertidas
		System.out.print("Este � o array com posi��es invertidas e completo: ");
		for(int i=0; i<20; i++) {
			if(i<19) {
				System.out.print(numList[i] + " ");
				}else if(i==19) {
					System.out.println(numList[i]);
				}
			}
		
		//Reorganiza o array numList em ordem crescente
		boolean foraDeOrdem = true;
		
		while(foraDeOrdem == true) {
			boolean alterou = false;
			for(int i=0; i<19; i ++) {
				int aux = numList[i];
				if(numList[i] > numList[i+1]) {
					numList[i] = numList[i+1];
					numList[i+1] = aux;
					alterou = true;
				}
			}
			if(alterou==false) {
				foraDeOrdem = false;
			}
		}
		
		//Imprime o array numlist em ordem crescente
		System.out.print("Este � o array organizado por ordem crescente: ");
		for(int i=0; i<20; i++) {
			if(i<19) {
				System.out.print(numList[i] + " ");
				}else if(i==19) {
					System.out.println(numList[i]);
				}
			}
		
		//Calcula a m�dia de n�meros em posi��es �mpares
		medPosImp = numPosImp / totPosImp;
		
		//Imprime o maior n�mero
		System.out.println("Este � o maior n�mero do array: " + maiorNum);
		
		//Imprime o ID do menor n�mero do array
		System.out.println("Este � o ID do menor n�mero do array na organiza��o original: " + idMenor);
		
		//Imprime a quatidade de n�meros �mpares no array
		System.out.println("Este � o total de n�meros �mpares no array: " + totImp);
		
		//Imprime a m�dia dos n�meros em posi��es �mpares
		System.out.println("Esta � a m�dia dos n�meros em posi��es �mpares: " + medPosImp);
	}
}
