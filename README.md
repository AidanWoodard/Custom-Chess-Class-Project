# **ASCII Chess with Custom Ruleset**

## **Purpose**

### **CS II Final Project**

This fundamental chess game written in Java and interacted with through the terminal. It is the final project for Computer Science Fundamentals II and explicitly requires writing a new chess piece while maintaining core OOP principles in Java and a maintainable codebase.

### **Custom Bishop**

Implemented with ~400 lines of Java, the custom bishop is effectively "married" to it's twin. **Both can move one space left or right if that adjacent space is available for both pieces.** This allows more complex gameplay and a coding challenge.

## **Installation**

Clone the repository into a Java-friendly IDE:

> git init . && git clone https://github.com/AidanWoodard/Custom-Chess-Class-Project.git

Then run *Main.java*.

## **Usage Guidelines**

### **Gameplay**

When running the program, enter input into the terminal based on the provided moves, represented by corresponding numbers. **Example:**

> User's turn to move. Options:  
> ...  
> 2. c4  
> 3. d4  
> **4. e4**  
> ...
> 
> User Input: 4  
> **(Move king-side pawn forward 2 spaces to E4)**

### **Moving the Custom Piece**

The custom bishops move like any other piece. However, among the list of move options will be up to four additional move options for the bishops, allowing for horizontal motion **limited to one space.** This will effectively change the color of square that each bishop can attack, creating interesting gameplay.

However, both bishops must move simultaneously, and capturing is not allowed during horizontal motion.

## **Contribution Guidelines**

Anyone can contribute to this project, and all of the code is available here. The custom chess piece does **NOT** limit regular chess gameplay. If a contributor wants to enable normal chess gameplay, the custom piece can be removed easily in code. To do so:

- In Main.java create a ConventionalBoardFactory.java object in place of the CustomPieceBoardFactory.java object that is currently called.
- In Main.java create a standard Console.java object in place of the CustomPieceConsole.java object.
- The custom piece object or objects that call it do **NOT** need to be rewritten, as the class is modular and is not a dependency for play.
