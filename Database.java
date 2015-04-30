/*
 * UNCG Typing Tutor
 */

import java.util.HashMap;
import java.util.Map;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database Driver Class for the UNCG Typing Tutor
 * @author Richard Brantley
 */
public class Database 
{
    
    //Defining parameters for the MySQL connection
    private String host,port,database,user,password,query;
    
    //The current connected state of the MySQL connection
    private boolean connected;
    
    //The Mysql Connection Handler
    private Connection conn;
    
    //The MySQL Query Statement and Result Set Handlers
    private Statement statement;
    private ResultSet resultSet;
    
    /**
     * Database Class Constructor
     * @param host: The host for the MySQL connection IE: "localhost" or "127.0.0.1"
     * @param port: The port for the MySQL connection IE: 3306
     * @param database: The database name for the MySQL connection
     * @param user: The MySQL user that has proper access for the above MySQL database
     * @param password : The password the above MySQL user
     */
    Database(String host, String port, String database, String user, String password)
    {
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }
    
    /**
     * Connect to the MySQL Database
     * @return boolean state of connect
     * @throws SQLException 
     */
    public boolean connect() throws SQLException
    {
        //Get MySQL connection
        conn = null;
        conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+this.host+":"+this.port+"/"+this.database,this.user,this.password);
        
        //Create the default MySQL Statement and Result Set
        this.statement = conn.createStatement();
        this.resultSet = null;
        
        //Update the connected state
        this.connected = true;
        
        //Return success
        return true;
    }
    
    /**
     * Disconnect from the MySQL Database Handlers
     * @return boolean state of disconnection
     * @throws SQLException 
     */
    public boolean disconnect() throws SQLException
    {
        //Close the Result Set and Statement MySQL Handlers
        this.resultSet.close();
        this.statement.close();
        
        //Close the MySQL Connection Handler
        this.conn.close();
        
        //Update the MySQL Connection state
        this.connected = false;
        
        //Return success
        return true;
    }
    
    /**
     * Get a Student Object from the Database
     * @param studentId: Integer of the requested Student ID
     * @return Student: The Student object retrieved from the Database
     * @throws SQLException 
     */
    public Student getStudent(int studentId) throws SQLException
    {
        //Create a null instance of the Student
        Student student = new Student(studentId,null,null,0);
        
        //Connect to the Datbase
        this.connect();
        
        //Generate the MySQL string to retrieve the student
        String query = "select * from Students where student_id="+studentId+" LIMIT 1;";
        
        //Execute the above MySQL query
        this.resultSet = statement.executeQuery(query);        
        
        //Get the results from the executed query
        while ( this.resultSet.next() )
        {
            student.setStudentId(this.resultSet.getInt("student_id"))
                    .setFirstName(this.resultSet.getString("first_name"))
                    .setLastName(this.resultSet.getString("last_name"))
                    .setCurrentDifficulty(this.resultSet.getInt("current_difficulty"));
        }
        
        //Disconnect from the database
        this.disconnect();
        
        
        //Return the student object
        return student;
    }

    
    /**
     * Get a requested Lesson from the Database
     * @param lessonId: The Integer ID for the requested Lesson
     * @return lesson: The requested Lesson Object from the Database
     * @throws SQLException 
     */
    public Lesson getLesson(int lessonId) throws SQLException
    {
        //Create a null Lesson Object
        Lesson lesson = new Lesson(lessonId,null,0,0,0,0,0);
        
        //Connect to the MySQL Database
        this.connect();
        
        //Generate the MySQL Query String
        String query = "select * from Lessons where lesson_id="+lessonId+" LIMIT 1;";
        
        //Perform the exeuction on the above query string
        this.resultSet = statement.executeQuery(query);
        
        //Get results from the Query execution
        while ( this.resultSet.next() )
        {
            lesson.setLessonId(this.resultSet.getInt("lesson_id"))
                    .setDesiredWpm(this.resultSet.getInt("desired_wpm"))
                    .setTimeLimit(this.resultSet.getInt("time_limit"))
                    .setDifficulty(this.resultSet.getInt("difficulty"))
                    .setDesiredAccuracy(this.resultSet.getInt("desired_accuracy"))
                    .setDesiredScore(this.resultSet.getInt("desired_score"))
                    .setContents(this.resultSet.getString("contents"));
        }
        
        //Disconnect from the Database
        this.disconnect();
        
        //Return the lesson
        return lesson;
    }
    
    /**
     * Get a requested StudentLessonEntry from the Database
     * @param studentId: The Student ID for the requested Student/Lesson entry
     * @param lessonId: The Lesson ID for the requested Student/Lesson entry
     * @return StudentLessonEntry Object for the requested entry
     */
    public StudentLessonEntry getStudentLessonEntry(int studentId, int lessonId) throws SQLException
    {
        //Create a null StudentLessonEntry Object
        StudentLessonEntry studentLessonEntry = new StudentLessonEntry(studentId,lessonId,0,null,0,0,null);
        
        //Get the respective Student and Lesson Information for the Entry Object
        studentLessonEntry.setStudent(this.getStudent(studentId));
        studentLessonEntry.setLesson(this.getLesson(lessonId));
        
        //Connect to the MySQL Database
        this.connect();
        
        //Generate the MySQL Query String
        String query = "select * from Student_Lesson where student_id="+studentId+" AND lesson_id="+lessonId+" LIMIT 1;";
        
        //Perform the execution on the above Query String
        this.resultSet = this.statement.executeQuery(query);
        
        //Get results from the Query execution
        while ( this.resultSet.next() )
        {
            studentLessonEntry.setStudentId(this.resultSet.getInt("student_id"))
                    .setLessonId(this.resultSet.getInt("lesson_id"))
                    .setDateTaken(this.resultSet.getDate("date_taken"))
                    .setAccuracy(this.resultSet.getFloat("accuracy"))
                    .setScore(this.resultSet.getFloat("score"))
                    .setEntry(this.resultSet.getString("entry"));
        }
        
        //Disconnect from the Database
        this.disconnect();
        
        //Return the StudentLessonEntry
        return studentLessonEntry;
    }
    
    /**
     * Save the Student Object in the Database
     * @param student: The Student Object that is to be saved/updated in the Database
     * @return boolean success upon proper storage
     */
    public boolean saveStudent(Student student)
    {
        //Try to save/update the Student in the Database
        if ( student.save() )
        {
            //Success
            return true;
        }
        else
        {
            //Failure
            return false;
        }
        
    }
    
    /**
     * Save the Lesson Object in the Database
     * @param lesson: The Lesson Object that is to be saved/updated in the Database
     * @return boolean success upon proper storage
     */
    public boolean saveLesson(Lesson lesson)
    {
        //Try to save/update the Lesson in the Database
        if ( lesson.save() )
        {
            //Success
            return true;
        }
        else
        {
            //Failure
            return false;
        }
    }
    
    /**
     * Save the Lesson Entry Attempt for a Student and Lesson Pair
     * @param studentLessonEntry: The StudentLessonEntry Object that is to be saved/updated in the Database
     * @return boolean success upon proper storage
     */
    public boolean saveStudentLessonEntry(StudentLessonEntry studentLessonEntry)
    {
        //Try to save/update the StudentLessonEntry in the Database
        if ( studentLessonEntry.save() )
        {
            //Success
            return true;
        }
        else
        {
            //Failure
            return false;
        }
    }
    
    /**
     * Public function that sets the current database query
     * @param query: The SQL string that is to be used as the MySQL query. 
     * @return the Database object
     */
    public Database setQuery(String query){ this.query = query; return this; }
    
    
    /**
     * Public function that performs the current query execution and returns a result set
     * @return ResultSet the result set on the query
     */
    public ResultSet performQuery() throws SQLException{ return this.statement.executeQuery(this.query); }
    
}
