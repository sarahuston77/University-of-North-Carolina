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
w12345 <- merge(w12345, educinc, by = c('famid'), all = TRUE)

# Alternative way to do this with tidyverse and less repetition
# library("tidyverse")
# w12345 <- (list(w1_child, w2_child, w3_child, w4_child, w5_child)
           # %>% reduce(full_join, by = "famid")) 

# Select specified variables using dplyr
# install.packages("dplyr")
library(dplyr)
w12345 <- w12345 %>% dplyr::select(famid, c01cohort, c01gender, c01school, c01sibli, 
                                   contains("atts"), contains("pcmp"), contains("attt"),
                                   contains("dscr"), contains("atod"), fameduc, income, c01sibli)

# View variables to double check things
names(w12345)

# Reverse code for pcmp 1 and 2
pcmp_01_02_cols <- c(grep("pcmp01", names(w12345)), grep("pcmp02", names(w12345)))
w12345[ ,pcmp_01_02_cols] <- 5 - w12345[ ,pcmp_01_02_cols]

# Compute averages based on sets of columns for variable sets and place average into a new variable
w12345$c01attt <- rowMeans(w12345[c(grep("c01attt", names(w12345)))], na.rm = TRUE)
w12345$c04attt <- rowMeans(w12345[c(grep("c04attt", names(w12345)))], na.rm = TRUE)

w12345$c01pcmp <- rowMeans(w12345[c(grep("c01pcmp", names(w12345)))], na.rm = TRUE)
w12345$c04pcmp <- rowMeans(w12345[c(grep("c04pcmp", names(w12345)))], na.rm = TRUE)

w12345$c01dscr <- rowMeans(w12345[c("c01dscr07", "c01dscr08", "c01dscr09", "c01dscr10")], na.rm = TRUE)
w12345$c04dscr <- rowMeans(w12345[c("c04dscr07", "c04dscr08", "c04dscr09", "c04dscr10")], na.rm = TRUE)

w12345$c01atts <- rowMeans(w12345[c("c01atts03", "c01atts07", "c01atts08", "c01atts10")], na.rm = TRUE)
w12345$c02atts <- rowMeans(w12345[c("c02atts03", "c02atts07", "c02atts08", "c02atts10")], na.rm = TRUE)
w12345$c02atts <- rowMeans(w12345[c("c03atts03", "c03atts07", "c03atts08", "c03atts10")], na.rm = TRUE)
w12345$c04atts <- rowMeans(w12345[c("c01atts03", "c04atts07", "c04atts08", "c04atts10")], na.rm = TRUE)

w12345$c01atod <- rowSums(w12345[c("c01atod01", "c01atod02", "c01atod03", "c01atod04", "c01atod05", "c01atod06", "c01atod07", "c01atod08", "c01atod09")], na.rm = TRUE)
w12345$c04atod <- rowSums(w12345[c("c04atod01", "c04atod02", "c04atod03", "c04atod04", "c04atod05", "c04atod06", "c04atod07", "c04atod08", "c04atod09")], na.rm = TRUE)

## Final Quiz Questions

# 1) Dimension of your final data frame (row x column)
dimension <- dim(w12345)
dimension

# 2) What is the max average education level obtained by parents (“fameduc”)?
max_educ <- max(w12345$fameduc, na.rm = TRUE)
max_educ

# 3) How many people have this level of education?
num_highest_educ <- sum(w12345$fameduc >= max_educ, na.rm = TRUE)
num_highest_educ * 2 # Multiply by 2 since the average education is for two parents i.e., number of people is 2

# 4) What is the mean for variable “c01attt” for those who have 4 siblings?
four_sibs <- w12345[w12345$c01sibli == 4 & !is.na(w12345$c01sibli), ]
mean(four_sibs$c01attt)

# 5) Create difference scores between Waves 1 and 4 for all scales. Which scale has
# the greatest average absolute change (i.e., difference)?
w12345$difference_atts <- w12345$c01atts - w12345$c04atts
w12345$difference_pcmp <- w12345$c01pcmp - w12345$c04pcmp
w12345$difference_attt <- w12345$c01attt - w12345$c04attt
w12345$difference_dscr <- w12345$c01dscr - w12345$c04dscr
w12345$difference_atod <- w12345$c01atod - w12345$c04atod

mean(abs(w12345$difference_atts), na.rm = TRUE) # "atts" has the greatest average absolute change
mean(abs(w12345$difference_pcmp), na.rm = TRUE)
mean(abs(w12345$difference_attt), na.rm = TRUE)
mean(abs(w12345$difference_dscr), na.rm = TRUE)
mean(abs(w12345$difference_atod), na.rm = TRUE)
