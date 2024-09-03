"""Practice summing over lists."""

def sum_evens_in_list(input_list: list[int]) -> int:
    """Sum all even numbers in this list."""
    list_sum: int = 0
    for elem in input_list:
        if elem % 2 == 0:
            list_sum = list_sum + elem
    return list_sum
