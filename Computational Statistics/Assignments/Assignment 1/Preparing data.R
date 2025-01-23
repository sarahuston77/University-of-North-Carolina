# Read in files based off of path, type, and headers
w1_child <- read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w1_child.csv",
                     header = TRUE)
w2_child <- read.table("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w2_child.dat",
                       header = TRUE)
w3_child <- read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w3_child.csv",
                     header = TRUE)
w4_child <- read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w4_child.csv",
                     header = FALSE)
names_w4_child <- read.table("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/names_w4_child.txt")
w5_child <- read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w5_child.csv",
                     header = TRUE)
educinc <- read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/educinc.csv",
                    header = TRUE)

# Add transposed variable names to w4_child based off of the provided text file
names(w4_child) <- t(names_w4_child)

# Change all cells that have the specific empty value to NA cells for cohesion
w1_child[w1_child == "9" | w1_child == "8" | w1_child == "98" | w1_child == "99"] <- NA
w3_child[w3_child == "9" | w3_child == "8" | w3_child == "98" | w3_child == "99"] <- NA
w4_child[w4_child == "9" | w4_child == "8" | w4_child == "98" | w4_child == "99"] <- NA
w5_child[w5_child == "9" | w5_child == "8" | w5_child == "98" | w5_child == "99"] <- NA
educinc[educinc == "."] <- NA
w2_child[w2_child == "-999"] <- NA

# Make all headers into lower case for easier merging
names(w1_child) <- tolower(names(w1_child))
names(w2_child) <- tolower(names(w2_child))
names(w3_child) <- tolower(names(w3_child))
names(w4_child) <- tolower(names(w4_child))
names(w5_child) <- tolower(names(w5_child))
names(educinc) <- tolower(names(educinc))

# Merge all data frames via column names
w12345 <- merge(w1_child, w2_child, by = c('famid'), all = TRUE)
w12345 <- merge(w12345, w3_child, by = c('famid'), all = TRUE)
w12345 <- merge(w12345, w4_child, by = c('famid'), all = TRUE)
w12345 <- merge(w12345, w5_child, by = c('famid'), all = TRUE)

# Alternative way to do this with tidyverse
# library("tidyverse")
# w12345 <- (list(w1_child, w2_child, w3_child, w4_child, w5_child)
           # %>% reduce(full_join, by = "famid")) 


