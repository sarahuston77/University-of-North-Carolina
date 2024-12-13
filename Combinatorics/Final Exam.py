"""Code used during timed final exam to check the number of 4 digit numbers
without 3 consecutive digits e.g., *123, 568*. """

numbers = [str(i) for i in range(1000,10000)]
triples = ["012", "123", '234', '345', '456', '567', '678', '789']
numbers_clean = [number for number in numbers if number[:-1] not in triples and number[1:] not in triples]