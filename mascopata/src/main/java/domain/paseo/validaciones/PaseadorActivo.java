package domain.paseo.validaciones;

import domain.DatosAgendarPaseo;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaseadorActivo implements ValidadorDePaseos {

    @Autowired
    private PaseadorRepository paseadorRepository;

    public void validar(DatosAgendarPaseo datos) {
        if(datos.idPaseador()==null){
        return;
        }

        var paseadorActivo = paseadorRepository.findActivoById(datos.idPaseador());
        if(!paseadorActivo) {
            throw new ValidationException("El paseador seleccionado no se encuentra activo en el sistema");


    }
    }
}

