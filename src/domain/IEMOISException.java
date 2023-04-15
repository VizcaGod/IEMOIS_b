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
    public static final String WEEKS_EMPTY = "Hay una semana vacia";
    public static final String WEEKS_ERROR = "Hay errores en las semanas";
    public static final String NANO_EMPTY = "Nano esta vacio";
    public static final String IMPOSSIBLE = "Imposible de calcular";
    public static final String NAME_ERROR = "Ese curso ya existe";


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
