package org.mmora.appfatura;

import org.mmora.appfatura.modelo.*;

import java.util.Scanner;

public class FacturaEjemplo {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Andres");


        Scanner s = new Scanner (System.in);
        System.out.print("Ingrese una descripcion de la factura: ");
        Factura factura = new Factura(s.nextLine(), cliente);

        Producto producto;

        int cantidad;

        System.out.println();

        for (int i = 0; i<5 ; i++){
            producto = new Producto();
            System.out.print("Ingrese producto n° " + producto.getCodigo() + ": ");
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura( new ItemFactura(s.nextInt(),producto));

            System.out.println();
            s.nextLine();
        }

        System.out.println(factura);
    }
}
