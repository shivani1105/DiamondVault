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

Before setting up **DiamondVault**, ensure you have the following tools and foundational knowledge:

### Prerequisites

- **Development Environment**: Install [Android Studio](https://developer.android.com/studio) as the primary IDE for this project.
- **Languages & Frameworks**: The project leverages:
  - **HTML, CSS, Bootstrap** Used for the front-end layout and styling.
  - **Java** core language for Android development.
- **MVVM Architecture**: Familiarity with the Model-View-ViewModel (MVVM) design pattern is beneficial, as the project uses ViewModelProviderFactory for UI data management.
- **Database**: [MySQL](https://www.mysql.com/) is used for data storage. Ensure you have MySQL installed and know how to configure database connections.
- **Third-Party Services**: Knowledge of QR services (for generating QR codes) is advantageous, as this project uses such a service (zxing).

### Setup Instructions

1. **Clone the repository**: Open a terminal and run the following command to clone the project repository:
   ```bash
   git clone https://github.com/shivani1105/DiamondVault.git
   cd DiamondVault
   ```
2. **Install Dependencies**: Ensure any required libraries or dependencies are installed (if applicable). For Android Studio, open the project, and it should auto-detect and install required packages.

3. **Configure MySQL**: 
  - Create a new MySQL database for the project.
  - Adjust any necessary database connection parameters in the project files to match your local MySQL setup (e.g., database name, username, password).

4. **Open in Android Studio**:
   - Import the project into Android Studio.
   - Configure the project dependencies as prompted.

5. **Run the Project**: Once everything is configured, build and run the project in Android Studio to begin development or testing.

### Project Design

- **Diagrams and Models**: The project design includes various diagrams such as domain models and sequence diagrams, created using [Flowchart Maker and Online Diagram Software](https://app.diagrams.net/).

- **Use Cases**: Use cases are written following essential principles:
  - They represent business processes initiated and completed by an actor.
  - They deliver value to the end user.

- **Expanded Use Cases**: Expanded Use cases are written that show the pre and post conditions for a use case, how the use case begins with and ends with, actor input and output actions, system responses. For example, refer to the expanded use case for registration and qr code
<div style="display: flex; justify-content: space-around;">
    <img src="/project_documentation/EUC.jpg" alt="Expanded Use Case" width="400">
    <img src="/project_documentation/EUC_QR.jpg" alt="Expanded Use Case QR" width="375">
</div>


- **Sequence Diagrams**: EUC (Expanded Use Cases) captured as sequence diagrams where actor/object and object/actor interactions are shown. For example, refer to the sequence diagram of admin login.
  
  <img src="/project_documentation/seq_diagram.jpg" alt="Sequence Diagram" width="500">
  
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
