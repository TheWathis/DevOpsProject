### DevOpsProject

Projet DevOps effectué lors du second semestre de master 1. Ce projet est la construction d'une librairie (similaire à Pandas sur Python), où nous pouvons lire un fichier au format .CSV et manipuler ses données.

[![Workflow Status](https://img.shields.io/github/workflow/status/haskaris/DevOpsProject/CI)](https://shields.io/)
[![Workflow Travis Status](https://img.shields.io/travis/com/haskaris/DevOpsProject)](https://travis-ci.com/github/haskaris/DevOpsProject)
[![codecov](https://codecov.io/gh/haskaris/DevOpsProject/branch/main/graph/badge.svg?token=60M0FA5AUW)](https://codecov.io/gh/haskaris/DevOpsProject)

## Liste des fonctionnalités
- Créer un DataFrame vide
- Créer un DataFrame à partir d'un fichier CSV
- Récupérer la valeur maximum et minimum d'une colonne
- Trier le Dataframe à partir d'une colonne
- Sélectionner un ensemble de ligne/colonne

Fonctions possibles uniquement si la colonne contient des nombres :
- Faire la somme de la colonne
- Faire une moyenne de la colonne

## Choix des outils
- Github : Choix arbitraire
- Maven : Intégration continu
- JUnit : Test unitaire
- CodeCov : Outil de couverture de code, permet de consulter les résultats en ligne et de générer le badge de couverture
- Git CI/CL : Workflow CI pour effectuer les tests
- Travis CI : Publication des résutats de couverture vers CodeCov

## Workflow git
- On a suivi le Workflow Github :
1. La branche main doit toujours être déployable
2. Utiliser le concept de feature branch pour les nouveaux développements (ex: branche MathisCode)
3. Poussez régulièrement les modications vers une branche sur le serveur
4. Créer une pull request quand vous avez besoin de feedback et avant de merger avec master
5. Ne merger avec master qu'une fois votre code relu par quelqu'un d'autre
6. Tester un déploiement avant de merger avec master

- Pull/Merge requests : Validation du code par les tests, puis validation humaine du code

## Images dockers
- Pour l'instant on n'a pas

## Feedback
Rien à redire

