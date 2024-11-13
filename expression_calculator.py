"""
Модуль для обчислення виразу y = tan(x) / (3 * x), зчитування та запису результатів у текстовому та двійковому форматах.

Особливості:
- Читання даних від користувача з перевіркою.
- Обробка винятків при роботі з файлами.
- Тестування функціональності.

Автор: Ваше Ім'я
"""
import math
import struct


def get_input():
    """Отримує вхідне значення x від користувача з перевіркою."""
    while True:
        try:
            x = float(input("Введіть значення x (не 0): "))
            if x != 0:
                return x
            print("Помилка: x не може дорівнювати 0.")
        except ValueError:
            print("Помилка: введено некоректне значення. Спробуйте ще раз.")


class ExpressionCalculator:
    """Клас для обчислення виразу та роботи з файлами."""

    def __init__(self):
        self.result = None

    def calculate_expression(self, x):
        """Обчислює вираз y = tan(x) / (3 * x)."""
        if x == 0:
            raise ValueError("x не може дорівнювати 0.")
        self.result = math.tan(x) / (3 * x)

    def write_res_txt(self, filename):
        """Записує результат у текстовий файл."""
        try:
            with open(filename, 'w', encoding='utf-8') as file:
                file.write(f"Результат: {self.result:.18f}\n")
            print(f"Результат записано у файл {filename}")
        except IOError as e:
            print(f"Помилка запису у файл {filename}: {e}")

    def read_res_txt(self, filename):
        """Зчитує результат з текстового файлу."""
        try:
            with open(filename, 'r', encoding='utf-8') as file:
                line = file.readline().strip().split(': ')[1]
                self.result = float(line)
            print(f"Результат зчитано з файлу {filename}")
        except (FileNotFoundError, ValueError) as e:
            print(f"Помилка читання з файлу {filename}: {e}")

    def write_res_bin(self, filename):
        """Записує результат у двійковий файл."""
        try:
            with open(filename, 'wb') as file:
                file.write(struct.pack('d', self.result))
            print(f"Результат записано у файл {filename}")
        except IOError as e:
            print(f"Помилка запису у файл {filename}: {e}")

    def read_res_bin(self, filename):
        """Зчитує результат з двійкового файлу."""
        try:
            with open(filename, 'rb') as file:
                self.result = struct.unpack('d', file.read(8))[0]
            print(f"Результат зчитано з файлу {filename}")
        except (FileNotFoundError, struct.error) as e:
            print(f"Помилка читання з файлу {filename}: {e}")


def main():
    """Основна функція програми."""
    calculator = ExpressionCalculator()
    try:
        x = get_input()
        calculator.calculate_expression(x)
        print(f"Обчислений результат: {calculator.result:.18f}")

        calculator.write_res_txt("textRes.txt")
        calculator.write_res_bin("BinRes.bin")

        calculator.read_res_bin("BinRes.bin")
        print(f"Результат з двійкового файлу: {calculator.result:.18f}")

        calculator.read_res_txt("textRes.txt")
        print(f"Результат з текстового файлу: {calculator.result:.18f}")
    except ValueError as e:
        print(f"Помилка обчислення: {e}")
    except Exception as e:
        print(f"Невідома помилка: {e}")


if __name__ == "__main__":
    main()
