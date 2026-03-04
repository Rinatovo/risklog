# Risklog API

API REST simple de gestion d'incidents, construite avec Spring Boot.

## Stack

- Java 17+
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- H2 (base en mémoire)
- Springdoc OpenAPI (Swagger UI)

## Lancer le projet

### Prérequis

- JDK installé (pas seulement un JRE)
- Maven Wrapper inclus dans le projet (`mvnw`, `mvnw.cmd`)

### Démarrage

```bash
# Windows
mvnw.cmd spring-boot:run

# macOS / Linux
./mvnw spring-boot:run
```

Application disponible sur:

- `http://localhost:8080`

## Documentation API (Swagger)

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Endpoints principaux

Base path: `/api/incidents`

- `GET /api/incidents` : liste tous les incidents
- `POST /api/incidents` : crée un incident

### Exemple de payload POST

```json
{
  "id": "INC-001",
  "description": "Serveur indisponible",
  "severity": "HIGH"
}
```

## Validation métier

- `id` obligatoire, max 50 caractères
- `description` obligatoire, max 500 caractères
- `severity` obligatoire: `LOW`, `MEDIUM`, `HIGH`, `CRITICAL`
- Retour `409 Conflict` si un incident avec le même `id` existe déjà

## Tests

```bash
# Windows
mvnw.cmd test

# macOS / Linux
./mvnw test
```

## Structure simplifiée

- `controller/` : endpoints REST
- `service/` : logique métier
- `repository/` : accès données
- `model/` : entité Incident
