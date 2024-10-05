package HomeWork01.MyHashMap;

import java.util.LinkedList;
import java.util.TreeMap;

class MyHashMap<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int SIZE_TO_TREE = 8;

    private Object[] array;
    private int size;

    public MyHashMap() {
        array = new Object[DEFAULT_INITIAL_CAPACITY];
        size = 0;
    }

    // Получение индекса корзины
    private int hash(Object key) {
        return key == null ? 0 : Math.abs(key.hashCode() % array.length);
    }

    // Добавление или перезапись значения
    public void put(K key, V value) {
        int index = hash(key) % array.length;
        Object bucket = array[index];

        if (bucket == null) {
            array[index] = new LinkedList<Entry<K, V>>();
            bucket = array[index];
        }

        // Если корзина представлена списком
        if (bucket instanceof LinkedList) {
            LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) bucket;
            for (Entry<K, V> entry : list) {
                if (entry.key.equals(key)) {
                    entry.value = value; // Обновляем значение, если ключ существует
                    return;
                }
            }

            list.add(new Entry<>(key, value)); // Добавляем новую пару
            size++;

            // Преобразуем список в дерево, если размер списка больше 8
            if (list.size() > SIZE_TO_TREE) {
                TreeMap<K, V> tree = new TreeMap<>();
                for (Entry<K, V> entry : list) {
                    tree.put(entry.key, entry.value);
                }
                array[index] = tree; // Заменяем список деревом
            }

            // Проверяем есть ли уже дерево и работаем с ним
        } else if (bucket instanceof TreeMap) {
            TreeMap<K, V> tree = (TreeMap<K, V>) bucket;
            tree.put(key, value);
        }
    }

    // Получение значения по ключу
    public V get(K key) {
        int index = hash(key) % array.length;
        Object bucket = array[index];

        if (bucket == null) {
            return null;
        }

        // Если лист
        if (bucket instanceof LinkedList) {
            LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) bucket;
            for (Entry<K, V> entry : list) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }

            // Если дерево
        } else if (bucket instanceof TreeMap) {
            TreeMap<K, V> tree = (TreeMap<K, V>) bucket;
            return tree.get(key);
        }

        return null; // Ключ не найден
    }

    // Удаление значения по ключу
    public void remove(K key) {
        int index = hash(key) % array.length;
        Object bucket = array[index];

        if (bucket == null) {
            return;
        }

        // Если список
        if (bucket instanceof LinkedList) {
            LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) bucket;
            list.remove(key);
            size--;

            // Если дерево
        } else if (bucket instanceof TreeMap) {
            TreeMap<K, V> tree = (TreeMap<K, V>) bucket;
            tree.remove(key);
            size--;
        }
    }

    // Получения размера хеш таблицы
    public int size() {
        return size;
    }

    // Проверка наличия ключа
    public boolean containsKey(K key) {
        if (key == null) {
            throw new RuntimeException("Press correct key");
        }
        return get(key) != null;
    }
}