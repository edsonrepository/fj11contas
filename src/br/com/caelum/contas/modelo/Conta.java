package br.com.caelum.contas.modelo;

public abstract class Conta {

	private String titular;
	private String agencia;
	private int numero;
	protected double saldo;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void deposita(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar um valor negativo");
		} else {
			this.saldo += valor;
		}
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void saca(double valor) {
		this.saldo -= valor;
	}
	
	public String recuperaDadosParaImpressao() {
		String dados = "Titular: " + this.titular;
		dados += "\nNúmero: " + this.numero;
		dados += "\nAgência: " + this.agencia;
		dados += "\nSaldo: R$" + this.saldo;
		dados += "\nTipo: " + this.getTipo();
		return dados;
	}
	
	public abstract String getTipo();
	
	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}
	
	@Override
	public String toString() {
		return "[titular=" + titular + ", numero=" + numero
				+ ", agencia=" + agencia + "]";
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		Conta outraConta = (Conta) obj;
		
		return this.numero == outraConta.numero &&
				this.agencia.equals(outraConta.agencia);
	}
	
	//https://sergiotaborda.wordpress.com/desenvolvimento-de-software/java/excecoes-boas-praticas-mas-praticas/
	//https://www.guj.com.br/t/resolvido-diferenca-entre-throwable-e-exeption-dentro-do-catch/79565/2
}