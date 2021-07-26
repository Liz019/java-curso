
public class Fluxo {

	public static void main(String[] args) {
		System.out.println("Ini do main");
		try {
			metodo1();
		} catch(ArithmeticException | NullPointerException | MyException ex) {
				String msg = ex.getMessage();
				System.out.println("Exception " + msg);
				ex.printStackTrace();
		}
		System.out.println("Fim do main");

	}
	
	public static void metodo1() {
		System.out.println("Ini do metodo1");
		metodo2();
		System.out.println("fim do metodo1");
	}
	
	public static void metodo2() {
		System.out.println("Ini do metodo2");

		throw new MyException("erro");
		
		//System.out.println("Fim do metodo2");

	}
}
