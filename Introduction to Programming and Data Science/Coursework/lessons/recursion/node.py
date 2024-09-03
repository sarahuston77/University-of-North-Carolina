"""Node Class."""

from __future__ import annotations


class Node:
    """My Node class for linked lists."""
    
    data: int
    next: Node | None
    
    def __init__(self, data: int, next: Node | None) -> None:
        """Construct Node."""
        self.data = data
        self.next = next
        return None
        
    def __str__(self) -> str:
        """Produce a string visualization of the linked list."""
        if self.next is None:
            # base case (where it ends!)
            return f"{self.data} -> None"
        else:
            return f"{self.data} -> {self.next}"
        
    def head(self) -> int:
        """Returns the data attribute for the first element in the linked list."""
        return self.data
    
    def tail(self) -> (Node | None):
        """Returns a linked list of every element minus the head."""
        if self.data == 0:
            return self.next
        else:
            return None
    
    def last(self) -> int:
        """Returns the data of the last element in the list."""
        print("1")
        if self.next is None:
            # base case (where it ends!)
            print(self.data)
            return self.data
        else:
            self = self.next
            print(f"this is new self {self}")
            return self.last()