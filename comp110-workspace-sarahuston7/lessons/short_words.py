"""Eat literal shit."""

__author__ = "730459812"


def short_words(list_1: list[str]) -> list[str]:
    """Returns a list of words that are shorter than five characters."""
    short_list: list[str] = []
    i: int = 0
    while i < len(list_1):
        if len(list_1[i]) < 5:
            short_list.append(list_1[i])
        else:
            print(f"{list_1[i]} is too long!")
        i += 1
    return short_list