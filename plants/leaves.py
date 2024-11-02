class Leaves:
    """Клас, що представляє листя рослини."""

    def __init__(self, leaf_shape):
        """Ініціалізує форму листя."""
        self.leaf_shape = leaf_shape

    def get_leaf_shape(self):
        """Повертає форму листя."""
        return self.leaf_shape

    def set_leaf_shape(self, leaf_shape):
        """Задає нову форму листя."""
        self.leaf_shape = leaf_shape

    def __str__(self):
        return f"Форма листя: {self.leaf_shape}"
