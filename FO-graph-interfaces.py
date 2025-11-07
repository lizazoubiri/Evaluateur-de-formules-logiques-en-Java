# Représentation des formules
class Formula:
    def __str__(self):
        pass

    def to_nnf(self):
        """Transformation en forme normale négative"""
        pass

    def free_vars(self):
        """"Calcul des variables libres"""
        pass 

    def bound_vars(self):
        """"Calcul des variables liées"""
        pass


class Interpretation:
    
    def get_individuals(self):
        pass
    
   
    def apply_predicate(self, name, arguments):
        pass


class Graph(Interpretation):
    def __init__(self, n):
        """à remplir pour créer un graphe à n sommets, sans arcs"""
       
        pass

    def is_colored(self, vertex):
        """Renvoie si le sommet est coloré."""
        return self.vertices[vertex]

    def get_individuals(self):
        """Renvoie tous les sommets du graphe."""
        return self.vertices.keys()

    def apply_predicate(self, name, arguments):
        if name == "B":
            return self.is_colored(arguments[0])
        if name == "E":
            return arguments[0] in self.edges[arguments[1]]
        if name == "=":
            return arguments[0] == arguments[1]
        return False
    
    def color_vertex(self, vertex):
        """Ajoute un sommet avec une couleur."""
        pass

    def add_edge(self, source, destination):
        """Ajoute un sommet avec une couleur."""
        pass