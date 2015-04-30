/*
 * UNCG Typing Tutor
 */

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * StudentLessonEntry Object Class for the UNCG Typing Tutor
 * @author Richard Brantley
 */
public class StudentLessonEntry 
{
    //Database fields for the StudentLessonEntry Object
    private int student_id,lesson_id,wpm;
    private Date date_taken;
    private float accuracy,score;
    private String entry;
    public Student student;
    public Lesson lesson;
    
    /**
     * Constructor Function for the StudentLessonEntry Object
     * @param student_id: Integer of the Student ID
     * @param lesson_id: Integer of the Lesson ID
     * @param wpm: Integer for the words per minute for the Student/Lesson Association
     * @param date_taken: DateTime for the Date and Time this lesson was taken IE: YYYY-MM-DD HH:MM:SS MySQL Format
     * @param accuracy: The Float for the accuracy of this taken lesson
     * @param score: The Float Score for the taken lesson
     * @param entry: The actual entry of the student for this lesson
     */
    StudentLessonEntry(int student_id,int lesson_id,int wpm, Date date_taken, float accuracy, float score, String entry)
    {
        this.student_id = student_id;
        this.lesson_id = lesson_id;
        this.wpm = wpm;
        this.date_taken = date_taken;
        this.accuracy = accuracy;
        this.score = score;
        this.entry = entry;
    }
    
    //Getter functions for the StudentLessonEntry Object
    public int getStudentId(){ return this.student_id; }
    public int getLessonId(){ return this.lesson_id; }
    public Student getStudent(){ return this.student; }
    public Lesson getLesson(){ return this.lesson;} 
    public int getWpm(){ return this.wpm; }
    public Date getDateTaken(){ return this.date_taken; }
    public float getAccuracy(){ return this.accuracy; }
    public float getScore(){ return this.score; }
    public String getEntry(){ return this.entry; }
    
    /**
     * Set the Student Object Reference for this Student Lesson Association
     * @param student: The Student Object to assign to this taken lesson
     * @return StudentLessonEntry object reference
     */
    public StudentLessonEntry setStudent(Student student)
    {
        this.student = student;
        return this;
    }
    
    /**
     * Set the Lesson Object Reference for this Student Lesson Association
     * @param lesson: The Lesson Object to assign to this taken lesson
     * @return StudentLessonEntry object reference
     */
    public StudentLessonEntry setLesson(Lesson lesson)
    {
        this.lesson = lesson;
        return this;
    }
    
    /**
     * Set the student id
     * @param student_id: Student ID Integer
     * @return StudentLessonEntry Object
     */
    public StudentLessonEntry setStudentId(int student_id)
    {
        this.student_id = student_id;
        return this;
    }
    
    /**
     * Set the lesson ID value
     * @param lesson_id: Integer for the Lesson ID
     * @return StudentLessonEntry Object
     */
    public StudentLessonEntry setLessonId(int lesson_id)
    {
        this.lesson_id = lesson_id;
        return this;
    }
    
    /**
     * Set the Lesson words per minute
     * @param wpm: The integer of the words per minute
     * @return StudentLessonEntry Object
     */
    public StudentLessonEntry setWpm(int wpm)
    {
        this.wpm = wpm;
        return this;
    }
    
    /**
     * Set the Date Taken for this entry
     * @param date_taken: DateTime MySQL format for the date this was taken
     * @return StudentLessonEntry Object
     */
    public StudentLessonEntry setDateTaken(Date date_taken)
    {
        this.date_taken = date_taken;
        return this;
    }
    
    /**
     * Set the Accuracy for this taken lesson
     * @param accuracy: The float value of the accuracy
     * @return StudentLessonEntry Object
     */
    public StudentLessonEntry setAccuracy(float accuracy)
    {
        this.accuracy = accuracy;
        return this;
    }
    
    /**
     * Set the Score for the taken lesson
     * @param score: The float for the score of this lesson
     * @return StudentLessonEntry Object
     */
    public StudentLessonEntry setScore(float score)
    {
        this.score = score;
        return this;
    }
    
    /**
     * Set the Entry for this taken lesson
     * @param entry: The string value for the entry
     * @return StudentLessonEntry Object
     */
    public StudentLessonEntry setEntry(String entry)
    {
        this.entry = entry;
        return this;
    }
    
    /**
     * Save this Object in the Database
     * This will save the object if it currently exists or create a new entry
     * @return 
     */
    public boolean save()
    {
        return true;
    }
            
    
}
