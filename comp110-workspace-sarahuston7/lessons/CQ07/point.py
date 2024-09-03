"""Pracitce with coordinates."""

from __future__ import annotations

__author__ = "730459812"


class Point:
    """Creates a two dim point."""
    x: float
    y: float

    def __init__(self, x_init: float = 0.0, y_init: float = 0.0):
        """My constructor."""
        self.x = x_init
        self.y = y_init
    
    def __str__(self):
        """Printing method."""
        output: str = f"x: {self.x}; y: {self.y}"
        return output

    def scale_by(self, factor: int):
        """Mutates a coordinate."""
        self.x *= factor
        self.y *= factor

    def scale(self, factor: int) -> Point:
        """Creates a new scaled point."""
        new_point: Point = Point(self.x * factor, self.y * factor)
        return new_point
    
    def __mul__(self, factor: int | float) -> Point:
        """Multiplies old point and creates new."""
        new_point: Point = self
        new_point.x *= factor
        new_point.y *= factor
        return new_point
    
    def __add__(self, addn: int | float) -> Point:
        """Adds a number onto old point into new point."""
        added_point: Point = self
        added_point.x += addn
        added_point.y += addn
        return added_point


sara_point: Point = Point(3.0, 7.0)   
print(sara_point)
fun_point: Point = sara_point + 3.0
print(fun_point)