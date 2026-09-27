/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import enums.TipoMovilidad;
import java.time.LocalDate;
import java.time.LocalTime;

/** Describe una solicitud de traslado y sus condiciones de viaje. */
public class NeMovilidad {
    private String solicitante;
    private String carrera;
    private String motivo;
    private String lugarSalida;
    private String lugarDestino;
    private int pasajeros;
    private LocalDate fechaSalida;
    private LocalDate fechaRegreso;
    private LocalTime horaSalida;
    private LocalTime horaRegreso;
    private TipoMovilidad tipo;
    private String observaciones;

    /** Crea una necesidad sin datos iniciales. */
    public NeMovilidad() {
    }

    /**
     * Crea una necesidad de movilidad completa.
     * @param solicitante persona que solicita el traslado
     * @param carrera carrera o unidad solicitante
     * @param motivo motivo del traslado
     * @param lugarSalida lugar de origen
     * @param lugarDestino lugar de destino
     * @param pasajeros cantidad de pasajeros
     * @param fechaSalida fecha de salida
     * @param fechaRegreso fecha de regreso
     * @param horaSalida hora de salida
     * @param horaRegreso hora de regreso
     * @param tipo tipo de movilidad
     * @param observaciones información adicional
     */
    public NeMovilidad(String solicitante, String carrera, String motivo, String lugarSalida, String lugarDestino,
            int pasajeros, LocalDate fechaSalida, LocalDate fechaRegreso, LocalTime horaSalida, LocalTime horaRegreso,
            TipoMovilidad tipo, String observaciones) {
        this.solicitante = solicitante;
        this.carrera = carrera;
        this.motivo = motivo;
        this.lugarSalida = lugarSalida;
        this.lugarDestino = lugarDestino;
        this.pasajeros = pasajeros;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.horaSalida = horaSalida;
        this.horaRegreso = horaRegreso;
        this.tipo = tipo;
        this.observaciones = observaciones;
    }

    /** @return solicitante del traslado */
    public String getSolicitante() {
        return solicitante;
    }

    /** @param solicitante nuevo solicitante */
    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    /** @return carrera o unidad solicitante */
    public String getCarrera() {
        return carrera;
    }

    /** @param carrera nueva carrera o unidad */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /** @return motivo del traslado */
    public String getMotivo() {
        return motivo;
    }

    /** @param motivo nuevo motivo */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /** @return lugar de origen */
    public String getLugarSalida() {
        return lugarSalida;
    }

    /** @param lugarSalida nuevo lugar de origen */
    public void setLugarSalida(String lugarSalida) {
        this.lugarSalida = lugarSalida;
    }

    /** @return lugar de destino */
    public String getLugarDestino() {
        return lugarDestino;
    }

    /** @param lugarDestino nuevo destino */
    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    /** @return cantidad de pasajeros */
    public int getPasajeros() {
        return pasajeros;
    }

    /** @param pasajeros nueva cantidad de pasajeros */
    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    /** @return fecha de salida */
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    /** @param fechaSalida nueva fecha de salida */
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /** @return fecha de regreso */
    public LocalDate getFechaRegreso() {
        return fechaRegreso;
    }

    /** @param fechaRegreso nueva fecha de regreso */
    public void setFechaRegreso(LocalDate fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    /** @return hora de salida */
    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    /** @param horaSalida nueva hora de salida */
    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    /** @return hora de regreso */
    public LocalTime getHoraRegreso() {
        return horaRegreso;
    }

    /** @param horaRegreso nueva hora de regreso */
    public void setHoraRegreso(LocalTime horaRegreso) {
        this.horaRegreso = horaRegreso;
    }

    /** @return tipo de movilidad */
    public TipoMovilidad getTipo() {
        return tipo;
    }

    /** @param tipo nuevo tipo de movilidad */
    public void setTipo(TipoMovilidad tipo) {
        this.tipo = tipo;
    }

    /** @return observaciones de la solicitud */
    public String getObservaciones() {
        return observaciones;
    }

    /** @param observaciones nuevas observaciones */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /** @return representación textual de la necesidad */
    @Override
    public String toString() {
        return "Necesidad de Movilidad:\nSolicitante: " + solicitante + "\nCarrera: " + carrera + "\nMotivo: " + motivo
                + "\nLugar de Salida: " + lugarSalida + "\nLugar de Destino: " + lugarDestino + "\nPasajeros: " + pasajeros
                + "\nFecha de Salida: " + fechaSalida + "\nFecha de Regreso: " + fechaRegreso + "\nHora de Salida: " + horaSalida
                + "\nHora de Regreso: " + horaRegreso + "\nTipo de viaje: " + tipo + "\nObservaciones: " + observaciones+ "\n";
    }

    
}
