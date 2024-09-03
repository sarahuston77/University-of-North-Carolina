"""Learning how to utilize lists."""

__author__ = "730459812"


def all(list1: list[int], int1: int) -> bool:
    """When give a list of int and given an int, it will tell you if the int is present."""
    if len(list1) == 0:
        return False
    index_of_list1: int = 0
    contains_all: int = 0
    while index_of_list1 < len(list1):
        if list1[index_of_list1] == int1:
            contains_all += 1
        index_of_list1 += 1
    if contains_all == len(list1):
        return True
    else:
        return False


def max(input: list[int]) -> int:
    """When give an list of numbers, it will return the highest number."""
    if len(input) == 0:
        raise ValueError("max() arg is an empty List")
    index_of_list: int = 0
    highest_idx: int = 0
    while index_of_list < len(input):
        if input[index_of_list] > input[highest_idx]:
            highest_idx = index_of_list
        index_of_list += 1
    return input[highest_idx]


def is_equal(list3: list[int], list4: list[int]) -> bool:
    """Tests to see if every element at every index is equal in both lists."""
    index_both_lists: int = 0
    if len(list3) != len(list4):
        return False
    while index_both_lists < len(list3) and index_both_lists < len(list4):
        if list3[index_both_lists] == list4[index_both_lists]:
            index_both_lists += 1
        else:
            return False
    return True