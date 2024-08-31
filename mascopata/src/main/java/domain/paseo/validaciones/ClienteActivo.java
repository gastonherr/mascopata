package domain.paseo.validaciones;

import domain.DatosAgendarPaseo;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteActivo implements ValidadorDePaseos{

    @Autowired
    private ClienteRepository clienteRepository;

    public void validar(DatosAgendarPaseo datos) {
        if(datos.idCliente()==null){
            return;
        }

        var clienteActivo = clienteRepository.findActivobyId(datos.idCliente());

        if(!clienteActivo){
            throw new ValidationException("No se permite agendar paseos con clientes inactivos")
        }

    }
}
