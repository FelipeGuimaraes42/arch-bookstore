# Architecture Hortifruti
## Architecture Patterns Comparison for Java E-commerce System
This project aims to compare various architecture patterns in a simple Java-based e-commerce system. The goal is to analyze different architectural approaches and evaluate their benefits and trade-offs in terms of scalability, maintainability, performance, and other relevant factors.

## Summary
- [Project Overview](#overview)
- [Architecture Patterns](#architecture-patterns)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [License](#license)

## Project Overview <a name="overview"></a>
The project focuses on building a basic e-commerce system using Java. It includes functionalities such as product listing, shopping cart management, and user authentication. The primary objective is to implement and compare multiple architecture patterns to understand their strengths and weaknesses in the context of an e-commerce application.

The system's main components include:

Product Catalog: Responsible for managing product information, such as name, description, and price.
Shopping Cart: Handles the addition, removal, and updating of products in the cart for each user.
User Authentication: Provides user registration, login, and session management functionalities.


## Architecture Patterns <a name="architecture-patterns"></a>
The project aims to compare the following architecture patterns:

### Big Ball of Mud:
- Description: The Big Ball of Mud architecture is an informal, unstructured architectural style where the system lacks a clear modular structure or defined architectural boundaries. It typically arises from ad hoc development practices and a lack of architectural planning.
- Characteristics: Tightly coupled components, no clear separation of concerns, lack of architectural documentation, and difficulty in maintaining and evolving the system.

### MVC (Model-View-Controller):
- Description: MVC is an architectural pattern commonly used in web and desktop applications. It separates the application into three interconnected components: Model (data and business logic), View (user interface representation), and Controller (handles user input and orchestrates the interaction between Model and View).
- Characteristics: Clear separation of concerns, modular design, ease of testing and maintenance, and support for multiple views of the same data.

### Hexagonal Architecture (Ports and Adapters):
- Description: Hexagonal Architecture, also known as Ports and Adapters, emphasizes a clear separation between the core business logic (inside the hexagon) and the external dependencies (outside the hexagon). The core defines interfaces (ports) that are implemented by adapters to interact with external systems.
- Characteristics: Focuses on domain-driven design, decoupling of core business logic from external systems, flexibility to change or replace external dependencies, and testability through the use of ports and adapters.

### Clean Architecture:
- Description: Clean Architecture is an architectural approach that emphasizes separation of concerns and the independence of different layers. It prioritizes the business logic and isolates it from external frameworks, databases, and user interfaces. The architecture consists of concentric circles representing different layers, with the innermost layer containing the most critical business rules.
- Characteristics: Strong focus on domain-centric design, independence of frameworks and infrastructure, testability, flexibility to adapt to changing requirements, and easier maintenance and evolution of the system.


Each pattern will be implemented and evaluated based on several criteria, including:
- Scalability: Ability to handle increased load and easily scale specific components.
- Maintainability: Ease of understanding, modifying, and extending the system.
- Performance: System responsiveness and throughput under different loads.
- Testability: Simplicity and effectiveness of testing components in isolation.
- Flexibility: Ability to adapt to changing requirements and integrate with external systems.

## Getting Started  <a name="getting-started"></a>
To run the project locally, make sure you have Java and Maven installed on your system and follow these steps:

- Clone the repository: `git clone https://github.com/FelipeGuimaraes42/architecture-hortifruti.git`
- Open the project on your favorite IDE (I recomend IntelliJ or Eclipse)
- Build the project and download the dependencies: `mvn clean install`
- Choose one architecture (`cd mvc`, for example)
- Run the application: `mvn spring-boot:run` via command line, or use the IDE button.

## Contributing <a name="contributing"></a>
Not accepting right now!

~~Contributions are welcome! If you have suggestions, bug reports, or would like to add more architecture patterns to the comparison, please open an issue or submit a pull request.~~

## License <a name="license"></a>
