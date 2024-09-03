"""Dictionary practice."""

__author__ = "730459812"


def invert(dictionary: dict[str, str]) -> dict[str, str]:
    """When given a dictionary, it will swap values and keys."""
    inverted_list: dict[str, str] = {}
    for keys in dictionary:
        value = dictionary[keys]
        inverted_list[value] = keys
    duplicates_list: list[str] = []
    for keys in dictionary:
        duplicates_list.append(dictionary[keys])
        print(duplicates_list)
    index1: int = 0
    index2: int = 1
    while len(duplicates_list) > index2:
        if duplicates_list[index1] == duplicates_list[index2]:
            raise KeyError("Can't have two of the same keys!")
        else:
            index2 += 1
        index1 += 1
    return inverted_list


def favorite_color(dictionary: dict[str, str]) -> str:
    """When given a dictionary, it will return the most frequent color."""
    color_dict: dict[str, int] = {}
    i: int = 0
    best_color: str = ""
    for name in dictionary:
        if dictionary[name] in color_dict:
            color_dict[dictionary[name]] += 1
        else:
            color_dict[dictionary[name]] = 1
    for color in color_dict:
        if color_dict[color] > i:
            i = color_dict[color]
            best_color = color
    return best_color


def count(counter_list: list[str]) -> dict[str, int]:
    """When given a list, it will create a dictionary with unique values and the number of values it appeared."""
    new_dict: dict[str, int] = {}
    list_index: int = 0
    while len(counter_list) > list_index:
        new_dict[counter_list[list_index]] = 0
        list_index += 1
    index8: int = 0
    while len(counter_list) > index8:
        index9: int = 0
        counter: int = 0
        while len(counter_list) > index9:
            if counter_list[index8] == counter_list[index9]:
                counter += 1
            index9 += 1
        new_dict[(counter_list[index8])] = counter
        index8 += 1
    return new_dict


# def alphabetizer(abc_list: list[str]) -> dict[str, list[str]]:
#     """Give a list and get all the words that start with the same letter."""
    # dup_dict: dict[str, list[str]] = {}
    # for elements in abc_list:
    #     elements.lower()
    # print(abc_list)
    # for elements in abc_list:
    #     dup_dict[elements] = 0
    # if len(dup_dict) != len(abc_list):
    #     i: int = 0
    #     while i < len(abc_list):
    #         k: int = 0
    #         if abc_list[i] == abc_list[k]:
    #             abc_list.pop(i)
    #             k += 1
    #         i += 1
    # abc_dict: dict[str, list[str]] = {}
    # print(abc_list)
    # i: int = 0
    # while len(abc_list) > i:
    #     abc_dict[(abc_list[i][0]).lower()] = []
    #     i += 1
    #     print(abc_dict)
    # for objects in abc_dict:
    #     k: int = 0
    #     while len(abc_list) > k:
    #         if str(objects) == abc_list[k][0]:
    #             abc_dict[objects].append(abc_list[k])
    #             print(abc_dict)
    #         k += 1
    # return abc_dict
def alphabetizer(abc_list: list[str]) -> dict[str, list[str]]:
    """Give a list and get all the words that start with the same letter (case-insensitive)."""
    abc_dict: dict[str, list[str]] = {}

    for element in abc_list:
        # Use the first character of each word (lowercase) as the key
        first_char = element[0].lower()
        if first_char not in abc_dict:
            abc_dict[first_char] = []
        
        abc_dict[first_char].append(element)

    return abc_dict


def update_attendance(log: dict[str, list[str]], day: str, student: str) -> None:
    """Function that can update a dictionary log of attendence given a day and student."""
    if day not in log:
        log[day] = [student]
    else:
        new_list: list[str] = log[day]
        if student in new_list:
            return None
        log[day].append(student)
    return None