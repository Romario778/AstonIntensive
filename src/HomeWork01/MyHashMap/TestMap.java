package HomeWork01.MyHashMap;

public class TestMap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap<String, String>();

        myHashMap.put("one", "first");
        myHashMap.put("two", "second");
        myHashMap.put("three", "third");
        myHashMap.put("one1", "first");
        myHashMap.put("two2", "second");
        myHashMap.put("three3", "third");
        myHashMap.put("one11", "first");
        myHashMap.put("two22", "second");
        myHashMap.put("three33", "third");
        myHashMap.put("one345", "first");
        myHashMap.put("two345", "second");
        myHashMap.put("three345", "third");
        myHashMap.put("one1345", "first");
        myHashMap.put("two2345", "second");
        myHashMap.put("three3345", "third");
        myHashMap.put("one11345", "first");
        myHashMap.put("two22345", "second");
        myHashMap.put("three33345", "third");
        myHashMap.put("one890", "first");
        myHashMap.put("two890", "second");
        myHashMap.put("three890", "third");
        myHashMap.put("one1890", "first");
        myHashMap.put("two2890", "second");
        myHashMap.put("three3890", "third");
        myHashMap.put("one11890", "first");
        myHashMap.put("two22890", "second");
        myHashMap.put("three33890", "third");
        myHashMap.put("one345890", "first");
        myHashMap.put("two345890", "second");
        myHashMap.put("three345890", "third");
        myHashMap.put("one1345890", "first");
        myHashMap.put("two2345890", "second");
        myHashMap.put("three3345890", "third");
        myHashMap.put("one11345890", "first");
        myHashMap.put("two22345890", "second");
        myHashMap.put("three33345890", "third");

        System.out.println(myHashMap.get("one"));
        System.out.println(myHashMap.get("two"));
        System.out.println(myHashMap.get("three"));
        System.out.println(myHashMap.get("three33345890"));
        System.out.println(myHashMap.get("one345890"));
        System.out.println(myHashMap.get("two22345"));
        System.out.println(myHashMap.get("two2345890"));

        System.out.println(myHashMap.size());

        myHashMap.remove("one");
        myHashMap.remove("two");
        myHashMap.remove("three");
        System.out.println(myHashMap.size());

        System.out.println(myHashMap.containsKey("three33345890"));
        System.out.println(myHashMap.containsKey("654645645"));
        System.out.println(myHashMap.containsKey(null));
    }
}
