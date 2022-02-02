

	//converting the array to two equal parts and find the vampire number

	Boolean checkVampire(int[] arr, int num) {
		int firstPart = 0;
		int secondPart = 0;
		for (int index = 0; index < (arr.length) / 2; index++) {
			firstPart += arr[index] * Math.pow(10, (arr.length) / 2 - index - 1);
		}
		for (int index = (arr.length) / 2; index < arr.length; index++) {
			secondPart += arr[index] * Math.pow(10, (arr.length - index - 1));
		}
		if (firstPart * secondPart == num) {
			return true;
		}
		return false;
	}

	//finds all the permutations of the given input array and returns to the checkvampire method.
	void permutaionFinder(int[] arr, int index, int num) {
		if (index >= arr.length - 1) {
			if (this.checkVampire(arr, num)) {
				//flag will set to true if it is a vampire number.
				isFlag = true;
			}
		}
		for (int i = index; i < arr.length; i++) { 
			int t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;
			permutaionFinder(arr, index + 1, num);
			t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;
		}
	}
};

class Vampirenumber {
	Boolean isFlag = false;
	//breaking the number into individual number and storing in an array.
	public int[] breakNumber(int num) {
		int remainder= 0;
		int index=0;
		int length = (int) (Math.log10(num) + 1);
		int array[] = new int[length];
		while (num != 0) {
			remainder = num % 10;
			array[index] = remainder;
			num = num / 10;
			index++;
		}
		return array;
	}

public class Ques1 {

	public static void main(String[] args) {
		
		int number = 1001;
		int count = 0;
		Vampirenumber vampire = new Vampirenumber();
		while (count < 100) {
			if (((int) (Math.log10(number) + 1))%2 == 0) {
				int[] array = vampire.breakNumber(number);
				vampire.permutaionFinder(array, 0, number);
				if (vampire.isFlag) {
					System.out.println(number);
					count++;
					vampire.isFlag = false;
				}

			}
			number++;
		}
	}}
