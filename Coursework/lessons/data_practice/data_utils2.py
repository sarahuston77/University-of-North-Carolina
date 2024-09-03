"""Working with CSV Data."""

from csv import DictReader

def read_csv_rows(filename: str) -> list[dict[str,str]]:
    """Read a csv file and return as a list of dicts with header keys."""
    result: list[dict[str,str]] = []
    file_handle = open(filename,"r", encoding="utf8")
    csv_reader = DictReader(file_handle)
    for row in csv_reader:
        result.append(row)
    file_handle.close()
    return result

def column_vals(table: list[dict[str,str]], header: str) -> list[str]:
    """Returns values in a table column under specific header."""
    result: list[str] = []
    for row in table:
        # save every value under key header
        result.append(row[header])
    return result