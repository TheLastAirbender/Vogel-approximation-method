
public class ArrayBubble {
	 private int[] a;   //������ �� ������
	    private int elems;  //���������� ��������� � �������

	    public ArrayBubble(int max){    //����������� ������
	        a = new int[max];          //�������� ������� �������� max
	        elems = 0;                  //��� �������� ������ �������� 0 ���������
	    }

	    public void into(int value){   //����� ������� �������� � ������
	        a[elems] = value;           //������� value � ������ a
	        elems++;                    //������ ������� �������������
	    }

	    public void printer(){          //����� ������ ������� � �������
	        for (int i = 0; i < elems; i++){    //��� ������� �������� � �������
	            System.out.print(a[i] + " ");   //������� � �������
	            System.out.println("");         //� ����� ������
	        }
	        System.out.println("----��������� ������ �������----");
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

	    private void toSwap(int first, int second){ //����� ������ ������� ���� ����� �������
	        int dummy = a[first];      //�� ��������� ���������� �������� ������ �������
	        a[first] = a[second];       //�� ����� ������� ������ ������ �������
	        a[second] = dummy;          //������ ������� �������� ����� ������ �� ��������� ������
	    }

	    public void bubbleSorter(){     //����� ����������� ����������
	        for (int out = elems - 1; out >= 1; out--){  //������� ����
	            for (int in = 0; in < out; in++){       //���������� ����
	                if(a[in] > a[in + 1])               //���� ������� ��������� �������
	                    toSwap(in, in + 1);             //������� �����, �������� �������
	            }
	        }
	    }

}
