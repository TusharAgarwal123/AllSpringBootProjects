import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		int ar[] = { 1, 0, 0, 1, 1, 0 };

		System.out.println(work(ar));

	}

	public static int work(int ar[]) {

		for (int i = ar.length - 1; i >= 0; i--) {
			if (ar[i] == 1) {
				return i;
			}
		}

		return -1;

	}

}
