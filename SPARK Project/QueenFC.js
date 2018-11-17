

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



// The Movie DataBase fetch of the Bohemian Rhapsody Movie Poster

 let baseURL = 'https://api.themoviedb.org/3/';
        let configData = null;
        let baseImageURL = null;
        
        let getConfig = function () {
            let url = "".concat(baseURL, 'configuration?api_key=', APIKEY); 
            fetch(url)
            .then((result)=>{
                return result.json();
            })
            .then((data)=>{
                baseImageURL = data.images.secure_base_url;
                configData = data.images;
                console.log('config:', data);
                console.log('config fetched');
                runSearch('Bohemian Rhapsody')
            })
            .catch(function(err){
                alert(err);
            });
        }
        
        let runSearch = function (keyword) {
            let url = ''.concat(baseURL, 'search/movie?api_key=', APIKEY, '&query=', keyword);
    //FETCH REQUEST
            fetch(url)
            .then(result=>result.json())
            .then((data)=>{
                //process the returned data
                document.getElementById('output').innerHTML = JSON.stringify(data, null, 4);
                //work with results array...
                
            })
        }
        
        document.addEventListener('DOMContentLoaded', getConfig);
        /*******************************
        SAMPLE SEARCH RESULTS DATA
        {
      "vote_count": 981,
      "id": 424694,
      "video": false,
      "vote_average": 8.3,
      "title": "Bohemian Rhapsody",
      "popularity": 157.171,
      "poster_path": "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
      "original_language": "en",
      "original_title": "Bohemian Rhapsody",
      "genre_ids": [
        18,
        10402
      ],
      "backdrop_path": "/pbXgLEYh8rlG2Km5IGZPnhcnuSz.jpg",
      "adult": false,
      "overview": "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
      "release_date": "2018-10-24"
          },
          ********************************/






