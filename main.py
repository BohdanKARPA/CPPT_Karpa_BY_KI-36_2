from expression_calculator import ExpressionCalculator

def main():
    calculator = ExpressionCalculator()

    try:
        # Отримуємо значення x від користувача
        x = calculator.get_input()
        calculator.calculate_expression(x)
        print(f"x= {x}: {calculator.get_result()}")

        # Записуємо результат у файли
        calculator.write_res_txt("textRes.txt")
        calculator.write_res_bin("BinRes.bin")

        # Читаємо результат з двійкового файлу і виводимо його
        calculator.read_res_bin("BinRes.bin")
        print(f"Результат з двійкового файлу: {calculator.get_result()}")

        # Читаємо результат з текстового файлу і виводимо його
        calculator.read_res_txt("textRes.txt")
        print(f"Результат з текстового файлу: {calculator.get_result()}")

    except ArithmeticError as e:
        print("Помилка:", e)
    except IOError as e:
        print("Помилка вводу/виводу:", e)

if __name__ == "__main__":
    main()
