public class SumShopThread extends Thread {

    Shop shop;
    private long resultSum = 0;

    SumShopThread(Shop shop) {
        this.shop = shop;
        //this.counter = counter;
    }

    @Override
    public void run() {
        int testResult = 0;
        for (int x : shop.getAccount()
        ) {
            Main.getCounter().add(x);
            testResult = testResult + x;
        }
        System.out.println("сумма покупок " + getName() + " = " + testResult);
    }
}
