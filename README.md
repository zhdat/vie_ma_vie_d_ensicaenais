[<img src="https://www.ensicaen.fr/wp-content/uploads/2017/02/LogoEnsicaen.gif" width="256" >](https://www.ensicaen.fr)

Projet Vis_ma_vie_d_ensicaenai
================

## Description du projet

Ce projet contient un jeu de l'oie basé sur les années d'étude à l'ENSICAEN. 
Il s'agit d'un jeu développé lors du projet de Génie Logiciel par un groupe composé de 7 étudiants.

## Organisation du projet
 
Le projet a la structure suivante :

    .
    │
    ├── build.gradle, settings.gradle, gradle.properties
    │
    ├── .gitlab-ci.yml
    │
    └── src
        ├── main
        │   ├── java
        │   │      ├── fr.ensicaen.genielogiciel.mvp/*.java
        │   │      ├── fr.ensicaen.genielogiciel.mvp.model/*.java
        │   │      ├── fr.ensicaen.genielogiciel.mvp.presenter/*.java
        │   │      └── fr.ensicaen.genielogiciel.mvp.view/*.java
        │   │
        │   └── resources
        │          ├── fr.ensicaen.genielogiciel.mvp/view/*.fxml
        │          ├── fr.ensicaen.genielogiciel.mvp/view/*.css
        │          └── fr.ensicaen.genielogiciel.mvp/MessageBundle.properties.properties
        ├── test
            ├── java
            │      └── fr.ensicaen.genielogiciel.mvp/*.java
            └── resources

# À vous dice jouer !
