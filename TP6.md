# UCE Génie Logiciel Avancé : Techniques de Tests

**Nom et Prénom** : Kissouna Bradley  
**Groupe** : ILSEN

## Problèmes rencontrés et suggestions d'amélioration

### 1. **Problèmes de structure et de configuration**  
- **Mauvais package** : Le fichier `RocketPokemonFactory` est placé dans le package `fr.univavignon.pokedex.imp` au lieu de `fr.univavignon.pokedex.api`, ce qui empêche la compilation.
- **Méthode `calculateIV()` non implémentée** : La méthode `calculateIV()` n'est pas marquée avec l'annotation `@Override`, ce qui provoque une erreur de compilation.
- **Problème d'importation** : L'import `org.apache.commons.collections4.map.UnmodifiableMap` est inutile, car la carte n'est pas modifiée après sa création.
- **Problème EndOfFile** : Il n'y a pas de EndOfFile

- **Problème Variable** : index2name n'est pas final

### 2. **Optimisation de la bibliothèque Apache Commons Collections**  
L'utilisation de `UnmodifiableMap` est superflue. Il serait préférable d'utiliser une carte standard Java, puisque celle-ci ne nécessite pas d'être immuable après sa création.

### 3. **Problèmes de performance**  
La méthode `generateRandomStat()` effectue **1 000 000 d'itérations** et crée un nouvel objet `Random` à chaque itération, ce qui est inefficace et consomme inutilement des ressources. Il serait plus performant de déclarer un générateur de nombres aléatoires unique.

#### Proposition d'amélioration :
```java
private static final Random random = new Random();  // Générateur aléatoire unique

private static int generateRandomStat() {
    return random.nextInt(16); // Génère une valeur entre 0 et 15
}
```

### 4. **Stats surexpérimenté**  
- L'attribution de statistiques extrêmes (par exemple, 1000 pour l'attaque, la défense et l'endurance) pour les indices négatifs est incohérente.
- L'IV à `0` pour les indices négatifs et à `1` pour les autres n'est pas conforme à la logique standard des IV.

### 5. **Carte `index2name` incomplète**  
La carte `index2name` ne contient que trois entrées, et le commentaire `//TODO : Gotta map them all !` suggère que l'implémentation n'est pas terminée. Il serait nécessaire de la compléter pour couvrir tous les indices.

## Tests existants

- Le test `testCreatePokemon()` échouera pour les indices négatifs ou non présents dans `index2name`. Par exemple :
  - Un index `-1` entraîne un nom et des statistiques incorrectes, ce qui est inattendu.
  - L'IV constant de `1` pour les indices valides ne reflète pas la logique attendue.
