import java.util.Scanner;

public class questao1 {

	public static void main(String[] args) {
		
		int quantiaFuncionarios,terminarVerificador = 0;
		
		double totalSalarioBruto =0, totalINSS = 0, totalImpostoRenda = 0, totalSalarioLiquido = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Quantos funcion�rios deseja registrar?");
		quantiaFuncionarios  =teclado.nextInt();
			
		while(quantiaFuncionarios <= 0) {
			
			System.out.println("O numero de funcion�rios deve ser maior que '0'. Deseja cancelar o programa?\n\n1 - Sim\n2 - N�o ");
			terminarVerificador = teclado.nextInt();
			
			if (terminarVerificador != 1 && terminarVerificador != 2) {
				
				System.out.println("Op��o Inv�lida. Deseja cancelar o programa?\n\n1 - Sim\n2 - N�o ");
				terminarVerificador = teclado.nextInt();
				
			} else if (terminarVerificador == 2) {
				
				System.out.println("Quantos funcion�rios deseja registrar?");
				quantiaFuncionarios = teclado.nextInt();
			} else {
				
				System.out.println("Programa cancelado");
				break;
			}
		}
		
		
		if(terminarVerificador != 1) { //verifica se o usuario nao cancelou o programa
			
			String nomes[] = new String [quantiaFuncionarios];
			
			double matriz [][] = new double[quantiaFuncionarios][4];
			
			
			for(int c = 0; c < quantiaFuncionarios;c++) {
				
				System.out.print("Insira seu nome: ");
				nomes[c] = teclado.next();
				
				while (nomes[c].length() < 2) {
					
					System.out.println("Nome inv�lido\n\nO nome precisa ter ao menos 2 carcteres. Digite novamente: ");
					nomes[c] = teclado.next();
				}
				
				System.out.println("Insira seu salario bruto: ");
				matriz[c][0] = teclado.nextDouble();
				
				while (matriz[c][0] < 465) {
					
					System.out.println("Sal�rio inv�lido.\n\nO sal�rio deve ser um valor igual ou acima de R$ 465,00. Tente novamente: ");
					matriz[c][0] = teclado.nextDouble();	
				}
				
				if (matriz[c][0] <= 965.87) { //verifica��o INSS
					
					matriz[c][1] = matriz[c][0]*8/100;
					
				} else if (matriz[c][0] > 965.87 && matriz [c][0] <= 1609.45){
					
					matriz[c][1] = matriz[c][0]*9/100;
					
				} else if (matriz [c][0] > 1609.45 && matriz[c][0] <= 3218.9) {
					
					matriz[c][1] = matriz[c][0]*11/100;
					
				} else {
					
					matriz[c][1] = 454.07;
					
				} if (matriz[c][1] > 354.07) { //verificador teto INSS
					
					matriz[c][1] = 354.07;
					
				}
				
				if (matriz[c][0] <= 1434) { //verifica��o Imposto de renda
					
					matriz[c][2] = 0;
					
				} else if (matriz[c][0] > 1434 && matriz[c][0] <= 2150) {
					
					matriz[c][2] = matriz[c][0]*7.5/100;
					
				} else if (matriz[c][0] > 2150 && matriz[c][0] <= 2886) {
					
					matriz[c][2] = matriz[c][0]*15/100;
					
				} else if (matriz [c][0] > 2886 && matriz[c][0] <= 3582) {
					
					matriz[c][2] = matriz[c][0]*22.5/100;
					
				} else {
					
					matriz[c][2] = matriz[c][0]*27.5/100;
					
				}
				
				matriz[c][3] = matriz[c][0] - matriz[c][1] - matriz[c][2]; //calculo salario liquido
				
				totalSalarioBruto += matriz[c][0];
				totalINSS += matriz[c][1];
				totalImpostoRenda += matriz[c][2];
				totalSalarioLiquido += matriz[c][3];
	
			}
			for (int l = 0;l < quantiaFuncionarios;l++) {
				
				System.out.println("\nFuncion�rio: " + nomes[l] + "\nSal�rio bruto: R$" + matriz[l][0] + "\nDesconto INSS: R$" + matriz[l][1]  + "\nImposto de renda: R$" + matriz[l][2] + "\nSal�rio l�quido: R$" + matriz[l][3]);
				
			}
			
			System.out.println("\nO total dos sal�rios brutos �: R$" + totalSalarioBruto);
			System.out.println("O total dos descontos do INSS �: R$" + totalINSS);
			System.out.println("O total dos impostos de renda �: R$" + totalImpostoRenda);
			System.out.println("O total dos sal�rios l�quidos �: R$" + totalSalarioLiquido);
		}
		
	}

}
