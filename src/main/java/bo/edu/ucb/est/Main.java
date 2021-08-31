package bo.edu.ucb.est;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Cliente>clientes=new ArrayList<Cliente>();
	public static ArrayList<Cuenta>cuentas=new ArrayList<Cuenta>();
	public static ArrayList<Cuenta>cuentasClienteActual=new ArrayList<Cuenta>();
    public static void main(String[] args) {
    	
        Cliente cliente1=new Cliente("Juan Perez","jperez","3333");
        clientes.add(cliente1);
        	Cuenta cuenta1c1=new Cuenta("Juan Perez","jperez","3333","111122","Bolivianos","Caja de Ahorros",12000);
        	cuentas.add(cuenta1c1);
        	Cuenta cuenta2c1=new Cuenta("Juan Perez","jperez","3333","112211","USD","Cuenta Corriente",100);
        	cuentas.add(cuenta2c1);
        
        Cliente cliente2=new Cliente("Maria Gomez","mgomez","4444");
        clientes.add(cliente2);
        	Cuenta cuenta1c2=new Cuenta("Maria Gomez","mgomez","4444","221122","Bolivianos","Caja de Ahorros",0);
        	cuentas.add(cuenta1c2);
        
        Cliente cliente3=new Cliente("Carlos Gomez","cgomez","3333");
        clientes.add(cliente3);
        	Cuenta cuenta1c3=new Cuenta("Carlos Gomez","cgomez","3333","331122","Bolivianos","Caja de Ahorros",100);
        	cuentas.add(cuenta1c3);
        	Cuenta cuenta2c3=new Cuenta("Carlos Gomez","cgomez","3333","332211","USD","Cuenta Corriente",1000);
        	cuentas.add(cuenta2c3);
        	Cuenta cuenta3c3=new Cuenta("Carlos Gomez","cgomez","3333","332233","Bolivianos","Caja de Ahorros",100000);
        	cuentas.add(cuenta3c3);
  
       login();
    }
    
    public static void login() { // sin orientación a objetos
    	int flag=0;
    	int aux=0;
		String codigo;
		String pin;
		Scanner scanner=new Scanner(System.in);
		System.out.print("Ingrese su código de cliente: "); codigo=scanner.nextLine();
		System.out.print("Ingrese su pin de seguridad: "); pin=scanner.nextLine();
		for (int i=0; i<clientes.size(); i++) {
			if ((clientes.get(i).getCodigo()).equals(codigo) && (clientes.get(i).getPin()).equals(pin)) {
				flag=1;
				aux=i;
				for (int j=0; j<cuentas.size(); j++) {
		        	if ((clientes.get(aux).getCodigo()).equals(cuentas.get(j).getCodigo())) {
		        		cuentasClienteActual.add(cuentas.get(j));
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
			login();
		}
		else {
			System.out.print("\nAcceso permitido.\n\n");
			clientes.get(aux).menuPrincipal(cuentasClienteActual);
		}
		scanner.close();
	}
}
