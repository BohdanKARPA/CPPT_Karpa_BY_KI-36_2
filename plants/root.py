class Root:
    """Клас, що представляє корінь рослини."""

    def __init__(self, root_type):
        """Ініціалізує тип кореня."""
        self.root_type = root_type

    def get_root_type(self):
        """Повертає тип кореня."""
        return self.root_type

    def set_root_type(self, root_type):
        """Задає новий тип кореня."""
        self.root_type = root_type

    def __str__(self):
        return f"Тип кореня: {self.root_type}"
