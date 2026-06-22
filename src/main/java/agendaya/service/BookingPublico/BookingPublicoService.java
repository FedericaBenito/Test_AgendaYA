/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendaya.service.BookingPublico;
import agendaya.model.TipoEvento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 *
 * @author Carlita
 */
public class BookingPublicoService {
    
private static final String MENSAJE_SIN_EVENTOS = "No hay eventos disponibles para reservar";
    private static final String MENSAJE_EVENTO_NO_DISPONIBLE = "Este tipo de evento ya no está disponible";

    private final List<TipoEvento> tiposEvento;
    private final Map<String, Map<LocalDate, List<LocalTime>>> disponibilidadPorTipoEvento;

    public BookingPublicoService(
            List<TipoEvento> tiposEvento,
            Map<String, Map<LocalDate, List<LocalTime>>> disponibilidadPorTipoEvento
    ) {
        this.tiposEvento = tiposEvento == null ? new ArrayList<>() : new ArrayList<>(tiposEvento);
        this.disponibilidadPorTipoEvento = disponibilidadPorTipoEvento == null
                ? Map.of()
                : disponibilidadPorTipoEvento;
    }

    public List<TipoEvento> visualizarTiposEventoDisponibles() {
        return tiposEvento.stream()
                .filter(TipoEvento::isPublico)
                .filter(TipoEvento::isDisponible)
                .collect(Collectors.toList());
    }

    public String obtenerMensajeSinEventosDisponibles() {
        if (visualizarTiposEventoDisponibles().isEmpty()) {
            return MENSAJE_SIN_EVENTOS;
        }
        return "";
    }

    public ResultadoSeleccionTipoEvento seleccionarTipoEvento(String idTipoEvento) {
        TipoEvento tipoEvento = buscarTipoEventoPorId(idTipoEvento);

        if (tipoEvento == null || !tipoEvento.isPublico() || !tipoEvento.isDisponible()) {
            return new ResultadoSeleccionTipoEvento(
                    false,
                    MENSAJE_EVENTO_NO_DISPONIBLE,
                    null,
                    Map.of()
            );
        }

        Map<LocalDate, List<LocalTime>> disponibilidad =
                disponibilidadPorTipoEvento.getOrDefault(idTipoEvento, Map.of());

        return new ResultadoSeleccionTipoEvento(
                true,
                "Tipo de evento seleccionado correctamente",
                tipoEvento,
                disponibilidad
        );
    }

    private TipoEvento buscarTipoEventoPorId(String idTipoEvento) {
        return tiposEvento.stream()
                .filter(tipo -> tipo.getId().equals(idTipoEvento))
                .findFirst()
                .orElse(null);
    }
}
