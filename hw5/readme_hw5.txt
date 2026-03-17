README.txt
-----------

Course: CS 680 – Object-Oriented Design and Patterns
Assignment: HW5 – Multicast Observer Pattern
Author: Keerthi
Date: November 2025

-----------------------------------------------------
Project Description
-----------------------------------------------------
This assignment extends the observer pattern from HW4 to implement a multicast
event system that can notify multiple observers across two communication
channels — one for machine status updates and another for energy usage reports.
It models a smart laundry monitoring system, where each observer type reacts
differently to the same machine events.

The key idea is that one event (like a washing machine finishing or drawing
power) can be broadcast to several observers — such as a wall display, a mobile
app, and an analytics dashboard — through separate multicast channels.

-----------------------------------------------------
Main Components
-----------------------------------------------------
1. Core Interfaces and Events
   - StatusObserver: receives machine status updates.
   - EnergyObserver: receives energy usage updates.
   - StatusEvent: encapsulates machineId and MachineStatus.
   - EnergyEvent: encapsulates machineId and watts.

2. Observer Implementations (V2 versions)
   - WallDisplayObserverV2: prints updates to the wall display.
   - MobileAppObserverV2: receives both status and energy updates.
   - AnalyticsObserverV2: tracks event counts and computes average energy usage.

3. Channels and Controller
   - StatusChannel and EnergyChannel: maintain observer lists and broadcast events.
   - LaundryController: coordinates both channels and simulates machine activity.

-----------------------------------------------------
Folder Structure
-----------------------------------------------------
hw5/
│
├── build.xml                  → Ant build script
├── ivy.xml                    → Ivy configuration for JUnit dependencies
├── lib/                       → Contains ivy-2.5.2.jar and downloaded jars
│
├── src/
│   ├── main/hw5/              → Java source files
│   │   ├── *.java
│   └── test/hw5/              → JUnit test files
│       ├── MulticastBasicsTest.java
│       └── MulticastEdgeCasesTest.java
│
└── build/                     → Auto-generated (compiled classes + reports)

-----------------------------------------------------
Build & Run Instructions
-----------------------------------------------------
1. Clean previous builds:
   ant clean

2. Compile and test the project:
   ant test

3. If console shows � instead of bullets:
   chcp 65001
   setx JAVA_TOOL_OPTIONS "-Dfile.encoding=UTF-8"
   ant test

-----------------------------------------------------
Expected Output (Example)
-----------------------------------------------------
Wall • Machine 1 : IN_USE
Mobile • M1 -> IN_USE
Mobile • M1 -> 450.0W
Wall • Machine 1 : FINISHED
Mobile • M1 -> FINISHED
JUnit ran successfully (HW4 + HW5).

BUILD SUCCESSFUL
Tests run: 3, Failures: 0, Errors: 0

-----------------------------------------------------
Tools Used
-----------------------------------------------------
- Java JDK 17 (Eclipse Adoptium)
- Apache Ant 1.10.15
- Apache Ivy 2.5.2
- JUnit 5.11.0

-----------------------------------------------------
Submission Notes
-----------------------------------------------------
Include:
 - src/ folder
 - build.xml
 - ivy.xml
 - lib/ivy-2.5.2.jar

Do NOT include:
 - build/ directory

To zip for submission:
   Compress-Archive -Path src, build.xml, ivy.xml, lib/ivy-2.5.2.jar -DestinationPath hw5.zip

-----------------------------------------------------
End of File
-----------------------------------------------------
