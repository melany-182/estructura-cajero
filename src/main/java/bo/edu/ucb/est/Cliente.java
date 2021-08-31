package bo.edu.ucb.est;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	private String nombre;
	private String codigo;
	private String pin;
	
	public Cliente(String nombre,String codigo,String pin) {
		this.nombre=nombre;
		this.codigo=codigo;
		this.pin=pin;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getPin() {
		return pin;
	}
	
	public String toString() {
		StringBuilder sb=new StringBuilder();                                                                   
        sb.append("\nNombre: ");
        sb.append(getNombre());
        sb.append("\nCódigo: ");
        sb.append(getCodigo());
        sb.append("\nPin: ");
        sb.append(getPin());   
        return sb.toString();
	}
	
	public void menuPrincipal(ArrayList<Cuenta> cuentasClienteActual) {
		for (;;) {
			System.out.println("------- MENÚ PRINCIPAL -------");
			System.out.println("1. Ver saldo");
			System.out.println("2. Realizar retiro");
			System.out.println("3. Realizar depósito");
			System.out.println("4. Salir");
			Scanner scanner=new Scanner(System.in);
			String opcion0=null;
			System.out.print("\nIngrese una opción: "); opcion0=scanner.nextLine();
			
			switch (opcion0) {
				case "1": {
					int flag=0;
					System.out.println("\nSELECCIONE UNA DE SUS CUENTAS");
					for (int i=0; i<cuentasClienteActual.size(); i++) {
						System.out.println((i+1)+". Cuenta "+cuentasClienteActual.get(i).getNumero());
					}
					System.out.print("\nIngrese una opción: "); String opcion1=scanner.nextLine();
					for (int i=0; i<cuentasClienteActual.size(); i++) {
						if ((i+1)==Integer.valueOf(opcion1)) {
							flag=1;
							System.out.println("\nSaldo actual: "+cuentasClienteActual.get(i).getSaldo()+" "+cuentasClienteActual.get(i).getMoneda()+"\n");
							break;
						}
					}
					if (flag==0) {
						System.out.println("\nNúmero ingresado inválido.\n");
					}
					break;
				}
				case "2": {
					int flag=0;
					System.out.println("\nSELECCIONE UNA DE SUS CUENTAS");
					for (int i=0; i<cuentasClienteActual.size(); i++) {
						System.out.println((i+1)+". Cuenta "+cuentasClienteActual.get(i).getNumero());
					}
					System.out.print("\nIngrese una opción: "); String opcion2=scanner.nextLine();
					for (int i=0; i<cuentasClienteActual.size(); i++) {
						if ((i+1)==Integer.valueOf(opcion2)) {
							flag=1;
							System.out.println("\nSaldo actual: "+cuentasClienteActual.get(i).getSaldo()+" "+cuentasClienteActual.get(i).getMoneda());
							cuentasClienteActual.get(i).doRetiro(); // RETIRO
							scanner.close();
							//break;
						}
					}
					if (flag==0) {
						System.out.println("\nNúmero ingresado inválido.\n");
					}
					break;
				}
				case "3": {
					
					break;
				}
				case "4": {
					System.out.println("\n¡Hasta pronto!\n");
					//scanner.close();
					Main.login();
				}
				default: System.out.println("\nNúmero ingresado inválido.\n"); break;
				
				//scanner.close();
		    }
			scanner.close();
		}
		//scanner.close();
	}
}
