package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public List<Lotto> buyLotto(int inputMoney) {
        lottos = new ArrayList<>();
        int numOfLotto = inputMoney / Lotto.PRICE;
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(Lotto.create());
        }
        return lottos;
    }
}
