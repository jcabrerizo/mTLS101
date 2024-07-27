package es.cabrerizo.mtls101.rest.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Schema(name = "StringResponse", description = "Response body for returning string plus metadata")
public record StringResponse(
        @Schema(name = "message", example = "this is the message", description = "String message response")
        String message,
        @Schema(name = "timestamp", example = "2024-07-27T08:21:39.52158996Z", description = "Timestamp of the response creation in UTC time")
        String timestamp
) {
    public StringResponse(String message) {
        this(message, ZonedDateTime
                .now(ZoneOffset.UTC)
                .format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
        );
    }
}
