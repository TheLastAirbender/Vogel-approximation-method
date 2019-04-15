import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public class fogel {

	int a[];
	int elems;
	static int postavshik[] = new int[3];
	static int potrebitel[] = new int[4];
	static int pricematrix[][] = new int[3][4];
	static int reshenie[][]= new int[3][4];
	static int iteration=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Введите последовательно количество продукта у поставщиков:");
		
		for (int i=0; i<3; i++) {postavshik[i]=input.nextInt();}
		
		System.out.println("Введите количество продукта, нужного потребителям:");
		
		for (int i=0; i<4; i++) {potrebitel[i]=input.nextInt();}
		
		System.out.println("Введите матрицу стоимости перевозок:");
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<4; j++) {
				pricematrix[i][j] = input.nextInt();
			}
		}
		
		editReshenie(pricematrix);
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<4; j++) {
				System.out.print(reshenie[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	static void editReshenie(int[][] pricematrix) {
		iteration++;
		//System.out.println("iteration"+iteration+" ");
		int kletka[] = getIndex(pricematrix);
		
		if (postavshik[kletka[0]] > potrebitel[kletka[1]]
				&& postavshik[kletka[0]] !=0
				&& potrebitel[kletka[1]] !=0) {
			reshenie[kletka[0]][kletka[1]] = potrebitel[kletka[1]];
			postavshik[kletka[0]] = postavshik[kletka[0]] - potrebitel[kletka[1]];
			potrebitel[kletka[1]] = 0;
			//System.out.println("Записал в решение в клетку"+kletka[0]+" "+kletka[1]);
			//System.out.print(reshenie[kletka[0]][kletka[1]]);
			for (int i=0; i<3; i++) {
				pricematrix[i][kletka[1]]=1000;
			}
			//pricematrix[kletka[0]][kletka[1]]=1000;
		} 
	
		if (potrebitel[kletka[1]] >= postavshik[kletka[0]]
				&& postavshik[kletka[0]] !=0
				&& potrebitel[kletka[1]] !=0) {
			reshenie[kletka[0]][kletka[1]] = postavshik[kletka[0]];
			postavshik[kletka[0]] = potrebitel[kletka[1]] - postavshik[kletka[0]];
			postavshik[kletka[0]] = 0;
			//System.out.println("Записал в решение в клетку"+kletka[0]+" "+kletka[1]);
			//System.out.print(reshenie[kletka[0]][kletka[1]]);
			for (int i=0; i<4; i++) {
				pricematrix[kletka[0]][i]=1000;
			}
			//pricematrix[kletka[0]][kletka[1]]=1000;
		}
		if (iteration>5) {return;}
		editReshenie(pricematrix);
		
		//DecimalFormat df = new DecimalFormat("#####.#");
		
		
	}
	
	static int[] getIndex(int matrix[][]) {
		int[]index = new int[2];
		int min=100;
		int max=0;
		//int min_element1=100;
		//int min_element2=100;
		int summ_stolb[] = new int[4];
		int summ_strok[] = new int[3];
		int max_stolb=0;
		int max_stroka=0;
		ArrayBubble array = new ArrayBubble(4);
		//int stroka[]=new int[3];
		
		//считаем каждый столбец, записываем в массив
		for (int j=0; j<4; j++) {
			for (int i=0; i<3; i++) {
				if (matrix[i][j]<1000) {
					array.into(matrix[i][j]);
					//System.out.print(matrix[i][j]+" ");
				}
			}
			//System.out.println();
			array.bubbleSorter();
			summ_stolb[j]=array.getElement(1)-array.getElement(0);
			//System.out.print(summ_stolb[j]);
			if (summ_stolb[j]>max) {
				max=summ_stolb[j];
				max_stolb=j;}
			array.clear();
		}
		max=0;
		
		//считаем каждую строку, записываем в vfccbd
		for (int i=0; i<3; i++) {
			for (int j=0; j<4; j++) {
				if (matrix[i][j]<1000) {
					array.into(matrix[i][j]);
					//System.out.print(matrix[i][j]+" ");
				}
			}
			//System.out.println();
			array.bubbleSorter();
			summ_strok[i]=array.getElement(1)-array.getElement(0);
			if (summ_strok[i]>max) {
				max=summ_strok[i];
				max_stroka=i;}
			array.clear();
		}
		max=0;
		//System.out.println("Макс строка"+max_stroka);
		//System.out.println("Макс столб"+max_stolb);
		
		if (summ_strok[max_stroka]>summ_stolb[max_stolb]) {
			//System.out.println("Строка больше");
			for (int j=0; j<4; j++) {
				if (matrix[max_stroka][j]<min) {
					System.out.println("Берем "+matrix[max_stroka][j]);
					min=matrix[max_stroka][j];
					index[0]=max_stroka;
					index[1]=j;
				}
				//array.into(matrix[max_stroka][j]);
			}
			array.bubbleSorter();
			//index[0]=array.getElement(0);
		} else {
			//System.out.println("STOLB больше");
			//System.out.println("dec="+summ_stolb[max_stolb]);
			for (int i=0; i<3; i++) {
				if (matrix[i][max_stolb]<min) {
					min=matrix[i][max_stolb];
					index[0]=i;
					index[1]=max_stolb;
				}
				//array.into(matrix[max_stolb][i]);
			}
			//array.bubbleSorter();
			//index[1]=array.getElement(1);
		}
		array.clear();
		//System.out.println("Минимальный элемент "+min);
		//System.out.println("Буду работать с клеткой "+index[0]+" "+index[1]);
		return index;
	}
	
}
