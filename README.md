# Capqualif

Voici la marche à suivre pour faire tourner l'application !

Pré-requis : pour faire tourner l'application sur votre ordinateur, vous devez installer node et npm (https://phoenixnap.com/kb/install-node-js-npm-on-windows).

1) Cloner le repository sur votre ordinateur
2) Pour commencer, faisons tourner le backend ! Sur votre ordinateur, ouvrez un terminal et accédez au dossier `capqualif-poc-v1 > backend`
3) Tapez `mvn package` : cette commande permet de créer un fichier `backend-0.0.1-SNAPSHOT.jar`, qui est une version exécutable du backend de l'application
4) Toujours dans le terminal, accédez au dossier `target`
5) Tapez `java -jar backend-0.0.1-SNAPSHOT.jar` : la commande fait démarrer l'exécutable, qui tournera sur le port 8080 de l'ordinateur
6) Dans un navigateur web, tapez `http://localhost:8080/api/sailors/123` : si une réponse en json s'affiche, c'est que le backend fonctionne. Youpi !
*Attention : le backend tourne tant que la fenêtre de temrinal à partir de laquelle il a été lancé est ouverte. Si cette fenêtre est fermée, le backend ne tournera plus.*
7) Faisons maintenant tourner le frontend ! Sur votre ordinateur, ouvrez un terminal et accédez au dossier `capqualif-poc-v1 > frontend`
8) Tapez `npm install` : cette commande permet de télécharger sur son ordinateur toutes les dépendances nécessaires pour faire marcher le frontend de l'application
9) Tapez `npm start` pour faire démarrer le frontend
10) Dans un navigateur web, tapez `http://localhost:3000` : l'application devrait s'afficher. Si c'est le cas, bravo !


----
C'est parti pour le dev front !
