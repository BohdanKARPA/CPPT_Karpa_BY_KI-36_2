# jagged_matrix_module.py

def get_matrix_size():
    """
    Запитує користувача на введення розміру квадратної матриці.
    Перевіряє, що введене значення є додатнім числом.
    Повертає:
        int: Розмір матриці.
    """
    while True:
        try:
            size = int(input("Введіть розмір квадратної матриці: "))
            if size <= 0:
                print("Помилка: Розмір матриці має бути додатнім числом.")
            else:
                return size
        except ValueError:
            print("Помилка: Введіть коректне числове значення.")

def get_fill_character():
    """
    Запитує користувача на введення одного символу для заповнення.
    Перевіряє, що введено лише один символ.
    Повертає:
        str: Символ для заповнення.
    """
    while True:
        fill_char = input("Введіть один символ для заповнення: ")
        if len(fill_char) != 1:
            print("Помилка: Ви маєте ввести один символ.")
        else:
            return fill_char

def create_jagged_array(size, fill_char):
    """
    Створює зубчастий масив на основі вказаної заштрихованої області.
    Аргументи:
        size (int): Розмір квадратної матриці.
        fill_char (str): Символ для заповнення заштрихованої області.
    Повертає:
        list: Зубчастий масив з заповненими лише заштрихованими областями.
    """
    jagged_array = []
    i = 0
    while i < size:
        # Додаємо рядок із заповнювачем, довжина якого зменшується на 1 з кожною ітерацією
        row = [fill_char] * (size - i)
        jagged_array.append(row)
        i += 1
    return jagged_array

def print_jagged_array(jagged_array):
    """
    Виводить зубчастий масив на екран за допомогою генератора.
    Аргументи:
        jagged_array (list): Зубчастий масив для відображення.
    """
    print("Сформований масив:")
    # Використання генератора для створення рядків
    output = "\n".join("".join(row) for row in jagged_array)
    print(output)

def main():
    """
    Основна функція для запуску програми. Запитує вхідні дані від користувача,
    створює зубчастий масив, відображає його і зберігає у файл.
    """
    # Отримуємо розмір матриці та символ для заповнення
    size = get_matrix_size()
    fill_char = get_fill_character()

    # Створюємо зубчастий масив
    jagged_array = create_jagged_array(size, fill_char)

    # Виводимо зубчастий масив на екран
    print_jagged_array(jagged_array)

if __name__ == "__main__":
    main()
