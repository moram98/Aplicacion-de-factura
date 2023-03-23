package org.mmora.appfatura.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Factura {

    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;
    private static int ultimoFolio;

    private static final int MAX_ITEMS = 12;
    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getClase() {
        return cliente;
    }

    public void setClase(Cliente clase) {
        this.cliente = clase;
    }

    public ItemFactura[] getIntems() {
        return items;
    }

    public void addItemFactura(ItemFactura item){
        if (indiceItems < MAX_ITEMS){
            this.items[indiceItems++] = item;
        }

    }

    public float calcularTotal(){
        float total = 0.0f;
        for( int i = 0;  i < indiceItems; i++){
            total += this.items[i].calcularImporte();
        }
        return total;
    }
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura N° : ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n");


        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, YYYY");
        sb.append("fecha emision: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre \t$ \tCant. \tTotal \n ");

        for(int i = 0; i < indiceItems; i++){
            sb.append(this.items[i].toString())
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return  sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
