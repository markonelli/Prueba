import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public DetalleResponse errorException(Throwable e) {
        log.debug("Entrando al método errorException");

        DetalleResponse detalleResponse = new DetalleResponse(DetalleResponse.RESPUESTA_ERROR);
        detalleResponse.setDetalle(e.toString());

        if (e instanceof CustomRuntimeException)
            detalleResponse.setMensaje(e.getMessage());

        log.error("ocurrió un error al ejecutar la consulta", e);
        log.debug("Saliendo del método errorException");

        return detalleResponse;
    }

}
