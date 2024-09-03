"""Testing points for correctness."""

from __future__ import annotations

from lessons.CQ07.point import Point

points_1: Point = Point(4.0, 3.0)
print(points_1.x)
print(points_1.y)

points_1.scale_by(2)
print(points_1.x)
print(points_1.y)

points_1.scale_by(3)
print(points_1.x)
print(points_1.y)