# Rapport TP6

Denis Werle
Master 1 IA

### Intégration

J'ai ajouté la classe `RocketPokemonFactory`, puis j'ai remplacé l'utilisation de la classe `PokemonFactory` 
dans la classe réalisant les tests pour l'interface `IPokemonFactory`.

### Tests

Je constate que la classe `RocketPokemonFactory` passe toujours les tests. L'implémentation étant considérablement 
différente de celle attendue, certains tests de cette classe devraient être en echec.  

J'en déduis qu'il me manque des tests. Ma classe `IPokemonFactoryTest` ne teste seulement que la fonction `createPokemon` 
retourne bien un Pokémon avec le bon index. Il faudrait changer l'implémentations des tests de cette interface afin 
qu'ils soient plus complets.