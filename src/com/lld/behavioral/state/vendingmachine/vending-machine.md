Imagine you're building a simple vending machine system
On the surface, it seems straightforward : accept money, dispense products
and go back to idle

But the tricky part is that the machine's behavior must change depending on
what's happening right now. A vending machine can be in only one state 
at a time, for example : 

IdleState: Waiting for user input (nothing selected, no money inserted)

ItemSelectedState: An item has been selected, waiting for payment

HasMoneyState: Money has been inserted, waiting to dispense selected item

DispensingState: The machine is actively dispensing the item

The machine supports a few user facing operations :

selectItem(String itemCode) - Select an item to purchase 

insertCoin(double amount) - Insert payment for the selected item

dispenseItem() - Trigger an item dispensing process

Each of these methods should behave differently based on machine's current state

For example, calling dispenseItem() while the machine is in IdleState should do
nothing or show an error

Calling insertCoin() before selecting an item should be disallowed
Calling selectItem() during dispenseState should ignored until the item
is dispensed

Naive Approach 

A common but flawed approach is to manage state transitions manually inside a 
monolithic VendingMachine class using if-else or switch statements