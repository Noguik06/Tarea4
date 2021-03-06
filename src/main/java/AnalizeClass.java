/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Noguera
 */
public class AnalizeClass {
    
    /**
     *Clase para leer las clases
     * 
     * @param filename el nombre del archivo
     * @return un objeto tipo ClassInfo con la informacion del objeto
     */
    public static List<ClassInfo> loadDataFromFile(String fileName) {
        List<ClassInfo> dataList = new ArrayList<>();
        File archive = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine()) != null) {
                StringTokenizer stringTokenized = new StringTokenizer(line, "\n");
                if(stringTokenized.hasMoreTokens()) {
                    ClassInfo classInfo = new ClassInfo();
                    String[] stringsInLine = stringTokenized.nextToken().split(",");
                    classInfo.setClassName(stringsInLine[0]);
                    classInfo.setLoc(Double.parseDouble(stringsInLine[1]));
                    classInfo.setNumberOfMethods(Double.parseDouble(stringsInLine[2]));
                    dataList.add(classInfo);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnalizeClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AnalizeClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataList;
    }
    
    public static  List<ClassInfo> loadClassInfo(String fileName) {
        return AnalizeClass.loadDataFromFile(fileName);
    }
    
    public static ObjectType calculateSizeRange(List<ClassInfo> classInfoList) {
        ObjectType objectType = new ObjectType();
        objectType.setAverage(average(classInfoList));
        objectType.setVariance(variance(classInfoList));
        return objectType;
    }
    
    
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
