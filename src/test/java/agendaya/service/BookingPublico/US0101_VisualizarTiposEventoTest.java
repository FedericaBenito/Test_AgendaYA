/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendaya.service.BookingPublico;
import agendaya.model.TipoEvento;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Carlita
 */
public class US0101_VisualizarTiposEventoTest {
  @Test
    void debeVisualizarSoloTiposDeEventoPublicosYDisponibles() {
        TipoEvento consultaInicial = new TipoEvento("EVT-001", "Consulta inicial 30 min", 30, true, true);
        TipoEvento seguimiento = new TipoEvento("EVT-002", "Reunión de seguimiento 1h", 60, true, true);
        TipoEvento privado = new TipoEvento("EVT-003", "Evento interno", 45, false, true);
        TipoEvento noDisponible = new TipoEvento("EVT-004", "Evento pausado", 30, true, false);

        BookingPublicoService service = new BookingPublicoService(
                List.of(consultaInicial, seguimiento, privado, noDisponible),
                Map.of()
        );

        List<TipoEvento> resultado = service.visualizarTiposEventoDisponibles();

        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(consultaInicial));
        assertTrue(resultado.contains(seguimiento));
        assertFalse(resultado.contains(privado));
        assertFalse(resultado.contains(noDisponible));
    }

    @Test
    void debeMostrarMensajeCuandoNoExistenTiposDeEventoDisponibles() {
        TipoEvento eventoPrivado = new TipoEvento("EVT-001", "Evento privado", 30, false, true);
        TipoEvento eventoNoDisponible = new TipoEvento("EVT-002", "Evento pausado", 45, true, false);

        BookingPublicoService service = new BookingPublicoService(
                List.of(eventoPrivado, eventoNoDisponible),
                Map.of()
        );

        List<TipoEvento> resultado = service.visualizarTiposEventoDisponibles();
        String mensaje = service.obtenerMensajeSinEventosDisponibles();

        assertTrue(resultado.isEmpty());
        assertEquals("No hay eventos disponibles para reservar", mensaje);
    }  
}
