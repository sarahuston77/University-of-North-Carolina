"""Creating a river simulation."""

from exercises.ex08.river import River

my_river: River = River(6, 50)
my_river.view_river()
my_river.one_river_week()