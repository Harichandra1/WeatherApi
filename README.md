**Weather App with JavaFX**

This project is a simple weather application that uses JavaFX for the user interface for the backend services. It fetches weather data using the WeatherAPI and displays it in the UI, allowing users to enter a city and get the current temperature and weather condition.

Features
	•	Enter a city name to get current weather information.
	•	Displays the temperature and weather condition in real-time.
	•	Built using JavaFX for the UI  for the backend logic.

Technologies Used
	•	Java 17 - The programming language.
	•	JavaFX 20 - Used for building the graphical user interface (GUI).
	•	WeatherAPI - Provides weather data (via an API call).

Setup and Installation

Prerequisites
	•	JDK 17 or above: Make sure you have OpenJDK 17 installed.
	•	Maven: The project uses Maven for dependency management and building the application.
	•	WeatherAPI Key: You need to create a free account at WeatherAPI to get your API key.

Steps
	1.	Clone the repository:

git clone https://github.com/your-username/weather-app.git


	2.	Navigate to the project directory:

cd weather-app


	3.	Open the App.java file and insert your WeatherAPI key into the following line:

String apiKey = "YOUR_API_KEY";


	4.	Build and run the application with Maven:

mvn javafx:run


	5.	The application will start and open the JavaFX-based user interface where you can enter a city name to fetch weather details.

Usage
	1.	Once the application is running, enter the name of a city in the input field.
	2.	Click the “Get Weather” button.
	3.	The temperature and current weather condition of the city will be displayed.

Troubleshooting
	•	If you encounter a Module javafx.controls not found error, make sure you have the correct JavaFX version installed and set the module path correctly in your environment.
If anyone is interested in contributing and enhancing the user interface, I would welcome their collaboration.
