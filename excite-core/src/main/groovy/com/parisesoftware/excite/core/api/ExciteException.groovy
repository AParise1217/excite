package com.parisesoftware.excite.core.api

/**
 * Excite Exception
 * <p>
 * Generic Exception for when Excite encounters an issue
 *
 * @version 1.0.1
 * @since 1.0.1
 */
class ExciteException extends RuntimeException {

    ExciteException(final String message, Throwable cause) {
        super(message, cause)
    }

    ExciteException(Throwable cause) {
        super(cause)
    }

    ExciteException(final String message) {
        super(message)
    }

    ExciteException() {
        super()
    }

}
