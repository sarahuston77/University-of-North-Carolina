#Examples of things you can code and where numbers can be stored
c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
mynumbers = c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
mynumbers
othernumbers <- 1:10

#Lists all global variables
ls()

evenmorenumbers = seq(1, 10, 1)
ls()

#Explore the possibilities

#rep() repeats something for a specified number of times
rep("hello", times = 3)

# sort() sorts
sort(c(6, 2, 9, 3))

# unique() finds the unique numbers
unique(c(3, 3, 3, 7, 7, 2, 8))

# round() rounds to a specified digit
round(pi, digits = 3)

# Start, Stop, Step
seq(1, 10, 1)
seq(from = 1, to = 10, by = 1)

# seq(10, 1, 1) Doesn't work! "from" has to be less
# than "to" for this function.
# we can reorder arguments if we use argument calls
seq(to = 10, from = 1, by = 1)

# Print every leap year from now until 20 years
seq(2024, 2044, 4)[2:length(seq(2024, 2044, 4))]

# Take a look at what is in the environment:
ls()

# let's add something:
EvenMoreNumbers = seq(50, 100, 1)
ls()
