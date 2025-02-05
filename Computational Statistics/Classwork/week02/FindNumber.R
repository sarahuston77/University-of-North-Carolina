##### Removed Number Problem #####
# PROBLEM: Vector 1 to 100. Randomly remove a number and then find out what was removed.

# Set up problem
toy_vector <- seq(from = 1, to = 100, by = 1)

# Randomly remove an entry
removed_number_idx <- sample(100,1)
toy_vector <- toy_vector[-removed_number_idx]

# Sum route
missing_number <- sum(seq(1,100,1)) - sum(toy_vector)

##### Vector notation #####
MyVector <- seq(from = 10, to = 20, by = 2)

# Negative sequencing
vect <- seq(from = 10, to = 1, by = -1)

# Show the vector
MyVector

# Access the first value
MyVector[1]

# To remove a value, put a ‘-’ in front of the index:
MyVector[-1]