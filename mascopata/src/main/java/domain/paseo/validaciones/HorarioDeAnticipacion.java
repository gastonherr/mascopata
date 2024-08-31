package domain.paseo.validaciones;

import domain.DatosAgendarPaseo;
import jakarta.validation.ValidationException;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioDeAnticipacion implements ValidadorDePaseos{

    public void validar(DatosAgendarPaseo datos) {
        var ahora = LocalDateTime.now();
        var horaDePaseo = datos.fecha();

        var diferenciaDe60min = Duration.between(ahora, horaDePaseo).toMinutes()<60;
        if (diferenciaDe60min) {
            throw new ValidationException("Los paseos deben programarse con al menos 60 minutos de anticipación");
        }

    }
}
