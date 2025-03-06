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
AddSubtractOne <- function(m = NULL, roundm = TRUE, precision = 2){
  
  if (is.null(m))
    stop(paste0("ERROR: No scalar input provided for m.", " Please provide a value."))
  if (roundm)
    m <- round(m, precision)
  add <- m + 1
  names(add) <- "Added"
  subtract <- m - 1
  names(subtract) <- "Subtracted"
  return (list(add, subtract))
}

AddSubtractOne()

# Mode function for a vector of numbers
mode <- function(v = NULL){
  u <- unique(v)
  return(u[which.max(tabulate(v))])s
}

v = c(1, 2, 3, 3, 4)
mode(v)

myData <- seq(1,50)
newData <- myData
for(p in 1:length(myData)){
  newData[p] <- myData[p] + 1
}