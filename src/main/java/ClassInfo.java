/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Juan Noguera
 */
public class ClassInfo {
    
    private String className;
    private double loc;
    private double numberOfMethods;

     /**
     *Empty constructor of the class 
     */
    public ClassInfo() {
    }
    
    /**
     *Constructor of the class 
     * 
     * @param className name of the class
     * @param loc number of lines of code
     * @param numberOfMethods number of methods per class
     */
    public ClassInfo(String className, double loc, double numberOfMethods) {
        this.className = className;
        this.loc = loc;
        this.numberOfMethods = numberOfMethods;
    }

    /**
     *ClassName attribute getter
     * 
     * @return class name
     */
    public String getClassName() {
        return className;
    }
    
    /**
     *ClassName attribute setter
     * 
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }
    
    
    /**
     *loc attribute getter
     * 
     * @return loc value
     */
    public double getLoc() {
        return loc;
    }

    /**
     *loc attribute setter
     * 
     * @param loc
     */
    public void setLoc(double loc) {
        this.loc = loc;
    }

    /**
     *Number of methods attribute getter
     * 
     * @return number of methods
     */
    public double getNumberOfMethods() {
        return numberOfMethods;
    }

    /**
     *Number of methods attribute setter
     * 
     * @param numberOfMethods
     */
    public void setNumberOfMethods(double numberOfMethods) {
        this.numberOfMethods = numberOfMethods;
    }
    
    /**
     *Calculates the natural logarithm of the loc and number of loc per method
     * 
     * @return natural logarithm of loc per method
     */
    public double naturalLogarithmOfLocPerMethod() {
        return Math.log(this.loc / this.numberOfMethods);
    }
}
