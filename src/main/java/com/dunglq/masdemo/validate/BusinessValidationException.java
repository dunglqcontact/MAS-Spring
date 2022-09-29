package com.dunglq.masdemo.validate;

import com.dunglq.masdemo.exceptions.BaseException;
import lombok.Getter;

import javax.validation.ConstraintDeclarationException;

/**
 * The type Business validation exception.
 *
 * @author trinhvo
 */
@Getter
public class BusinessValidationException extends ConstraintDeclarationException {
    private static final long serialVersionUID = -1724495539499702530L;
    private final BaseException exception;

    /**
     * Instantiates a new Business validation exception.
     *
     * @param exception the exception
     */
    public BusinessValidationException(BaseException exception) {
        super();
        this.exception = exception;
    }

    /**
     * Instantiates a new Business validation exception.
     *
     * @param exception the exception
     * @param message   the message
     * @param args      the args
     */
    public BusinessValidationException(BaseException exception, String message, Object... args) {
        super(String.format(message, args));
        this.exception = exception;
    }
}
