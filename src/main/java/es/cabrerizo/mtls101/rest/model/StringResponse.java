package es.cabrerizo.mtls101.rest.model;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public record StringResponse(
        String message,
        String timestamp
) {
    public StringResponse(String message) {
        this(message, ZonedDateTime
                .now(ZoneOffset.UTC)
                .format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
        );
    }
}
