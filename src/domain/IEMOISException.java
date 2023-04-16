package domain;


/**
 * exception class for IEMOIS.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version 1.0v
 */
public class IEMOISException extends Exception
{
    /**
     * The constant WEEKS_EMPTY.
     */
// instance variables - replace the example below with your own
    public static final String WEEKS_EMPTY = "Hay una semana vacia";
    /**
     * The constant WEEKS_ERROR.
     */
    public static final String WEEKS_ERROR = "Hay errores en las semanas";
    /**
     * The constant NANO_EMPTY.
     */
    public static final String NANO_EMPTY = "Nano esta vacio";
    /**
     * The constant IMPOSSIBLE.
     */
    public static final String IMPOSSIBLE = "Imposible de calcular";
    /**
     * The constant NAME_ERROR.
     */
    public static final String NAME_ERROR = "Ese curso ya existe";


    /**
     * Constructor for objects of class EIMOISException
     *
     * @param message the message
     * @Param message
     */
    public IEMOISException(String message)
    {
        // initialise instance variables
        super(message);
    }
}
