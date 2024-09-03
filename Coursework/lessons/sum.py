"""Summing the elements of a list using different loops."""

__author__ = "730459812"


def w_sum(vals: list[float]) -> float:
    """Function that gives a sum using a while loop."""
    index_of_w_sum: int = 0
    w_sum_val: float = 0.0
    while index_of_w_sum < len(vals):
        w_sum_val += vals[index_of_w_sum]
        index_of_w_sum += 1
    return w_sum_val


def f_sum(vals: list[float]) -> float:
    """Function that gives sum using a for in loop w/o range."""
    f_sum_val: float = 0.0
    for numbers in vals:
        f_sum_val += numbers
    return f_sum_val


def f_range_sum(vals: list[float]) -> float:
    """Function that gives sum using a for loop and range."""
    f_range_sum_val: float = 0.0
    for index in range(0, len(vals)):
        f_range_sum_val += vals[index]
    return f_range_sum_val