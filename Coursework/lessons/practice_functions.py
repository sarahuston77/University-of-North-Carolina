def mimic(my_words: str) -> str:
    """Given the string my_words, outputs the same string."""
    return my_words

print(mimic("Hello"))

def mimic_letter(my_words: str, letter_idx: int) -> str:
    """Outputs the character of my_words at index letter_idx."""
    if letter_idx < len(my_words):
        return my_words[letter_idx]
    else:
        return("Too high of an index.")

print(mimic_letter("sara",2))