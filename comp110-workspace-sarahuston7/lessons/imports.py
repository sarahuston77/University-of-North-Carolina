"""Practice importing from other modules."""

from lessons import my_functions

print(my_functions.addition(1,2))

print(my_functions.my_variable)

if __name__ == "__main__":
    print("Howdy!")

from lessons.my_functions import addition

print(addition(1,2))
