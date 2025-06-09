from ast import Or
import random
from re import L


User=str(input("Welcome to the Guessing Game! What is your name? "))

Answer=random.randint(1,20)
print(Answer)

chance=4; #The numbers of chances the user has

while True:
    if User.isalpha():
        print("That's great " + User)
        break
    else:
        User = str(input("I'm very sure that's not a name. Please enter your name: "))
    


print("Hello"+".") , print("\nI'm thinking of a number between 1 and 20. Can you guess it? You will have 4 chances in total")

Guess=int(input("Input your guess: "))
while (Guess <0 or Guess >20):
    Guess=int(input("Please input a number between 1 and 20: "))

    
while (Guess != Answer) and (chance>=1):
    if Guess < Answer:
        if Guess == (Answer - 1 | Answer - 2 | Answer - 3):
            print("You have",chance,"chance(s) left.")
            Guess = int(input("\nYour guess was very close, but low. Please try again: "))
            
        else:
            print("You have",chance,"chance(s) left.")
            Guess = int(input("\nYour guess was low, please try again: "))
            
    elif Guess > Answer:
        if Guess == (Answer-1 or Answer-2 or Answer-3):
            print("You have",chance,"chance(s) left.")
            Guess = int(input("\nYour guess was very close, but high. Please try again: "))
            
        else:
            
            print("You have",chance,"chance(s) left.")
            Guess = int(input("\nYour guess was high, please try again: "))
                
    chance=chance-1


if (chance<1 and Guess!=Answer):
    print("\nYou are out of chances; try playing again.")

if Guess==Answer:
    print("\nCongrats! Your guess",Guess,"was the right answer. Your prize is drawing your ringing phone to your attention...... HAHA! Got you! But for real; good job!" )


    




