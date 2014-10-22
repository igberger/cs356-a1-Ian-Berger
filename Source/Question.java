//Ian Berger
//CS356
//Assignment 1
public class Question
{
   boolean multiple;
   private String[] answers;
   public Question(boolean multiple, String[] answers)
   {
      this.multiple = multiple;
      this.answers = answers;
   }
   
   public boolean multipleAnswers()
   {
      return multiple;
   }
   public int getNumberOfAnswers()
   {
      return answers.length;
   }
   public String getAnswer(int i)
   {
      return answers[i];
   }
}