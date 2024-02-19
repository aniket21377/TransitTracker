TransitTracker: A Comprehensive Journey Tracking Application

What the Project Does:
TransitTracker is a robust application designed to track journeys, providing users with essential details such as route information, stops, distances between stops, and real-time progress updates. It ensures a seamless user experience with dynamic features like unit conversion, progress tracking, and lazy loading for extensive routes.

Why the Project is Useful:
This project serves as a valuable tool for individuals traveling via various modes of transportation. Whether for daily commutes or long-distance trips, TransitTracker offers convenience and reliability by presenting crucial journey data in an intuitive and accessible format. Users can stay informed about their travel progress, plan ahead, and make informed decisions during transit.

How Users Can Get Started with the Project:
Installation: Install TransitTracker on your Android device or emulator.
Launch the App: Open the app to access the main interface.
View Journey Details: Explore the journey route, stops, distances, and progress indicators.
Interact with Buttons: Toggle between kilometres and miles using the unit conversion button. Signal the arrival at the next stop by tapping the designated button.
Track Progress: Monitor the journey's progress through the dynamic progress bar and textual updates.
Explore Sample Data: Familiarize yourself with the app's functionality using the provided sample data.

Project Components

MainActivity:
The entry point of the application.
Utilizes Jetpack Compose for UI setup.
Includes necessary lifecycle functions like onCreate().

Data Class:
Represents transit information such as source, destination, distance, and journey state.

SampleData Object:
Provides pre-defined sample data for demonstration purposes.

Composable Functions:
MessageCard: Displays transit message cards for individual stops.
Conversation: Renders a conversation list for journeys with more than 10 stops.
OrdinaryColumn: Renders a conversation list for journeys with 10 or fewer stops.
Greeting: Represents the main UI screen, comprising text boxes, progress bars, buttons, and essential UI elements.

Utility Functions:
convertMilesToKm: Converts distance from miles to kilometres.
convertKmToMiles: Converts distance from kilometres to miles.

Preview:
GreetingPreview: Provides a visual preview of the main UI theme for testing and design purposes.


