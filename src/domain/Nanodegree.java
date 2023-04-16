package domain;  
 
import java.util.ArrayList;

public class Nanodegree extends Program{
   

    private int projectWeeks;    
    private ArrayList<Course> courses;
    
    /**
     * Constructs a new nanodegree
     * @param name 
     * @param projectWeeks
     */
    public Nanodegree(String name, int projectWeeks){
        this.name=name;
        this.projectWeeks=projectWeeks;
        courses= new ArrayList<Course>();
    }


     /**
     * Add a new course
     * @param c
     */   
    public void addCourse(Course c){
        if (courses.contains(c)){
            try {
                throw new IEMOISException(IEMOISException.NAME_ERROR);
            } catch (IEMOISException e) {
                throw new RuntimeException(e);
            }
        }else {
            courses.add(c);
        }
    }
       
 
    
    @Override
    public int weeks() throws IEMOISException{
        int res = 0;
        if ((Integer)projectWeeks == null) throw new IEMOISException(IEMOISException.WEEKS_EMPTY);
        if (projectWeeks < 1) throw new IEMOISException(IEMOISException.WEEKS_ERROR);
        if (courses.isEmpty()) throw new IEMOISException(IEMOISException.NANO_EMPTY);
        for(Course a: courses){
            res += a.weeks();
        }
        return res + projectWeeks;
    }

    /**
     * Calculates an estimate of weeks
     * For courses where the weeks cannot be known or has error, the max, min or avg  of the known courses is assumed
     * @param type (max,min,avg) 
     * @return 
     * @throws IEMOISException NANO_EMPTY, if it don't have courses. IMPOSSIBLE, if it can't be calculated
     */
    public int weeks(String type) throws IEMOISException{
        if (type != "max" || type != "min" || type != "avg") throw new IEMOISException(IEMOISException.IMPOSSIBLE);
        if (courses.size() <= 0) throw new IEMOISException(IEMOISException.NANO_EMPTY);
        int res = 0;
        int pos = -1;
        try {
            for (Course c: courses){ 
                pos +=1;
                if (type == "max" && c.weeks() >= res){
                    res = c.weeks();
                } else if (type == "min" && c.weeks() <= res){
                    res = c.weeks();
                } else if (type == "avg"){
                    res += c.weeks();
                }                
            }
            res = (type == "avg") ? res / courses.size() : res;
            }catch (IEMOISException e) {
                courses.set(pos ,  new Course( courses.get(pos).name() , res));
                weeks(type);
            }
        return res;
        
    }   
    
    
     /**
     * Calculates an estimate of weeks
     * For courses where the weeks cannot be known, unknown is assumed
     * @param unknown 
     * @return 
     * @throws IEMOISException NANO_EMPTY, if it don't have courses. WEEKS_ERROR, if some course has error
     */
    public int weeks(int unknown) throws IEMOISException{
        int res = 0;
        int pos = -1;
        try {
            for (Course c: courses){ 
                pos +=1;
                res += c.weeks();           
            }
            }catch (IEMOISException e ) {
                if(e.equals(IEMOISException.NANO_EMPTY) || e.equals(IEMOISException.WEEKS_ERROR)){
                    throw new IEMOISException(e.getMessage());
                } 
                courses.set(pos ,  new Course( courses.get(pos).name() , unknown));
                weeks(unknown);
            }
        return res;
    } 
    
    @Override
    public String data() throws IEMOISException{
        StringBuffer answer=new StringBuffer();
        answer.append(name+". Proyecto: "+ projectWeeks);
        for(Course c: courses) {
            answer.append("\n\t"+c.data());
        }
        return answer.toString();
    } 
    


    
    

}
