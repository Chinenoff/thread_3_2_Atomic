import java.util.concurrent.atomic.LongAdder;

public class Main {

    private static final int MAXNUMBERSHOP = 3;
    private static final SumShopThread[] allThread = new SumShopThread[MAXNUMBERSHOP];
    private static LongAdder counter;

    public static void main(String[] args) {

        //создаём магазины
        Shop[] allMyShops = new Shop[MAXNUMBERSHOP];
        createShop(allMyShops);

        counter = new LongAdder();

        //тестовый вывод массивов
        /*for (Shop shop : allMyShops
        ) {
            System.out.println(shop);
        }*/

        //запускаем потоки магазинов
        startThread(allMyShops);

        //ожидание завершения расчётов главным потоком
        for (int i = 0; i < MAXNUMBERSHOP; i++) {
            try {
                allThread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //финальный расчёт LongAdder
        long result = counter.sum();

        System.out.println("Выручка всех магазинов = " + result);
        System.out.println("Все потоки отработали, завершаем программу");
    }

    //метод генерации массивов магазинов
    public static Shop[] createShop(Shop[] myShops) {
        for (int i = 0; i < myShops.length; i++) {
            Shop shop = new Shop();
            shop.accountGenerate(20);
            myShops[i] = shop;
        }
        return myShops;
    }

    //метод создания потоков магазинов
    public static void startThread(Shop[] myShops) {
        for (int i = 0; i < MAXNUMBERSHOP; i++) {
            SumShopThread sumShopThread = new SumShopThread(myShops[i]);
            allThread[i] = sumShopThread;
            sumShopThread.setName("МАГАЗИН-" + i);
            sumShopThread.start();
        }
    }

    public static LongAdder getCounter() {
        return counter;
    }
}
