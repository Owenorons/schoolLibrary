/******************************************************************************
 * Student no. S3494967
 * Student Name: Owen O. Uwahen
 * Assignment 1 - AMS System 
 *****************************************************************************/
package ams.model;
import java.util.*;

import ams.model.exception.EnrollmentException;

public abstract class AbstractStudent implements Student {

    // instance variables - int for student ID, String for students full name,
    // a HashSet of enrolled Courses and an ArrayList of current Results.
    protected int studentId;
    protected String fullName;
    protected Set<Course> courses = new HashSet<Course>();
    protected List<Result> results = new ArrayList<Result>();
    
    
    // abstract method to enroll student into course
    //takes a Course as parameter.
    public abstract void enrollIntoCourse(Course course) 
    throws EnrollmentException;

    // withdraws the student from a course as 
    //identified by the String parameter
    // if the student is not currently enrolled 
    //in the course throw exception
    @Override
    public void withdrawFromCourse(String courseID) throws EnrollmentException {
    	boolean notwithdrawn = true;//set notwithdrawn to true
        Iterator<Course> iter = courses.iterator();
        while (iter.hasNext()) {
            Course c = (Course) iter.next();
            if (c.getCode().equals(courseID)) {
                courses.remove(c);
                notwithdrawn = false;
            }
        }
        if (notwithdrawn)
        	throw new EnrollmentException("this Student is not currently "
        			+ "enrolled in" +" this course");
    }
    
    
    // returns the students currently enrolled in courses as an array of Courses - if
    // the student is not enrolled in any courses a null value is returned
    @Override
    public Course[] getCurrentEnrollment() {
        if (courses.isEmpty())
            return null;
        else {
        // convert the set of courses to an array ready to return.
            Course[] c = courses.toArray(new Course[0]);
            return c;
        }
    }
    
    // returns the students full name as a String.
    @Override
    public String getFullName() {
        return fullName;
    }
    
    // returns the student ID 
    @Override
    public int getStudentId() {
        return studentId;
    }
    
    // returns student results as an array of Results - will return a null value
    // if there are no results to return.
    @Override
    public Result[] getResults() {
        if (results.isEmpty())
            return null;
        else {
            Result[] r = results.toArray(new Result[0]);
            return r;
        }
    }

    // adds a Result to the students current list of results - if the student
    // has previously failed the result will be updated and the current course
    // removed from the students set of courses. returns a boolean result based
    // on success
    @Override
    public boolean addResults(Result result) {
        if (this.courses.contains(result.getCourse())) {
            Iterator<Result> iter = results.iterator();
            while (iter.hasNext()) {
                Result r = (Result) iter.next();
                if (result.getCourse().equals(r.getCourse()) 
                && !(r.getResult()) ) {
                    results.remove(r);
                    results.add(result);
                    courses.remove(result.getCourse());
                    return true;
                }
            }
            courses.remove(result.getCourse());
            return results.add(result);
        }
        else
            return false;
    }
  

    // returns an int of the students current Load - will iterate through the
    // set of courses and sums their respective credit points 
    @Override
    public int calculateCurrentLoad() {
        int load = 0;
        Iterator<Course> iter = courses.iterator();
        while (iter.hasNext()) {
            Course c = (Course) iter.next();
            load += c.getCreditPoints();
        }        
        return load;
    }
    
    // returns an int of the current students total career points based off the
    // list of Results - iterates through the list and sums credit points of all
    // subjects passed
    @Override
    public int calculateCareerPoints() {
        int points = 0;
        Iterator<Result> iter = results.iterator();
        while (iter.hasNext()) {
            Result r = (Result) iter.next();
            if (r.getResult()) {
                Course c = r.getCourse();
                points += c.getCreditPoints();
            }
        }        
        return points;
    }
}