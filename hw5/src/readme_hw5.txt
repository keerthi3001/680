CS 680 – Homework 5
Author: Keerthi
Project: Laundry System with Multicast Notifications

Overview
HW5 extends HW4’s observer-based laundry system to two independent event
streams: machine Status (AVAILABLE/IN_USE/FINISHED) and Energy (watts).
Observers can subscribe to either stream or both. Unsubscription is supported,
and duplicate values are not rebroadcast.

Files (package hw5)
- MachineStatus, StatusEvent, EnergyEvent
- StatusObserver, EnergyObserver
- StatusChannel, EnergyChannel
- LaundryController (owns both channels; exposes subscription APIs)
- WallDisplayObserverV2 (status only), MobileAppObserverV2 (status+energy),
  AnalyticsObserverV2 (status+energy; counts statuses and averages watts)

Build & Run (same as HW4)
ant clean
ant resolve
ant test
ant build
(or: ant test-console)

Notes
Initial states aren’t broadcast unless changed. This keeps behavior consistent
with HW4 where Analytics counts only events actually emitted.
