# Stock Market Simulation
This project is a stock market simulation that uses real-time prices obtained through the AlphaVantage API. It facilitates learning and experimentation with the market by allowing users to create portfolios, trade, and apply different strategies.

The project was designed and developed using an MVC architecture, adhering to SOLID principles and utilizing various design patterns such as Factory and Singleton. It was delivered in iterations on a bi-weekly basis using agile and test-driven development.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Architecture](#architecture)
- [Technologies Used](#technologies)
- [Screen Captures](#screencaptures)
- [Credits](#credits)
- [License](#license)

## Installation

Instructions on how to install and set up the project.

1. Download the project zip and uncompress and open as project in IntelliJ.

2. If you want to setup in IntelliJ then you need to download jar as follows and need to add in modules<br/>
   &nbsp;2.1. Jcalender<br/>
   &nbsp;&nbsp;&nbsp;2.1.1. Download jcalender from https://www.toedter.com/download/jcalendar-1.4.zip<br/>
   &nbsp;&nbsp;&nbsp;2.1.2. Extract and jcalendar-1.4.jar can be found in lib folder of extracted library<br/>
   
   &nbsp;2.2. Jfreechart<br/>
   &nbsp;&nbsp;&nbsp;2.2.1. Download Jfreechart from https://sourceforge.net/projects/jfreechart/<br/>
   &nbsp;&nbsp;&nbsp;2.2.2. extract and add jar from lib folder into intellij modules<br/>

## Usage

Instructions on how to use the project.
<span style="background-color: #FFFF00">NOTE: Currently, we are supporting high value stocks only list can be found in res/ folder</span>

1. Your present working directory should be as:<br/>
   &nbsp;panjwaniha@Haris-MacBook-Air res % pwd<br/>
   &nbsp;/Users/panjwaniha/IdeaProjects/assign-6-stocks-part-3/res<br/>

2. To run Jar file<br/>
   &nbsp;panjwaniha@Haris-MacBook-Air res % java -jar assign-6-stocks-part-3.jar<br/>

## Features

1. Real-time prices obtained through the AlphaVantage API
2. Ability to create portfolios and trade stocks
3. Support for applying different strategies
4. Visualization of portfolio performance over time based on trades
5. Test coverage of 97%

## Architecture

The project uses an MVC architecture, where the Model represents the data and the business logic, the View represents the user interface, and the Controller acts as an intermediary between the Model and the View. The project also utilizes various design patterns such as Factory and Singleton to improve code maintainability and reusability.

## Technologies Used

1. AlphaVantage API
2. MVC Architecture
3. Factory and Singleton Design Patterns
4. Agile and Test-Driven Development
5. Java

## Screen Captures

1. ![Text UI](https://github.com/PratikSymz/Stock-Market_Simulator/blob/main/screencaptures/Screenshot%202023-07-09%20at%2020.06.28.png)
1.1. ![Load Portfolio and Show value](https://github.com/PratikSymz/Stock-Market_Simulator/blob/main/screencaptures/Screenshot%202023-07-09%20at%2020.07.08.png)
1.2. ![Performance over time](https://github.com/PratikSymz/Stock-Market_Simulator/blob/main/screencaptures/Screenshot%202023-07-09%20at%2020.46.14.png)

2. ![GUI Main Menu](https://github.com/PratikSymz/Stock-Market_Simulator/blob/main/screencaptures/Screenshot%202023-07-09%20at%2020.47.02.png)
2.1. ![Buy/Sell Stock](https://github.com/PratikSymz/Stock-Market_Simulator/blob/main/screencaptures/Screenshot%202023-07-09%20at%2020.47.39.png)
2.2. ![Add Strategy](https://github.com/PratikSymz/Stock-Market_Simulator/blob/main/screencaptures/Screenshot%202023-07-09%20at%2020.48.16.png)
2.3. ![Performance Graph](https://github.com/PratikSymz/Stock-Market_Simulator/blob/main/screencaptures/portfolio-performance-graph.png)

## Credits
This project was designed and developed by Hari Vilas Panjwani and Pratik Budhiraja. Special thanks to AlphaVantage for providing the API used in this project.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
