import java.util.Scanner;

public class Input {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String REQUEST_MONEY_INFO = "구입금액을 입력해 주세요.";
	private static final String LUCKY_NUMBERS_INFO = "당첨 번호를 입력해 주세요.";

	private Input() {}

	public static int getInputMoney() {
		System.out.println(REQUEST_MONEY_INFO);
		int money = scanner.nextInt();
		scanner.nextLine();
		return money;
	}

	public static int[] getLuckyNumbers() {
		System.out.println(LUCKY_NUMBERS_INFO);
		return trimLuckyNumbers();
	}

	private static int[] trimLuckyNumbers() {
		String[] splitNumbers = scanner.nextLine().split(",");
		int[] result = new int[splitNumbers.length];
		for (int i = 0; i < splitNumbers.length; i++) {
			result[i] = Integer.parseInt(splitNumbers[i].trim());
		}
		return result;
	}

}
