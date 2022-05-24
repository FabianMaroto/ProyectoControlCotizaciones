/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UNED.ControlCotizaciones.Clases;

import java.util.Date;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fabián de Jesús Maroto Fernández
 * 
 * Universidad Estatal a Distancia de Costa Rica
 * Programación Intermedia
 * Profesora Adriana Rubio Escobar
 * Proyecto
 * III Cuatrimestre 2021
 */
public class Prestamo {
    protected String identificacion;
    protected String nombre;
    protected String apellido1; // Atributo añadido para manejar el primer apellido del usuario.
    protected String apellido2; // Atributo añadido para manejar el segundo apellido del usuario.
    protected int edad;
    protected double ingresoMensual;
    protected int idCotizacion;
    protected Date fecha;
    protected double montoPrestamo;
    protected int meses;
    protected double tasaInteres;
    protected double renta;
    protected boolean aprobado; // Atributo añadido para la aprobación de los préstamos.

    // Métodos constructores
    public Prestamo(String identificacion, String nombre, String apellido1, String apellido2, int edad, double ingresoMensual, int idCotizacion, Date fecha, int montoPrestamo, int meses, double tasaInteres, double renta, boolean aprobado) 
    {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido1 = apellido2;
        this.edad = edad;
        this.ingresoMensual = ingresoMensual;
        this.idCotizacion = idCotizacion;
        this.fecha = fecha;
        this.montoPrestamo = montoPrestamo;
        this.meses = meses;
        this.tasaInteres = tasaInteres;
        this.renta = renta;
        this.aprobado = aprobado;
    }

    public Prestamo() 
    {
        this.identificacion = "";
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.edad = 0;
        this.ingresoMensual = 0.0;
        /* Objeto numeroAleatorio para el número de identificación de la 
        cotización del cliente.
        Páginas 126 y 127 del libro Programación Intermedia en Java.
        */
        Random numeroAleatorio = new Random();
        this.idCotizacion = numeroAleatorio.nextInt(1000);
        /* Para la obtención de la fecha se emplearon los procedimientos
        expuestos en la siguiente página:
        https://lineadecodigo.com/java/obtener-fecha-actual-con-java/
        */ 
        Date fechaActual = new Date();
        this.fecha = fechaActual;
        this.montoPrestamo = 0;
        this.meses = 0;
        this.tasaInteres = 0.31;
        this.renta = 0;
        this.aprobado = false;
    }

    // Métodos Get y Set
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getIngresoMensual() {
        return ingresoMensual;
    }

    public void setIngresoMensual(double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
       this.tasaInteres = tasaInteres;
    }

    public double getRenta() {
        return renta;
    }
    
    public void setRenta(double renta) {
        this.renta = renta;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }
    
    /*Método para el cálculo de la renta por medio de la fórmula brindada. El
    cálculo está determinado por la fórmula R = A*i/(1-1/(1+i)/n), donde R
    representa el resultado de la operación, A el monto del crédito, i la tasa
    de interés de acuerdo al tipo de préstamo y n la cantidad de meses en los
    que se desea cancelar el préstamo.
    */
    public void calcularRenta() {
        setRenta(montoPrestamo * tasaInteres / (1 - 1 / (1 + tasaInteres)/meses));
    }
    
    /* Método que permite evaluar si el ingreso mensual del usuario sobrepasa
    el 40% de la cuota del préstamo que solicitó. Retorna true si el ingreso
    del cliente es mayor al resultado de la multiplicación entre getRenta() y
    0.40.
    */
    public void aprobarPrestamo() {
        double resultado = getRenta() * 0.40;
        if (getIngresoMensual() > resultado) {
            setAprobado(true);
        }
    }
}