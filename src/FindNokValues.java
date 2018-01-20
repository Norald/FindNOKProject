import java.util.ArrayList;
import java.util.Arrays;

/*Так как NOK(a, b ,c) = NOK (NOK(a, b), c) то для поиска НОК для N чисел
* воспользуемся функцией поиска НОК для 2 значений.*/
public class FindNokValues {
    public static void main(String[] args) {
        System.out.println(findNok(new ArrayList<Integer>(Arrays.asList(5, 8, 7, 4, 3, 9, 2))));
        System.out.println(findNok(new ArrayList<Integer>(Arrays.asList(22, 53, 72, 14))));
    }

    public  static int findNok(ArrayList<Integer> listOfValues){
        int currentNok=0;
        if(listOfValues.size()>20){//Если сумма списка больше 20 то кидаем Exception
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < listOfValues.size(); i++) {
            if(listOfValues.get(i)>100){//Если существует значение в списке больше чем 100 то кидаем Exception
                throw new ArithmeticException();
            }
        }

        for (int i = listOfValues.size()-1; i >=0 ; i--) {
            //проходим по списку и сравниваем последние 2 значения
            //после чего их удаляем а вконце добавляем их НОК
            if(i==0) break;//если доходим до 0 элемента списка, то он и является НОК, выходим из цикла
            currentNok = findNokFor2Values(listOfValues.get(i), listOfValues.get(i-1));//поиск НОК 2 чисел
            listOfValues.remove(i);
            listOfValues.remove(i-1);
            listOfValues.add(currentNok);//Добавление НОК в конце списка
        }
        return currentNok;
    }

    private static int findNokFor2Values(int val1, int val2){//функция поиска НОК для 2 значений
        int counter = 0;
        while(true){
            counter++;
            if(counter%val1==0&&counter%val2==0){//если оба значения делятся без остатка, тогда найден НОК
                break;
            }
        }
        return counter;
    }
}
