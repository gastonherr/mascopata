package domain.paseo.validaciones;

import domain.DatosAgendarPaseo;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioDePaseo implements ValidadorDePaseos{

    public void validar(DatosAgendarPaseo datos) {
        var domingo = DayOfWeek.SUNDAY.equals(datos.fecha().getDayOfWeek());

        var antesDeComienzo = datos.fecha().getHour()<8;
        var luegoDeFin = datos.fecha().getHour()>20;

        if ((domingo || antesDeComienzo || luegoDeFin)){
            throw new ValidationException("Los paseos son de lunes a sabados de 8 a 20 hs");
        }

    }
}
