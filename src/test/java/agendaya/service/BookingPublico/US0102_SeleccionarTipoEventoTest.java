/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendaya.service.BookingPublico;
import agendaya.model.TipoEvento;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Carlita
 */
public class US0102_SeleccionarTipoEventoTest {
 @Test
    void debeSeleccionarTipoEventoValidoYMostrarFechasYHorariosDisponibles() {
        TipoEvento consultaInicial = new TipoEvento("EVT-001", "Consulta inicial 30 min", 30, true, true);

        LocalDate fechaDisponible = LocalDate.of(2030, 6, 25);
        List<LocalTime> horariosDisponibles = List.of(
                LocalTime.of(10, 0),
                LocalTime.of(11, 0)
        );

        BookingPublicoService service = new BookingPublicoService(
                List.of(consultaInicial),
                Map.of(
                        "EVT-001",
                        Map.of(fechaDisponible, horariosDisponibles)
                )
        );

        ResultadoSeleccionTipoEvento resultado = service.seleccionarTipoEvento("EVT-001");

        assertTrue(resultado.isExitoso());
        assertEquals("Consulta inicial 30 min", resultado.getTipoEventoSeleccionado().getNombre());
        assertTrue(resultado.getFechasHorariosDisponibles().containsKey(fechaDisponible));
        assertEquals(horariosDisponibles, resultado.getFechasHorariosDisponibles().get(fechaDisponible));
    }

    @Test
    void debeMostrarMensajeSiElTipoDeEventoYaNoEstaDisponible() {
        TipoEvento eventoNoDisponible = new TipoEvento("EVT-001", "Consulta inicial 30 min", 30, true, false);

        BookingPublicoService service = new BookingPublicoService(
                List.of(eventoNoDisponible),
                Map.of()
        );

        ResultadoSeleccionTipoEvento resultado = service.seleccionarTipoEvento("EVT-001");

        assertFalse(resultado.isExitoso());
        assertEquals("Este tipo de evento ya no está disponible", resultado.getMensaje());
        assertNull(resultado.getTipoEventoSeleccionado());
        assertTrue(resultado.getFechasHorariosDisponibles().isEmpty());
    }   
}
