🔧 Prérequis
Avant de commencer, assurez-vous d'avoir installé :

JDK 17 ou supérieur
Maven 3.6+ ou supérieur
MySQL 8.0+ ou supérieur
Un IDE Java (IntelliJ IDEA, Eclipse, VS Code, etc.)

🛠️ Technologies utilisées

Java : 17+
Spring Boot : 3.x
Spring Data JPA : Pour la persistance des données
MySQL : Base de données relationnelle
Lombok : Pour réduire le code boilerplate
SpringDoc OpenAPI : Documentation Swagger/OpenAPI
Maven : Gestion des dépendances

📥 Installation
1. Cloner le projet
bashgit clone <url-de-votre-repo>
cd gestion_produits
2. Configurer MySQL
Créez une base de données MySQL :
CREATE DATABASE gestion_produits;
3. Configurer le fichier application.properties
Modifiez le fichier src/main/resources/application.properties avec vos paramètres MySQL :
propertiesspring.datasource.url=jdbc:mysql://localhost:3306/gestion_produits
spring.datasource.username=votre_username
spring.datasource.password=votre_password
🚀 Lancement du projet
Avec Maven (ligne de commande)
bash# Nettoyer et compiler le projet
mvn clean install

# Lancer l'application
mvn spring-boot:run
Avec votre IDE
IntelliJ IDEA

Ouvrez le projet dans IntelliJ
Attendez que Maven télécharge les dépendances
Localisez la classe principale avec @SpringBootApplication
Cliquez sur le bouton ▶️ vert à côté de la classe
Ou utilisez le raccourci : Shift + F10

Eclipse

Importez le projet Maven
Clic droit sur le projet → Run As → Spring Boot App

VS Code

Installez l'extension "Spring Boot Extension Pack"
Ouvrez la palette de commandes (Ctrl+Shift+P)
Tapez "Spring Boot: Run"

Vérifier que l'application fonctionne
L'application démarre sur le port 8080 par défaut.
Vous devriez voir dans la console :
Started GestionProduitsApplication in X.XXX seconds
Testez avec :
bashcurl http://localhost:8080/api/produit
📚 Documentation API
Swagger UI
Une fois l'application lancée, accédez à la documentation interactive Swagger :
URL : http://localhost:8080/swagger-ui.html
Formats de documentation

Interface interactive : http://localhost:8080/swagger-ui.html
JSON OpenAPI : http://localhost:8080/v3/api-docs
YAML OpenAPI : http://localhost:8080/v3/api-docs.yaml
🔗 Endpoints disponibles
GET : api/produits  : Récupérer tous les produits
GET : api/produits/{id}  : Récupérer un produit par ID
POST : api/produits  : Créer un produit
PUT : api/produits/{id}  : Mettre à jour un produit
DELETE : api/produits/{id}  : Supprimer un produit
