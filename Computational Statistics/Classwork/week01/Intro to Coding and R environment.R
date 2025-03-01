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
all_years <- seq(to = 2025 + 20, from = 2025, by = 1)
leap_indices <- which(all %% 4 == 0)
print(all_years[indices])

# Take a look at what is in the environment:
ls()

# let's add something:
EvenMoreNumbers = seq(50, 100, 1)
ls()

# Create a toy vector to play with
ToyWords <- c("hello", "bye")

# Take a look at it
ToyWords

# is it a vector?
is.vector(ToyWords)

# is it numeric?
is.numeric(ToyWords)

# What is it?
class(ToyWords)