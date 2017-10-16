# Pigeon_Square

MAROUN Marc-Yves 
Lesieur Florent

EXIGENCES
Le but est d’implémenter une simulation dont on nourrit des pigeons dans un
espace public : pigeons square. La simulation se passe dans une fenêtre où les
pigeons attendent la nourriture. L’utilisateur, donc, leur donne à manger en
cliquant sur un emplacement dans la fenêtre.
Règles À SUIVRE :
i. Chaque pigeon est contrôlé par un thread.
ii. Si rien ne se passe, les pigeons s’endorment et ne bougent pas.
iii. En apercevant de la nourriture, un pigeon se déplace vers la nourriture la
plus proche.
iv. Une nourriture fraiche touchée est mangée, donc elle doit disparaitre
immédiatement de la scène.
v. Nos pigeons sont gâtés ; un pigeon qui touche une nourriture pas fraîche,
il l’ignore.
vi. Une nourriture fraîche, reste ainsi juste pour un certain temps.
vii. Des fois les pigeons se font effrayer et ils se dispersent à des positions
aléatoires loin du danger. Intégrer ce mécanisme dont la probabilité
d’occurrence change d’un tour à l’autre.
OBJECTIF
Les pigeons et la nourriture doivent être représenter graphiquement. Un simple
cercle ou un objet 3D, c’est à vous de choisir. Le plus important est le
multithreading et la structure des classes. En ce qui concerne le multithreading,
vous serez amené à :
i. S’assurer que les pigeons arrêtent de bouger le moment où il ne reste plus
de nourriture sur la scène.
ii. Si plus qu’un pigeon touche la nourriture simultanément, uniquement un
seul pourra la supprimer.
iii. Prendre en compte la nourriture dans le processus de dessin. Puisque les
threads ne sont pas synchronisés, ceci permet d’ajouter de la nourriture
même au moment du dessin de la scène. Il sera commode de parcourir une
structure de nourriture et de faire un verrou pendant le processus de
dessin.
