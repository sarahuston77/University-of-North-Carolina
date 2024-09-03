"""Turtle practice."""
#python -m lessons.turtle_tutorial

from turtle import Turtle, colormode, done
colormode(255)

leo: Turtle = Turtle()

side_length: int = 300

#speed
leo.speed(50)

#hiding turtle
leo.hideturtle()

#color
#both pen and fill
leo.color(100,20,0)
#pen only
#leo.pencolor("pink")
#fill only
#leo.fillcolor(32,67,93)

#moving stuff
leo.penup()
leo.goto(-150, 100)
leo.pendown()

#filling w/ color
leo.begin_fill()

#triangle
i: int = 0
while i < 3:
    leo.forward(side_length)
    leo.right(120)
    i = i + 1

#ending color fill
leo.end_fill()

bob: Turtle = Turtle()

bob.pencolor("black")
bob.penup()
bob.goto(-150, 100)
bob.pendown()
bob.speed(75)


i: int = 0
while i < 200:
    side_length = side_length * 0.96
    bob.forward(side_length)
    bob.right(121)
    i = i + 1

done()



