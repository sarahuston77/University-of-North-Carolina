"""Making a cool flower scene."""


__author__ = "730459812"


from turtle import Turtle, colormode, done
colormode(255)


def main() -> None:
    """The entrypoint of my scene."""
    fun: Turtle = Turtle()
    fun.hideturtle()
    background_color(Turtle())
    grass_of_any_length(Turtle(), -350.0, -350.0, 350.0, 100)
    small_circle(Turtle(), 0.0, 0.0)
    flower_petal(Turtle(), 31.0, 12.0, 26, 13)
    small_circle(Turtle(), 231.0, 112.0)
    flower_petal(Turtle(), 261.5, 124.0, 26, 13)
    star_at_random_location(Turtle(), 20)
    star_at_random_location(Turtle(), 10)
    star_at_random_location(Turtle(), 30)


def grass_of_any_length(sara: Turtle, x: float, y: float, z: float, length_of_grass: int) -> None:
    """Drawing grass."""
    max_speed: int = 0
    sara.speed(max_speed)
    sara.hideturtle()
    sara.penup()
    sara.goto(x, y)
    sara.setheading(0.0)
    sara.pendown()
    sara.color("green")
    i: int = 0
    while i < 100:
        sara.setheading(0.0)
        sara.left(120)
        sara.forward(length_of_grass)
        sara.penup()
        sara.goto(x + 10, y)
        sara.pendown()
        x += 10
        i += 1

  
def background_color(sara: Turtle) -> None:
    """Coloring the background."""
    max_speed: int = 0
    sara.speed(max_speed)
    sara.hideturtle()
    sara.penup()
    sara.goto(500, 500)
    sara.pendown()
    sara.setheading(0.0)
    sara.color("pink")
    sara.begin_fill()
    i: int = 0
    while i < 4:
        sara.right(90)
        sara.forward(1000)
        i = i + 1
    sara.end_fill()


def small_circle(sara: Turtle, x: float, y: float) -> None:
    """Drawing a circleish."""
    max_speed: int = 0
    sara.speed(max_speed)
    sara.hideturtle()
    sara.penup()
    sara.goto(x, y)
    sara.setheading(0.0)
    sara.pendown()
    sara.color("blue")
    sara.begin_fill()
    i: int = 0
    while i < 400:
        sara.forward(0.1)
        sara.right(1)
        i = i + 1
    sara.end_fill()


def flower_petal(sara: Turtle, x: float, y: float, length: int, width: int) -> None:
    """Drawing one flower petal."""
    max_speed: int = 0
    sara.speed(max_speed)
    sara.hideturtle()
    sara.penup()
    sara.goto(x, y)
    sara.setheading(0.0)
    sara.pendown()
    sara.color("purple")
    i: int = 0
    while i < 12:
        sara.right(120)
        sara.forward(length)
        sara.right(90)
        sara.forward(width)
        sara.right(90)
        sara.forward(width)
        sara.right(90)
        sara.forward(length)
        i += 1


def star_at_random_location(sara: Turtle, length: int) -> None:
    """Star at random location of any size."""
    max_speed: int = 0
    sara.speed(max_speed)
    sara.hideturtle()
    sara.penup()
    from random import randint
    x: int = randint(-300, 300)
    y: int = randint(-300, 300)
    sara.goto(x, y)
    sara.setheading(0.0)
    sara.pendown()
    sara.color("yellow")
    sara.begin_fill()
    i: int = 0
    while i < 10:
        if i % 2 == 0:
            sara.right(36)
            sara.forward(length)
        else:
            sara.right(252)
            sara.forward(length)
        i = i + 1
    sara.end_fill()


main()
done()