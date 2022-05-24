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
public class PrestamoPymes extends Prestamo {
    private int cantidadEmpleados;
    
    // Métodos constructores
    public PrestamoPymes(String identificacion, String nombre, String apellido1, String apellido2, int edad, double ingresoMensual, int idCotizacion, Date fecha, int montoPrestamo, int meses, double tasaInteres, double renta, boolean aprobado) {
        super(identificacion, nombre, apellido1, apellido2, edad, ingresoMensual, idCotizacion, fecha, montoPrestamo, meses, tasaInteres, renta, aprobado);
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public PrestamoPymes() {
        super();
        this.cantidadEmpleados = 0;
    }
    
    // Métodos Get y Set
    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(int cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }
    
    /* La tasa de interés para los préstamos para pymes corresponde a un 8%, por
    lo que es necesario cambiar el valor de la tasa de interés.
    */
    @Override
    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    
    /* Método para calcular la renta para un préstamo para pymes, el cual emplea
    la fórmula antes descrita y realiza un descuento al total del préstamo según
    la cantidad de empleados. Por lo tanto, de 1 a 5 empleados, se realiza un
    descuento del 2%, de 6 a 10 empleados un 3% y, finalmente, de 11 a más
    empleados, se realiza un descuento del 10%.
    */
    @Override
    public void calcularRenta() {
        setRenta(montoPrestamo * tasaInteres / (1 - 1 / (1 + tasaInteres)/meses));
        
        if (cantidadEmpleados >= 1 && cantidadEmpleados <= 5) {
            setRenta(getRenta() - (getRenta() * 0.02));
        } else if (cantidadEmpleados >= 6 && cantidadEmpleados <= 10) {
            setRenta(getRenta() - (getRenta() * 0.03));
        } else if (cantidadEmpleados >= 11) {
            setRenta(getRenta() - (getRenta() * 0.1));
        }
    }
}
