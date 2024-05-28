package br.com.fiap.reciclagem.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MaterialNaoEncontradoException extends RuntimeException {

    public MaterialNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}

