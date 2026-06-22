/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendaya.service.BookingPublico;
import agendaya.model.TipoEvento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Carlita
 */
public class ResultadoSeleccionTipoEvento {
    
private final boolean exitoso;
    private final String mensaje;
    private final TipoEvento tipoEventoSeleccionado;
    private final Map<LocalDate, List<LocalTime>> fechasHorariosDisponibles;

    public ResultadoSeleccionTipoEvento(
            boolean exitoso,
            String mensaje,
            TipoEvento tipoEventoSeleccionado,
            Map<LocalDate, List<LocalTime>> fechasHorariosDisponibles
    ) {
        this.exitoso = exitoso;
        this.mensaje = mensaje;
        this.tipoEventoSeleccionado = tipoEventoSeleccionado;
        this.fechasHorariosDisponibles = fechasHorariosDisponibles;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public TipoEvento getTipoEventoSeleccionado() {
        return tipoEventoSeleccionado;
    }

    public Map<LocalDate, List<LocalTime>> getFechasHorariosDisponibles() {
        return fechasHorariosDisponibles;
    }
}
