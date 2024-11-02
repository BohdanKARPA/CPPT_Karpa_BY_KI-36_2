from abc import ABC, abstractmethod

class Plant(ABC):
    """Абстрактний клас, що представляє рослину."""

    def __init__(self, root, stem, leaves):
        """Ініціалізує частини рослини."""
        self.root = root
        self.stem = stem
        self.leaves = leaves

    @abstractmethod
    def get_description(self):
        """Абстрактний метод для опису рослини."""
        pass

    def get_root(self):
        """Повертає корінь рослини."""
        return self.root

    def get_stem(self):
        """Повертає стебло рослини."""
        return self.stem

    def get_leaves(self):
        """Повертає листя рослини."""
        return self.leaves
