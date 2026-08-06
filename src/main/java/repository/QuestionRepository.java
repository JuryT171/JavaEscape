package repository;

import model.Answer;
import model.Question;

import java.util.List;

public class QuestionRepository {

    private final List<Question> questions;

    public QuestionRepository() {

        questions = List.of(

                new Question(
                        0,
                        "Oracle",
                        "Какой принцип ООП позволяет скрывать внутреннюю реализацию объекта?",
                        List.of(
                                new Answer("Наследование", false),
                                new Answer("Инкапсуляция", true),
                                new Answer("Полиморфизм", false),
                                new Answer("Абстракция", false)
                        )
                ),


                new Question(
                        1,
                        "JetBrains",
                        "Какой модификатор доступа делает поле доступным только внутри класса?",
                        List.of(
                                new Answer("public", false),
                                new Answer("protected", false),
                                new Answer("private", true),
                                new Answer("static", false)
                        )
                ),


                new Question(
                        2,
                        "Google",
                        "Как называется способность объекта иметь разные формы?",
                        List.of(
                                new Answer("Инкапсуляция", false),
                                new Answer("Полиморфизм", true),
                                new Answer("Компиляция", false),
                                new Answer("Интерфейс", false)
                        )
                ),


                new Question(
                        3,
                        "Microsoft",
                        "Какой класс является родителем всех классов в Java?",
                        List.of(
                                new Answer("Main", false),
                                new Answer("Object", true),
                                new Answer("Class", false),
                                new Answer("Parent", false)
                        )
                ),


                new Question(
                        4,
                        "Amazon",
                        "Что делает ключевое слово final у переменной?",
                        List.of(
                                new Answer("Позволяет менять значение", false),
                                new Answer("Запрещает изменение значения", true),
                                new Answer("Создает новый объект", false),
                                new Answer("Удаляет объект", false)
                        )
                ),


                new Question(
                        5,
                        "OpenAI",
                        "Какая коллекция не допускает повторяющихся элементов?",
                        List.of(
                                new Answer("ArrayList", false),
                                new Answer("HashMap", false),
                                new Answer("HashSet", true),
                                new Answer("LinkedList", false)
                        )

                )
        );

    }

    public List<Question> getQuestions() {

        return questions;
    }
}