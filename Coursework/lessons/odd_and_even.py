"""Quiz practice."""

def odd_and_even(list_1: list[int]) -> list[int]:
    """"Makes a new list w/ elemebts that are odd and have an even index."""
    list_new: list[int] = []
    i: int = 0
    while i < len(list_1):
        if list_1[i] % 2 != 0 and i % 2 == 0:
            list_new.append(list_1[i])
        i += 1
    return list_new