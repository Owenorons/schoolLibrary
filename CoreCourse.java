/******************************************************************************
 * Student no. S3494967
 * Student Name: Owen O. Uwahen
 * Assignment 1 - AMS System 
 *****************************************************************************/
package ams.model;

public class CoreCourse extends AbstractCourse {
    
    private static final int CREDITPOINT = 12;

    // constructor with array of Strings for prerequisites
    //  and sets these values to their respective
    // instance variables.
    public CoreCourse(String courseCode, String title, String[] preReqs) {
        this.courseCode = courseCode;
        this.title = title;
        this.preReqs = preReqs;
    }

    // returns the current credit points as an int.
    @Override
    public int getCreditPoints() {
        return CREDITPOINT;
    }
    
    // toString method builds a String containing course code, title and 
    // prerequisites and use delimiter to separate more prerequisites if available.
    @Override
    public String toString() {
        String str;
        // separate prerequisites with a comma
        if (this.preReqs != null) {
            StringBuilder prereQ = new StringBuilder();
            for (int i = 0; i < this.preReqs.length; i++) {
                if (i == 0)
                	prereQ.append(this.preReqs[i]);
                else {
                	prereQ.append(',');
                	prereQ.append(this.preReqs[i]);
                }
            }
            str = this.courseCode + ":" + this.title + ":"
            + CREDITPOINT + ":" + prereQ + ":CORE";
        }
        // or else build the string.
        else
            str = this.courseCode + ":" + this.title + ":" +
        CREDITPOINT + ":CORE";
        return str;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
