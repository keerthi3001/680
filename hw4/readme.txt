CS 680 – Homework 4  
Author: Keerthi  
Project: Laundry Machine Notification System (Observer Design Pattern)

------------------------------------------------------------
Overview
------------------------------------------------------------
This project demonstrates the Observer design pattern using a 
Laundry Machine Notification System. When a laundry machine 
changes its status (e.g., AVAILABLE → IN_USE → FINISHED), all 
registered observers are automatically notified.

The system separates the observable objects (laundry machines) 
from the observers (mobile notifier, wall display, analytics tracker). 
This allows one-to-many event communication and makes it easy 
to add or remove observers without modifying the observable code.

------------------------------------------------------------
Classes and Design
------------------------------------------------------------
• Observable<T>        – Generic class that manages observer registration 
                          and event notifications.
• Observer<T>          – Interface implemented by all observers.
• LaundryMachineObservable – Observable subclass representing a washing 
                          machine that broadcasts status changes.
• LaundryEvent         – Value object containing machine ID and status.
• MachineStatus        – Enum for AVAILABLE, IN_USE, and FINISHED.
• MobileNotifierObserver – Sends mobile-style notifications to users.
• WallDisplayObserver  – Prints status updates to a simulated wall display.
• AnalyticsObserver    – Tracks how many times each status occurred.

------------------------------------------------------------
Testing
------------------------------------------------------------
Two JUnit 5 test classes are included:
• LaundryObserverBasicTest – Verifies single machine event notifications.
• LaundryObserverEdgeTest  – Verifies multiple machines and multiple 
                             observers scenario.

------------------------------------------------------------
How to Build and Run
------------------------------------------------------------
Requirements:
• Apache Ant 1.10+ with Ivy support
• Java 17 or newer

Steps:
1. Open a terminal in this project folder.
2. Run the following commands in order:

   ant clean
   ant resolve
   ant test
   ant build

   (or use 'ant test-console' for detailed JUnit output)

If successful, compiled files are in:
   build/main/
   build/test/

JUnit test results appear in the console.

------------------------------------------------------------
Notes
------------------------------------------------------------
• The AnalyticsObserver only counts events that are broadcasted 
  by LaundryMachineObservable. Initial states are not included 
  unless explicitly notified.

• The code follows the UML and API structure discussed in Lecture 9.

------------------------------------------------------------
End of File
------------------------------------------------------------
