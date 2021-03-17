const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [   // array containing the data to be displayed on the page
  {                 // each array element is an object with several attributes
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name stored in a variable at the top of this file to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
// Get a reference to the id='page-title' so we can change it
// .getElementById() take an id="" value as an argument
const thePageTitle = document.getElementById('page-title')  // get me to the element with the id='page-title'
//      could have also said .querySelector('#id') too
// Get a reference to the <span> element (class='name') of the page title
// .querySelector() takes any valid css selector as an argument
const theSpan = thePageTitle.querySelector('.name') // Get me to the element with the class='name' of thePageTitle

// Set the text in the <span> to the contents of the variable name (product description)
theSpan.innerText = name;  // innerText represents the text in an element
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
// Get a reference to the element with the class="description"
const theDescription = document.querySelector('.description')
theDescription.innerText = description;   // Set the text of theDescription to variable description
//  alternative: document.querySelect('.description).innerText = description;

}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions (defined below)
 * to create the elements needed for our our html and add them to the DOM
 */
function displayReviews() {
  // Get a reference to where we want to add the reviews - in the <div> with the id='main'
  const theDiv = document.getElementById('main')

  // Loop through the array of reviews, adding an element to the DOM for each review
  // Use a .forEach array function with an anonymous function to do this
  reviews.forEach((aReview) => {
      // create a new html element to hold the current review
      const newReview = document.createElement('div'); // create a <div> element to add to the DOM

      // add class="review" to the <div>
      newReview.setAttribute('class', 'review')

      // Call each helper function to add it's contribution to our DOM
      // Each helper function takes the parent element it belongs to and the data to be included in the element
      //      the element in belongs to is the newReview element and the data is an attribute of the current array element

      addReviewer(newReview, aReview.reviewer) // Call addReviewer with the reviewer from the array
       addRating(newReview, aReview.rating)     // Call addRating with the rating from the array
       addTitle(newReview, aReview.title)       // Call addTitle with the title from the array
       addReview(newReview, aReview.review)   // Call addReviewer with the review from the array

      // Now we have all the elements for a review defined and connected to a new <div>
      //    all that's left is to add the new <div> to the DOM
      theDiv.insertAdjacentElement('beforeend', newReview) // add the new <div> before the end of theDiv (main)
      
  })


}

/**
 * I will creating a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} el: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const aReviewer = document.createElement('h4')
  aReviewer.innerText = name; // Set the text of the h4 to the name passed into the function
  parent.appendChild(aReviewer); // Connect the new h4 element to the parent html element passed in
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  // create the <div> to hold the star img tags (i img for each rating value)
  const starDiv = document.createElement('div')
  starDiv.setAttribute('class', 'rating') // add class="rating" to the div
  // generate one <img> for each value in the rating
  for(let i=0; i < numberOfStars; i++) {
    const starImg = document.createElement('img')   // create an <img>
    starImg.src='img/star.png'                      // set src="img/star.png"
    starImg.setAttribute('class', 'ratingStar')     // set class="ratingStar"
    starDiv.appendChild(starImg)                    // add img tag to <div> for rating
  }
  parent.appendChild(starDiv)
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const aTitle = document.createElement('h3')
  aTitle.innerText = title;
  parent.appendChild(aTitle);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const aReview = document.createElement('p')
  aReview.innerText = review;
  parent.appendChild(aReview)

}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
