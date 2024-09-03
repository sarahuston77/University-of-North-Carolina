"""File to define Fish class."""


class Fish:
    """Creating a fish."""

    age: int

    def __init__(self, age2: int = 0):
        """Constructing a fish."""
        self.age = age2
    
    def one_day(self):
        """Changing age per day."""
        self.age += 1