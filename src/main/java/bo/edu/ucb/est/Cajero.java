package bo.edu.ucb.est;

import java.util.ArrayList;
import java.util.Scanner;

public class Cajero {
	public static ArrayList<Cliente> clientes;
	public static ArrayList<Cuenta> cuentas;
	private static ArrayList<Cuenta> cuentasClienteActual=new ArrayList<Cuenta>();
	public static boolean ingresos[]=new boolean[3];
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

	public static void login(ArrayList<Cliente> clientes,ArrayList<Cuenta> cuentas,int aux) { // sin orientación a objetos
    	int newaux=-1;
		int flag=0;
    	int auxilio=0;
		String codigo;
		String pin;
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.print("Ingrese su código de cliente: "); codigo=scanner.nextLine();
		System.out.print("Ingrese su pin de seguridad: "); pin=scanner.nextLine();
		
		for (int i=0; i<clientes.size(); i++) {
			if ((clientes.get(i).getCodigo()).equals(codigo) && (clientes.get(i).getPin()).equals(pin)) {
				newaux=i;
				if (ingresos[newaux]==false) {
					cuentasClienteActual.clear();
				}
			}
		}
		
		for (int i=0; i<clientes.size(); i++) {
			if (i==newaux) {
				if (ingresos[newaux]==true) {
					cuentasClienteActual.clear();
					auxilio=1; // el cliente entró dos veces seguidas
				}
			}
		}
		
		for (int i=0; i<clientes.size(); i++) {
			if ((clientes.get(i).getCodigo()).equals(codigo) && (clientes.get(i).getPin()).equals(pin)) {
				flag=1;
				aux=i;
				for (int j=0; j<cuentas.size(); j++) {
		        	if ((clientes.get(aux).getCodigo()).equals(cuentas.get(j).getCodigo())) {
		        		if (ingresos[i]==false && auxilio==0) {
		        			cuentasClienteActual.add(cuentas.get(j));
		        		}
		        		if (ingresos[i]==true && auxilio==1) {
		        			cuentasClienteActual.add(cuentas.get(j));
		        		}
		        		//else {}
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
			login(clientes,cuentas,aux);
		}
		else {
			System.out.print("\nAcceso permitido.\n\n");
			for (int i=0; i<clientes.size(); i++) {
				
				if (i==aux) {
					ingresos[i]=true;
				}
				else {
					ingresos[i]=false;
				}
				//System.out.println(ingresos[i]);
			}
			//scanner.close(); ---> esto genera una excepción. Por qué???
			clientes.get(aux).menuPrincipal(clientes,cuentas,cuentasClienteActual,ingresos,aux);
		}
		//scanner.close();
	}
}
