package domain;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosAgendarPaseo (
        @NotNull
        Long idCliente,
        Long idPaseador,

        @NotNull
        @Future
        LocalDateTime fecha)
{

}
