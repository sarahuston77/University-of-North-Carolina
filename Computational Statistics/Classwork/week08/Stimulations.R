set.seed(1)
myrnorm = rnorm(500, mean = 0, sd = 1)
myunif = runif(500, min = -3, max = 3)
mybinom = rbinom(500, size = 2, prob = .5)
mypois = rpois(500, lambda = 4)
par(mfrow=c(2,2))
hist(myrnorm); hist(myunif); hist(mybinom); hist(mypois)


set.seed(123)
study = runif(100, min = 0, max = 4)
deterministic = 2 + .7*study
stochastic = rnorm(100, 0, 1)
grades = deterministic + stochastic

library(lattice)
xyplot(grades ~ study, cex = 2)
myreg = lm(grades ~ study)
myreg

getwd()
setwd("/Users/sara/Computational Statistics")
setwd("/Users/sara")
