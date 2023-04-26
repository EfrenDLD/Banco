import java.util.Scanner;
public class Menu {
    public Scanner scanner;
    private CuentaBancaria cuenta;
    public Menu() {
        scanner = new Scanner(System.in);
        this.cuenta = new CuentaBancariaImpl(0);
    }
    public void OperacionesBancarias() {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\nMENU BANCO");
            System.out.println("1.- Consultar saldo");
            System.out.println("2.- Depositar dinero");
            System.out.println("3.- Retirar dinero");
            System.out.println("4.- Transferir dinero");
            System.out.println("5.- Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            System.out.println(" ");

            switch (opcion){
                case 1:
                    System.out.println("Tu saldo actual es: " + cuenta.consultarSaldo());
                    break;
                    
                case 2:
                    System.out.println("Ingresa la cantidad a depositar:");
                    double deposito = scanner.nextDouble();
                    cuenta.depositar(deposito);
                    System.out.println("Depósito exitoso. Tu saldo actual es: " + cuenta.consultarSaldo());
                    break;

                case 3:
                    System.out.println("Ingresa la cantidad a retirar:");
                    double retiro = scanner.nextDouble();
                    if (cuenta.retirar(retiro)) {
                        System.out.println("Retiro exitoso. Tu saldo actual es: " + cuenta.consultarSaldo());
                    } else {
                        System.out.println("No tienes suficiente saldo para realizar esta operación.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese la cantidad a transferir:");
                    double cantidadTransferencia = scanner.nextDouble();
                    CuentaBancaria cuentaDestino = new CuentaBancariaImpl(0);
                    boolean exitoTransferencia = cuenta.transferir(cantidadTransferencia, cuentaDestino);
                    if (exitoTransferencia) {
                        System.out.println("Transferencia exitosa!. Saldo actual: " + cuenta.consultarSaldo());
                    } else {
                        System.out.println("No se pudo realizar la transferencia. Saldo actual: " + cuenta.consultarSaldo());
                    }
                    break;
                case 5:
                    System.out.println("Usted a salido de la operacion.");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}