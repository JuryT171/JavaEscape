let selectedAnswer = null;


document.addEventListener("DOMContentLoaded", loadQuestion);


function loadQuestion() {

    fetch("game")
        .then(response => response.json())
        .then(question => {


            document.getElementById("company").innerText =
                "🚪 " + question.company;


            document.getElementById("question").innerText =
                question.text;


            const answersDiv =
                document.getElementById("answers");


            answersDiv.innerHTML = "";


            question.answers.forEach((answer, index) => {

                const button =
                    document.createElement("button");


                button.innerText = answer.text;

                button.className = "answer";


                button.onclick = function () {

                    selectedAnswer = index;


                    console.log(
                        "Выбран ответ:",
                        selectedAnswer
                    );

                };


                answersDiv.appendChild(button);

            });

        });

        document
            .getElementById("answerButton")
            .onclick = sendAnswer;



        function sendAnswer() {


            if (selectedAnswer === null) {

                alert("Выберите ответ");

                return;
            }


            fetch("answer", {

                method: "POST",

                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },

                body:
                    "answerIndex=" + selectedAnswer

            })

            .then(response => response.json())

            .then(result => {


                if (result.finished) {


                    if (result.won) {

                        alert(
                            "🎉 Победа! Оффер получен!"
                        );

                    } else {

                        alert(
                            "❌ Игра окончена"
                        );

                    }


                } else {

                    selectedAnswer = null;

                    loadQuestion();

                }

            });

            function showResult(result) {


                document.getElementById("company")
                    .style.display = "none";


                document.getElementById("question")
                    .style.display = "none";


                document.getElementById("answers")
                    .style.display = "none";


                document.getElementById("answerButton")
                    .style.display = "none";


                const resultDiv =
                    document.getElementById("result");


                resultDiv.style.display = "block";


                if (result.won) {


                    document.getElementById("resultTitle")
                        .innerText =
                        "🎉 Поздравляем!";


                    document.getElementById("resultText")
                        .innerText =
                        "Ты прошел весь лабиринт компаний! " +
                        "Правильных ответов: " +
                        result.score;


                } else {


                    document.getElementById("resultTitle")
                        .innerText =
                        "❌ Игра окончена";


                    document.getElementById("resultText")
                        .innerText =
                        "Ты не смог открыть все двери. " +
                        "Правильных ответов: " +
                        result.score;

                }

                function restartGame() {

                    window.location.href = "index.html";

                }

            }

        }

}