"""Learning how to make a one shot wordle"""

__author__ = "730459812"

#creating the secret word
secret_word: str = "sara"

#prompting the user for their six letter word
user_guess: str = input(f" What is your {len(secret_word)}-letter guess? ")

#making sure the word is the correct length
while len(user_guess) != len(secret_word):
    user_guess = str = input(f"That was not {len(secret_word)}-letters! Try again: ")

#Character boxes
WHITE_BOX: str = "\U00002B1C"
GREEN_BOX: str = "\U0001F7E9"
YELLOW_BOX: str = "\U0001F7E8"

#checking indicies for correct matches
index_of_guess: int = 0
resulting_emoji_of_guess: str = ""

#showing the correct emojies
while index_of_guess < len(secret_word):
    if ord(user_guess[index_of_guess]) == ord(secret_word[index_of_guess]):
        resulting_emoji_of_guess += GREEN_BOX
    else:
        guess_exists: bool = False
        alternate_indices: int = 0
        while (guess_exists == False) and (alternate_indices < len(secret_word)):
            if ord(secret_word[alternate_indices]) == ord(user_guess[index_of_guess]):
                guess_exists = True
            else:
                alternate_indices += 1
        if guess_exists == True:
            resulting_emoji_of_guess += YELLOW_BOX
        else:
            resulting_emoji_of_guess += WHITE_BOX
    index_of_guess += 1

print(resulting_emoji_of_guess)

#verifying the guess or not
if user_guess == secret_word:
    print("Woo! You got it!")
else:
    print("Not quite. Play again soon!")