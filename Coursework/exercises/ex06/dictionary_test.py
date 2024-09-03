"""Performing unit tests to ensure code works well."""

__author__ = "730459812"


from exercises.ex06.dictionary import invert
from exercises.ex06.dictionary import favorite_color
from exercises.ex06.dictionary import count
from exercises.ex06.dictionary import alphabetizer
from exercises.ex06.dictionary import update_attendance


def test_normal_invert():
    """Dict of str and str."""
    test_dict1: dict[str, str] = {"sara": "mel", "kathy": "sydney"}
    assert invert(test_dict1) == {"mel": "sara", "sydney": "kathy"}


def test_empty_dict():
    """Empty dict."""
    test_dict2: dict[str, str] = {}
    assert invert(test_dict2) == {}


def test_normal_short_invert():
    """Short dict of str and str."""
    test_dict3: dict[str, str] = {"sara": "mel"}
    assert invert(test_dict3) == {"mel": "sara"}


def test_norm_fav_color():
    """Most freqeuent color is favorite."""
    test_dict4: dict[str, str] = {"sara": "blue", "steve": "yellow", "mel": "blue"}
    assert favorite_color(test_dict4) == "blue"


def test_two_equiv_fav_colors():
    """1st color listed of equivalent favorites is listed."""
    test_dict5: dict[str, str] = {"sara": "blue", "steve": "yellow"}
    assert favorite_color(test_dict5) == "blue"


def test_norm_fav_color_long():
    """Most frequent color is favorite for a longer list."""
    test_dict6: dict[str, str] = {"sara": "blue", "steve": "yellow", "mel": "blue", "kathy": "blue"}
    assert favorite_color(test_dict6) == "blue"


def test_norm_count():
    """When given a list, should create dict w. frequency item appeared."""
    test_list1: list[str] = ["sara", "steve", "syd"]
    assert count(test_list1) == {"sara": 1, "steve": 1, "syd": 1}


def test_empty_list_count():
    """Given an empty list, will return empty dictionary."""
    test_list2: list[str] = list()
    assert count(test_list2) == {}


def test_list_with_dup_count():
    """List with duplicates returns frequencies."""
    test_list3: list[str] = ["sara", "steve", "syd", "syd"]
    assert count(test_list3) == {"sara": 1, "steve": 1, "syd": 2}


def test_alpha_norm():
    """Give a list and get all the words that start with the same letter."""
    test_list4: list[str] = ["sara", "teve", "yd", "syd"]
    assert alphabetizer(test_list4) == {"s": ["sara", "syd"], "y": ["yd"], "t": ["teve"]}


def test_alpha_empty():
    """Empty list creates empty dictionary."""
    test_list5: list[str] = list()
    assert alphabetizer(test_list5) == {}


def test_alpha_only_one_char():
    """List of all same letter returns one element dict."""
    test_list6: list[str] = ["sara", "steve", "syd"]
    assert alphabetizer(test_list6) == {"s": ["sara", "steve", "syd"]}


def test_attend_norm():
    """Updates attendance log on same day."""
    test_dict14: dict[str, list[str]] = {"Tues": ["Sam"]}
    day: str = "Monday"
    name: str = "Kathy"
    update_attendance(test_dict14, day, name)
    assert test_dict14 == {"Monday": ["Kathy"], "Tues": ["Sam"]}


def test_attend_diff_day():
    """Updates attendance log on diff day."""
    test_dict13: dict[str, list[str]] = {"Monday": ["sara, sydney"]}
    day: str = "Tues"
    name: str = "Kathy"
    update_attendance(test_dict13, day, name)
    assert test_dict13 == {"Monday": ["sara, sydney"], "Tues": ["Kathy"]}


def test_attend_empty():
    """Empty starting returns 1 elem log."""
    test_dict14: dict[str, list[str]] = {}
    day: str = "Monday"
    name: list[str] = "Kathy"
    update_attendance(test_dict14, day, name)
    assert test_dict14 == {"Monday": ["Kathy"]}