"""Quiz 02 practice."""

from __future__ import annotations

class ChristmassTreeFarm:
    """Represents an Xmas tree farm."""

    plots: list[int]

    def __init__(self, plots: int = 0, inital_planting: int = 0):
        """Constructs tree."""
        self.plots = []
        i: int = 0
        while i < inital_planting:
            self.plots.append(1)
            i += 1
        while i < plots:
            self.plots.append(0)
            i += 1
        
    def plant(self, p_ind: int) -> None:
        """Will plant a tree at an index or uproot."""
        if len(self.plots) > p_ind:
            self.plots[p_ind] = 1
        else:
            self.plots.append(1)

    def growth(self) -> None:
        """Will increase all trees by 1."""
        i: int = 0
        while i < len(self.plots):
            self.plots[i] += 1
            i += 1

    def harvest(self, replant: bool) -> int:
        """Will replace trees after harvst."""
        har: int = 0
        i: int = 0
        if replant == True:
            while i < len(self.plots):
                if self.plots[i] >= 5:
                    self.plots[i] = 1
                i += 1
        else:
            while i < len(self.plots):
                if self.plots[i] >= 5:
                    self.plots[i] = 1
                i += 1
        return har
    
    def overload(self, add: ChristmassTreeFarm) -> ChristmassTreeFarm:
        """Add two xmas tree list."""
        new_xmas: ChristmassTreeFarm = ChristmassTreeFarm()
        for indexes in self.plots:
            new_xmas.append(self.plots[indexes])
        for ind in add.plots:
            new_xmas.append(self.plots[ind])

class Course:
        """Models the idea of a UNC course."""
        name: str
        level: int
        prerequisites: list[str]

def find_courses(classy: list[Course], string: str) -> list[str]:
    """"Dumn."""
    i: int = 0
    new_list: list[str] = []
    while i < len(classy):
        if string in classy[i].prerequisites and classy[i].level >= 400:
            new_list.append(classy[i].name)
        i += 1
    return new_list

sara: ChristmassTreeFarm = [1,1]
tree: ChristmassTreeFarm = [2,2]
sara + tree

class Icecream:

    name: str
    val: int

    def __init__(self, nam1: str = "", val1: int = 0):
        """Constr."""
        self.name = nam1
        self.val = val1
    
    def __mul__(self, factor: int) -> Icecream:
        """override."""
        new_ice: Icecream = Icecream()
        new_ice.name = self.name
        new_ice.val = self.val * factor
        return new_ice