package modelo;

public abstract class Conta {
	
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;
	
	public Conta() {
		
	}
	
	public Conta(int agencia, int numero) {
		Conta.total++;
		//System.out.println("o total de contas � " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
		//System.out.println("estou criando uma conta");
	}
	
	public abstract void deposita(double valor);
	
	public void saca(double valor) throws SaldoInsuficienteException {
		if(this.saldo < valor ) {
			throw new SaldoInsuficienteException("saldo: " + this.saldo + ", Valor: " + valor);
			
		}
		
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException { 
	    saca(valor);
	    destino.deposita(valor);
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("nao pode valor <= 0");
			return;
		}
		this.numero = numero;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("nao pode valor menor igual a 0");
			return;
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public static int getTotal() {
		return Conta.total;
	}
}
