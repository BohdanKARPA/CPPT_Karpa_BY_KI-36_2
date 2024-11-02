from .plant import Plant


class Tree(Plant):
    """Клас, що представляє дерево, наслідуючи рослину."""

    def __init__(self, root, stem, leaves, tree_type):
        """Ініціалізує дерево з заданим типом."""
        super().__init__(root, stem, leaves)
        self.tree_type = tree_type
        self.fruit_count = 0

    def get_tree_type(self):
        """Повертає тип дерева."""
        return self.tree_type

    def set_tree_type(self, tree_type):
        """Задає новий тип дерева."""
        self.tree_type = tree_type

    def grow(self, increment):
        """Збільшує висоту дерева та додає плоди."""
        new_height = self.get_stem().get_height() + increment
        self.get_stem().set_height(new_height)
        self.bear_fruit()

    def bear_fruit(self):
        """Збільшує кількість плодів на дереві."""
        self.fruit_count += 10

    def get_fruit_count(self):
        """Повертає кількість плодів на дереві."""
        return self.fruit_count

    def get_description(self):
        """Повертає опис дерева."""
        return (f"Дерево типу: {self.tree_type}\n"
                f"{self.root}\n{self.stem}\n{self.leaves}\n"
                f"Кількість плодів: {self.fruit_count}")
