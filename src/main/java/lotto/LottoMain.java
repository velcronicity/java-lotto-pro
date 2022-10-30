package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.util.LottoUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        String purchaseMoney = InputView.getPurchaseMoney();
        Lotto lotto = new Lotto(parseInt(purchaseMoney));
        ResultView.printPurchaseNumbers(lotto.getPurchaseLottoList());
        String winningNumbers = InputView.getWinningNumbers();
        LottoResult lottoResult = lotto.computeResult(LottoUtil.toLottoNumber(winningNumbers));
        ResultView.printResult(lottoResult);
    }

    private static int parseInt(String moneyString) {
        try {
            return Integer.parseInt(moneyString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매금액 입력값을 확인해주세요. 숫자만 입력 가능합니다.", e);
        }
    }
}
