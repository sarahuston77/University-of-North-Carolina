"""Test my zip function."""

__author__ = "730459812"


from lessons.zip import zip


def test_lists_normal():
    """List of str and ints should return a dictionary w/ corresponding str as keys and ints as values."""
    test_list1: list[str] = ["sara", "mel"]
    test_list2: list[int] = [2, 4]
    assert zip(test_list1, test_list2) == {'sara': 2, 'mel': 4}


def test_list_different_sizes():
    """When lists are different sizes, should return empty dict."""
    test_list3: list[str] = ["sara", "mel"]
    test_list4: list[int] = [2]
    assert zip(test_list3, test_list4) == {}


def test_list_empty():
    """When lists are empty, should return an empty dictionary."""
    test_list5: list[str] = []
    test_list6: list[int] = []
    assert zip(test_list5, test_list6) == {}