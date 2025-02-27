package org.samuelraymundo.helpdesk.services.exceptions;

import org.samuelraymundo.helpdesk.resources.StandardError;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(List<FieldMessage> errors) {
        super();
    }

    public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fielName, String message) {
        this.errors.add(new FieldMessage(fielName, message));
    }
}
