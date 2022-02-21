import static java.lang.System.lineSeparator;

import java.util.List;
import java.util.Map;

public class Output {

	private static final StringBuilder sb = new StringBuilder();

	private Output() {}

	public static void printLottoNum(int numOfLotto, List<Lotto> lotteries) {
		sb.append(numOfLotto).append("개를 구매했습니다.").append(lineSeparator());
		for (Lotto lottery : lotteries) {
			sb.append(lottery.getNumbers()).append(lineSeparator());
		}
		System.out.println(sb);
		sb.setLength(0);
	}

	public static void printResult(Map<Rank, Integer> map, int numberOfLotteries) {
		sb.append("당첨 통계")
			.append(lineSeparator())
			.append("----------")
			.append(lineSeparator());

		appendMatchedInfo(map, numberOfLotteries);
		System.out.println(sb);
		sb.setLength(0);
	}

	private static void appendMatchedInfo(Map<Rank, Integer> map, int numberOfLotteries) {
		int total = 0;
		int i = 3;
		for (Rank rank : map.keySet()) {
			total += map.getOrDefault(rank, 0) * rank.getWinningMoney();
			sb.append(i++).append("개 일치 (").append(rank.getWinningMoney()).append(")-").append(
				map.getOrDefault(rank, 0)).append(lineSeparator());
		}
		sb.append(((total - numberOfLotteries * 1000) / (double) (numberOfLotteries * 1000)) * 100).append("%");
	}
}
