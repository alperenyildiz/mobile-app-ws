package com.aula.app.ws.ui.model.response;

import java.time.OffsetDateTime;

public class ErrorMessage {

    private OffsetDateTime date;
    private String errorMessage;

    public ErrorMessage(OffsetDateTime date, String errorMessage) {
        this.date = date;
        this.errorMessage = errorMessage;
    }

    public ErrorMessage() {
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
