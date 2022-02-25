package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    private List<Lotto> lottoBundle = new ArrayList<>();

    public void buyLotto(int numOfLotto) throws IllegalArgumentException {
        for (int i = 0; i < numOfLotto; i++) {
            lottoBundle.add(Lotto.create());
        }
    }

    public void buyLotto(List<Integer> lottoNumbers) throws IllegalArgumentException {
        lottoBundle.add(Lotto.create(lottoNumbers));
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }
}
