/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(num1, num2) {
  let result = num1 * num2;
  return result;
  // alternate solution: return num1 * num2
}
/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 * 
 * We can supply default values for parameters that are missing
 * Simply code the parameterName=defaultValue
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
function multiplyNoUndefined(firstParameter=0, secondParameter=0) {
  console.log(`1st Parameter: ${firstParameter}`)
  console.log(`2nd Parameter: ${secondParameter}`)
return firstParameter * secondParameter;
}


 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;  // terminate the function and return to the caller
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function - defined in the function block
  let inScopeInScopeTest = true;

  { // scopedToBlock variable is created here
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  } // scopedToBlockVariable is destroyed here - no longer available to anyone

  console.log(`scopedToBlock: ${scopedToBlock}`);
  // scopedToBlock doesn't exist here so an error will be thrown
  {
    if (inScopeInScopeTest && scopedToBlock) {
      console.log("This won't print!");
    }
  }
  // var defines a variable with function scope regardless of where it is defined

  var scopedToBlock = 1;  // This variable is available anywhere in the function
}

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  // join is going to take the elements in an array and makes them a string with the separator between them
  return description + listOfQuirks.join(separator);
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 * 
 * .reduce() - return an array reduced/converted to a single value using a function as an argument
 * .reduce() - goes through the array one element at a time (implied for-loop) passing the element to the function used as the argument
 * 
 *     syntax: arrayName.reduce(anonymous-function(reducer, element-in-array))
 * 
 *              the anonymous function takes two parameters: reducer and element-in-array
 * 
 *              the reducer will hold the value from the previous call to the anon function
 *                  (result) from prior execution of the anon function
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */

function sumAllNumbers(numbersToSum) {
  // the variable sum (reducer) will contain the sum of all numbers in the array
  //
  // the anon-func will change the value in sum (reducer) each time its called
  //
  // the variable aNumber will be the current element in the array passed to the anonymous function
  return numbersToSum.reduce((sum,aNumber) =>  {
                                                    return sum += aNumber; // return the result of adding
                                                                          //      the current array element
                                                                          //      to the current sum
                                                });
}

/* To achieve the same result without .reduce

int sum = 0;
for (int i=0; i < numbersToSum.length; i++)
  sum += numberToSum[i];

  return sum;

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  

  
}


/**
 * This example was added by Frank at the last minute and has no test.
 * Give the browser the html and use the inspect to to run it
 * 
 * The map function will return an array created from the elements passed to it
 * 
 * @param - None
 * @returns {arrray created from values passed to it}
 */

function mapArrayFunctionExampleFromBook() {
let numbersToSquare = [1, 2, 3, 4];
console.log(`Array calling map to create new array with values squared: `)
console.table(numbersToSquare);

let squaredNumbers = numbersToSquare.map( (number) => {
    return number * number;
});

console.log(`Array returned from map with values in passed array squared: `)
console.table(squaredNumbers);
}
