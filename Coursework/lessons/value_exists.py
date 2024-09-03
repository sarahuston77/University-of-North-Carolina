"""Fn that checks if something exists."""


def value_exists(dict_1: dict[str,int], int_1: int) -> bool:
    """Fn returns true if int is stored in dict."""
    for elem in dict_1:
        if dict_1[elem] == int_1:
            return True
    return False