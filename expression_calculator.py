import math
import struct

class ExpressionCalculator:
    def __init__(self):
        self.result = None

    def calculate_expression(self, x):
        """Обчислює вираз y = tan(x) / (3 * x)"""
        if x == 0:
            raise ArithmeticError("Ділення на нуль неможливе (x не може дорівнювати 0)")
        self.result = math.tan(x) / (3 * x)

    def get_result(self):
        """Повертає результат обчислення"""
        return self.result

    def write_res_txt(self, filename):
        """Записує результат в текстовий файл з кодуванням UTF-8"""
        with open(filename, 'w', encoding='utf-8') as file:
            file.write(f"Результат: {self.result:.18f}\n")

    def read_res_txt(self, filename):
        """Зчитує результат з текстового файлу з кодуванням UTF-8"""
        try:
            with open(filename, 'r', encoding='utf-8') as file:
                line = file.readline().strip().split(': ')[1]
                self.result = float(line)
        except FileNotFoundError:
            print(f"Файл '{filename}' не знайдено.")
        except ValueError:
            print(f"Не вдалося перетворити значення '{line}' на число.")

    def write_res_bin(self, filename):
        """Записує результат в двійковий файл"""
        with open(filename, 'wb') as file:
            file.write(struct.pack('d', self.result))

    def read_res_bin(self, filename):
        """Зчитує результат з двійкового файлу"""
        try:
            with open(filename, 'rb') as file:
                self.result = struct.unpack('d', file.read(8))[0]
        except FileNotFoundError:
            print(f"Файл '{filename}' не знайдено.")

    def get_input(self):
        """Отримує вхідне значення x від користувача з перевіркою на некоректні значення"""
        while True:
            try:
                x = float(input("Введіть значення x: "))
                if x != 0:
                    return x
                print("Помилка: x не може дорівнювати 0. Спробуйте ще раз.")
            except ValueError:
                print("Помилка: введено некоректне значення. Введіть дійсне число.")
