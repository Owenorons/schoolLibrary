/******************************************************************************
 * Student no. S3494967
 * Student Name: Owen O. Uwahen
 * Assignment 1 - AMS System 
 *****************************************************************************/
package ams.model;

public class ElectiveCourse extends AbstractCourse {

    // instance variable which holds the current credit points for the course.
    private int currentCP;
    
    // constructor accept course code and title as string, integer for credit
    // points and array of String for prerequisites  
    
    public ElectiveCourse(String code, String title, int CP, String[] preReqs) {
        this.courseCode = code;
        this.title = title;
        this.currentCP = CP;
        this.preReqs = preReqs;
    }

    // returns the current credit points value as an integer.
    @Override
    public int getCreditPoints() {
        return currentCP;
    }
    
    // toString method returns a String delimited by : characters of 
    // courses code, title, prerequisites (if any) and the fact it 
    //is Elective
    public String toString() {
        String s;
        if (this.preReqs != null ) {
            StringBuilder prereQ = new StringBuilder();
            for (int i = 0; i < this.preReqs.length; i++) {
                if (i == 0)
                	prereQ.append(this.preReqs[i]);
                else {
                	prereQ.append(',');
                	prereQ.append(this.preReqs[i]);
                }
            }
            s = this.courseCode + ":" + this.title + ":" + currentCP + ":" +prereQ 
            		+ ":ELECTIVE";
        }
        else
            s = this.courseCode + ":" + this.title + ":" + currentCP + ":ELECTIVE";
        return s;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
