# SearchPhotoApp

Exemple d'une application mobile Android qui montre l'utilisation de l'architecture MVVM en chargeant les informations depuis https://api.unsplash.com/search/photos permettant de montrer les bonne pratique du développement Android.

L'utilisateur doit pouvoir saisir dans un champ de recherche un mot clé et obtenir les résultats affichés, il peut aussi ajoutés en favoris les photos qu'il souhaite, il doit aussi pouvoir les consulter hors ligne, le changement de la rotation est également gérée.

Ce projet inclus l'utilisation des librairies :

- ViewModel
- LiveData
- Dagger Hilt (Injection de dépendance)
- Retrofit
- Room 
- Coroutines Kotlin
- Flow

Il a été réalisé avec une architecture multi-module + utilisation du ViewBinding.

Des tests ont été écrit

MAD Score :

![summary](https://user-images.githubusercontent.com/87708206/130112012-7046b72e-5fdb-428d-82d0-5e2566241a20.png)
![kotlin](https://user-images.githubusercontent.com/87708206/130112021-277f0890-ec33-4270-bdf4-1238d0a2e41c.png)


Multi-module ?

Le module principale ici "app" a connaissance des différents modules qu'il a besoin dans notre exemple il a besoin du repository-consultation, Network et Model.
Le code-network n'a connaissance que du Model.
Le core-repository-consultation n'a connaissance que du module Network et Model.
Le core-model quand a lui n'a besoin de personne.

On aurait très bien pu créer un package feature où on aurait mit des classe relatives à la "consultation" néanmoins pour ce projet d'exemple nous n'avons pas eu besoin de vue custom ou encore de classe spécifique à la "consultation", tout a été placé dans le module principale "app".


Pourquoi ViewBinding ?

Contrairement à l'utilisation de ButterKnife ou Kotlin synthetics nous avons le null-safe avec ViewBinding, le code est beaucoup plus lisible et les référence d'id sont facilement accessible depuis la vue courante.

Coroutines ?

L'utilisation des coroutines pour les tâche asynchrone est recommandé par Google.
- Pas de fuite mémoire
- Gestion de l'annulation dans la hiérarchie des coroutines en cours d'exécution
- Léger, on peut exécuter plusieurs coroutines dans un seul Thread

Room ? LiveData ? ViewModel ? LifeCycle ?

L'architecture components se divise en ces quatres catégories

Lifecycle nous permet de mieux maîtriser les cycles de vie des activités et fragment, le Live Data va nous permettre d'observer le changement de données, le ViewModel va nous permettre de garder les données dans une classe sans qu'elle ne soit impacté par des changement de configuration (rotation...) et enfin Room une librairie qui va nous permettre de créer, requêter et manipuler plus facilement des bases de données SQLite.

Injection de dépendance ? Dagger-Hilt ?

Contrairement à Dagger classique où l'on doit créer des composant et d'inclure chaque module à chaque fois avec Hilt on a simplement besoin d'une annotation.
Pareil pour les ContributesAndroidInjector où dans Dagger classique nous devions écrire une tonne de code dans Hilt seulement une annotation est requise.
Pas besoin de ViewModelFactory dans Hilt
Donc Hilt beaucoup moins verbeux.

Picasso ?

Utilisation d'une librairie pour charger les images, Picasso gère le cache des images mais aussi le cas où il n'arrive pas a récupérer les images ce qui nous évite de le faire nous même.
On aurait pu aussi utiliser la librairie Glide qui est en quelque sorte similaire, en revanche Picasso quand à lui est plus rapide pour charger les images depuis le net, en revanche Glide est plus rapide pour charger le cache.
