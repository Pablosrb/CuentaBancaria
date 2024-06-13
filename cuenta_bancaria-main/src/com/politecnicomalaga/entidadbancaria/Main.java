package com.politecnicomalaga.entidadbancaria;

import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
    public static Cuenta miCuenta = new Cuenta("0000",0,"NADA");

    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir) {

            System.out.println("A. Dar datos de la cuenta.");
            System.out.println("B. Cargar cliente de la cuenta desde fichero JSON");
            System.out.println("C. Realizar ingreso efectivo");
            System.out.println("D. Realizar retirada efectivo");
            System.out.println("E. Grabar cuenta a fichero JSON");
            System.out.println("F. Cargar cuenta desde fichero JSON");
            System.out.println("G. Exportar datos a Texto (toString) hacia pantalla y fichero");

            Scanner sc = new Scanner(System.in);
            String menu = sc.nextLine();

            if (menu.compareTo("A") == 0) {
                crearCuenta(sc);
            } else if (menu.compareTo("B") == 0) {
                cargarCliente(sc);
            } else if (menu.compareTo("C") == 0) {
                operacionIngreso(sc);
            } else if (menu.compareTo("D") == 0) {
                operacionRetirar(sc);
            } else if (menu.compareTo("E") == 0) {
                grabarCuenta(sc);
            } else if (menu.compareTo("F") == 0) {
                cargarCuenta(sc);
            } else if (menu.compareTo("G") == 0) {
                exportar(sc);
            } else {
                System.out.println("Elige una opción correcta.");
            }

        }
    }

    private static void crearCuenta (Scanner sc){
        String ccc,fechaApertura;

        System.out.println("Inserte el CCC de la cuenta");
        ccc = sc.nextLine();
        System.out.println("El saldo incial de la cuenta va a ser 0");
        System.out.println("Inserte la fecha de apertura de la cuenta");
        fechaApertura = sc.nextLine();

        miCuenta.setCcc(ccc);
        miCuenta.setFechaApertura(fechaApertura);

    }

    private static void operacionIngreso(Scanner sc){
        String fecha;
        float cantidad;

        System.out.println("Fecha del dia de la operación");
        fecha = sc.nextLine();
        System.out.println("Cantidad de la operación");
        cantidad = sc.nextFloat();

        miCuenta.ingresarEfectivo(cantidad, fecha);


    }

    private static void operacionRetirar(Scanner sc){
        String fecha;
        float cantidad;

        System.out.println("Fecha del dia de la operación");
        fecha = sc.nextLine();
        System.out.println("Cantidad de la operación");
        cantidad = sc.nextFloat();

        miCuenta.retirarEfectivo(cantidad, fecha);
    }

    public static void cargarCliente(Scanner sc) {
        System.out.println("Introduzca el fichero para cargar el cliente");
        String filename = sc.nextLine();
        if (!filename.isBlank()){
            String json = ControladorFicheros.readText(filename);
            Gson gson = new Gson();
            miCuenta.micliente = gson.fromJson(json, Cliente.class);


        }
    }

    private static void grabarCuenta (Scanner sc){
        System.out.println("Introduce el nombre del archivo para guardar la cuenta");
        String filename = sc.nextLine();

        Gson gson = new Gson();
        String datos = gson.toJson(miCuenta);
        ControladorFicheros.writeText(filename, datos,true);

    }

    public static void cargarCuenta(Scanner sc) {
        System.out.println("Introduzca el fichero para cargar la cuenta");
        String filename = sc.nextLine();
        if (!filename.isBlank()){
            String json = ControladorFicheros.readText(filename);
            Gson gson = new Gson();
            miCuenta = gson.fromJson(json, Cuenta.class);


        }
    }



    private static void exportar(Scanner sc) {
        System.out.println("Menú:");
        System.out.println("A. Mostrar unicamente los datos por pantalla");
        System.out.println("B. Mostrar los datos y hacer una copia de seguridad de ellos");
        String menu = sc.nextLine();

        String dat = miCuenta.verDatos();

        if (menu.toUpperCase().compareTo("A") == 0) {
            System.out.println(dat);

        } else if (menu.toUpperCase().compareTo("B") == 0) {
            System.out.println(dat);

            System.out.println("Ruta para hacer una copia de seguridad: ");
            String filename = sc.nextLine();
            ControladorFicheros.writeText(filename,dat,true);
        }




    }

}
