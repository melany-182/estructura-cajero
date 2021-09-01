package bo.edu.ucb.est;
import java.util.ArrayList;

public class Main {
	public static ArrayList<Cliente>clientes=new ArrayList<Cliente>();
	public static ArrayList<Cuenta>cuentas=new ArrayList<Cuenta>();
	
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
        	
        Cajero.login(clientes,cuentas,0);
    }
}
