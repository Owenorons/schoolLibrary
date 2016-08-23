/******************************************************************************
 * Student no. S3494967
 * Student Name: Owen O. Uwahen
 * Assignment 1 - AMS System 
 *****************************************************************************/

package ams.model;
import ams.model.exception.*;

public class University {
   
   // instance variables - one Student, one Program as per requirements.
	
   private Student student;
   private Program program;
   
   // returns current Student as a Student
   
   public Student getStudent() {
      return this.student;
   }
   
   // takes a Student as a parameter and sets that to the current student.
   
   public void setStudent(Student student) {
      this.student = student;
   }
   
   // returns the current Program as a Program.
   
   public Program getProgram() {
      return this.program;
   }
   
   // takes a Program as a parameter and sets that as the current Program.
   
   public void addProgram(Program program) {
      this.program = program;
   }
   
   // takes a Course as a parameter and then attempts to add that course to
   // the current program - may throw a ProgramException
   
   public void addCourse(Course course) throws ProgramException {
      program.addCourse(course);
   }
   
   // takes a String for required Course ID as a parameter and then attempts
   // to remove that course from the current program. may throw a Program
   // Exception exception
   
   public void removeCourse(String courseId) throws ProgramException {
      program.removeCourse(courseId);
   }
   
   // takes a String for required Course Code and then returns the Course
   // matching that Course Code from the current Program.
   
   public Course getCourse(String courseCode) {
      return program.getCourse(courseCode);
   }
   
   // returns an array of Courses using the Programs getAllCourses method
   
   public Course [] getProgramCourses() {
      return program.getAllCourses();
   }
   
   // attempts to withdraw student from a course - takes the required Course ID
   // as a String parameter - may throw an EnrollmentException exception
   
   public void withdrawStudentFromCourse(String courseID) throws
                                       EnrollmentException {
      student.withdrawFromCourse(courseID);
   }
   
   // attempts to enroll student into a Course taken in as a parameter - may 
   // throw an EnrollmentException exception.
   
   public void enrollStudentIntoCourse(Course course) throws 
                                       EnrollmentException {
      student.enrollIntoCourse(course);
   }
   
   // attempts to add a Result to the students current list of results - takes
   // a Result as a parameter and returns a boolean based on success.
   
   public boolean addStudentResult(Result result) {
      return student.addResults(result);
   }
   
   // returns an array of the current Students Results using the Student 
   // getResults method.
   
   public Result [] getStudentResults() {
      return student.getResults();
   }
   
   // returns an array of the current Students Courses using the Student
   // getCurrentEnrollment method.
   
   public Course[] getCurrentStudentEnrollment() {
      return student.getCurrentEnrollment();
   }
   
   // returns an int of the current Students load using the Student 
   // calculateCurrentLoad method
   
   public int calculateCurrentStudentLoad() {
      return student.calculateCurrentLoad();
   }
   
   // returns an integer of the current Students total career 
   // points using the Student calculateCareerPoints method.
   
   public int calculateTotalCareerPoints() {
      return student.calculateCareerPoints();
   }
}