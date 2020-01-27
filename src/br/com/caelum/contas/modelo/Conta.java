package br.com.caelum.contas.modelo;

public class Conta {

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
		this.saldo += valor;
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
	
	public String getTipo() {
		return "Conta";
	}
	
	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}
	
}
