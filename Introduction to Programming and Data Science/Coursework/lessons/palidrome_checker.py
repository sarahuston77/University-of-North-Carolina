# """Checking if a string is a palindrome."""

# arr = ['The quick brown fox jumped over the sleeping dog.', 'Oozy rat in a sanitary zoo', 'Carla loves chocoalte.', 'saas']

# def palidrome_checker(arr: list) -> list[bool]:
#     """Will check if each string in an arrary is a palidrome and return T/F."""
#     bool_list: list[bool] = []
#     for string in arr:
#         string_cleaned: str = ""
#         for idx in range(0,len(arr)):
#             if arr[idx].isalpha() == True:
#                 string_cleaned += arr[idx]
#         string_cleaned.lower()
#         string_reversed: str = string_cleaned[::-1]
#         if string_reversed == string:
#             bool_list.append(True)
#         else:
#             bool_list.append(False)
#     return bool_list

# print(palidrome_checker(arr))

# def merge_arrays(nums1, m, nums2, n):
#     """Will add two lists together in ascending order within size constraints."""
#     for idx in nums1:
#         i: int = 0
#         while i < len(nums2):
#             if nums1[idx] <= nums2[i] and nums1[idx + 1] >= nums2[i]:
#                 nums1.append(nums2[i])
#             i += 1


# nums1 = [1,2,3,0,0,0]
# m = 3 
# nums2 = [2, 5, 6]
# n = 3
# print(merge_arrays(nums1, m, nums1, n))
# print(nums1)

