/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * @author Juan Noguera
 */
public class Functions {
    
    /**
     *Calculates the average of a data set
     * @param classInfoList Data set to calculate the average
     * @return Average of the data set
     */
    public static double average(List<ClassInfo> classInfoList) {
        double sum = 0.0;
        for(ClassInfo element : classInfoList) {
            sum += element.naturalLogarithmOfLocPerMethod();
        }
        double listSize = (double)classInfoList.size();
        double average = sum / listSize;
        return average;
    }
    
    /**
     *Calculates the variance of a data set
     * @param classInfoList Data set to calculate the variance
     * @return variance of the data set
     */
    public static double variance(List<ClassInfo> classInfoList) {
        double sum = 0.0;
        double average = average(classInfoList);
        for(ClassInfo element : classInfoList) {
            sum += Math.pow((element.naturalLogarithmOfLocPerMethod() - average), 2.0);
        }
        double listSize = (double)classInfoList.size();
        double variance = sum / (listSize - 1);
        return variance;
    }
}
