/*
 * UNCG Typing Tutor
 */

import java.util.HashMap;
import java.util.Map;

/**
 *  The Student Class Object for the UNCG Typing Tutor
 * @author Richard Brantley
 */
public class Student 
{
    //Database fields for the Student Object
    private String first_name,last_name;
    private int student_id,current_difficulty;
    
    /**
     * Class Constructor Function for the Student Object
     * @param student_id: The integer value for the ID of the Student
     * @param firstName: The string value for the first name of the Student
     * @param lastName: The string value for the last name of the student
     * @param current_difficulty: The current difficulty of the student 
     */
    Student(int student_id, String firstName, String lastName, int current_difficulty)
    {
        this.student_id = student_id;
        this.first_name=firstName;
        this.last_name=lastName;
        this.current_difficulty=current_difficulty;
    }
    
    /**
     * Get the students first name
     * @return String first_name
     */
    public String getFirstName()
    {
        return this.first_name;
    }
    
    /**
     * Get the students last name
     * @return String last_name
     */
    public String getLastName()
    {
        return this.last_name;
    }
    
    /**
     * Get the current difficulty of the student
     * @return int current_difficulty
     */
    public int getCurrentDifficulty()
    {
        return this.current_difficulty;
    }
    
    /**
     * Set the ID of the current Student Object
     * @param studentId: Integer of the Student ID to assign
     * @return Student Object Instance
     */
    public Student setStudentId(int studentId)
    {
        this.student_id = studentId;
        return this;
    }
    
    /**
     * Set the First Name of the current Student Object
     * @param firstName: String of the students first name
     * @return Student Object Instance
     */
    public Student setFirstName(String firstName)
    {
        this.first_name = firstName;
        return this;
    }
    
    /**
     * Set the Last Name of the current Student Object
     * @param lastName: String of the students last name
     * @return Student Object Instance
     */
    public Student setLastName(String lastName)
    {
        this.last_name = lastName;
        return this;
    }
    
    /**
     * Set the current difficulty of the Student Object
     * @param currentDifficulty: integer of the students difficulty
     * @return Student Object Instance
     */
    public Student setCurrentDifficulty(int currentDifficulty)
    {
        this.current_difficulty = currentDifficulty;
        return this;
    }
    
    /**
     * Save the current Student to the Database
     * This will save the Student if they already exist or create a new one
     * @return boolean upon successful storage
     */
    public boolean save()
    {
        return true;
    }
    
}
