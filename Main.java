package ProblemOfPrisoners;

import java.util.Map;
import java.util.TreeMap;

// TODO это продолжить
public class Main {
    // Для начала надо создать Map, которая будет заполняться различными случайными цифрами
    // например от 1 до N, ключами будут выступать тоже номера от 1-N
    // задача: Сделать так, что бы номера в Map были все разные и распологались в Map в случайном порядке
    // public static int  N = 10;
    public static void main(String[] args) {
        int rooms = 10; // допустим у нас 10 комнат, то каждую комнату надо положить рандомное число, тоже от 1 до 10
        int countOfPrisoners = rooms; // заключённых тоже 10
        int numberOfAttempts = rooms / 2; // количество попыток у каждого заключённого
        Map<Integer, Integer> data = new TreeMap<>();// наша map где ключ номер комнаты, а значение рандомное число
        int key = 1;
        int value = (int) (Math.random() * rooms) + 1;
        data.put(key, value);// первый раз в любом случае генерится уникальное число, положили в мапу
        key++;
        for (key = key; key < rooms + 1; key++) { // в цикле пока не кончатся наши комнаты

            value = (int) (Math.random() * rooms) + 1;

            // если мапа уже содержит такое число, то продолжить генерить пока не появится уникальное
            while (data.containsValue(value)) {
                value = (int) (Math.random() * rooms) + 1;
            }
            data.put(key, value);// положили в мапу


        }
        for (Map.Entry<Integer, Integer> d : data.entrySet()) {
            key = d.getKey();
            value = d.getValue();
            System.out.println(key + " = " + value);
        }

        // Теперь мапа заполнена и можно осуществить перебор
        // цикл наших заключённых
        for (int i = 0; i < countOfPrisoners; i++) {
            int numberOfPrisoner;// номер заключённого
            numberOfPrisoner = i + 1;
            int attempCounter = 0;// счётчик попыток
            int prisonerWay = 0; // это будет наш путь заключённого
            System.out.println();
            System.out.print("Путь Заключённого № " + numberOfPrisoner);


            // проверка нашёл ли заключённый свой номер

            for (Map.Entry<Integer, Integer> d : data.entrySet()) {
                attempCounter++;
                System.out.println("Счёторчик заключённого " + attempCounter);
                System.out.println();
                if (attempCounter > numberOfAttempts) {// проверка на количество попыток
                    System.out.println();
                    System.out.println("Заключённый № " + numberOfPrisoner + " увы не нашёл свой номер, игра проиграна ");
                    break;
                }

                // сначало заключенный идёт к ящику (ключу нашей мапы) где лежит его номер
                if (numberOfPrisoner == d.getKey()) {
                    prisonerWay = d.getKey();
                    System.out.print(" -> " + prisonerWay);

                }


                if (prisonerWay == d.getValue()) {
                    System.out.println();
                    System.out.println("Заключённый № " + numberOfPrisoner + " нашёл свой номер в ячейке № " + d.getKey() + " на " + attempCounter + " попытке!!!");
                    break;


                }

            }
        }
    }
}