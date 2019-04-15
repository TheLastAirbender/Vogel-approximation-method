
public class ArrayBubble {
	 private int[] a;   //ссылка на массив
	    private int elems;  //количество элементов в массиве

	    public ArrayBubble(int max){    //конструктор класса
	        a = new int[max];          //создание массива размером max
	        elems = 0;                  //при создании массив содержит 0 элементов
	    }

	    public void into(int value){   //метод вставки элемента в массив
	        a[elems] = value;           //вставка value в массив a
	        elems++;                    //размер массива увеличивается
	    }

	    public void printer(){          //метод вывода массива в консоль
	        for (int i = 0; i < elems; i++){    //для каждого элемента в массиве
	            System.out.print(a[i] + " ");   //вывести в консоль
	            System.out.println("");         //с новой строки
	        }
	        System.out.println("----Окончание вывода массива----");
	    }
	    
	    public int getElement(int index){
	    	return a[index]; 
	    }
	    
	    public void clear() {
	    	for (int i=0; i<elems; i++) {
	    		a[i]=0;
	    	}
	    	elems=0;
	    }

	    private void toSwap(int first, int second){ //метод меняет местами пару чисел массива
	        int dummy = a[first];      //во временную переменную помещаем первый элемент
	        a[first] = a[second];       //на место первого ставим второй элемент
	        a[second] = dummy;          //вместо второго элемента пишем первый из временной памяти
	    }

	    public void bubbleSorter(){     //МЕТОД ПУЗЫРЬКОВОЙ СОРТИРОВКИ
	        for (int out = elems - 1; out >= 1; out--){  //Внешний цикл
	            for (int in = 0; in < out; in++){       //Внутренний цикл
	                if(a[in] > a[in + 1])               //Если порядок элементов нарушен
	                    toSwap(in, in + 1);             //вызвать метод, меняющий местами
	            }
	        }
	    }

}
