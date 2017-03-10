package cachemap;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//кеш таблиця з атоматичним видаленням застарілих даних
public final class CacheMapInpl<K, V> extends ConcurrentHashMap<K, V>
        implements CacheMap <K, V> {

    //структура, що зберігає час перебування записів у кеш таблиці
    private Map<K, Long> timeMap = new ConcurrentHashMap<>();

    //тривалість, протягом якої дані не вважаються застарілими
    private long lifetimeInMillis = 1000;

    /**
     * створює нову кеш-таблицю, час зберігання об'єктів - 1000 мс
     */
    public CacheMapInpl() {
        initialize();
    }

    /**
     * створює нову кеш-таблицю
     * @param lifetimeInMillis час зберігання об'єктів
     */
    public CacheMapInpl(long lifetimeInMillis) {
        this.lifetimeInMillis = lifetimeInMillis;
        initialize();
    }
    
    //ініціалізація потоку, що виконує очищення кеш таблиці
    private void initialize() {
        new CacheMapCleanerThread().start();
    }

    /**
     * додає новий об'єкт до кеш таблиці
     * @param key ключ
     * @param value об'єкт
     * @return об'єкт
     */
    @Override
    public V put(K key, V value) {
        Date date = new Date();
        timeMap.put(key, date.getTime());
        V returnVal = super.put(key, value);
        return returnVal;
    }

    /**
     * встановлює значення часу (в мілісекундах) протягом якого
     * дані не вважаються застарілими
     * @param lifetimeInMillis the lifetimeInMillis to set
     */
    @Override
    public void setLifetimeInMillis(long lifetimeInMillis) {
        this.lifetimeInMillis = lifetimeInMillis;
    }
    
    //TODO решта методів, що можуть бути реалізовані
       
    //поток, що виконує очищення кеш таблиці
    private class CacheMapCleanerThread extends Thread {

        /**
         * запускає виконання потоку
         */
        @Override
        public void run() {
            while (true) {
                cleanCacheMap();
                try {
                    Thread.sleep(lifetimeInMillis / 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //очищує дані в кеш таблиці, які застаріли
        private void cleanCacheMap() {
            long currentTime = new Date().getTime();
            for (K key : timeMap.keySet()) {
                if (currentTime > (timeMap.get(key) + lifetimeInMillis)) {
                    remove(key);
                    timeMap.remove(key);
                }
            }
        }

    }
}
