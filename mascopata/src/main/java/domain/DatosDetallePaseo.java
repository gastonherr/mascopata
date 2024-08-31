package domain;

import java.time.LocalDateTime;

public record DatosDetallePaseo(Long id, Long idCliente, Long idPaseador, LocalDateTime fecha) {

    public DatosDetallePaseo(Paseo paseo) {
        this(paseo.getId(), paseo.getPaseador().getId(), paseo.getCliente().getId(), paseo.getFecha());
    }
}
