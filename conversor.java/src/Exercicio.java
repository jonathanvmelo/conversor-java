import java.util.Scanner;

public class Exercicio {
	public static int soma(int x, int y) {
		int total = y / 2;
		int resultadoParcial = y + x;
		int resFinal = total * resultadoParcial;
		return resFinal;

	}


	public static void main(String[] args) {

//		Scanner scan = new Scanner(System.in);
//		int x = scan.nextInt();
//		int y = scan.nextInt();
		System.out.println(soma(1,500));

	}


}
