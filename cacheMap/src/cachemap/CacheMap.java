package cachemap;

import java.util.Map;


interface CacheMap <K, V> extends Map <K, V>{   
    /**
     * встановлює час, протягом якого дані не вважаються застарілими
     * @param lifetimeInMillis 
     */
    public void setLifetimeInMillis(long lifetimeInMillis);
}
