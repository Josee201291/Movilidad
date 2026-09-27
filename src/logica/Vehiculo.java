/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/** Representa un vehículo disponible para prestar servicios de movilidad. */
public class Vehiculo {
    private String marca;
    private String modelo;
    private String patente;
    private String tipo;  
    private String estado;
    private int capacidad;

    /** Crea un vehículo sin datos iniciales. */
    public Vehiculo() {
    }


    /**
     * Crea un vehículo con sus características operativas.
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param patente matrícula o patente
     * @param tipo tipo de vehículo
     * @param estado estado operativo
     * @param capacidad cantidad máxima de pasajeros
     */
    public Vehiculo(String marca, String modelo, String patente, String tipo, String estado, int capacidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.tipo = tipo;
        this.estado = estado;
        this.capacidad = capacidad;
    }


    /** @return marca del vehículo */
    public String getMarca() {
        return marca;
    }

    /** @param marca nueva marca */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /** @return modelo del vehículo */
    public String getModelo() {
        return modelo;
    }

    /** @param modelo nuevo modelo */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    /** @return tipo de vehículo */
    public String getTipo() {
        return tipo;
    }

    /** @param tipo nuevo tipo */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /** @return estado operativo */
    public String getEstado() {
        return estado;
    }

    /** @param estado nuevo estado operativo */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /** @return capacidad máxima de pasajeros */
    public int getCapacidad() {
        return capacidad;
    }

    /** @param capacidad nueva capacidad máxima */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /** @return representación textual del vehículo */
    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", patente=" + patente + ", tipo=" + tipo + ", estado=" + estado + ", capacidad=" + capacidad + '}';
    }

    /** @return matrícula o patente */
    public String getPatente() {
        return patente;
    }

    /** @param patente nueva patente */
    public void setPatente(String patente) {
        this.patente = patente;
    }

    

    
    
    
}
