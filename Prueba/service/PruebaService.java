import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PruebaRepository {

    @Autowired
    private PruebaRepository pruebaRepository;

    public List<PruebaRepository> listar() {
        return this.pruebaRepository.listar();
    }

    public PruebaRepository obtener(Integer codigo) {
        return this.pruebaRepository.buscarPorCodigo(codigo);
    }

    public PruebaRepository insertar(Prueba prueba) {
        return this.pruebaRepository.ejecutarSpInsert(prueba);
    }

    public PruebaRepository actualizar(Prueba prueba) {
        return this.PruebaRepository.ejecutarSpUpdate(prueba);
    }

}