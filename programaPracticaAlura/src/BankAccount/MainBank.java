package BankAccount;

import java.util.Scanner;

public class MainBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean sesion = true;

        System.out.println("Introduzca el usuario");
        String username = sc.nextLine();

        DatosCuentaCliente datosCliente = new DatosCuentaCliente("");

        while (sesion){
            if (username.equals(datosCliente.getUsername())){
                System.out.println("Tipo de cuenta: \n" + "1. Corriente\n2. Ahorros\n3. Salir");
                String tipoDeCuenta = sc.nextLine();
                datosCliente.setTipoCuenta(tipoDeCuenta);

                if (tipoDeCuenta.equals("Corriente") || tipoDeCuenta.equals("1")){
                    //Opcion con If
                    System.out.println("No. Cuenta: " + datosCliente.getCuentaCorriente());
                    while (sesion){
                        System.out.println("**Selecciona una opcion: \n" + "1. Consultar Saldo" +
                                "\n2. Retirar\n3. Depositar\n4. Salir");
                        String opcion = sc.nextLine();
                        if (opcion.equals("1")){
                            System.out.printf("Saldo Actual: %,.2f%n", datosCliente.getSaldo());
                        } else if (opcion.equals("2")) {
                            System.out.println("Cuanto deseas retirar?");
                            double retiro = sc.nextDouble();
                            sc.nextLine();
                            double saldoActual = datosCliente.getSaldo();

                            double nuevoSaldo = saldoActual - retiro;

                            datosCliente.setSaldo(nuevoSaldo);
                            System.out.printf("Tu nuevo saldo es: %,.2f%n", nuevoSaldo);
                        } else if (opcion.equals("3")) {
                            System.out.println("Cuanto deseas depositar?");
                            double deposito = sc.nextDouble();
                            sc.nextLine();
                            double saldoActual = datosCliente.getSaldo();

                            double nuevoSaldo = saldoActual + deposito;

                            datosCliente.setSaldo(nuevoSaldo);
                            System.out.printf("Tu nuevo saldo es: %,.2f%n", nuevoSaldo);
                        } else if (opcion.equals("4")) {
                            System.out.println("Gracias por usar nuestros Servicios");
                            break;
                        } else {
                            System.out.println("Introduzca una opcion valida");
                        }
                    }
                } else if (tipoDeCuenta.equals("Ahorros") || tipoDeCuenta.equals("2")) {
                    //Opcion con Switch
                    System.out.println("No. Cuenta: " + datosCliente.getCuentaAhorros());
                    while (sesion){
                        System.out.println("**Selecciona una opcion: \n" + "1. Consultar Saldo" +
                                "\n2. Retirar\n3. Depositar\n4. Salir");
                        String opcion = sc.nextLine();
                        double saldoActual = datosCliente.getSaldo();

                        switch (opcion){
                            case "1":
                                System.out.printf("Saldo Actual: %,.2f%n", datosCliente.getSaldo());
                                break;
                            case "2":
                                System.out.println("Cuanto deseas retirar?");
                                double retiro = sc.nextDouble();
                                sc.nextLine();

                                double nuevoSaldo = saldoActual - retiro;

                                datosCliente.setSaldo(nuevoSaldo);
                                System.out.printf("Tu nuevo saldo es: %,.2f%n", nuevoSaldo);
                                break;
                            case "3":
                                System.out.println("Cuanto deseas depositar?");
                                double deposito = sc.nextDouble();
                                sc.nextLine();

                                nuevoSaldo = saldoActual + deposito;

                                datosCliente.setSaldo(nuevoSaldo);
                                System.out.printf("Tu nuevo saldo es: %,.2f%n", nuevoSaldo);
                                break;
                            case "4":
                                System.out.println("Gracias por usar nuestros Servicios");
                                sesion = false;
                                break;
                            default:
                                System.out.println("Introduzca una opcion valida");
                        }
                    }
                } else if (tipoDeCuenta.equals("3")) {
                    System.out.println("Gracias por usar nuestros Servicios");
                    break;
                } else {
                    System.out.println("Introduzca una opcion valida");
                }

            } else {
                System.out.println("El usuario no existe");
                sesion = false;
                break;
            }
        }
    }
}
