package bo.edu.ucb.est;

import java.util.ArrayList;
import java.util.Scanner;

public class Cajero {
	public static ArrayList<Cliente> clientes;
	public static ArrayList<Cuenta> cuentas;
	private static ArrayList<Cuenta> cuentasClienteActual=new ArrayList<Cuenta>();
	public Cajero(ArrayList<Cliente> clientes,ArrayList<Cuenta> cuentas,ArrayList<Cuenta> cuentasClienteActual) {
		Cajero.clientes=clientes;
		Cajero.cuentas=cuentas;
		Cajero.cuentasClienteActual=cuentasClienteActual;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public ArrayList<Cuenta> getCuentasClienteActual() {
		return cuentasClienteActual;
	}

	public static void login(ArrayList<Cliente> clientes,ArrayList<Cuenta> cuentas,int ingreso) { // sin orientación a objetos
    	int flag=0;
    	int aux=0;
		String codigo;
		String pin;
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.print("Ingrese su código de cliente: "); codigo=scanner.nextLine();
		System.out.print("Ingrese su pin de seguridad: "); pin=scanner.nextLine();
		for (int i=0; i<clientes.size(); i++) {
			if ((clientes.get(i).getCodigo()).equals(codigo) && (clientes.get(i).getPin()).equals(pin)) {
				flag=1;
				aux=i;
				for (int j=0; j<cuentas.size(); j++) {
		        	if ((clientes.get(aux).getCodigo()).equals(cuentas.get(j).getCodigo())) {
		        		if (ingreso==0) {
		        			cuentasClienteActual.add(cuentas.get(j));
		        		}
		        		else {}
		        	}
				}
				break;
			}
			else {
				flag=0;
			}
		}
		
		if (flag==0) {
			System.out.print("\nEl código de cliente y el pin de seguridad no coinciden. Intente de nuevo.\n\n");
			//scanner.close();
			login(clientes,cuentas,ingreso);
		}
		else {
			System.out.print("\nAcceso permitido.\n\n");
			//scanner.close(); ---> esto genera una excepción. Por qué???
			clientes.get(aux).menuPrincipal(clientes,cuentas,cuentasClienteActual);
		}
		//scanner.close();
	}
}
