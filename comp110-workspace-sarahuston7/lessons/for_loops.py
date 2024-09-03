"""For loop practice in class."""

pets: list[str] = ["Louie","Bo","Bear"]

for items in pets:
    print(f"Good boy, {items}!")

for idx in range(0,len(pets)):
    elem: str = pets[idx]
    print(f"{idx}:{elem}")
