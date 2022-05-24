/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UNED.ControlCotizaciones.Clases;

import java.util.Date;

/**
 *
 * @author Fabián de Jesús Maroto Fernández
 */
public class PrestamoPersonal extends Prestamo {
    private int tipoCliente;
    private int productosCliente;
    
    // Métodos contructores
    public PrestamoPersonal(String identificacion, String nombre, String apellido1, String apellido2, int edad, double ingresoMensual, int idCotizacion, Date fecha, int montoPrestamo, int meses, double tasaInteres, double renta, boolean aprobado) {
        super(identificacion, nombre, apellido1, apellido2, edad, ingresoMensual, idCotizacion, fecha, montoPrestamo, meses, tasaInteres, renta, aprobado);
        this.tipoCliente = tipoCliente;
        this.productosCliente = productosCliente;
    }

    public PrestamoPersonal() {
        super();
        this.tipoCliente = 0;
        this.productosCliente = 0;
    }
    
    // Métodos Get y Set
    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getProductosCliente() {
        return productosCliente;
    }

    public void setProductosCliente(int productosCliente) {
        this.productosCliente = productosCliente;
    }
    
    /* Método para calcular la renta para un préstamo personal. En este caso,
    se emplea la misma fórmula de la clase padre, sin embargo, se evalúan dos
    tipos de cliente, activo (0) y nuevo (1). Si el usuario es de tipo activo,
    y disfruta de 1 a 5 productos de la entidad, se realiza un descuento de
    un 1%, en el caso de que posea 6 o más productos, el descuento será de 3%.
    El descuento se resta al total de la renta calculada.
    */
    @Override
    public void calcularRenta() {
        setRenta(montoPrestamo * tasaInteres / (1 - 1 / (1 + tasaInteres)/meses));
        
        if (tipoCliente == 0) {
            if (productosCliente >= 1 && productosCliente <= 5) {
                setRenta(getRenta() - (getRenta() * 0.01));
            } else if (productosCliente >= 6) {
                setRenta(getRenta() - (getRenta() * 0.03));
            }
        }
    }
}
