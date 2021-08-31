package bo.edu.ucb.est;

import java.util.Scanner;

public class Cuenta extends Cliente {
	private String numero;
	private String moneda;
	private String tipo;
	private double saldo; // saldo inicial
	
	public Cuenta(String nombre,String codigo,String pin,String numero,String moneda,String tipo,double saldo) {
		super(nombre,codigo,pin);
		this.numero=numero;
		this.moneda=moneda;
		this.tipo=tipo;
		this.saldo=saldo;
	}

	public String getNumero() {
		return numero;
	}

	public String getMoneda() {
		return moneda;
	}

	public String getTipo() {
		return tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}

	public void doRetiro() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("\nIngrese la cantidad a retirar: "); String ret=scanner.next();
		double retiro=Double.valueOf(ret);
		if (retiro>0 && retiro<=getSaldo()) {
			setSaldo(saldo-retiro);
			//saldo=saldo-retiro;
			System.out.println("\nTransacción realizada exitosamente.\n");
			System.out.println("Nuevo saldo: "+getSaldo()+" "+getMoneda()+"\n");
		}
		else { //if (retiro==0 || retiro<0 || retiro>getSaldo()) {
			System.out.println("\nEl valor ingresado no es válido. Ingrese un monto diferente.\n");
			//doRetiro();
		}
		scanner.close();
	}
	
	/*public void doDeposito() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("\nIngrese la cantidad a depositar: "); double deposito=scanner.nextDouble();
		if (deposito==0 || deposito<0) {
			System.out.println("\nEl valor ingresado no es válido. Ingrese un monto diferente.\n");
			doDeposito();
		}
		else {
			saldo=saldo+deposito;
			System.out.println("\nTransacción realizada exitosamente.\n");
		}
		scanner.close();
	}*/
}
