setwd("./Data")
#------------#
# CHILD DATA #
#------------#
#Get data in -- CAUTION: Check missing values of measures of interest!
w1 = read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w1_child.csv", header = TRUE, 
		  na = c("9", "8", "98", "99"))
# w2 = read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w2_child.dat", header = TRUE,   ### I erased this file from my folder so I don't mistakenly post it on sakai
# 		  na = c("9", "8", "98", "99"))
w3 = read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w3_child.csv", header = TRUE, 
		  na = c("9", "8", "98", "99"))
w4 = read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w4_child.csv", header = FALSE,   #I erased names from this one
		  na = c("9", "8", "98", "99"))

    #Export w2 data so it's in a different format (space delimited)
    #write.table(w2, file = "w2_child.dat", quote = TRUE, sep = " ", na = "-999", row.names = FALSE)

w2 = read.table("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/w2_child.dat", header = TRUE, na = "-999")

#Give names to w4
 namesforw4 = readLines("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/names_w4_child.txt")
 names(w4)
 length(names(w4))
 length(namesforw4)
 names(w4) = namesforw4

names(w1) = tolower(names(w1))
names(w2) = tolower(names(w2))
names(w3) = tolower(names(w3))
names(w4) = tolower(names(w4))

#Get education and income data (wave 1) in
educinc = read.csv("~/Computational Statistics/Computational Statistics/Assignments/Assignment 1/Data/educinc.csv", head = TRUE, na = ".")

#Getting variables of interest: 
#(wave 1: demographics, atts, pcmp, edex01, attt, atod, dscr)
#(wave 2 & 3: demographics, atts)
#(wave 4: demographics, atts, pcmp, edex01, attt, atod, dscr)
# we don't have family values at wave 4

#creating indices:
 attsindw1 = grep("atts", names(w1))
 attsindw2 = grep("atts", names(w2))
 attsindw3 = grep("atts", names(w3))
 attsindw4 = grep("atts", names(w4))

w1.sm = w1[ , c(1,2,3,8,13,18, attsindw1, 507:515, 579, 570:578, 815:823, 516:533,978)]

w2.sm = w2[ , c(1, attsindw2, grep("pcmp", names(w2)), grep("edex01", names(w2)), grep("attt", names(w2)),
                grep("atod", names(w2))[1:9], grep("dscr", names(w2)))]

w3.sm = w3[ , c(1, attsindw3, grep("pcmp", names(w3)), grep("edex01", names(w3)), grep("attt", names(w3)),
                grep("atod", names(w3))[1:9], grep("dscr", names(w3)) )]

w4.sm = w4[ , c(1, attsindw4, grep("pcmp", names(w4)), grep("edex01", names(w4)), grep("attt", names(w4)),
                grep("atod", names(w4))[1:9], grep("dscr", names(w4)) )]

#MERGING
w1.2.sm = merge(w1.sm, w2.sm, by = "famid", all = TRUE)
w3.4.sm = merge(w3.sm, w4.sm, by = "famid", all = TRUE)
w1234sm = merge(w1.2.sm, w3.4.sm, by = "famid", all = TRUE)
w1234sm = merge(w1234sm, educinc, by = "famid", all = TRUE)

#COMPUTING AVERAGE SCORES FOR ALL SCALES (atts, pcmp, attt, atod, dscr)

##### ATTS #######
# W1, W2, W3, W4
w1234sm$c01atts = with(w1234sm, (c01atts03 + c01atts07 + c01atts08 + c01atts10)/4)
w1234sm$c02atts = with(w1234sm, (c02atts03 + c02atts07 + c02atts08 + c02atts10)/4)
w1234sm$c03atts = with(w1234sm, (c03atts03 + c03atts07 + c03atts08 + c03atts10)/4)
w1234sm$c04atts = with(w1234sm, (c04atts03 + c04atts07 + c04atts08 + c04atts10)/4)

##### PCMP #######
# W1, W4
#reverse-code items 1 and 2
w1234sm$c01pcmp01R = 5 - w1234sm$c01pcmp01 #w1
w1234sm$c01pcmp02R = 5 - w1234sm$c01pcmp02 #w1

w1234sm$c04pcmp01R = 5 - w1234sm$c04pcmp01 #w4
w1234sm$c04pcmp02R = 5 - w1234sm$c04pcmp02 #w4

w1234sm$c01pcmp = with(w1234sm, (c01pcmp01R + c01pcmp02R + c01pcmp03 + c01pcmp04 + 
                                  c01pcmp05 + c01pcmp07 + c01pcmp08 + c01pcmp09)/8)
w1234sm$c04pcmp = with(w1234sm, (c04pcmp01R + c04pcmp02R + c04pcmp03 + c04pcmp04 + 
                                  c04pcmp05 + c04pcmp07 + c04pcmp08 + c04pcmp09)/8)

##### ATTT #######
# W1, W4
w1234sm$c01attt = with(w1234sm, (c01attt01 + c01attt02 + c01attt03 + c01attt04 + 
                                   c01attt05  + c01attt06 + c01attt07 + c01attt08 +
                                   c01attt09)/9)
#for W4
w1234sm$c04attt = with(w1234sm, (c04attt01 + c04attt02 + c04attt03 + c04attt04 + 
                                   c04attt05  + c04attt06 + c04attt07 + c04attt08 +
                                   c04attt09)/9)

##### ATOD #######
# W1, W4
w1234sm$c01atod = rowSums(w1234sm[, 41:49], na.rm = T)
# W4
w1234sm$c04atod = rowSums(w1234sm[, 227:235], na.rm = T)

w1234sm$c01atod
w1234sm$c04atod

##### DSCR #######
# W1, W4
w1234sm$c01dscr = with(w1234sm, (c01dscr07 + c01dscr08 + c01dscr09 + c01dscr10)/4)
w1234sm$c04dscr = with(w1234sm, (c04dscr07 + c04dscr08 + c04dscr09 + c04dscr10)/4)

dim(w1234sm)
##DESCRIBE TO DOUBLE CHECK
library(psych)
double_check = describe(w1234sm)
save(double_check, file = "double_check.RData")
load("double_check.RData")  #if I remove object right above, loading it makes it reappear!
identical(double_check, describe(w1234sm))
################################
#  ASSIGNMENT 1 QUIZ QUESTIONS #
################################
#1
dim(w1234sm)
#2
max(w1234sm$fameduc, na.rm = T)
#3
length(which(w1234sm$fameduc == 19))
#4
w1234sm.4sib = w1234sm[which(w1234sm$c01sibli == 4), ]
mean(w1234sm.4sib$c01attt, na.rm = T)
#5 
abs(mean(w1234sm$c01atts - w1234sm$c04atts, na.rm = TRUE))
abs(mean(w1234sm$c01pcmp - w1234sm$c04pcmp, na.rm = TRUE))
abs(mean(w1234sm$c01attt - w1234sm$c04attt, na.rm = TRUE))
abs(mean(w1234sm$c01dscr - w1234sm$c04dscr, na.rm = TRUE))
abs(mean(w1234sm$c01atod - w1234sm$c04atod, na.rm = TRUE)) # biggest difference

t.test(w1234sm$c01atod, w1234sm$c04atod, paird = TRUE)

w1234sm$new_edu[w1234sm$fameduc < 7 & !is.na(w1234sm$fameduc)] <- "Elementary"
w1234sm$new_edu[w1234sm$fameduc >= 7 & w1234sm$fameduc < 13 & !is.na(w1234sm$fameduc)] <- "High School"
w1234sm$new_edu[w1234sm$fameduc >= 13 & w1234sm$fameduc < 17 & !is.na(w1234sm$fameduc)] <- "College"
w1234sm$new_edu[w1234sm$fameduc >= 17 & !is.na(w1234sm$fameduc)] <- "More than College"
w1234sm$new_edu <- factor(c(w1234sm$new_edu), levels = c("Elementary", "High School", "College", "More than College"), exclude = NA)

hs_group <- subset(w1234sm, new_edu == "High School" & !is.na(c04edex01))
college_group <- subset(w1234sm, new_edu == "College" & !is.na(c04edex01))
t.test(hs_group$c04edex01, college_group$c04edex01, parid = TRUE)

