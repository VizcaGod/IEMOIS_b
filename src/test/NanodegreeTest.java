package test;

import domain.Course;
import domain.IEMOISException;
import domain.Nanodegree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * The type Nanodegree test.
 */
public class NanodegreeTest{


    /**
     * Instantiates a new Nanodegree test.
     */
    public NanodegreeTest(){
    }


    /**
     * Set up.
     */
    @Before
    public void setUp(){    
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown(){
    }


    /**
     * Should calculate the cost of a nanodegree.
     */
    @Test
    public void shouldCalculateTheCostOfANanodegree(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        s.addCourse(new Course("INTRO TO JAVASCRIPT", 3));
        s.addCourse(new Course("JAVASCRIPT AND THE DOM", 2));
        try {
           assertEquals(8,s.weeks());
        } catch (IEMOISException e){
            fail("Threw a exception");
        }    
    }

    /**
     * Should throw exception if nanodegree has no courses.
     */
    @Test
    public void shouldThrowExceptionIfNanodegreeHasNoCourses(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 10);
        try {
           int weeks=s.weeks();
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.NANO_EMPTY,e.getMessage());
        }
    }


    /**
     * Should throw exception if there is error inweeks.
     */
    @Test
    public void shouldThrowExceptionIfThereIsErrorInweeks(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        s.addCourse(new Course("INTRO TO JAVASCRIPT",3));
        s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        try { 
           int weeks=s.weeks();
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.WEEKS_ERROR,e.getMessage());
        }    
    }

    /**
     * Should throw exception ifweeks is not known.
     */
    @Test
    public void shouldThrowExceptionIfweeksIsNotKnown(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        s.addCourse(new Course("INTRO TO JAVASCRIPT",null));
        s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        try { 
           int weeks=s.weeks();
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.WEEKS_EMPTY,e.getMessage());
        }    
    }

    /**
     * Should not repeat course.
     */
    @Test
    public void shouldNotRepeatCourse(){
        Nanodegree t = new Nanodegree("FULL STACK DEVELOPER",6);
        t.addCourse(new Course("FUNDAMENTS",2));
        t.addCourse(new Course("FRONT-END PROGRAMMING",2));
        t.addCourse(new Course("BACK-END PROGRAMMING",2));
        //Prueba con otro curso que tiene el mismo nombre.
        Nanodegree r = new Nanodegree("FULL STACK DEVELOPER",6);
        r.addCourse(new Course("FUNDAMENTS",2));
        r.addCourse(new Course("FRONT-END PROGRAMMING",2));
        r.addCourse(new Course("BACK-END PROGRAMMING",2));
        fail("Threw an exception");

    }


}