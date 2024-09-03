"""Learning how to make a wordle."""

__author__ = "730459812"


def contains_char(string_that_gets_searched: str, character_trying_to_find: str) -> bool:
    """When given two strings, the 1st of any len, the 2nd of 1 char, it will return true if the single charac is found in 1st string."""
    assert len(character_trying_to_find) == 1
    # Will search word until we run out of indexes or true is returned.
    alternate_index_of_string: int = 0
    while alternate_index_of_string < len(string_that_gets_searched):
        if ord(string_that_gets_searched[alternate_index_of_string]) == ord(character_trying_to_find):
            # Character is present.
            return True
        # Character is not present.
        else:
            alternate_index_of_string = alternate_index_of_string + 1
    # Character is not present.
    return False


def emojified(string_guess: str, string_that_gets_searched: str) -> str:
    """Given 2 str of = length, 1st = guess, 2nd = secret, it will give sequence of wordle emojis."""
    assert len(string_that_gets_searched) == len(string_guess)
    emojis: str = ""
    index_of_word: int = 0
    # Character boxes.
    WHITE_BOX: str = "\U00002B1C"
    GREEN_BOX: str = "\U0001F7E9"
    YELLOW_BOX: str = "\U0001F7E8"
    # Checks through indexs of secret word for matching, or if the letter is present.
    while index_of_word < len(string_guess):
        # Correct letter.
        if ord(string_that_gets_searched[index_of_word]) == ord(string_guess[index_of_word]):
            emojis += GREEN_BOX
        # Letter found elsewhere in word.
        elif contains_char(string_that_gets_searched, string_guess[index_of_word]) is True:
            emojis += YELLOW_BOX
        # Letter not found in word.
        else:
            emojis += WHITE_BOX
        index_of_word = 1 + index_of_word
    return emojis


def input_guess(guess_length: int) -> str:
    """Give the desired length, it will prompt the user for a word of the correct length."""
    user_guess_word = str(input(f"Enter a {guess_length} character word: "))
    while len(user_guess_word) != guess_length:
        user_guess_word = str(input(f"That wasn't {guess_length} chars! Try again: "))
    return user_guess_word


def main() -> None:
    """The entrypoint of the program and the main game loop."""
    hidden_word: str = "codes"
    number_of_turns: int = 1
    winner: bool = False
    storing_input: str = ""
    # Keeps playing until 6 turns are up.
    while number_of_turns < 7 and winner is False:
        guess_var: str = ""
        print(f"=== Turn {number_of_turns}/6 ===")
        storing_input = input_guess(len(hidden_word))
        guess_var = emojified(storing_input, hidden_word)
        print(guess_var)
        # They get the right word.
        if hidden_word == storing_input:
            print(f"You won in {number_of_turns}/6 turns!")
            winner = True
        # Wrong guess.
        else:
            number_of_turns += 1
    if number_of_turns >= 7: 
        print("X/6 - Sorry, try again tomorrow!")


# Adding code so we can run as a module and import functions across codes.
if __name__ == "__main__":
    main()