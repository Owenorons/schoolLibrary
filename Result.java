/******************************************************************************
 * Student no. S3494967
 * Student Name: Owen O. Uwahen
 * Assignment 1 - AMS System 
 *****************************************************************************/

package ams.model;

public class Result {
    
    // instance variables, a Course and a boolean for pass or fail.
    private Course course;
    private boolean passed;
    
    // constructor takes Course and boolean as arguments assigns to IV's
    public Result(Course course, boolean b) {
        this.course = course;
        this.passed = b;
    }

    // getCourse returns the Course associated with this Result
    public Course getCourse() {
        return course;
    }
    
    // getResult returns a boolean to indicate pass or fail
    public boolean getResult() {
        return passed;
    }
    
    // sets the result from the boolean argument
    public void addResult(boolean b) {
        this.passed = b;
    }
    
    // simple toString method constructs string with course and pass or fail
    // delimited by : character and returns that String.
    @Override
    public String toString() {
        String passFail;
        if (this.passed)
            passFail = "pass";
        else
            passFail = "fail";
        String s = this.course.getCode() + ":" + passFail;
        return s;
    }

}