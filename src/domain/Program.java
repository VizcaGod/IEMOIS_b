package domain;


/**
 * The type Program.
 */
public abstract class Program{

    /**
     * The Name.
     */
    protected String name;


    /**
     * Return the name
     *
     * @return string
     */
    public String name(){
        return name;
    }


    /**
     * Return weeks
     *
     * @return int
     * @throws IEMOISException ,if the time is not available or has an error
     */
    public abstract int weeks() throws IEMOISException;


    /**
     * Return the representation as string
     *
     * @return string
     * @throws IEMOISException ,if the data is not complete
     */
    public abstract String data() throws IEMOISException;

}
