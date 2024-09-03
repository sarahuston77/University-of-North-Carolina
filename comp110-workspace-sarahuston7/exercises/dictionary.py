"""All about dictionary functions."""

__author__ = "730459812"


def invert(dictionary: dict[str,str]) -> dict[str,str]:
    """When given a dictionary, it will invert the keys and the values with each other."""
    duplicates_list: list(str) = []
    for key in dictionary:
        duplicates_list.append(dictionary[key])
    index1: int = 0
    index2: int = 1
    while len(duplicates_list) > index2:
        if duplicates_list[index1] == duplicates_list[index2]:
            raise KeyError("Can't have two of the same keys!")
        else:
            index2 += 1
        index1 += 1
    final: dict[str,str] = {}
    for key in dictionary:
        final[dictionary[key]] = key      
    return final


def favorite_color(dictionary: dict[str,str]) -> str:
    """When given a dictionary, it will return the most frequent color."""
    colors_list: list(str) = []
    colors_list_without_duplicates: list(str) = []
    for color in dictionary:
        colors_list.append(dictionary[color])
        colors_list_without_duplicates.append(dictionary[color])
    index4: int = 1
    while len(colors_list_without_duplicates) > index4:
        index3: int = 0
        if colors_list_without_duplicates[index3] == colors_list_without_duplicates[index4]:
            colors_list_without_duplicates.pop(index3)
        else:
            index4 += 1
        index3 += 1
    single_colors_dict: dict[str,int] = {}
    index5: int = 0
    while len(colors_list_without_duplicates) > index5:
        single_colors_dict[(colors_list_without_duplicates[index5])] = 0
        index5 += 1 
    #counting duplicates
    index8: int = 0
    while len(colors_list) > index8:
        index9: int = 0
        counter: int = 0
        while len(colors_list) > index9:
            if colors_list[index8] == colors_list[index9]:
                counter += 1
            index9 += 1
        single_colors_dict[(colors_list[index8])] = counter
        index8 += 1
    #picking highest number from dictionary
    winning_color_list_indexs: list[int] = []
    print(single_colors_dict)
    emptyyy_dict: dict[int,str] = {}
    for frequency in single_colors_dict: 
        winning_color_list_indexs.append(single_colors_dict[frequency])
    max_appearence: int = max(winning_color_list_indexs)
    print(max_appearence)
    for frequency in single_colors_dict:     
        if max_appearence == single_colors_dict[frequency]:
            emptyyy_dict[frequency] = "hi"
            print(emptyyy_dict)
            invert({emptyyy_dict})
            print(emptyyy_dict)
            return(emptyyy_dict)