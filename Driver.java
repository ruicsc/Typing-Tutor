/*
 * UNCG Typing Tutor
 */

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Richard Brantley
 */
public class Driver 
{

    public static void main(String args[]) throws SQLException
    {
        //Testing Students
        System.out.println("Getting Student with ID 1:");
        getStudent(1);
        System.out.println("\n");
        
        //Testing Lessons
        System.out.println("Getting Lesson with ID 1:");
        getLesson(1);
        System.out.println("\n");
        
        //Testin Lesson Entries
        System.out.println("Getting Lesson Entry for Student ID:1 and Lesson ID:1");
        getLessonEntry(1,1);
        System.out.println("\n");
    }
    
    public static void getStudent(int studentId) throws SQLException
    {

        Database database = new Database("localhost","3306","typingtutor","root","");
        Student student = database.getStudent(studentId);
        System.out.println("First Name: "+student.getFirstName());
        System.out.println("Last Name: "+student.getLastName());
        System.out.println("Current Difficulty: "+student.getCurrentDifficulty());
     
    }
    
    public static void getLesson(int lessonId) throws SQLException
    {
        
        Database database = new Database("localhost","3306","typingtutor","root","");
        Lesson lesson = database.getLesson(lessonId);
        System.out.println("Lesson ID: "+lesson.getLessonId());
        System.out.println("Contents: "+lesson.getContents());
        System.out.println("Difficulty: "+lesson.getDifficulty());
        
    }
    
    public static void getLessonEntry(int studentId, int lessonId) throws SQLException
    {
        
        Database database = new Database("localhost","3306","typingtutor","root","");
        StudentLessonEntry studentLesson = database.getStudentLessonEntry(studentId,lessonId);
        System.out.println(studentLesson.student.getFirstName()+" made a "+studentLesson.getScore()+" on lesson "+studentLesson.lesson.getLessonId()+".");
        
    }
   
}
