/* Define any shared data required by the app 
    Score
     Set of problems
        Each problem has:
                Left-side number for the multiple
                Right-side number
                Current answer
                Set of answers
*/
let score = 0;              /* Hold score for set of problems for the user */
let setOfProblems = [];     /* Hold set of problems to be presented to the user */
let currentProblem = 1;      /* the number of the problem the user is currently seeing */


/* Generate a problem set containing 10 problems. We'll put it in a function because we'll probably want to use this more than once */
function generateProblemSet() {
    for(let i =0; i <10; i++) {     
        /* Randomly generate a single multiplication problem */
        /* Define a problem to hold the values we generate */
        let problem = {
            left: getRandomNumber(10),   /* should be random value between 0 and 9*/
            right: getRandomNumber(10),  /* should be random value between 0 and 9*/
            correctAnswer: null,        /* right now, we don't know the correct answer*/
            
        }
        
        /* determine the correct answer to the problem*/
        problem.correctAnswer = problem.left * problem.right; /* calculate the correct answer based on the random values */
        /* the set of answers needs to have the correct answer and 3 random other answers */
        /*      we are not worried if the correct answer happens to be one of the randomly generated ones */
        /* randomize/shuffle the elements in the setOfAnswers so the correct answer is not always first */
        let setOfAnswers = 
                shuffleArray([problem.correctAnswer, getRandomNumber(82), getRandomNumber(82), getRandomNumber(82)])
        

        /* Add the problem and the set of answers to the problem set */

        setOfProblems.push({problem, setOfAnswers}) // Each array element has two attributes in an object
    }
}
/* Show the problem to the user */
function displayProblem() { // Add a single problem to the DOM so it displays
    const theProblem = document.getElementById('problem')   // Get a reference to where the expression is going in the DOM
    // expression elements (left / right values) are in an element in an array (setOfProblems)
    const problemExpression = `${setOfProblems[currentProblem-1].problem.left} * ${setOfProblems[currentProblem-1].problem.right}`; // left side * right side
    // add the problem expression to the DOM so it displays
    theProblem.querySelector('div.expression').innerText = problemExpression;
}

/* show the answer choices to the user */
function displayAnswers() {
    const theAnswers    = document.getElementById('answers')
    const listOfAnswers = theAnswers.querySelector('ul')
    const allAnswers    = listOfAnswers.querySelectorAll('li')
    // Now we have all the list items to hold the answers in an array called allAnswers
    // Go through the array of <li> and assign each one to one of the answers choices

    // To make the code easier to read - extract the answer array from the problem
    const answerChoices = setOfProblems[currentProblem-1].setOfAnswers;

    for(let i=0; i<allAnswers.length; i++) {
        allAnswers[i].innerText = answerChoices[i]; // Assign the answerChoice to the corresponding element in the list items
    }
}

/* Randomly generate a single multiplication problem                                                    */
/* Show four randomly generated answers to the problem in a list across the page                        */

/* include the correct in the four answers displayed to the user                                        */
/* allow user to click on one of the answers displayed                                                  */
/* Update the problem count when the user selects an answer                                             */
/* Determine if the answer chosen was correct                                                           */
/* update score if answer was correct                                                                   */
/* Move/change to the next problem when user chooses and answer                                         */
/* Reset when the user wants to start over                                                              */
/* Have a utility function to generate random numbers for the problem and answers                       */




/**
 * Utility function to generate a random number based on max
 * @param {number} max
 */
 function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
  }
  
  /**
   * Utility function to shuffle the items in an array
   * @param {object} arr
   */
  function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
  }
    /*
    After the DOM has been fully loaded, we want to start displaying and setting up our app
    */

document.addEventListener('DOMContentLoaded', () => {

    /* add event listeners for the <li> tags to make them clickable */
    let answerListItems = document.querySelectorAll('#answers ul li')

    answerListItems.forEach((aListItem)  => {
        aListItem.addEventListener('click', (eventObject) => {
            const answerPicker = parseInt(eventObject.innerText); // extract the value from <li> clicked
            const correctAnswer = parseInt(setOfProblems[currentProblem-1].problem.correctAnswer)
            if(answerPicked === correctAnswer) {
                score++;
            }
        })
    })
    
    generateProblemSet();   // Generate a problem set
    displayProblem();       // Display a problem
    displayAnswers();       // Display answer choices

})