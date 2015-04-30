/*
 * UNCG Typing Tutor
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Lesson Object Class for the UNCG Typing Tutor
 * @author Richard Brantley
 */
public class Lesson 
{
    
    //Database fields for the Lesson Object Class
    private int lesson_id,desired_wpm,time_limit,difficulty;
    private float desired_accuracy,desired_score;
    private String contents;
    
    /**
     * Lesson Class Constructor Function
     * @param lesson_id: integer of the lesson id
     * @param contents: string contents of the lesson
     * @param desired_accuracy: float value for the desired accuracy for the lesson
     * @param desired_score: float value for the desired score for the lesson
     * @param desired_wpm: int value for the desired words per minute for this lesson
     * @param time_limit: int value in seconds for the time limit of the lesson
     * @param difficulty: int value for the difficulty of the lesson
     */
    Lesson(int lesson_id, String contents,float desired_accuracy, float desired_score, int desired_wpm, int time_limit, int difficulty)
    {
        this.lesson_id = lesson_id;
        this.contents = contents;
        this.desired_accuracy = desired_accuracy;
        this.desired_score = desired_score;
        this.desired_wpm = desired_wpm;
        this.time_limit = time_limit;
        this.difficulty = difficulty;
    }
    
    //Getter functions for the Lesson Class Object
    public String getContents(){ return this.contents; }
    public int getLessonId(){ return this.lesson_id; }
    public int getDesiredWpm(){ return this.desired_wpm; }
    public int getTimeLimit(){ return this.time_limit; }
    public int getDifficulty() { return this.difficulty; }
    public float getDesiredAccuracy(){ return this.desired_accuracy; }
    public float getDesiredScore(){ return this.desired_score; }
    
    /**
     * Set the Lesson ID of the current Lesson
     * @param lessonId: integer value for the Lesson ID
     * @return Lesson Object Instance
     */
    public Lesson setLessonId(int lessonId)
    {
        this.lesson_id = lessonId;
        return this;
    }
    
    /**
     * Set the Contents of the current Lesson
     * @param contents: string of the contents
     * @return Lesson Object Instance
     */
    public Lesson setContents(String contents)
    {
        this.contents = contents;
        return this;
    }
    
    /**
     * Set the desired wpm of the current lesson
     * @param desired_wpm: int of the desired words per minute for the lesson
     * @return Lesson Object Instance
     */
    public Lesson setDesiredWpm(int desired_wpm)
    {
        this.desired_wpm = desired_wpm;
        return this;
    }
    
    /**
     * Set the time limit in seconds for the lesson
     * @param time_limit: int of the desired time limit in seconds for the lesson
     * @return Lesson Object Instance
     */
    public Lesson setTimeLimit(int time_limit)
    {
        this.time_limit = time_limit;
        return this;
    }
    
    /**
     * Set the difficulty of the lesson
     * @param difficulty: int of the difficulty for the lesson
     * @return Lesson Object Instance
     */
    public Lesson setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
        return this;
    }
    
    /**
     * Set the desired accuracy for the lesson
     * @param desired_accuracy: int value for the desired accuracy for the lesson
     * @return Lesson Object Instance
     */
    public Lesson setDesiredAccuracy(int desired_accuracy)
    {
        this.desired_accuracy = desired_accuracy;
        return this;
    }
    
    /**
     * Set the desired score for the lesson
     * @param desired_score: int value for the desired score for the lesson
     * @return Lesson Object Instance
     */
    public Lesson setDesiredScore(int desired_score)
    {
        this.desired_score = desired_score;
        return this;
    }
    
    /**
     * Save the Lesson Object in the Database
     * This will save the Lesson in the Database if it exists or create a new entry
     * @return boolean upon successful storage
     */
    public boolean save() throws SQLException
    {
        
        Database database = new Database("localhost","3306","typingtutor","root","");
        database.connect();
        
        String query = "";
        ResultSet resultSet = database.setQuery(query).performQuery();
        
        return true;
    }
    
}
