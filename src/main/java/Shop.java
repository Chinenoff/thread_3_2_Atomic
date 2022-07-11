import java.util.Random;

public class Shop {

    private final int MAX_SIZ_EBILL = 1000;
    private int[] account;

    public int[] getAccount() {
        return account;
    }

    public void accountGenerate(int numberOfBills) {
        Random random = new Random();
        account = new int[numberOfBills];
        for (int i = 0; i < numberOfBills; i++) {
            account[i] = random.nextInt(MAX_SIZ_EBILL);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shop{");
        sb.append("account=");
        if (account == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < account.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(account[i]);
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }
}
