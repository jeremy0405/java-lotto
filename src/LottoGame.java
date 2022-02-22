import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoGame {

	private Map<Lotto, Integer> result;
	private List<Lotto> lotteries;
	private List<Integer> luckyNumbers;

	public void start() {
		init();
		buyLotto(getInputMoney());
		setLuckyNumbers();
		getResult();
		printResult();
	}

	private void init() {
		lotteries = new ArrayList<>();
		result = new HashMap<>();
	}

	private int getInputMoney() {
		return Input.getInputMoney();
	}

	private void buyLotto(int inputMoney) {
		int numOfLotto = inputMoney / Lotto.PRICE;
		for (int i = 0; i < numOfLotto; i++) {
			lotteries.add(new Lotto());
		}
		Output.printLottoNum(numOfLotto, lotteries);
	}

	private void setLuckyNumbers() {
		this.luckyNumbers = Arrays.stream(Input.getLuckyNumbers())
								.boxed()
								.collect(Collectors.toList());
	}

	private void getResult() {
		for (Lotto lottery : lotteries) {
			int countOfMatchedNum = 0;
			countOfMatchedNum = getMatchedNum(lottery, countOfMatchedNum);
			result.put(lottery, countOfMatchedNum);
		}
	}

	private int getMatchedNum(Lotto lotto, int countOfMatchedNum) {
		for (int luckyNumber : luckyNumbers) {
			if (lotto.getNumbers().contains(luckyNumber)) {
				countOfMatchedNum++;
			}
		}
		return countOfMatchedNum;
	}

	private void printResult() {
		Map<Rank, Integer> map = getRankIntegerMap();
		Output.printResult(map, lotteries.size());
	}

	private Map<Rank, Integer> getRankIntegerMap() {
		Map<Rank, Integer> map = new EnumMap<>(Rank.class);
		Collection<Integer> values = result.values();

		initializeMap(map);

		for (int value : values) {
			Rank rank = Rank.create(value);
			if (!Objects.isNull(rank)) {
				map.put(rank, map.get(rank) + 1);
			}
		}
		return map;
	}

	private void initializeMap(Map<Rank, Integer> map) {
		map.put(Rank.FIFTH, 0);
		map.put(Rank.THIRD, 0);
		map.put(Rank.SECOND, 0);
		map.put(Rank.FIRST, 0);
	}

}
