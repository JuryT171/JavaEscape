import model.Answer;

public class TestAnswer {

    public static void main(String[] args) {

        Answer answer1 = new Answer("String", false);
        Answer answer2 = new Answer("int", true);

        System.out.println(answer1);
        System.out.println(answer2);

        if(answer2.isCorrect()){
            System.out.println("Правильный ответ!");
        }
    }
}
