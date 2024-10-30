def get_matrix_size():
    # Перевіряє, що введене значення є додатнім числом.
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
    # Перевіряє, що введено лише один символ.
    while True:
        fill_char = input("Введіть один символ для заповнення: ")
        if len(fill_char) != 1:
            print("Помилка: Ви маєте ввести один символ.")
        else:
            return fill_char

def create_jagged_array(size, fill_char):
    # Створює зубчастий масив із мінімальним використанням пам'яті.
    row_template = [fill_char] * size  # Повний рядок, який буде зрізатись
    jagged_array = []  # Ініціалізація порожнього масиву

    # Додаємо кожен рядок до масиву, зменшуючи його довжину на кожній ітерації
    for i in range(size):
        row = row_template[:size - i]  # Створюємо рядок необхідної довжини
        jagged_array.append(row)       # Додаємо рядок до масиву

    return jagged_array

def print_jagged_array(jagged_array):
    # Виводить зубчастий масив на екран.
    print("Сформований масив:")
    output = "\n".join("".join(row) for row in jagged_array)
    print(output)

def main():
    """
    Основна функція для запуску програми. Запитує вхідні дані від користувача,
    створює зубчастий масив, відображає його.
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
