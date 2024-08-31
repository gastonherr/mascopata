package domain;

import domain.paseo.validaciones.ValidadorDePaseos;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDePaseosService {

    @Autowired
    private PaseadorRepository paseadorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    //    @Autowired
    //    private PaseoRepository paseoRepository;

    @Autowired
    List<ValidadorDePaseos> validadores;

    public DatosDetallePaseo agendar (DatosAgendarPaseo datos){

        if(!clienteRepository.findById(datos.idCliente().isPresent())){
            throw new ValidationException("no se encontró el id del cliente");
        }

        validadores.forEach(v-> v.validar(datos));

        var paseo = new Paseo(paseador, cliente, datos.fecha());

        paseorepository.save(paseo);

        return new DatosDetallePaseo(paseo);
    }







}
