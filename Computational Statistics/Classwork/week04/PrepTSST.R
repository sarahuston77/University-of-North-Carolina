# This code assumes you have a project created that is named "InClass". 

####### Read in Data ########
# The data files are in my main project folder. 
# this is why I don't have to paste in the directory. 

library(dplyr)
TSST_SR <- read.table("TSST_SelfReport.csv", 
                      header = TRUE, 
                      sep = ",") %>%
  dplyr::select(ID, Gender, Race, Age, BMI, contains("Emo_"),
                contains("Sit_")) %>%
  dplyr::mutate(Race = factor(Race, levels = c(1,2,3,4,5,6,7,8), # first variable to mutate
                              labels = c("American Indian or Alaskan Native",
                                         "Asian American", 
                                         "Native Hawaiian or other Pacific Islander", 
                                         "African American", 
                                         "European American", 
                                         "Latin American",
                                         "More than one race", 
                                         "Other")),
                # second variable to mutate: 
                Gender = factor(Gender, levels = c(0,1), labels = c("Female", "Male")))

load("TSST_HR.RData")
names(TSST_HR)

TSST_HR <- as.data.frame(TSST_HR)

TSST_HRonly <- TSST_HR[ , c(1, grep("HR", names(TSST_HR)))] 
names(TSST_HRonly)

#### Let's see if the same people have data in both dataframes ######
SR_IDs <- unique(TSST_SR$ID)
HR_IDs <- unique(TSST_HRonly$ID)
all.equal(SR_IDs, HR_IDs)


###### Merge ######
TSST_HR_SR = merge(TSST_HR, TSST_SR, by = "ID", all = TRUE)

###### Recode variables ######
TSST_HR_SR[TSST_HR_SR == 999] <- NA 

TSST_HR_SR$Emo_Angry_rev <- 6- TSST_HR_SR$Emo_Angry

Emo_Angry_explore <- cbind(TSST_HR_SR$Emo_Angry, TSST_HR_SR$Emo_Angry_rev)

head(Emo_Angry_explore)

###### Get Averages #####
meanHRSpeech1 <- mean(TSST_HR_SR$HRSpeech_1, na.rm = TRUE)
# Note the "na.rm = TRUE". This removes NAs!

# Standard deviation: 
sdHRSpeech1 <- sd(TSST_HR_SR$HRSpeech_1, na.rm = TRUE)

# See results: 
meanHRSpeech1
sdHRSpeech1

