# Inventory Service

This is a Spring Boot-based RESTful API for managing products and their stock levels. It provides endpoints for creating products, managing stock, and retrieving product and stock information. The project uses a relational database to store product and stock data and includes features like validation, exception handling, and DTO mapping.

## Key Features

### Product Management:
- Create a new product with details like name, description, price, and category.
- Retrieve product details by ID.
- Check if a product exists by ID.

### Stock Management:
- Add a product to stock (increases quantity by 1).
- Remove a product from stock (decreases quantity by 1).
- Retrieve the current stock levels for all products.

### Validation:
- Ensures that a product cannot be created with a duplicate name.
- Prevents stock quantity from going below zero.

### Exception Handling:
- Custom exceptions are thrown for scenarios like product already exists, product not found, and stock quantity already zero.

---

## Project Structure

### Key Classes

#### `ProductController`:
- REST controller for product-related operations.
- **Endpoints:**
  - `POST /api/products`: Create a new product.
  - `GET /api/products/{id}`: Retrieve product details by ID.
  - `GET /api/products/exists/{id}`: Check if a product exists by ID.

#### `StockController`:
- REST controller for stock-related operations.
- **Endpoints:**
  - `POST /api/stock/{id}`: Add a product to stock.
  - `GET /api/stock`: Retrieve the current stock levels for all products.
  - `PUT /api/stock/{id}`: Remove a product from stock.

#### `Product` and `Stock` Entities:
- JPA entities representing the `products` and `stocks` tables in the database.
- `Stock` has a one-to-one relationship with `Product`.

#### `ProductDTO` and `StockDTO`:
- Data Transfer Objects (DTOs) used for request and response payloads.
- `ProductDTO` is used for creating and retrieving product details.
- `StockDTO` is used for retrieving stock details.

#### `BaseEntity`:
- A base class for all entities that includes common fields like `id`, `createdAt`, and `updatedAt`.

#### Custom Exceptions:
- `ProductAlreadyExistsException`: Thrown when a product with the same name already exists.
- `ProductDoesNotExistsException`: Thrown when a product is not found.
- `ProductQuantityAlreadyZeroException`: Thrown when attempting to remove a product from stock with zero quantity.

#### Global Exception Handling:
- `GlobalExceptionHandler` handles custom exceptions and returns structured error responses.

---

## API Endpoints

### Product Endpoints

#### Create a Product
**Endpoint:** `POST /api/products`

**Request Body:**
```json
{
  "name": "Laptop",
  "description": "High-performance laptop",
  "price": 1200.00,
  "category": "Electronics"
}
```

**Response:**
```json
{
  "id": 1,
  "name": "Laptop",
  "description": "High-performance laptop",
  "price": 1200.00,
  "category": "Electronics"
}
```

#### Get Product by ID
**Endpoint:** `GET /api/products/{id}`

**Response:**
```json
{
  "id": 1,
  "name": "Laptop",
  "description": "High-performance laptop",
  "price": 1200.00,
  "category": "Electronics"
}
```

#### Check if Product Exists
**Endpoint:** `GET /api/products/exists/{id}`

**Response:** `true` or `false`

---

### Stock Endpoints

#### Add Product to Stock
**Endpoint:** `POST /api/stock/{id}`

**Response:**
```json
{
  "id": 1,
  "name": "Laptop",
  "description": "High-performance laptop",
  "price": 1200.00,
  "category": "Electronics"
}
```

#### Get Stock Levels
**Endpoint:** `GET /api/stock`

**Response:**
```json
[
  {
    "id": 1,
    "quantity": 5,
    "product": {
      "id": 1,
      "name": "Laptop",
      "description": "High-performance laptop",
      "price": 1200.00,
      "category": "Electronics"
    }
  }
]
```

#### Remove Product from Stock
**Endpoint:** `PUT /api/stock/{id}`

**Response:**
```json
{
  "id": 1,
  "name": "Laptop",
  "description": "High-performance laptop",
  "price": 1200.00,
  "category": "Electronics"
}
```

---

## Database Schema

### `products` Table
| Column      | Type           | Description                        |
|------------|--------------|--------------------------------|
| id         | BIGINT        | Primary key, auto-generated.   |
| name       | VARCHAR       | Product name (unique).         |
| description| VARCHAR       | Product description.           |
| price      | DECIMAL(10,2) | Product price.                 |
| category   | VARCHAR       | Product category.              |
| created_at | TIMESTAMP     | Timestamp when product was created. |
| updated_at | TIMESTAMP     | Timestamp when product was updated. |

### `stocks` Table
| Column      | Type    | Description                        |
|------------|--------|--------------------------------|
| id         | BIGINT  | Primary key, auto-generated.   |
| quantity   | INTEGER | Stock quantity.                |
| product_id | BIGINT  | Foreign key referencing products. |
| created_at | TIMESTAMP | Timestamp when stock was created. |
| updated_at | TIMESTAMP | Timestamp when stock was updated. |

---

## How to Run the Project

### Clone the repository:
```bash
git clone <repository-url>
```

### Configure the database:
Update `application.properties` or `application.yml` with your database credentials.

### Run the application:
```bash
./mvnw spring-boot:run
```

Access the API at `http://localhost:8080/api/products` and `http://localhost:8080/api/stock`.

---

## Dependencies
- Spring Boot
- Spring Data JPA
- Spring Web
- Lombok (for reducing boilerplate code)
- H2 Database (or any relational database of your choice)

---

## Future Enhancements
- Add authentication and authorization (e.g., JWT).
- Implement pagination for product and stock lists.
- Add more validation rules (e.g., price must be positive).
- Write unit and integration tests.
