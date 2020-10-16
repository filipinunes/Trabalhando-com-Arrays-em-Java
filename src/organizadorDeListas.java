import java.util.Random;


public class organizadorDeListas {

	public static void main(String[] args) {
		Random gerador = new Random();
		int numList[] = new int[20];
		int maiorNum=0, menorNum=0, idMenor=0, totImp=0;
		float medPosImp=0, totPosImp=0, numPosImp=0;
		
		
		for(int i=0; i<20; i++) {
			//Gera um número randômico
			int num = gerador.nextInt(150);
			numList[i] = num;
			
			//Verifica o maior número do array
			if(i==0) {
				maiorNum = num;
			}else if(num>maiorNum) {
				maiorNum = num;
			}	
			
			//Verifica o menor número do array
			if(i==0) {
				menorNum = num;
			}else if(num<menorNum) {
				menorNum = num;
				idMenor = i;
			}
			
			//Verifica se o número é impar e soma 1 se for
			if((num % 2) != 0) {
				totImp += 1;
			}
			
			//Verifica se a posição do número no array é impar
			if((i % 2) != 0) {
				totPosImp += 1;
				numPosImp += num;				
			}
		}
		
		//Imprime o array numlist
		System.out.print("Este é o array original e completo: ");
		for(int i=0; i<20; i++) {
			if(i<19) {
				System.out.print(numList[i] + " ");
				}else if(i==19) {
					System.out.println(numList[i]);
				}
			}
		
		//Reorganiza o array invertendo as posições
		for(int i=0; i<=10; i++) {
			int aux = numList[i];
			numList[i] = numList[numList.length - 1 - i];
			numList[numList.length - 1 - i] = aux;
		}
		
		//Imprime o array numlist com as posições invertidas
		System.out.print("Este é o array com posições invertidas e completo: ");
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
		System.out.print("Este é o array organizado por ordem crescente: ");
		for(int i=0; i<20; i++) {
			if(i<19) {
				System.out.print(numList[i] + " ");
				}else if(i==19) {
					System.out.println(numList[i]);
				}
			}
		
		//Calcula a média de números em posições ímpares
		medPosImp = numPosImp / totPosImp;
		
		//Imprime o maior número
		System.out.println("Este é o maior número do array: " + maiorNum);
		
		//Imprime o ID do menor número do array
		System.out.println("Este é o ID do menor número do array na organização original: " + idMenor);
		
		//Imprime a quatidade de números ímpares no array
		System.out.println("Este é o total de números ímpares no array: " + totImp);
		
		//Imprime a média dos números em posições ímpares
		System.out.println("Esta é a média dos números em posições ímpares: " + medPosImp);
	}
}
