/*
 * UNCG Typing Tutor
 */

/**
 * Algorithm Class for the UNCG Typing Tutor
 * @author Rui Da
 */
public class Algorithm {
    
    /**
     * Get user typing accuracy
     * @param textTutor string for the tutor input
     * @param textUser string for the user input
     * @return double for the accuracy
     */
    public double getAccuracy(String textTutor, String textUser)
    {
        int miss = 0;
        double result;
        
        for(int i = 0; i < textTutor.length(); i++)
        {
            if(textUser.charAt(i) != textTutor.charAt(i))
                miss++;
        }
        
        result = (double)miss / (double)textTutor.length();
        
        return result;
    }
    
    /**
     * Get user lefthand typing accuracy
     * @param textTutor string for the tutor input
     * @param textUser string for the user input
     * @return double for the accuracy
     */
    public double getLeftAcc(String textTutor, String textUser)
    {
        int miss = 0, total = 0;
        double result;
        
        for(int i = 0; i < textTutor.length(); i++)
        {
            if(((textUser.charAt(i) >= 97 && textUser.charAt(i) <= 103)
             || (textUser.charAt(i) >= 113 && textUser.charAt(i) <= 116)
             || (textUser.charAt(i) >= 118 && textUser.charAt(i) <= 120)
             || textUser.charAt(i) == 'z'))
            {
                total++;
                if (textUser.charAt(i) != textTutor.charAt(i))
                {
                    miss++;
                }
            }
        }
        
        result = (double)miss / (double)total;
        
        return result;
    }
    
    /**
     * Get user righthand typing accuracy
     * @param textTutor string for the tutor input
     * @param textUser string for the user input
     * @return double for the accuracy
     */
    public double getRightAcc(String textTutor, String textUser)
    {
        int miss = 0, total = 0;
        double result;
        
        for(int i = 0; i < textTutor.length(); i++)
        {
            if((textUser.charAt(i) >= 104 && textUser.charAt(i) <= 112)
             || textUser.charAt(i) == 'u'
             || textUser.charAt(i) == 'y')
            {
                total++;
                if (textUser.charAt(i) != textTutor.charAt(i))
                {
                    miss++;
                }
            }
        }
        
        result = (double)miss / (double)total;
        
        return result;
    }
    
    /**
     * Get user typing accuracy of combination characters(capital letters)
     * @param textTutor string for the tutor input
     * @param textUser string for the user input
     * @return double for the accuracy
     */
    public double getCombAcc(String textTutor, String textUser)
    {
        int miss = 0, total = 0;
        double result;
        
        for(int i = 0; i < textTutor.length(); i++)
        {
            if(textUser.charAt(i) >= 65 && textUser.charAt(i) <= 90)
            {
                total++;
                if (textUser.charAt(i) != textTutor.charAt(i))
                {
                    miss++;
                }
            }
        }
        
        result = (double)miss / (double)total;
        
        return result;
    }
    
    /**
     * Get user typing accuracy of numbers
     * @param textTutor string for the tutor input
     * @param textUser string for the user input
     * @return double for the accuracy
     */
    public double getNumAcc(String textTutor, String textUser)
    {
        int miss = 0, total = 0;
        double result;
        
        for(int i = 0; i < textTutor.length(); i++)
        {
            if(textUser.charAt(i) >= 48 && textUser.charAt(i) <= 57)
            {
                total++;
                if (textUser.charAt(i) != textTutor.charAt(i))
                {
                    miss++;
                }
            }
        }
        
        result = (double)miss / (double)total;
        
        return result;
    }
    
    /**
     * Get user typing speed.
     * @param startTime double for starting time
     * @param endTime double for ending time
     * @param textLength integer for text length
     * @return double for speed
     */
    public double getSpeed(double startTime, double endTime, int textLength)
    {
        return (endTime - startTime) / (double)textLength;
    }
}
