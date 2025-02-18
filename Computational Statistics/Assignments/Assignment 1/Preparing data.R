# Read in files based off of path, type, and headers with specific NA values accounted for
w1_child <- read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w1_child.csv",
                     header = TRUE, na.strings = c("9", "8", "98", "99"))
w2_child <- read.table("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w2_child.dat",
                       header = TRUE, , na.strings = c("-999"))
w3_child <- read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w3_child.csv",
                     header = TRUE, na.strings = c("9", "8", "98", "99"))
w4_child <- read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w4_child.csv",
                     header = FALSE, na.strings = c("9", "8", "98", "99"))
names_w4_child <- read.table("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/names_w4_child.txt")
educinc <- read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/educinc.csv",
                    header = TRUE, na.strings = c("."))

# Add transposed variable names to w4_child based off of the provided text file
names(w4_child) <- t(names_w4_child)

# Make all headers into lower case for easier merging
names(w1_child) <- tolower(names(w1_child))
names(w2_child) <- tolower(names(w2_child))
names(w3_child) <- tolower(names(w3_child))
names(w4_child) <- tolower(names(w4_child))
names(educinc) <- tolower(names(educinc))

# install.packages("dplyr")
# install.packages("tidyverse")
library("tidyverse")
library("dplyr")

# Merge files by famid and select specified variables
w1234 <- (list(w1_child, w2_child, w3_child, w4_child, educinc)
            %>% reduce(full_join, by = "famid")) %>% dplyr::select(famid, c01cohort, c01gender, c01school, c01sibli, 
                                   contains("atts"), contains("pcmp"), contains("attt"),
                                   contains("dscr"), contains("atod"), fameduc, income, c01sibli)

# View variables to double check things
names(w1234)

# Reverse code for pcmp 1 and 2
pcmp_01_02_cols <- c(grep("pcmp01", names(w1234)), grep("pcmp02", names(w1234)))
w1234[ ,pcmp_01_02_cols] <- 5 - w1234[ ,pcmp_01_02_cols]

# Compute averages based on sets of columns for variable sets and place average into a new variable
w1234$c01attt <- rowMeans(w1234[c(grep("c01attt", names(w1234)))], na.rm = TRUE)
w1234$c04attt <- rowMeans(w1234[c(grep("c04attt", names(w1234)))], na.rm = TRUE)

w1234$c01pcmp <- rowMeans(w1234[c(grep("c01pcmp", names(w1234)))], na.rm = TRUE)
w1234$c04pcmp <- rowMeans(w1234[c(grep("c04pcmp", names(w1234)))], na.rm = TRUE)

w1234$c01dscr <- rowMeans(w1234[c("c01dscr07", "c01dscr08", "c01dscr09", "c01dscr10")], na.rm = TRUE)
w1234$c04dscr <- rowMeans(w1234[c("c04dscr07", "c04dscr08", "c04dscr09", "c04dscr10")], na.rm = TRUE)

w1234$c01atts <- rowMeans(w1234[c("c01atts03", "c01atts07", "c01atts08", "c01atts10")], na.rm = TRUE)
w1234$c02atts <- rowMeans(w1234[c("c02atts03", "c02atts07", "c02atts08", "c02atts10")], na.rm = TRUE)
w1234$c02atts <- rowMeans(w1234[c("c03atts03", "c03atts07", "c03atts08", "c03atts10")], na.rm = TRUE)
w1234$c04atts <- rowMeans(w1234[c("c01atts03", "c04atts07", "c04atts08", "c04atts10")], na.rm = TRUE)

w1234$c01atod <- rowSums(w1234[c("c01atod01", "c01atod02", "c01atod03", "c01atod04", "c01atod05", "c01atod06", "c01atod07", "c01atod08", "c01atod09")], na.rm = TRUE)
w1234$c04atod <- rowSums(w1234[c("c04atod01", "c04atod02", "c04atod03", "c04atod04", "c04atod05", "c04atod06", "c04atod07", "c04atod08", "c04atod09")], na.rm = TRUE)

## Final Quiz Questions

# 1) Dimension of your final data frame (row x column)
dim(w1234)

# 2) What is the max average education level obtained by parents (“fameduc”)?
max_educ <- max(w1234$fameduc, na.rm = TRUE)
max_educ

# 3) How many children have parents with this level of education?
sum(w1234$fameduc >= max_educ, na.rm = TRUE)

# 4) What is the mean for variable “c01attt” for those who have 4 siblings?
four_sibs <- w1234[w1234$c01sibli == 4 & !is.na(w1234$c01sibli), ]
mean(four_sibs$c01attt)

# 5) Create difference scores between Waves 1 and 4 for all scales. Which scale has
# the greatest average absolute change (i.e., difference)?
score_variables <- c("atts", "pcmp", "attt", "dscr", "atod")
w1234[paste("difference_", score_variables, sep = "")] <- abs(w1234[paste("c01", score_variables, sep = "")] - w1234[paste("c04", score_variables, sep = "")])

# "atod" has the greatest average absolute change
ave_abs_change <- colMeans(w1234[ , c("difference_atts", "difference_pcmp", "difference_attt", "difference_dscr", "difference_atod")], na.rm = TRUE)
ave_abs_change[which.max(ave_abs_change)]
