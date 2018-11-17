

//Songs questions

 // Array of trivia data
 var TriviaData = new Array(10)
 createTwoDimensionalArray(3);

 // Variables to track state of the game
 // i.e. number questions asked, current correct total and current question
 var questionsAsked = 0;
 var totalCorrect = 0;
 var currentQuestion = 0;
 var selectionValid = false;

 // Questions
 TriviaData[0][0] = "Freddie Mercury is still alive.";
 TriviaData[1][0] = "David Bowie collaborated with Queen.";
 TriviaData[2][0] = "Freddie Mercury's real name is Farrokh Bulsara.";
 TriviaData[3][0] = "The video for ‘I Want To Break Free’, which sees the band doing housework in drag, was Roger’s idea.";
 TriviaData[4][0] = "Brian May and Roger Taylor were playing in the band Revature alongside Tim Staffell.";
 TriviaData[5][0] = "Freddie had one extra tooth that caused him an overbite.";
 TriviaData[6][0] = "Brian May has a PhD in astrophysics from Imperial College London.";
 TriviaData[7][0] = "Some of the animated footage in their video for 'These Are The Days Of Our Lives' was created by animators for the Walt Disney Company.";
 TriviaData[8][0] = "Mercury had a long-term relationship with Mary Dallas.";
 TriviaData[9][0] = "Freddie Mercury favored dogs over cats.";

 // Answers
 TriviaData[0][1] = "false";
 TriviaData[1][1] = "true";
 TriviaData[2][1] = "true";
 TriviaData[3][1] = "true";
 TriviaData[4][1] = "false";
 TriviaData[5][1] = "false";
 TriviaData[6][1] = "true";
 TriviaData[7][1] = "true";
 TriviaData[8][1] = "false";
 TriviaData[9][1] = "false";

 // Has question been asked
 // -- necessary because we are asking in random order
 TriviaData[0][2] = "no";
 TriviaData[1][2] = "no";
 TriviaData[2][2] = "no";
 TriviaData[3][2] = "no";
 TriviaData[4][2] = "no";
 TriviaData[5][2] = "no";
 TriviaData[6][2] = "no";
 TriviaData[7][2] = "no";
 TriviaData[8][2] = "no";
 TriviaData[9][2] = "no";

 // Load up first question
 setQuestion();
 // Sets question text and indicator so that we know the question has been displayed
 function setQuestion() {
     selectionValid = false; // Flag to make sure question has not been asked yet
     while (selectionValid == false) {
         currentQuestion = Math.floor(Math.random() * 10); // randomly select starting question
         if (TriviaData[currentQuestion][2] == "no") {
             selectionValid = true;
         }
     }
     document.getElementById("TriviaQuestion").innerHTML = TriviaData[currentQuestion][0];
     TriviaData[currentQuestion][2] = "yes";
     questionsAsked = questionsAsked + 1;
 }

 function processAnswer(myAnswer) {
     if (TriviaData[currentQuestion][1] == myAnswer) {
         // answer correct
         totalCorrect = totalCorrect + 1;
     }
 }

 // This function creates our two dimensional array
 function createTwoDimensionalArray(arraySize) {
     for (i = 0; i < TriviaData.length; ++i)
         TriviaData[i] = new Array(arraySize);
 }

 // This function checks the answer, updates correct total
 // and randomly selects the next question
 function checkAnswer() {
     if (document.getElementById("RadioTrue").checked) {
         processAnswer("true");
     }
     else {
         processAnswer("false");
     }
     // get next question if not asked all yet
     if (questionsAsked < 10) {
         setQuestion();
     }
     // final question asked - disable button and show final results
     else {
         alert("Quiz complete! You got " + totalCorrect + " correct out of 10.");
         document.getElementById("ButtonContinue").disabled = true;
     }
     // update totals
     document.getElementById("NumberAsked").innerHTML = questionsAsked;
     document.getElementById("NumberCorrect").innerHTML = totalCorrect;
 }
 // Reload page to restart quiz
 location.reload();







 let state = {
  movie: ''
};

const apiUrl = 'https://www.themoviedb.org/authenticate/019f4ff823c8d1b6e89faab78c31213b';

//using promises
let movies = function() {
  fetch(apiUrl, {method: "GET", headers:{"Accept":"application/json"}})
  //define behavior for when the response returns
  .then((response) => {
      //return unwrapped promise object for the next chaining operation
      return response.json();
  })
      //utilize unwrapped promise a javascript object
  .then((data) => {
      console.log(data);
      state.movie = data.movie;
      updateContent();
  })
      //what if there's a problem?
  .catch( (error) => {
      alert('oh no :(');
      console.log(error);
  });
}

let updateContent = function() {
  console.log(state);
  //select movie 
  const movieElement = document.getElementById('movie-field');
  movieElement.innerText = state.movie;
}

document.getElementById('new-movie-button').addEventListener('click', movies);







