# Golf Club Management System

## Prerequisites
- Docker
- Docker Compose
- Maven

## Running the Application

### Using Docker Compose
1. Clone the repository
2. Ensure you're in the project root directory
3. Build and run:
   ```bash
   docker-compose up --build
   ```

### Local Development
1. Ensure MySQL is running locally
2. Update `application.properties` database settings
3. Run with Maven:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints
- Members: `/api/members`
- Tournaments: `/api/tournaments`

### Search Endpoints
- Members by name: `/api/members/search/name?name=`
- Tournaments by location: `/api/tournaments/search/location?location=`
