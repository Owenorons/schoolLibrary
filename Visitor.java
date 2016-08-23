/******************************************************************************
 * Student no. S3494967
 * Student Name: Owen O. Uwahen
 * Assignment 1 - AMS System 
 *****************************************************************************/

package ams.model;

public interface Visitor {
    public void visit(ElectiveCourse elective);
    public void visit(CoreCourse core);
}