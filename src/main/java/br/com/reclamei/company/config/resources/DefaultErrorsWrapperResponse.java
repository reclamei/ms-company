package br.com.reclamei.company.config.resources;

import java.sql.Timestamp;
import java.time.Instant;

public class DefaultErrorsWrapperResponse {

    public final String message;
    public final Timestamp timestamp = Timestamp.from(Instant.now());
    public final int status;
    public final String path;


    public DefaultErrorsWrapperResponse(String message, int status, String path) {
        this.message = message;
        this.status = status;
        this.path = path;
    }

    @Override
    public String toString() {
        return "DefaultErrorsWrapperResponse{" +
                "message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", status=" + status +
                ", path='" + path + '\'' +
                '}';
    }
}
