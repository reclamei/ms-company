package br.com.reclamei.company.config.resources;

import br.com.reclamei.company.core.exception.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> resourceNotFound(final RuntimeException ex, final WebRequest request) {
        log.warn(ex.getMessage(), ex);
        var body = new DefaultErrorsWrapperResponse(ex.getMessage(), NOT_FOUND.value(), request.getDescription(false));
        return handleExceptionInternal(ex, body, new HttpHeaders(), NOT_FOUND, request);
    }

    @ExceptionHandler(value = {FeignException.BadRequest.class})
    public ResponseEntity<Object> resourceFeignBadRequest(FeignException ex, final WebRequest request) {
        log.warn(ex.getMessage(), ex);
        var body = new DefaultErrorsWrapperResponse(getErrorMessageFromException(ex, "detalhes"), BAD_REQUEST.value(), request.getDescription(false));
        return handleExceptionInternal(ex, body, new HttpHeaders(), BAD_REQUEST, request);
    }

    private static String getErrorMessageFromException(final FeignException ex, final String fieldMessage) {
        var objectMapper = new ObjectMapper();
        JsonNode node;
        try {
            node = objectMapper.readTree(ex.contentUTF8()).get(fieldMessage);
            return Objects.isNull(node) ? ex.contentUTF8() : node.toString().replace("\"", "");
        } catch (JsonProcessingException e) {
            log.error(ex.getMessage(), ex);
        }
        return "";
    }

}
