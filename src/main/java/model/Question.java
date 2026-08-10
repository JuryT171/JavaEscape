package model;

import java.util.List;

public class Question {

    private int id; // номер вопроса
    private String company;
    private String text; // текст вопроса
    private List<Answer> answers;  // лист с ответами


    public Question() {
    }

    public Question(int id, String company, String text, List<Answer> answers) {
        this.id = id;
        this.company = company;
        this.text = text;
        this.answers = answers;
    }


    public int getId() {
        return id;
    }
    public String getCompany() {
        return company;
    }
    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public boolean checkAnswer(int answerIndex) {
        return answers // берем список ответов
                .get(answerIndex) // каждый ответ по индексу
                .isCorrect(); // проверяем
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }
}