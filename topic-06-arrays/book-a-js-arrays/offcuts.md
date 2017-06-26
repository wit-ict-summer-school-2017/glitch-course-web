# Array Additional Topic

## Removing/Adding or both with splice

One of the more powerful array methods is `splice`, which allows you to either add to an array or remove elements or even do both! You can think of `splice` as a powerful generalization of `push`, `pop`, `unshift`, and `shift` all in one!

The splice method accepts at least two arguments. The first argument is the starting index, indicating where values will be removed or added. The second parameter is the number of values to remove. Optionally, you can pass in an unlimited number of additional arguments; these correspond to values you'd like to add to the array. The splice method always returns an array of the **removed** elements. Here are some examples:

~~~
const arr11 = [1, 2, 3, 4];
arr11.splice(0, 1); // returns [1]
console.log(arr11); // [2,3,4]
~~~

~~~
const arr12 = [1, 2, 3, 4];
arr12.splice(0, 1, 5); // returns [1]
console.log(arr12); // [5,2,3,4]
~~~

~~~
const arr12 = ['a', 'b', 'c', 'd'];
arr12.splice(1, 2, 'x', 'y', 'z'); // ['b', 'c']
console.log(arr12); // ['a', 'x', 'y', 'z', 'd']
~~~

## Exercise 3:

In the examples below, use `splice` to convert the first array to the second array:

~~~
[2, 3, 4, 5] -> [2, 4, 5]
["alpha", "gamma", "delta"] -> ["alpha", "beta", "gamma", "delta"]
[10,-10,-5,-3,2,1] -> [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
~~~

## Reference vs Value

An essential distinction between primitives and objects (including arrays, which are a type of object in JavaScript) is how their values are passed when assigned to new variables. Take a look at the following example:

~~~
var instructor = "Elie";
var anotherInstructor = instructor;
anotherInstructor // "Elie";

// Let's assign a new value to anotherInstructor:
anotherInstructor = "Matt";

instructor; // "Elie"
anotherInstructor; // "Matt"
~~~

In this example, even though we changed the `anotherInstructor` variable, it did not affect the `instructor` variable. This is because each one of these primitive types has a specific address in memory (it is a bit more complex than that, but we'll keep things simple to start). Another way to think of this is that when we assigned `anotherInstructor` to equal `instructor`, JavaScript created a copy of the string "Elie" and assigned that value to `anotherInstructor`. So even though those two variables were storing identical-looking strings, they can be modified independently of one another.

This may seem confusing until we compare this with what happens when dealing with reference types. Let's take a look at this array:

~~~
var instructors = ["Elie", "Matt"];
var instructorCopy = instructors;
instructorCopy.push("Tim");

instructorCopy; // ["Elie", "Matt", "Tim"]
instructors; // ["Elie", "Matt", "Tim"]
~~~

We see here that the `original` instructor array was changed when we pushed Tim to `instructorCopy`! This is because the `instructorCopy` did not create a new array, it just created a reference (or pointer) to the `instructors` array. In other words, unlike with our previous example, setting `instructorCopy` equal to `instructors` doesn't creat a _copy_ of the `instructors` array in JavaScript. Instead, both variable names refer to the exact same array!

This can take some time to wrap your head around. If you're curious, you can read more about the phenomenon of passing by value vs. passing by reference [here](http://stackoverflow.com/questions/518000/is-javascript-a-pass-by-reference-or-pass-by-value-language) and [here](http://stackoverflow.com/questions/6605640/javascript-by-reference-vs-by-value)

## Using split to turn a string into an array

Many times you will need to manipulate a string and turn it into an array. To split a string into an array you can use the `split` method and pass in a delimiter value.

~~~
var string = "hello world";
string.split(""); // ["h", "e", "l", "l", "o", " ", "w", "o", "r", "l", "d"]
string.split(" ");  // ["hello", "world"]
~~~

If you pass a delimiter into the `split` method, the delimiting values will be removed from the array:

~~~
var dashedString = "lots-of-dashes-here";
var removedDashes = dashedString.split("-");
removedDashes; // ["lots", "of", "dashes", "here"]
~~~

We can then join the array using the `join` method to bring it back to a string. You can think of the `split` as doing the opposite of what `join` does.

~~~
var dashedString = "lots-of-dashes-here";
var removedDashes = dashedString.split("-").join(" ");
removedDashes; // "lots of dashes here"
~~~

## Mutability

We've seen how you can update array values by simply accessing an array element and assigning it a new value:

~~~
var arr = ["hi", "bye"];
arr[0] = "hello";
arr; // ["hello", "bye"]
~~~

You can also access characters in strings using bracket notation:

~~~
var name = "Matt";
name[0]; // "M"
~~~

However, unlike with arrays, you can't reassign the value of a character in a string. If you try, JavaScript will simply ignore you:

~~~
var name = "Matt";
name[0] = "m";
name; // "Matt", not "matt"!
~~~

This distinction between arrays and strings highlights a concept called _mutability_. We say that arrays in JavaScript are mutable, since you can change any element inside of them via a simple reassignment. However, strings are _immutable_, as you cannot change the characters within them in the same way that you do with arrays. In fact, any operation which changes characters in a string actually produces a new string, rather than mutating the original string.

For more on mutability in JavaScript, you may want to check out [this](https://www.sitepoint.com/immutability-javascript/) article. Note: the article makes use of functions in JavaScript, so it may be best to read it after finishing the functions unit in this course.