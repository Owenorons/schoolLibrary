/******************************************************************************
 * Student no. S3494967
 * Student Name: Owen O. Uwahen
 * Assignment 1 - AMS System 
 *****************************************************************************/
package ams.model;
import java.util.Iterator;

import ams.model.exception.*;

public class PGStudent extends AbstractStudent {
    
    private static final int MAXIMUM_LOAD = 48;
    
    // constructor takes integer for id and string for name assigns to IV.
    public PGStudent(int id, String name) {
        this.studentId = id;
        this.fullName = name;
    }
    
    // toString method returns a String with delimiter separating the current
    // students id, name and maximum load.
    @Override
    public String toString() {
        String s = this.studentId + ":" + this.fullName + ":" + MAXIMUM_LOAD;
        return s;
    }
    
    // enroll student into a Course method
    //
    @Override
    public void enrollIntoCourse(Course course) throws EnrollmentException {
        // calculate the total credit points load for the student and
        // course prerequisites from course is exist.
        int CreditPoint = course.getCreditPoints() + this.calculateCurrentLoad();
        String[] preReqs = course.getPreReqs();
        // if the student is currently enrolled in this course throw exception
        if (courses.contains(course))
            throw new EnrollmentException("Already enrolled in this Course");
        // check to see student has previously passed the course and if so
        // throw an exception
        Iterator<Result> itera = results.iterator();
        while (itera.hasNext()) {
            Result r = (Result) itera.next();
            if (r.getCourse().equals(course) && r.getResult())
                throw new EnrollmentException("Cannot Enroll in course as it" +
                        " was previously passed");
        }
        // if there are prerequisites student have to pass at
        // least one of them or else throw exception
        if (preReqs != null) {
            int numberOfPassedPreQ = 0;
            Iterator<Result> iter = results.iterator();
            while (iter.hasNext()) {
                Result r = (Result) iter.next();
                for (int i = 0; i < preReqs.length; i++) {
                    if (r.getCourse().getCode().equals(preReqs[i]) 
                            && r.getResult())
                    	 numberOfPassedPreQ++;
                }
            }
            if ( numberOfPassedPreQ < 1)
                throw new EnrollmentException("No prerequisites passed for " +
                        "this subject");
        }
        
        // if student has exceeded their maximum load we first say they are 
        // unable to enroll - however if the load is only exceeded by 6 or less
        // then check if the student has passed previous subjects
        // if they have not - throw an exception - if  passed all their
        // previous course then they are able or enroll throw 
        // overload exception.
        
        if ( CreditPoint > MAXIMUM_LOAD) {
            //first of all set enrollable boolean check to false
        	boolean enrollable = false; 
            
            if ( CreditPoint <= MAXIMUM_LOAD + 6) {
                Iterator<Result> iter = results.iterator();
                while (iter.hasNext()) {
                    Result r = (Result) iter.next();
                    if (!r.getResult())
                        throw new EnrollmentException("Student has not" +
                        		" passed all subjects - overload not allowed");
                }
                enrollable = true;
            }
            if (!enrollable)
                throw new EnrollmentException("course would exceed maximum" +
                		" load");
        }
        // else course is added as all relevant checks
        // has been completed.
        this.courses.add(course);
    }
}