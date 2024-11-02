class Stem:
    """Клас, що представляє стебло рослини."""

    def __init__(self, height):
        """Ініціалізує висоту стебла."""
        self.height = height

    def get_height(self):
        """Повертає висоту стебла."""
        return self.height

    def set_height(self, height):
        """Задає нову висоту стебла."""
        self.height = height

    def __str__(self):
        return f"Висота стебла: {self.height} см"
