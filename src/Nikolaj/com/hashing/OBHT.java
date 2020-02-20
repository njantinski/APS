package Nikolaj.com.hashing;

class OBHT<K extends Comparable<K>, V>{
    private MapEntry<K,V> buckets[];

    private static final MapEntry former = new MapEntry(null, null);
    private int occupancy = 0;

    public OBHT(int m){
        buckets = (MapEntry<K,V>[]) new MapEntry[m];
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }

    static final int NONE = -1;

    public int search(K targetedKey){
        int b = hash(targetedKey);
        int nSearch = 0;
    
        for(;;){
            MapEntry<K,V> oldEntry = buckets[b];
            if(oldEntry == null)
                return NONE;
            else if(targetedKey.equals(oldEntry.key))
                return b;
            else{
                b = (b + 1) % buckets.length;
                nSearch ++;
                if(nSearch == buckets.length)
                    return NONE;
            }
        }
    }

    public void insert(K key, V value){
        MapEntry<K, V> newEntry = new MapEntry<>(key,value);
        int b = hash(key);
        int nSearch = 0;

        for(;;){
            MapEntry<K,V> oldEntry = buckets[b];
            if(oldEntry == null){
                if(++occupancy == buckets.length)
                    System.out.println("Hesh tabelata e polna ! ");

                buckets[b] = newEntry;
                return;
            }
            else if(oldEntry == former || key.equals(oldEntry.key)){
                buckets[b] = newEntry;
                return;
            }
            else{
                b = (b + 1) % buckets.length;
                nSearch++;
                if(nSearch== buckets.length)
                return;
            }
        }

    }


    public void delete(K key){
        int b = hash(key);
        int nSearch = 0;

        for(;;){
            MapEntry<K,V> oldEntry = buckets[b];
            if(oldEntry == null)
                return;
            else if(key.equals(oldEntry)){
                buckets[b] = former;
                return;
            }
            else{
                b = (b+1) % buckets.length;
                nSearch++;
                if(nSearch == buckets.length)
                    return;
            }
        }
    }


}