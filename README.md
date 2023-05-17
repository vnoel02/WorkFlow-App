# Final Iteration Report
For the final iteration, a total of five userstories were implemented. The one was about implementing a way to enter tasks into a view of calendar. It's scenarios involved basic operations of entering a task. The second userstory involved operations like editing a task. The second scenario couldn't be implemented, which discussed deleting a task. One userstory was about adding a light mode and dark mode to the profile activity. Next two user stories involved creating a profile and implementing an easy userface. 

We were unable to implement userstory #4 as there's not enough time to implement.

#### Velocity Points:
Userstory #1: 1 point

Userstory #2: 1 point

Userstory #6: 1 point

Userstory #7: 1 point

Userstory #9: 2 points 


Design Archecture: The Model View Controller (MVC) was used mainly for the profile creation activity and parts of the calendar view. It involves the usage of databases and datastorages that the user would interact with via user interface. For the calendar view, an Adapter design was used so the different views (Day view, Weekly View, Event View) would be able to share the same data and influence the UI accordingly.

Warning/Error Removal: There were some errors left unattended because they were mainly refering to commented out code or miniscule issues with xml layout where Android Studio would find that the layout would be too wide for desktop screens which is irrelevent for our goals.


# Second Iteration Report 
Two new userstories were implemented. One userstory involves the connection between two parts of the app, profile creation and the organizational calendar. The other was a simple notification/toast that was provided from selecting a specific date. The main issues that arrived from implementing the userstories was combining the profile activity and the calendar activity as the calendar activity required a different package and methods to implement correctly compared to the straightforward profile creator. 

#### Velocity Points:
 Userstory #3: 1 point
 
 Userstory #10: 3 points

Totoal: 4 points


# First Iteration Report

Both user stories for the first iteration were implemented however were modified due to the size of the userstories. Some scenarios are large enough to become it's own userstory for the next iteration. The profile page mentioned a userstory has been implemented, however, the scenario where multiple profiles could be created is left for a future iteration.

#### Velocity Points:
 Userstory #8: 1 point

 UserStory #5: 1 point

Total: 2 points

Note: Since the other half of the userstories would be completed in the next iteration, the velocity points of each story is halved.









# Project Proposal

## Group: 9 Inc

Victor Noel, victor.noel25@bcmail.cuny.edu, vnoel02

Rodler Jean, rodjean1234@gmail.com , rodjean1234

md ayub nabi , mdayubn@yahoo.com, ayub8

## App Name: WorkFlow

### Function 1: Notification Handling
Description: It is important as a study/work organization app to have the ability to introduce notifications to the user. This involves some of the NotificationCampat, a class that allows use to create and modify notifications.

### Function 2 : Assigned task
Description: The application would have assigned specific task to periods of times that can be modified by the user. 

### Funciton 3 : Customizable task
description: app gives real time alerts when the assined task is due. and can also send reminder ahead of time. 

### Risks and Mitigation
Description: One risk we have is poor user interface. Since our app help users oraganize their scheldule it would be very important that the UI is very user friendly and customizable. We plan to have an agile development methodology to help lessen the risk of UI not being up to standard. Another risk we have is designing the app for an outdated api. To counter this risk we plan too continuosly update the apllication with new releases of Android.
