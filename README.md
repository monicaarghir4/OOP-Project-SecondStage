# OOP Project - OOP TV

### Arghir Monica-Andreea 322CA



For implementing the platform which imitates a Netflix format I created several packages, classes and interfaces in order to have a very practical and well organized code.

* I started from the Main class which contains the starting point of the project.
* In the input package I extracted the data from the json files
* In the output package I created json formats
* I also have a package designed for verifying certain errors 
* Moving on to the solving package which contains the class that takes every action from the input and executes the specific method for it. For implementing it I used the singleton design pattern, so I could create just one instance since I'm only using it to start checking the actions in the main function. 
* Lastly we have two main interfaces implemented by a lot of classes used to build a factory design pattern:
    * The first one is designed for the change type of action
    * The second one is for the on page type


