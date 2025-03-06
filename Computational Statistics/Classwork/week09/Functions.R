# General function formating
# NameOfFunction <- function(<argument list>) {
# <type of code here>
# return (<whatever objects you want to be returned>)
# }

# Function example
# m is a scalar input that will have 1 added to it
AddOne <- function(m){
  output <- m + 1
  names(output) <- "Added"
  return (output)
}

# Save in an object
output <- AddOne(10)
output

# @param m Required numeric input
# @param roundm Logical, if TRUE the input scalar is rounded. Defaults to TRUE.
AddSubtractOne <- function(m = NULL, roundm = TRUE){
  if (roundm)
    m <- round(m)
  add <- m + 1
  names(add) <- "Added"
  subtract <- m - 1
  names(subtract) <- "Subtracted"
  return (list(add, subtract))
}

AddSubtractOne(10)