package agendaya.service;

import agendaya.model.Cliente;
import agendaya.model.Plantilla;
import agendaya.model.Profesional;

public class TestDataFactory {

    public static Cliente clienteEjemplo() {
        return new Cliente("Juan", "Pérez", "30111222", "juan.perez@mail.com");
    }

    public static Profesional profesionalEjemplo() {
        return new Profesional("Ana", "García", "25333444", "ana.garcia@agendaya.com");
    }

    public static Plantilla plantillaEjemplo(String nombre, String categoria) {
        return new Plantilla(
                nombre,
                "Asunto de ejemplo",
                "Hola {{nombre_cliente}}, tu turno está confirmado. Saludos, {{nombre_profesional}}",
                "Equipo AgendaYA",
                categoria,
                clienteEjemplo(),
                profesionalEjemplo()
        );
    }
}