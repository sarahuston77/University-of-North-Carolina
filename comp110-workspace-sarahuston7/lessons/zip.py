"""Combining two lists into a dictionary."""

__author__ = "730459812"


def zip(list_str: list[str], list_num: list[int]) -> dict[str, int]:
    """When give a list of words and list of ints, it creates a dictionary."""
    new_dict: dict[str, int] = {}
    if len(list_str) != len(list_num):
        return new_dict
    i: int = 0
    while len(list_str) > i:
        new_dict[list_str[i]] = 0
        i += 1
    k: int = 0
    for elem in new_dict:
        l: int = 0
        while len(list_num) > l:
            new_dict[elem] = list_num[k]
            l += 1
        k += 1
    return new_dict