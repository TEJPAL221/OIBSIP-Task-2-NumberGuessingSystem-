# OIBSIP-Task-2-NumberGuessingSystem-
# 🎯 Guess The Number – Java Game

### 🧠 Developed by: [Your Name]  
### 🏢 Internship: Oasis Infobyte – Java Development Internship  
### 📅 Internship Duration: [Month, Year]

---

## 📋 Project Description

**Guess The Number** is a simple yet interactive Java-based console game where players attempt to guess a randomly generated number within a defined range and limited attempts. The game spans multiple rounds and awards scores based on guessing accuracy and efficiency.

This project was developed as part of the **Oasis Infobyte Java Development Internship** to demonstrate core Java programming skills, logic building, and user interaction through the command-line interface.

---

## 🚀 Features

- 👤 **Player Name Input**
- 🔢 **Random Number Generation**
- ⏳ **Limited Attempts per Round**
- 🎮 **Multi-Round Gameplay (3 rounds)**
- 🧮 **Dynamic Scoring System**
- 🏆 **Achievements Based on Final Score**
- 💻 **User-friendly Console Interface**

---

## 🛠️ Technologies Used

- **Java SE (JDK 17 or higher)**
- **Command-Line Interface (CLI)**
- **OOP (Object-Oriented Programming) Concepts**
- **Random Number Generation**
- **Input Validation with Exception Handling**

---

## 🗂️ File Structure

GuessTheNumber/
│
├── GuessTheNumber.java # Main application file
├── README.md # Project documentation

yaml
Copy
Edit

---

## 🏁 Getting Started

### ✅ Prerequisites

- Java Development Kit (JDK 17 or higher)
- Terminal / Command Prompt

### 🔧 How to Run the Game

1. **Clone or download** the project folder.
2. Open the terminal and navigate to the project directory:


cd "C:\path\to\your\GuessTheNumber"
Compile the Java file:

javac GuessTheNumber.java
Run the program:

java GuessTheNumber
Follow the on-screen instructions to play the game!

📸 Sample Gameplay

=== WELCOME TO GUESS THE NUMBER ===
Try to guess the number between 1 and 100
You have 10 attempts per round
There are 3 rounds in total
Good luck!

Please enter your name: Alex

Hello, Alex! Let's begin.

=== ROUND 1 ===
I'm thinking of a number between 1 and 100

Attempts left: 10
Enter your guess: 45
Not quite! The number is higher than your guess.
...
🎉 CONGRATULATIONS! You've guessed the number correctly!
Round score: 85 points
...
=== FINAL RESULTS ===
Player: Alex
Total Score: 245 points
Performance: 81.7%
Achievement: SKILLED PLAYER
🏆 Scoring Logic
Score is calculated based on the number of attempts taken.

Maximum score per round: 100

Minimum score (if guessed at last attempt): 10

If player fails to guess: 0 points

Achievements:
Score %	Achievement
90% - 100%	MASTER GUESSER
70% - 89%	SKILLED PLAYER
50% - 69%	GOOD EFFORT
30% - 49%	NOVICE
Below 30%	BEGINNER

