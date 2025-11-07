# TP3 - Logique du premier ordre : Manipulation et évaluation de formules en Java

Ce projet a été réalisé dans le cadre du **TP3 de Logique du premier ordre (L3 Informatique - AMU)**.  
L’objectif est de créer une bibliothèque Java permettant de **représenter, manipuler et évaluer des formules logiques** dans différentes interprétations (graphes et mots finis).

---

## Structure du projet

- `Formula.java` → classe abstraite définissant la structure des formules.
- `Predicate.java`, `Negation.java`, `Conjunction.java`, `Disjunction.java`, `Existential.java`, `Universal.java`  
  → implémentent les différents types de formules du premier ordre.
- `Interpretation.java` → interface commune à toutes les interprétations.
- `Graph.java` → interprétation d’un graphe orienté coloré (sommets bleus, arcs).
- `WordInterpretation.java` → interprétation d’un mot fini sur `{a,b}`.
- `MainGraphTest.java` et `MainEvalTest.java` → tests sur les graphes.
- `MainWordTest.java` → tests sur les mots finis.

---

## Fonctionnalités principales

### Partie 1 — Représentation des formules

- Implémentation des structures logiques de base.
- Calcul des variables libres et liées.
- Conversion en forme normale négative (NNF).

### Partie 2 — Interprétation : graphes orientés colorés

- Représentation d’un graphe à sommets colorés.
- Prédicats :
  - `B(x)` → x est bleu,
  - `E(x,y)` → arc orienté,
  - `=(x,y)` → égalité.
- Tests avec un graphe à 4 sommets.

### Partie 3 — Évaluation des formules

- Méthode `evaluate(I, ρ)` pour évaluer une formule dans une interprétation.
- Méthode `isModel(I)` pour vérifier si une interprétation est un modèle d’une formule close.
- Tests :
  - `∃x.B(x)` → vrai
  - `∀x.B(x)` → faux
  - `∃x∃y(E(x,y) ∧ B(y))` → vrai

### Partie 4 — Interprétation : mots finis sur {a,b}

- Domaine : positions du mot {0, …, n−1}.
- Prédicats :
  - `a(x)` → position x contient un `a`,
  - `b(x)` → position x contient un `b`,
  - `<(x,y)` → x < y,
  - `=(x,y)` → égalité.
- Tests :
  - `abba` → ∃x.a(x) = vrai, ∀x.b(x) = faux
  - `abababab` → ∃x.a(x) = vrai, ∀x.b(x) = faux
  - `bbb` → ∃x.a(x) = faux, ∀x.b(x) = vrai

---

## Résumé des résultats

| Formule             | Graphe orienté | Mots finis       |
| ------------------- | -------------- | ---------------- |
| ∃x.B(x)             | true           | true (pour abba) |
| ∀x.B(x)             | false          | false            |
| ∃x∃y(E(x,y) ∧ B(y)) | true           | —                |
| ∃x.a(x)             | —              | true             |
| ∀x.b(x)             | —              | dépend du mot    |

---

## Technologies

- **Langage :** Java 17+
- **IDE :** Visual Studio Code
- **Compilation :** `javac *.java`
- **Exécution :** `java NomClasseMain`

---

## Auteurs

- **Liza Zoubiri** – L3 Informatique, Aix-Marseille Université  
  (Projet individuel de logique du premier ordre en Java)

---
