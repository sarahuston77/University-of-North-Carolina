# Function for installing package
install.packages("psych")
install.packages("dplyr") # must have quotes

# Function for calling it into our environment
library(dplyr) # with or without quotes
library(psych)

# Call in data provided by a loaded package:
data(bfi)

# Check out the data:
class(bfi)

# Dimensions of data (row, col)
dim(bfi) 

# First few lines of data for the first 2 variables:
head(bfi)[1:2]

# Get the first value for variable A2
bfi$A2[1]

# Another way to get the same value:
bfi[1,2] # [row,column]

# Only get the data for those who meet a criterion
# Here, the criterion is that a value of variable A1 equals 2
A1is2which <- which(bfi$A1 == 2)
A2whenA1is2 <- bfi$A2[A1is2which]

# Learn about which() function: which indicies are TRUE?
?which()

# Let's find how many people had A1=2
length(A2whenA1is2)

# Another way to get the same vector
A1is2logical <- bfi$A1 == 2

# Set NA to false
A1is2logical[which(is.na(A1is2logical))] <- FALSE

# Create vector of A1 = 2
A2whenA1is2new <- bfi$A2[A1is2logical]
length(A2whenA1is2new)

# Lets say we want to see how many people are younger than age 30 in our Bfi data.
# using which - only has the index's this is true
length(which(bfi$age<30))

# Using logical alone: SAME length because it has T and F
length(bfi$age<30)
  
# We need some clever indexing
length(bfi$age[bfi$age<30])

# Creates a vector of length 8, repeating 5
myvector = rep(5, 8)
myvector

# Adds to each element in the vector
myvector + 5

# Vector of length 8, 1...8
my8numbers = 1:8
my8numbers
myvector

# Adds element wise
myvector + my8numbers

# Call in data from psych package
data(bfi, package = "psych")

# Create a new object with a new variable:
mynewvariable = bfi$A1 + bfi$A2

# Or add the variable directly to the data frame:
bfi$sumA1A2 = bfi$A1 + bfi$A2

# Check it was done right
names(bfi)
head(bfi)

# Call in package
library(dplyr)

TSST_SR <- read.table("~/Computational Statistics/Computational Statistics/Classwork/TSST_data/TSST_SelfReport.csv", header = TRUE, sep = ",") %>%
  dplyr::select(ID, Gender, Race, Age, BMI, contains("Emo_"), contains("Sit_")) %>%
  dplyr::mutate(Race = factor(Race, levels = c(1,2,3,4,5), # first variable to mutate labels = 
                              c("American Indian or Alaskan Native",
                              "Asian American",
                              "Native Hawaiian or other Pacific Islander",
                              "African American",
                              "European American")), # second variable to mutate labels = 
                Gender = factor(Gender, levels = c(0,1), labels = c("Female", "Male")))

load("TSST_HR.RData")

# View column names
names(TSST_HR)

# Make it a data frame
TSST_HR <- as.data.frame(TSST_HR)

# Notice below that the row index is blank [,c()]
# This means all rows will be selected
# We put 1 there to make sure we get the first column - "ID"
TSST_HRonly <- TSST_HR[ , c(1, grep("HR", names(TSST_HR)))] 

names(TSST_HRonly)
dim(TSST_SR)
dim(TSST_HRonly)

SR_IDs <- unique(TSST_SR$ID) 
HR_IDs <- unique(TSST_HRonly$ID) 
all.equal(SR_IDs, HR_IDs)

TSST_HR_SR = merge(TSST_HR, TSST_SR, by = "ID", all = TRUE)

TSST_HR_SR[TSST_HR_SR == 999] <- NA

# The max value is 6.
# Subtracting each number from 6 will make the highest value = 0, and the next highest 1
TSST_HR_SR$Emo_Angry_rev <- 6- TSST_HR_SR$Emo_Angry

Emo_Angry_explore <- cbind(TSST_HR_SR$Emo_Angry, TSST_HR_SR$Emo_Angry_rev) 
head(Emo_Angry_explore)

# mean:
meanHRSpeech1 <- mean(TSST_HR_SR$HRSpeech_1, na.rm = TRUE) # Note the "na.rm = TRUE". This removes NAs!
# Standard deviation:
sdHRSpeech1 <- sd(TSST_HR_SR$HRSpeech_1, na.rm = TRUE)
# See results:
meanHRSpeech1
sdHRSpeech1
