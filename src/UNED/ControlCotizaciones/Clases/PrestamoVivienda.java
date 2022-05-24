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
public class PrestamoVivienda extends Prestamo {
    private double metrosCuadrados;

    // Métodos constructores
    public PrestamoVivienda(String identificacion, String nombre, String apellido1, String apellido2, int edad, double ingresoMensual, int idCotizacion, Date fecha, int montoPrestamo, int meses, double tasaInteres, double renta, boolean aprobado) {
        super(identificacion, nombre, apellido1, apellido2, edad, ingresoMensual, idCotizacion, fecha, montoPrestamo, meses, tasaInteres, renta, aprobado);
        this.metrosCuadrados = metrosCuadrados;
    }

    public PrestamoVivienda() {
        super();
        this.metrosCuadrados = 0.0;
    }

    // Métodos Get y Set
    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }
    
    /* La tasa de interés para los préstamos para vivienda requieren de una tasa
    de interés del 5.25%, por esta razón, fue pertinente modificar el valor de
    la tasa de interés.
    */
    @Override
    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    
    /* Método para calcular la renta de un préstamo para viivienda, para el cual
    se requiere solicitar los metros cuadrados de la propiedad al usuario.
    En este sentido, cuando la propiedad excede los 500 m^2, se realiza un cargo
    extra, que se calcula restando la medida ingresada por el cliente menos 500
    con el fin de obtener los metros extra. Este excedente es multiplicado por
    25 y sumado al resultado del cálculo de la renta.
    */
    @Override
    public void calcularRenta() {
        setRenta(montoPrestamo * tasaInteres / (1 - 1 / (1 + tasaInteres)/meses));
        
        if (metrosCuadrados > 500) {
            setRenta(getRenta() + (25 * (metrosCuadrados - 500)));
        }
    }
}