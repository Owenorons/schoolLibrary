/******************************************************************************
 * Student no. S3494967
 * Student Name: Owen O. Uwahen
 * Assignment 1 - AMS System 
 *****************************************************************************/
package ams.model;

import java.util.Iterator;

import ams.model.exception.EnrollmentException;

public class UGStudent extends AbstractStudent {

    private static final int MAXIMUM_LOAD = 60;
    
    // constructor takes integer for id string for fullname
    
    public UGStudent(int id, String name) {
        this.studentId = id;
        this.fullName = name;
    }
    
    // constructs and returns string of students id, fullname and load.
    
    @Override
    public String toString() {
        String s = this.studentId + ":" + this.fullName + ":" + MAXIMUM_LOAD;
        return s;
    }
    
    // attempts to enroll student into the Course given as an argument - may
    // throw an enrollment exception if rules are broken
    
    @Override
    public void enrollIntoCourse(Course course) throws EnrollmentException {
    	
        // calculate load if we add this subject and get prerequisites (if any)
    	
        int CP = course.getCreditPoints() + this.calculateCurrentLoad();
        String[] preReqs = course.getPreReqs();
        
        // if student already enrolled in this course throw an exception
        
        if (courses.contains(course))
            throw new EnrollmentException("Already enrolled in this Course");
        
        // check to see if student has previously PASSED the subject and if so
        // throw an exception
        
        Iterator<Result> itera = results.iterator();
        while (itera.hasNext()) {
            Result r = (Result) itera.next();
            if (r.getCourse().equals(course) && r.getResult())
                throw new EnrollmentException("Cannot Enroll in course as it" +
                        " was previously passed");
        }
        // if there are prerequisites then we must check that all have been 
        // passed and if not then we must throw an exception
        
        if (preReqs != null) {
            
            int noPassed = 0;
            Iterator<Result> iter = results.iterator();
            while (iter.hasNext()) {
                Result r = (Result) iter.next();
                for (int i = 0; i < preReqs.length; i++) {
                    if (r.getCourse().getCode().equals(preReqs[i])
                            && r.getResult())
                    noPassed++;
                }
            }
            if (noPassed != preReqs.length)
                throw new EnrollmentException("Prerequisites not all passed" +
                        " for this subject");
        }
        
        // finally if the current load with this subject exceeds the maximum
        // we must throw an exception
        
        if ( CP > MAXIMUM_LOAD) {
            throw new EnrollmentException("Enrollment would exceed maximum" +
                    " load - overload not allowed");
        }
        
        // if we get this far without an exception thrown we can safely add 
        // the course to the students set of enrolled courses
        
        courses.add(course);
    }
}