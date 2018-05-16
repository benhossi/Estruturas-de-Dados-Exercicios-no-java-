import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pilha p = new Pilha ();
		int resto;
		System.out.println("Bem vindo ao conversor DecimalToBinary !!!");
		System.out.print("Digite o número decimal: ");
		int numero = sc.nextInt();
	
		while(numero != 0) {
			resto = numero%2;
			p.push(resto);
			numero=numero/2;
		}
		System.out.println("Conversão: ");
		while(!p.isEmpety()) {
			resto = p.pop();
			System.out.println(resto);
		}						
	}

}
