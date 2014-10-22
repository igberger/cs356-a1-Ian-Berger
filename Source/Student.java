//Ian Berger
//CS356
//Assignment 1
import java.util.Random;
public class Student
{
   private String id;
   
   public Student(String id)
   {
      this.id = id;
   }
   
   public String getID()
   {
      return id;
   }
   public boolean[] getAnswer(Question q)
   {
      boolean[] answer = new boolean[q.getNumberOfAnswers()];
      Random r = new Random();
      
      //Randomly generate answer
      if(q.multipleAnswers())//Randomly pick answers
      {
         for(int i=0; i<q.getNumberOfAnswers(); i++)
            if(r.nextInt(2)==1)
               answer[i] = true;
      }
      
      else//Randomly select answer to pick
         answer[r.nextInt(q.getNumberOfAnswers())] = true;
      
      return answer;
   }
}