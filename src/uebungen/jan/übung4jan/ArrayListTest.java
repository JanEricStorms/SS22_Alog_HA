package uebungen.jan.übung4jan;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		double valueStart = 0;
		double valueStop = 0;
		List<Integer> x = new ArrayList<>();
		System.out.println(valueStart = System.currentTimeMillis());
		for (int i = 0; i < 1000000; i++) {
//			if (i%10000==0) {
//				System.out.println(i);
//			}
			x.add(0,i);
		}
		valueStop = System.currentTimeMillis();
		double result = valueStop-valueStart;
		System.out.println("Result: " + result + "in Milisecounds");
		int h = 0;
		int m = 0;
		int s = 0;
		if(result < 1000){
			System.out.println(result + " in Secounds");
		}else{
			result = result/1000;
			System.out.println(result);
			while(result >= 60){
				System.out.println("Result before : " + result);
				result = result- 60;
				System.out.println("Result after : " + result);
				s++;
				System.out.println(s);
				if(s == 60){
					m++;
					s = 0;
					System.out.println(s + " " + m);
					if(m == 60){
						h++;
						m=0;
						System.out.println(m +" " + h);
					}
				}
			}
			System.out.println("Readable Result: " + h + "Stunden " + m + "Minuten " + s + "Sekunden " + result + "Milisekunden");
		}


	}

}
