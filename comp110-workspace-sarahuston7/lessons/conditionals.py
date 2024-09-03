"""Testing Condiontals with low card example"""

low_card: int = 5
current_card: int = 6

if current_card < low_card:
    low_card = current_card
else:
    print(str(current_card) + " is not the low card")
print("The low card is " + str(low_card) )

#hey