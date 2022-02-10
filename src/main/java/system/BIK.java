package system;

import entity.documents.Application;

public class BIK {

    public static String checkCreditworthiness(Application application) {
        String decision = null;
        Long delta = application.getEarings() - application.getSpending();
        if (delta <= 0 || delta <= application.getAmount()) {
            decision = "ODMOWA";
        } else {
            decision = "PRZYZNANO";
        }
        return decision;
    }

}
