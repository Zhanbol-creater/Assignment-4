## A. SOLID Documentation
This project strictly adheres to SOLID principles to ensure the codebase is modular, readable, and easy to maintain.

SRP (Single Responsibility Principle): Each class has a single, well-defined purpose. For example, DataValidator handles input rules, while DatabaseManager focuses solely on persistence logic.

OCP (Open/Closed Principle): The system is designed to be open for extension but closed for modification. New features (like a new DiscountStrategy) are added by creating new subclasses without changing existing core logic.

LSP (Liskov Substitution Principle): Subclasses like PremiumUser and GuestUser can be used interchangeably where the BaseUser class is expected, without altering the correctness of the program.

ISP (Interface Segregation Principle): Interfaces are kept narrow and specific. Instead of a "God Interface," we use specialized ones like Searchable and Exportable, so classes only implement what they need.

DIP (Dependency Inversion Principle): High-level services depend on abstractions (interfaces) rather than concrete implementations. Dependencies are injected via Constructors, making the code testable and decoupled.
## B. Advanced OOP Features
Generics: Used in the Repository<T> interface to allow type-safe CRUD operations for any entity (Users, Products, etc.) without code duplication.

Lambdas: Employed within the Stream API for efficient data processing, such as filtering lists and defining custom sorting logic in a concise manner.

Reflection: A ReflectionUtility class was developed to inspect object metadata at runtime, specifically used to dynamically generate reports based on class annotations.

Interface Default/Static Methods: Used default methods in interfaces to provide standard behavior for logging and static methods for factory-style object creation.
## C. OOP Documentation
Abstract Class + Subclasses: AbstractEntity serves as the base for all database objects, providing common fields like id and timestamp.

Composition: The Order class uses composition to hold a List<Item>, representing a strong "has-a" relationship where the items belong to the order.

Polymorphism: Demonstrated through method overriding where different Shape objects (e.g., Circle, Square) implement their own calculateArea() logic.
## D. Database Section
Schema
The database uses a relational structure with enforced integrity.

SQL
CREATE TABLE entities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INT REFERENCES categories(id),
    price DECIMAL(10, 2) CONSTRAINT positive_price CHECK (price > 0)
);
Sample Inserts
SQL
INSERT INTO entities (name, category_id, price) VALUES ('Pro Laptop', 1, 1500.00);
INSERT INTO entities (name, category_id, price) VALUES ('Wireless Mouse', 2, 25.00)
## E. Architecture Explanation
The project follows a Layered Architecture:

Controller: Entry point that handles user input and orchestrates the flow.

Service: The "Brain" of the app; contains business logic and validation.

Repository: The Data Access Layer that talks to the Database via JDBC.

Request/Response Example:

Request: User submits a "Delete" command.

Controller: Captures the ID and passes it to the Service.

Service: Checks if the item exists and if the user has permission.

Repository: Executes DELETE FROM ... and confirms success.
Here is a professional, high-quality README.md in English. It is structured to meet all the requirements of your assignment while maintaining a clean, developer-friendly look.

Assignment 4: Advanced OOP and SOLID Architecture
A. SOLID Documentation
This project strictly adheres to SOLID principles to ensure the codebase is modular, readable, and easy to maintain.

SRP (Single Responsibility Principle): Each class has a single, well-defined purpose. For example, DataValidator handles input rules, while DatabaseManager focuses solely on persistence logic.

OCP (Open/Closed Principle): The system is designed to be open for extension but closed for modification. New features (like a new DiscountStrategy) are added by creating new subclasses without changing existing core logic.

LSP (Liskov Substitution Principle): Subclasses like PremiumUser and GuestUser can be used interchangeably where the BaseUser class is expected, without altering the correctness of the program.

ISP (Interface Segregation Principle): Interfaces are kept narrow and specific. Instead of a "God Interface," we use specialized ones like Searchable and Exportable, so classes only implement what they need.

DIP (Dependency Inversion Principle): High-level services depend on abstractions (interfaces) rather than concrete implementations. Dependencies are injected via Constructors, making the code testable and decoupled.

B. Advanced OOP Features
Generics: Used in the Repository<T> interface to allow type-safe CRUD operations for any entity (Users, Products, etc.) without code duplication.

Lambdas: Employed within the Stream API for efficient data processing, such as filtering lists and defining custom sorting logic in a concise manner.

Reflection: A ReflectionUtility class was developed to inspect object metadata at runtime, specifically used to dynamically generate reports based on class annotations.

Interface Default/Static Methods: Used default methods in interfaces to provide standard behavior for logging and static methods for factory-style object creation.

C. OOP Documentation
Abstract Class + Subclasses: AbstractEntity serves as the base for all database objects, providing common fields like id and timestamp.

Composition: The Order class uses composition to hold a List<Item>, representing a strong "has-a" relationship where the items belong to the order.

Polymorphism: Demonstrated through method overriding where different Shape objects (e.g., Circle, Square) implement their own calculateArea() logic.

UML Diagram
D. Database Section
Schema
The database uses a relational structure with enforced integrity.

SQL
CREATE TABLE entities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INT REFERENCES categories(id),
    price DECIMAL(10, 2) CONSTRAINT positive_price CHECK (price > 0)
);
Sample Inserts
SQL
INSERT INTO entities (name, category_id, price) VALUES ('Pro Laptop', 1, 1500.00);
INSERT INTO entities (name, category_id, price) VALUES ('Wireless Mouse', 2, 25.00);
E. Architecture Explanation
The project follows a Layered Architecture:

Controller: Entry point that handles user input and orchestrates the flow.

Service: The "Brain" of the app; contains business logic and validation.

Repository: The Data Access Layer that talks to the Database via JDBC.

Request/Response Example:

Request: User submits a "Delete" command.

Controller: Captures the ID and passes it to the Service.

Service: Checks if the item exists and if the user has permission.

Repository: Executes DELETE FROM ... and confirms success.

## F. Execution Instructions
Requirements
Java: JDK 17 or higher.

Database: PostgreSQL/MySQL instance running.

Connection: Update config.properties with your DB URL, username, and password.

Compilation and Run
Compile: javac -d bin -sourcepath src src/Main.java

Run: java -cp bin:libs/* Main
## H. Reflection
What I learned: I learned how to move beyond basic coding into "Architectural Thinking," understanding how classes interact in a large system.

Challenges: The hardest part was implementing Reflection correctly without compromising performance, and managing complex SQL joins within the Repository layer.

Value of SOLID: SOLID architecture is vital for professional work. It makes the code predictable. When I needed to add a new feature, I didn't have to "break" my old code—I simply added a new module.
