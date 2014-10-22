//Ian Berger
//CS356
//Assignment 1
import java.util.Hashtable;
public class IClickerService
{
   private Question question;
   private int[] answerTally;
   private Hashtable<String, boolean[]> submissions;
   private int totalSubmissions, uniqueSubmissions;
   public IClickerService(Question question)
   {
      this.question = question;
      answerTally = new int[question.getNumberOfAnswers()];
      submissions = new Hashtable<String, boolean[]>();
      totalSubmissions = uniqueSubmissions = 0;
   }
   
   public void setQuestion(Question question)
   {
      this.question = question;
      answerTally = new int[question.getNumberOfAnswers()];
      submissions = new Hashtable<String, boolean[]>();
      totalSubmissions = uniqueSubmissions = 0;
   }
   
   public void submit(String id, boolean[] answer)//answer.size()==question.getNumberOfAnswers()
   {
	  totalSubmissions++;
      for(int i=0; i<question.getNumberOfAnswers(); i++)//Increment tally for each answer submitted by student
         if(answer[i])
            answerTally[i]++;
      
      answer = submissions.put(id, answer);//Hash student's answer and set answer to their previous answer (if any)
      
      if(answer!=null)//Student already submitted an answer
      {
         for(int i=0; i<question.getNumberOfAnswers(); i++)//Decrement tally for each answer previously submitted by student
            if(answer[i])
               answerTally[i]--;
      }
      else//Student has not submitted an answer
    	uniqueSubmissions++;
            	
   }
   public void printStats()
   {
	  if(question.multipleAnswers())
	  {
		 System.out.println("Multiple Answer:");
	  }
	  else
	  {
		 System.out.println("Single Answer:");
	  }
	  
	  System.out.println("Total Submissions: " + totalSubmissions);
	  System.out.println("Unique Submissions: " + uniqueSubmissions);
	  
      for(int i=0; i<question.getNumberOfAnswers(); i++)
      {
         System.out.print(question.getAnswer(i) + ": ");
         System.out.println(answerTally[i]);
      }
   }
}