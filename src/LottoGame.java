import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		Output.printResult(result);
	}

	private void init() {
		lotteries = new ArrayList<>();
		result = new HashMap<>();
	}

	private int getInputMoney() {
		return Input.getInputMoney("구입금액을 입력해 주세요.");
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

}
