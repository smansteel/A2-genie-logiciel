# Genep'isep : Outil de gestion des compétences

## Frontend : Angular - Tailwind CSS

Rendez vous dans le dossier front :

```sh
cd ./front
```

Pour installer ce projet il faudra avoir pnpm, npm et node installé.
Vous pouvez télécharger Node [ici](https://nodejs.org/en/download/package-manager). Une fois Node installé, pnpm peut être installé avec :

```sh
npm install -g pnpm
```

Vous pouvez maintenant installer les dépendences du projet avec :

```sh
pnpm install
```

Vous pouvez maintenant build le projet :

```sh
pnpm run build
```

Une fois le projet build, rendez vous dans le dossier dist/front/browser :

```sh
cd ./dist/front/browser
```

Vous pouvez servir les fichiers de cette application statiquement sans problèmes avec le serveur web de votre choix !

## Backend : Java Spring

Pour executer le backend, il faudra avoir une base de données PostgresQL, voici un fichier docker compose simple pour en créer une :

```yaml
version: "3.9"

services:
    postgres:
        image: postgres:16-alpine
        ports:
            - 54322:5432 # uses port 54322 to open database on local server
        volumes:
            - ./pgdata:/var/lib/postgresql/data
        environment:
            - POSTGRES_PASSWORD= # postgres root password
            - POSTGRES_USER= # postgres root username
            - POSTGRES_DB= # postgres database name
        restart: unless-stopped
```

une fois ce fichier `compose.yaml` enregistré, celui ci peut être démarré avec

```sh
docker compose up
```

Rendez vous dans le dossier backend :

```sh
cd ./backend
```

Pour installer ce projet il faudra avoir un JDK java installé.
Vous pouvez télécharger Eclipse Temurin, un JDK populaire et open source [ici](https://adoptium.net/fr/temurin/releases/?os=windows&arch=x64).

Enregistrez les variables d'environnement suivantes :

```sh
db_password=
db_string=
db_username=
jwt_secret=
```

Note : la variable `db_string` doit avoir cette forme là : `jdbc:postgresql://host:port/database`

Sur windows:

```sh
./mvnw.cmd spring-boot:run
```

Sur les systèmes POSIX :

```sh
./mvnw spring-boot:run
```

Note : Le fichier n'a pas forcément les permissions d'execution car il est en provenance du web, effectuez la commande suivante pour le rendre executable :

```sh
chmod +x ./mvnw
```

## Utilisez le projet !
