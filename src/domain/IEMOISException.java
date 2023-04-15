package domain;


/**
 * exception class for IEMOIS.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version 1.0v
 */
public class IEMOISException extends Exception
{
    // instance variables - replace the example below with your own
    static final String WEEKS_EMPTY = "Hay una semana vacia";
    static final String WEEKS_ERROR = "Hay errores en las semanas";
    static final String NANO_EMPTY = "Nano esta vacio";
    static final String IMPOSSIBLE = "Imposible de calcular";
    /**
     * Constructor for objects of class EIMOISException
     * @Param message
     */
    public IEMOISException(String message)
    {
        // initialise instance variables
        super(message);
    }
}
