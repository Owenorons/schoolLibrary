/******************************************************************************
 * Student no. S3494967
 * Student Name: Owen O. Uwahen
 * Assignment 1 - AMS System 
 *****************************************************************************/
package ams.model;

import ams.model.exception.EnrollmentException;

public interface Enrollable {
    // must take a Course as parameter to enroll student into course - may
    // throw an EnrollmentException exception.
    public void enrollIntoCourse(Course course) throws EnrollmentException;
    // must take a String as parameter for course code to withdraw student from
    // that course - may throw an enrollment exception
    public void withdrawFromCourse(String string) throws EnrollmentException;
}