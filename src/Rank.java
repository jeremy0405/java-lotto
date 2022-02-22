public enum Rank {

	FIFTH(3, 5000),
	THIRD(4, 50000),
	SECOND(5, 1500000),
	FIRST(6, 2000000000);

	private final int countOfMatch;
	private final int winningMoney;

	Rank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	static Rank create(int countOfMatch) {
		switch (countOfMatch) {
			case 3:
				return FIFTH;
			case 4:
				return THIRD;
			case 5:
				return SECOND;
			case 6:
				return FIRST;
		}
		return null;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}
}
