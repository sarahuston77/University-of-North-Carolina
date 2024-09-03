"""File to define River class."""

from __future__ import annotations

__author__ = "730459812"

from exercises.ex08.fish import Fish
from exercises.ex08.bear import Bear


class River:
    """Creating a river."""

    day: int
    bears: list[Bear]
    fish: list[Fish]

    def __init__(self, num_fish: int, num_bears: int):
        """New River with num_fish Fish and num_bears Bears."""
        self.day: int = 0
        self.fish: list[Fish] = []
        self.bears: list[Bear] = []
        # populate the river with fish and bears
        for x in range(0, num_fish):
            self.fish.append(Fish())
        for x in range(0, num_bears):
            self.bears.append(Bear())

    def check_ages(self):
        """Makes sure ages are low."""
        new_age_fish: list[Fish] = []
        new_age_bear: list[Bear] = []
        i: int = 0
        while i < len(self.fish):          
            if self.fish[i].age <= 3:
                new_age_fish.append(self.fish[i])
            i += 1
        k: int = 0
        while k < len(self.bears):
            if self.bears[k].age <= 5:
                new_age_bear.append(self.bears[k])
            k += 1
        self.fish = new_age_fish
        self.bears = new_age_bear
        return None

    def remove_fish(self, amount: int):
        """Removes fish from the begining of the list."""
        new_fish_list: list[Fish] = []
        t: int = len(self.fish) - amount
        while t < len(self.fish):
            new_fish_list.append(self.fish[t])
            t += 1
        self.fish = new_fish_list
        return None

    def bears_eating(self):
        """Each bear eats 3 fish if there are at least five fish in river."""
        g: int = 0
        while g < len(self.bears):
            if len(self.fish) >= 5:
                self.bears[g].eat(3)
                self.remove_fish(3)
            g += 1
        return None
    
    def check_hunger(self):
        """Bear is too hungry, it starves and dies."""
        d: int = 0
        not_starved_bears: list[Bear] = []
        while d < len(self.bears):
            if self.bears[d].hunger_score >= 0:
                not_starved_bears.append(self.bears[d])
            d += 1
        self.bears = not_starved_bears
        return None
        
    def repopulate_fish(self):
        """Reproduction fish not like humans."""
        c: int = len(self.fish)
        repop_fish: list[Fish] = [self.fish]
        while c < (len(self.fish) + ((len(self.fish) // 2) * 4)): 
            baby_fish: Fish = ()
            repop_fish.append(baby_fish)
            c += 1
        self.bears = repop_fish
        return None
    
    def repopulate_bears(self):
        """Reproduction bears similar to humans."""
        r: int = len(self.bears)
        repop_bears: list[Bear] = [self.bears]
        while r < (len(self.bears) + (len(self.bears) // 2)): 
            baby_bear: Bear = ()
            repop_bears.append(baby_bear)
            r += 1
        self.bears = repop_bears
        return None
    
    def view_river(self):
        """Viewing river."""
        output: str = f"~~~ Day {self.day}: ~~~\n"
        num_bears2: int = len(self.bears)
        num_fish2: int = len(self.fish)
        output += f"Fish population: {num_fish2}\n"
        output += f"Bear population: {num_bears2}"
        print(output)
        return output
            
    def one_river_day(self):
        """Simulate one day of life in the river."""
        # Increase day by 1
        self.day += 1
        # Simulate one day for all Bears
        for bear in self.bears:
            bear.one_day()
        # Simulate one day for all Fish
        for fish in self.fish:
            fish.one_day()
        # Simulate Bear's eating
        self.bears_eating()
        # Remove hungry Bear's from River
        self.check_hunger()
        # Remove old Fish and Bear's from River
        self.check_ages()
        # Simulate Fish repopulation
        self.repopulate_fish()
        # Simulate Bear repopulation
        self.repopulate_bears()
        # Visualize River
        self.view_river()

    def one_river_week(self):
        """Calls one river day seven times."""
        i: int = 1
        while i < 8:
            self.one_river_day()
        i += 1
        
