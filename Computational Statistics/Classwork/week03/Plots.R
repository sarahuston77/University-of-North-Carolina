data(airquality)
head(airquality)

airquality$seasons <- matrix(,length(airquality$Ozone),1)
airquality$seasons[which(airquality$Month== 5)] <- "Spring"
airquality$seasons[which(airquality$Month == 6 & airquality$Day)]
airquality$seasons[ which(airquality$Month== 7 | airquality$Month)]
airquality$seasons[which(airquality$Month == 6 & airquality$Day)]
airquality$seasons[which(airquality$Month== 9 & airquality$Day)]
airquality$seasons[which(airquality$Month == 9 & airquality$Day)]
                                                                                                                              
hist(airquality$Wind)

require(ggplot2)
# First let's define the data space
g <- ggplot(data=airquality, mapping = aes(Wind))
g

# Now we can use this "g" object and
# try out different layers
g + geom_histogram(binwidth = 2)

g + geom_histogram(breaks=seq(1, 21, by=2),
                   col="red",
                   fill="green",
                   alpha = .2) +
  labs(title="Histogram for Wind")

g + geom_histogram(aes(fill = seasons),
                   breaks=seq(1, 21, by=2),
                   col="black")

g + geom_density(aes(fill=factor(seasons)), alpha=0.8) +
  labs(title="Density plot",
       subtitle="Wind by Season",
       x="Wind",
       fill="Season")

# Let's define a new data space so we include "seasons"
gseas <- ggplot(airquality, aes(seasons, Wind))
gseas + geom_boxplot(varwidth=T, fill="plum") +
  labs(title="Box plot",
       subtitle="Wind by Seasons",
       x="Season",
       y="Wind")

gseas + geom_violin() +
  labs(title="Violin plot",
       subtitle="Wind vs Seasons",
       x="Season",
       y="Wind")
