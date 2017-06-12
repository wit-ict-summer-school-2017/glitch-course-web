# Exercise 1:

~~~
const usersFirstName = prompt('enter first name');
const usersLastName = prompt('enter first name');
const usersAge = prompt('enter first name');

const user = {
  firstName: usersFirstName,
  lastName: usersFirstName,
  age: usersFirstName,
};

console.log(user);
~~~

# Exercise 2:

~~~
const usersFirstName = prompt('enter first name');
const usersLastName = prompt('enter last name');
const usersAge = prompt('enter your age');

const userGreeting = prompt('enter your greeting');

const user = {
  firstName: usersFirstName,
  lastName: usersFirstName,
  age: usersFirstName,
  greeting: userGreeting,
  sayHello() {
    console.log(this.greeting + ' says ' + this.firstName);
  },
};

console.log(user);
user.sayHello();
~~~

# Exercise 3:

~~~
Have a go yourself!
~~~