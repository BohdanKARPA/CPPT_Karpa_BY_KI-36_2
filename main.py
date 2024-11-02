from plants.root import Root
from plants.stem import Stem
from plants.leaves import Leaves
from plants.tree import Tree


def create_tree():
    """Функція для створення нового дерева на основі введення користувача."""
    print("\nСтворення нового дерева:")

    # Вибір типу кореня з валідацією
    while True:
        print("1. Введіть тип кореня:")
        print("   1 - мочкуватий")
        print("   2 - стрижневий")
        root_choice = input("Оберіть тип кореня (1 або 2): ")
        if root_choice in ["1", "2"]:
            root_type = "мочкуватий" if root_choice == "1" else "стрижневий"
            break
        else:
            print("Невірний вибір. Введіть 1 або 2.")

    root = Root(root_type)

    # Введення висоти стебла з перевіркою
    stem_height = get_positive_float("2. Введіть висоту стебла (в см): ")
    stem = Stem(stem_height)

    # Вибір форми листя з валідацією
    while True:
        print("3. Введіть форму листя:")
        print("   1 - ланцетоподібна")
        print("   2 - яйцеподібна")
        print("   3 - кругла")
        leaf_choice = input("Оберіть форму листя (1, 2 або 3): ")
        if leaf_choice in ["1", "2", "3"]:
            leaf_shape = {
                "1": "ланцетоподібна",
                "2": "яйцеподібна",
                "3": "кругла"
            }[leaf_choice]
            break
        else:
            print("Невірний вибір. Введіть 1, 2 або 3.")

    leaves = Leaves(leaf_shape)

    # Вибір типу дерева з валідацією
    while True:
        print("4. Виберіть тип дерева:")
        print("   1 - Яблуня")
        print("   2 - Груша")
        print("   3 - Вишня")
        print("   4 - Абрикос")
        tree_type_choice = input("Оберіть тип дерева (1-4): ")
        if tree_type_choice in ["1", "2", "3", "4"]:
            tree_type = {
                "1": "Яблуня",
                "2": "Груша",
                "3": "Вишня",
                "4": "Абрикос"
            }[tree_type_choice]
            break
        else:
            print("Невірний вибір. Введіть 1, 2, 3 або 4.")

    # Повертаємо об'єкт дерева
    return Tree(root, stem, leaves, tree_type)


def display_menu():
    """Відображає меню з опціями для користувача."""
    print("\nМеню:")
    print("1. Створити нове дерево")
    print("2. Показати опис дерева")
    print("3. Збільшити висоту дерева")
    print("4. Вийти")


def get_positive_float(prompt):
    """Запитує у користувача позитивне число, поки воно не буде введено правильно."""
    while True:
        try:
            value = float(input(prompt))
            if value > 0:
                return value
            else:
                print("Помилка: введіть додатнє число.")
        except ValueError:
            print("Помилка: введіть коректне число.")


def main():
    tree = None  # Ініціалізуємо змінну для зберігання об'єкта дерева

    while True:
        display_menu()
        choice = input("Оберіть опцію: ")

        if choice == "1":
            # Створення нового дерева
            tree = create_tree()
            print("\nДерево створено успішно!")

        elif choice == "2":
            # Показати опис дерева
            if tree:
                print("\nОпис дерева:")
                print(tree.get_description())
            else:
                print("\nСпочатку створіть дерево (опція 1).")

        elif choice == "3":
            # Збільшити висоту дерева
            if tree:
                grow_amount = get_positive_float("Введіть, на скільки см виросте дерево: ")
                tree.grow(grow_amount)
                print("Дерево успішно виросло.")
                print(tree.get_description())
            else:
                print("\nСпочатку створіть дерево (опція 1).")

        elif choice == "4":
            # Вихід з програми
            print("Вихід з програми.")
            break

        else:
            print("Невірний вибір. Спробуйте ще раз.")


if __name__ == "__main__":
    main()
