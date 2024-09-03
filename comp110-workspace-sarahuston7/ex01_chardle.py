"""Prompting the user for a five-character word and a single letter"""

__author__ = "730459812"

"""Naming the two variables that you are asking/inputting"""
five_character_word: str = input("Enter a 5-character word: ")
"""Ensuring word is the right length"""
if len(five_character_word) == 5:
    single_character: str = input("Enter a single character: ")
else:
    print("Error: Word must contain 5 characters")
    exit()

"""Ensuring the varibles came out correctly and the variable is the right length"""
if len(single_character) == 1: 
    print("Searching for " + single_character + " in " + five_character_word)
else:
    print("Error: Character must be a single character.")
    exit()
"""Counting matching indices"""
number_of_matches: int = 0

"""Checking indices for matches"""
if str(single_character) == str(five_character_word[0]):
    print(single_character + " found at index 0")
    number_of_matches += 1

if str(single_character) == str(five_character_word[1]):
    print(single_character + " found at index 1")
    number_of_matches += 1

if str(single_character) == str(five_character_word[2]):
    print(single_character + " found at index 2")
    number_of_matches += 1

if str(single_character) == str(five_character_word[3]):
    print(single_character + " found at index 3")
    number_of_matches += 1

if str(single_character) == str(five_character_word[4]):
    print(single_character + " found at index 4")
    number_of_matches += 1

"""Making sure the final instances are listed with the correct grammar"""
"""( str(number_of_matches) + " instance of " + single_character " in " + five_character_word)"""

if number_of_matches == 1:
    print("1 instance of " + single_character + " found in " + five_character_word)
else:
    if number_of_matches == 0:
        print("No instances of " + single_character + " found in " + five_character_word)
    else:
        print(str(number_of_matches) + " instances of " + single_character + " found in " + five_character_word)
