# OOP Project - OOP TV

### Arghir Monica-Andreea 322CA



For implementing the platform which imitates a Netflix format I created several packages, classes and interfaces in order to have a very practical and well organized code.

* I started from the Main class which contains the starting point of the project.
* In the input package I extracted the data from the json files
* In the output package I created json formats
* I also have a package designed for verifying certain errors 
* Moving on to the solving package which contains the class that takes every action from the input and executes the specific method for it. For implementing it I used the singleton design pattern, so I could create just one instance since I'm only using it to start checking the actions in the main function. In this package we can also find the class that implements the recommendation method that calculates the best movie that a premium member hasn't seen yet and sends a notification to the user.
* Lastly we have the package that contains the type of actions:
    * The first one is designed for the back action which takes the user on the previous page he was on
    * The second one is for the change page type of action which contains the interface for it and the classes that implement this. For this type of action I implemented the factory design pattern.
    * The third one is designed for the actions that add and delete a certain movie from the database (also using factory design pattern)
    * The last one is very similar to the change page, as it implements the on page actions. Along others, we have a very important action, filter. In order to do that I used the strategy design pattern (and put it in a different package) as it differs from action to action.


