# DiamondVault - Jewelry Inventory Management System

## Overview
DiamondVault is an inventory management application designed to streamline the tracking, organization, and monitoring of various aspects related to a jewelry business’s inventory. The application is tailored to meet the unique requirements of jewelry businesses by offering real-time tracking of product details, sales records, and revenue insights, ensuring efficient and informed inventory management.

## Project Goals
The primary objective of DiamondVault is to provide a robust and user-friendly solution for managing jewelry inventory. This includes:
- Enabling real-time tracking of product quantities and sales.
- Providing detailed product information for easy organization and access.
- Supporting financial insights with sales and revenue tracking.
- Allowing efficient product checkout and management with QR code scanning.
- Ensuring secure access through registration and login functionalities.

## Key Features
- **Product Management**: Supports adding, updating, and deleting inventory items with information such as metal size, wholesale and retail prices, gold and silver pricing, and quantity.
- **QR Code Integration**: Generates unique QR codes for each product to simplify tracking and management.
- **Sales and Revenue Monitoring**: Displays quarterly revenue, monthly sales, and transaction details.
- **Real-Time Market Updates**: Adjusts product pricing based on live gold and silver market prices.
- **Search and Filter**: Allows users to search and filter products by various attributes like title, category, and price.

## Agile-Scrum Approach
This project followed the Agile-Scrum methodology to ensure continuous development and integration of features. The Requirement to Use Case Matrix and Increment Matrix played a crucial role in aligning project requirements with development efforts and organizing task dependencies effectively:

- **Requirement to Use Case Matrix**: This matrix helped us identify and prioritize the essential use cases required to meet the project goals, ensuring that development efforts were aligned with high-priority requirements.  
  <img src="/project_documentation/rtuc_matrix.jpg" alt="Requirement to Use Case Matrix" width="500">

- **Increment Matrix**: By breaking down the use cases and tracking dependencies, the Increment Matrix facilitated structured planning across sprints, optimizing resource allocation and task assignment for each iteration.  
  <img src="/project_documentation/increment_matrix.jpg" alt="Increment Matrix" width="500">
  
Additional Scrum practices included:

1. **Sprint Planning**: Defined tasks and features for each sprint.
2. **Daily Standups**: Conducted daily meetings to discuss progress and address blockers.
3. **Sprint Review**: Reviewed completed work at the end of each sprint.
4. **Retrospective**: Discussed improvements for the upcoming sprints.
5. **Tools Used**: Trello for task management and GitHub for source control and code integration.

## Getting Started

Below is a glance into development environment and tools and structure of the project **DiamondVault**.

### Prerequisites

- **Android Development**: Set up [Android Studio](https://developer.android.com/studio) for Android development, as this project uses Java for backend logic.
- **Languages & Frameworks**: The project leverages:
  - **HTML, CSS, Bootstrap** for UI components and layout.
  - **Java** for Android development.
- **MVVM Architecture**: This project follows the Model-View-ViewModel (MVVM) design pattern, like using **ViewModelProviderFactory** for managing UI-related data.
- **Database**: [MySQL](https://www.mysql.com/) is used for data persistence, and **QR services** (a third-party service) for generating QR codes.

### Setup Instructions

1. Clone the repository and navigate to the project directory:
   ```bash
   git clone https://github.com/shivani1105/DiamondVault.git
   cd DiamondVault
   ```
2. Set up the necessary dependencies

3. Configure MySQL for the project by setting up a new database instance and adjusting any necessary connection parameters in the project files.

4. Import the project into Android Studio, configure the dependencies, and you’re ready to begin development.

### Project Design

- **Diagrams and Models**: The project design includes various diagrams such as domain models and sequence diagrams, created using [Flowchart Maker and Online Diagram Software](https://app.diagrams.net/).

- **Use Cases**: Use cases are written following essential principles:
  - They represent business processes initiated and completed by an actor.
  - They deliver value to the end user.

- **Expanded Use Cases**: Expanded Use cases are written that show the pre and post conditions for a use case, how the use case begins with and ends with, actor input and output actions, system responses. Ex: <img src="/project_documentation/EUC.jpg" alt="Expanded Use Case" width="400">.

- **Sequence Diagrams**: EUC (Expanded Use Cases) captured as sequence diagrams where actor/object and object/actor interactions are shown. For example, refer to the <img src="/project_documentation/seq_diagram.jpg" alt="Sequence Diagram" width="500">
  
## Tools and Technologies Used
- **Development**: Developed using VS Code and GitHub for code collaboration and integration.
- **Project Management**: Trello was used for task management and Agile tracking, facilitating collaboration and progress monitoring.
- **Demo and Documentation**: [YouTube Video Demo](https://www.youtube.com/watch?v=P7_rFjazdtw) showcases the application's functionality and user interface.


## How It Works
1. **Admin Login and Authentication**: Secure login for authorized access.
2. **Inventory Management**: Add products with detailed information, generate QR codes for tracking, and perform inventory operations.
3. **Sales Insights**: Access reports on quarterly revenue and monthly sales to make informed business decisions.
4. **Market Integration**: Real-time price adjustments based on gold and silver market data to keep product prices updated.
5. **QR Code Scanning**: Easy product access and checkout through QR code scanning functionality.
