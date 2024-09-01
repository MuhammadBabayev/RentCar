package org.example.rentcar.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {

    NOT_FOUND("Not found with id: %s"),
    INVALID_REQUEST("Invalid request data"),
    UNAUTHORIZED("Unauthorized access"),
    METHOD_NOT_ALLOWED("Method not allowed"),
    COMMENT_NOT_FOUND("Comment not found"),;

    private final String message;
}
