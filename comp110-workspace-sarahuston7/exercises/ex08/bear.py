"""File to define Bear class."""


class Bear:
    """Defining a bear."""

    age: int
    hunger_score: int

    def __init__(self, age2: int = 0, hunger_score2: int = 0):
        """Constructing a bear."""
        self.age = age2
        self.hunger_score = hunger_score2

    def one_day(self):
        """Increasing hunger and age each day."""
        self.hunger_score -= 1
        self.age += 1
    
    def eat(self, num_fish: int):
        """Increases bear's hunger score."""
        self.hunger_score += num_fish