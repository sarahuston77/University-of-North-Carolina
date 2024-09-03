"""Dictionary related utility functions."""

__author__ = "730459812"


from csv import DictReader


def read_csv_rows(filename: str) -> list[dict[str, str]]:
    """Read a csv file and return as a list of dicts with header keys."""
    result: list[dict[str, str]] = []
    file_handle = open(filename, "r", encoding="utf8")
    csv_reader = DictReader(file_handle)
    for row in csv_reader:
        result.append(row)
    file_handle.close()
    return result


def column_values(table: list[dict[str, str]], header: str) -> list[str]:
    """Returns values in a table column under specific header."""
    result: list[str] = []
    for row in table:
        # save every value under key header
        result.append(row[header])
    return result


def columnar(table: list[dict[str, str]]) -> dict[str, list[str]]:
    """Transforms a table represented as a list of rows to a dict of columns."""
    result: dict[str, list[str]] = {}
    for key in table[0]:
        col_vals: list[str] = column_values(table, key)
        result[key] = col_vals
    return result


def head(table: dict[str, list[str]], num_rows: int) -> dict[str, list[str]]:
    """Produce a new col-based dict with only N rows of data for each col."""
    result: dict[str, list[str]] = {}
    for col in table:
        list_N_items: list[str] = []
        i: int = 0
        while i < num_rows and i < len(table):
            list_N_items.append(table[col][i])
            i += 1
        result[col] = list_N_items
    return result


def select(table: dict[str, list[str]], col_names: list[str]) -> dict[str, list[str]]:
    """Produce a new table w/ only a specific subset of the original cols."""
    result: dict[str, list[str]] = {}
    for indx in range(0, len(col_names)):
        result[col_names[indx]] = table[col_names[indx]]
    return result


def concat(table1: dict[str, list[str]], table2: dict[str, list[str]]) -> dict[str, list[str]]:
    """Produce a new table w/ two col-based tables combined."""
    result: dict[str, list[str]] = {}
    for col in table1:
        result[col] = table1[col]
    for col in table2:
        if col in result:
            result[col] += table2[col]
        else:
            result[col] = table2[col]
    return result


def count(to_count_list: list[str]) -> dict[str, int]:
    """Given a list, will return the number of times the value appeared in list in dict format."""
    result: dict[str, int] = {}
    for indx in range(0, len(to_count_list)):
        if to_count_list[indx] in result:
            result[to_count_list[indx]] += 1
        else:
            result[to_count_list[indx]] = 1
    return result