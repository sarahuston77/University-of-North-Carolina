"""Utility class for numerical operations."""

from __future__ import annotations

from typing import Union

__author__ = "730459812"


class Simpy:
    """Fun little realistic example using a list of floats."""

    values: list[float]

    def __init__(self, list1: list[float] = None) -> None:
        """Constructing simpy."""
        if not list1:
            list1: list[float] = []
        self.values = list1
        return None
    
    def __str__(self) -> str:
        """Method that converts Simpy to a str representation."""
        return f"Simpy({self.values})"
    
    def fill(self, fill_with: float, fill_num: int) -> None:
        """Will fill simpy with a number x amount of times."""
        new_list: list[float] = []
        i: int = 0
        while i < fill_num:
            new_list.append(fill_with)
            i += 1
        self.values = new_list
        return None
    
    def arange(self, start: float, stop: float, step: float = 1.0) -> None:
        """Fill in the values attribute with a range of values."""
        assert step != 0.0
        new_list2: list[float] = []
        if start < stop:
            # Positive loop
            while start < stop:
                new_list2.append(start)
                start += step
        elif start > stop:
            # Negative loop
            while start > stop:
                new_list2.append(start)
                start += step
        self.values = new_list2
        return None
    
    def sum(self) -> float:
        """Sums all the items in Simpy and returns a float."""
        summy: float = float(sum(self.values))
        return summy
        
    def __add__(self, rhs: Union[float, Simpy]) -> Simpy:
        """Enabling use of right hand + with either Simpy or float value."""
        new_simpy: Simpy = Simpy()
        if type(rhs) is Simpy:
            assert len(self.values) == len(rhs.values)
            for i in range(0, len(rhs.values)):
                new_simpy.values.append(self.values[i] + rhs.values[i])
        else:
            inty: int = len(self.values)
            for i in range(0, inty):
                new_simpy.values.append(self.values[i] + rhs)
        return new_simpy
    
    def __pow__(self, power: Union[float, Simpy]) -> Simpy:
        """Exponents one Simpy by another."""
        new_simpy: Simpy = Simpy()
        if type(power) is Simpy:
            assert len(self.values) == len(power.values)
            for i in range(0, len(power.values)):
                new_simpy.values.append(self.values[i] ** power.values[i])
        else:
            inty: int = len(self.values)
            for i in range(0, inty):
                new_simpy.values.append(self.values[i] ** power)
        return new_simpy
    
    def __eq__(self, rhs: Union[float, Simpy]) -> list[bool]:
        """Will tell you which Simpy values match."""
        TF_list: list[bool] = []
        if type(rhs) is Simpy:
            assert len(self.values) == len(rhs.values)
            for t in range(0, len(rhs.values)):
                if rhs.values[t] == self.values[t]:
                    TF_list.append(True)
                else:
                    TF_list.append(False)
        else:
            for t in range(0, len(self.values)):
                if self.values[t] == rhs:
                    TF_list.append(True)
                else:
                    TF_list.append(False)
        return TF_list
    
    def __gt__(self, rhs: Union[float, Simpy]) -> list[bool]:
        """Will tell you if any values in a Simpy are greather than another."""
        TF_list: list[bool] = []
        if type(rhs) is Simpy:
            assert len(self.values) == len(rhs.values)
            for t in range(0, len(rhs.values)):
                if rhs.values[t] < self.values[t]:
                    TF_list.append(True)
                else:
                    TF_list.append(False)
        else:
            for t in range(0, len(self.values)):
                if self.values[t] > rhs:
                    TF_list.append(True)
                else:
                    TF_list.append(False)
        return TF_list
    
    def __getitem__(self, rhs: Union[int, list[bool]]) -> Union[float, Simpy]:
        """Will enable subscription of items in a Simpy plus expression."""
        if type(rhs) is int:
            return self.values[rhs]
        else:
            new_simpy1: Simpy = Simpy()
            for elm in range(0, len(rhs)):
                if rhs[elm] is True:
                    new_simpy1.values.append(self.values[elm])
            return new_simpy1