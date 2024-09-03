"""Learning how to use a dictionary."""

#Constructing a dictionary
ice_cream: dict[str, int] = {"chocolate": 12, "vanilla": 8, "strawberry": 5}

#Adding a key, value pair to a dictionary
ice_cream["mint"] = 3

#Removing a key
ice_cream.pop("mint")

#Accessing a value
print(ice_cream["chocolate"])

#Adjusting a value
ice_cream["vanilla"] = 10
#ice_cream["vanilla"] += 2

#Getting the length (number of pairs)
print(len(ice_cream))

#Check if a value is in dictionary
"mint" in ice_cream
"chocolate" in ice_cream

if "mint" in ice_cream and "chocolate" in ice_cream:
    print(f"Number of orders: {ice_cream['mint']}")
else:
    print("No orders of mint")

#Using a loop to print keys with their values
for key in ice_cream:
    #print <flavor> has <num_orders> orders"
    print(f"{key} has {ice_cream[key]} orders.")

print(ice_cream)


