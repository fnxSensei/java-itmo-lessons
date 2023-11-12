package com.itmo.project.lesson17;

import java.util.*;

public class Lesson17 {
    public static void main(String[] args) {
//        HashMap<String, Integer> customers = new HashMap<>();
//        customers.put("Москва", 790);
//        customers.put("Ростов", 250);
//        customers.put("Новгород", 20);
//        customers.put("Ростов", 300); //произойдет перезапись значения по ключу
//        customers.put("Самара", 630);
//        customers.put(null, 1000);
//        customers.put("СПб", null);
//
//        System.out.println(customers.size());//5
//
//        //удаление пары по ключу
//        customers.remove(null);  //1000
//        customers.remove(null);  //null
//        customers.remove(null);  //null
//
//        //удалит если в мапе существует пара
//        customers.remove("Ростов", 300);//true
//        customers.remove("Самара", 200);//false
//
//        customers.replace("Самара", 1200); //вернет 630
//        // заменит значение если в мапе существует пара "Москва" : 790
//        customers.replace("Москва", 790, 840); // true
//
//        //получения значения по ключу (не удаление)
//        System.out.println(customers.get("Москва"));//840
//
//
//        //если ключ есть вернет его значение,
//        // если его нет то вернет то значение которое указали
//        System.out.println(customers.getOrDefault("Москва", -1));//840
//        System.out.println(customers.getOrDefault("СПБ", -1));//-1
//
//        if (customers.containsKey("Ростов")) {
//            System.out.println("Информация о Ростове уже содержится");
//        }
//        if (customers.containsValue(1000)) {
//            System.out.println("Значение 1000 содержится в мапе");
//        }
//        //коллекция значений
//        Collection<Integer> customersValue = customers.values();
//        //множество ключей
//        Set<String> customersKey = customers.keySet();
//        //множество пар (ключ+значение)
//        Set<Map.Entry<String, Integer>> customersPairs = customers.entrySet();
//        //Set:
//        //Map.Entry["Москва", 790]
//        //Map.Entry["Ростов", 30]
//        for (Map.Entry<String, Integer> customersPair : customersPairs) {
//            System.out.println(customersPair.getValue());
//        }
//
//        ArrayList<String> cities = getCities(customers, 500);
//        System.out.println(cities);
//        EnumMap<ClientAuthData.Role, List<ClientAuthData>> clientsRole = new EnumMap<>(ClientAuthData.Role.class);
//        clientsRole.put(ClientAuthData.Role.USER, new ArrayList<>());
//        clientsRole.put(ClientAuthData.Role.ADMIN, new ArrayList<>());
//        //List<ClientAuthData>[] values = new List<ClientAuthData>[3]
//        //values[ClientAuthData.Role.ordinal()] = new ArrayList<>();
//        ClientAuthData data01 = new ClientAuthData("qqq", "123", ClientAuthData.Role.USER);
//        clientsRole.get(ClientAuthData.Role.USER).add(data01);
//
//        EnumSet<ClientAuthData.Role> rolesFull = EnumSet.allOf(ClientAuthData.Role.class);
//        EnumSet<ClientAuthData.Role> rolesEmpty = EnumSet.noneOf(ClientAuthData.Role.class); //пустой, а потом добавляем
//        rolesEmpty.add(ClientAuthData.Role.ADMIN);
//        rolesEmpty.add(ClientAuthData.Role.MODERATOR);
//        EnumSet<ClientAuthData.Role> rolesEx = EnumSet.complementOf(EnumSet.of(ClientAuthData.Role.USER)); //кроме User
//        // от и до [GUEST, USER, SUPER_USER, ADMIN, SUPER_ADMIN]
//        EnumSet<ClientAuthData.Role> fromTo = EnumSet.range(ClientAuthData.Role.USER, ClientAuthData.Role.ADMIN);
//        EnumSet<ClientAuthData.Role> fromTo2 = EnumSet.range(ClientAuthData.Role.values()[1], ClientAuthData.Role.ADMIN);
//
//        TreeMap<String, List<String>> students = new TreeMap<>();

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        String result = getkeyByNumberOfLetters(text).toString();
        System.out.println(result);
        topLetters(text);


    }

    private static ArrayList<String> getCities(HashMap<String, Integer> map, int max) {
        ArrayList<String> cities = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() < max) {
                cities.add(stringIntegerEntry.getKey());
            }
        }
        return cities;
    }

    private static void clientArray(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map, ClientAuthData clientData) {
        if (map.get(clientData.getRole()) == null) {
            map.put(clientData.getRole(), new ArrayList<>());
        }
        map.get(clientData.getRole()).add(clientData);

    }

    private static Map<String, String> getMap(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map) {
        List<ClientAuthData> user = map.get(ClientAuthData.Role.USER);
        Map<String, String> users = new HashMap<>();
        for (ClientAuthData client : user) {
            users.put(client.getUserName(), client.getPassword());
        }

        return users;
    }

    //Реализовать статический метод, который принимает Collection<String> strings и возвращает количество одинаковых
    // слов в коллекции strings в виде Map<String, Long>. Где ключи - слова, а значения - количество повторений.
    private static Map<String, Long> getRepeatOfWords(Collection<String> strings) {
        Map<String, Long> repeatOfWords = new HashMap<>();
        strings.forEach(n -> {
            if (repeatOfWords.containsKey(n)) {
                repeatOfWords.put(n, repeatOfWords.get(n) + 1);
            } else {
                repeatOfWords.put(n, 1L);
            }
        });
        return repeatOfWords;
    }

    //Реализовать статический метод, принимающий на вход String word и String text и возвращающий частоту встречаемости
    // слова word в тексте text в виде Map<String, Long>. Где ключ - слово, а значение - частота встречаемости
    private static Map<String, Long> getRepeatWordInText(String word, String text) {
        Map<String, Long> repeatWordInText = new HashMap<>();
        String[] textArray = text.toLowerCase().split("\\s");
        Long countOfWords = 0l;
        for (int i = 0; i < textArray.length; i++) {
            if (word.equals(textArray[i])) {
                repeatWordInText.put(word, ++countOfWords);
            }
        }
        return repeatWordInText;
    }

    //Реализовать статический метод, принимающий на вход String text и возвращающий Map<Integer, List<String>>
    // где ключи - количество букв в словах, значения - списки соответствующих слов.
    private static Map<Integer, List<String>> getkeyByNumberOfLetters(String text) {
        Map<Integer, List<String>> keyByNumberOfLetters = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        stringList = Arrays.asList(text.split("\\s"));
        for (String string : stringList) {
            char[] arr = string.toCharArray();
            int numberOfLetters = arr.length;
            if (!keyByNumberOfLetters.containsKey(numberOfLetters)) {
                keyByNumberOfLetters.put(numberOfLetters, new ArrayList<>());

            }
            keyByNumberOfLetters.get(numberOfLetters).add(string);

        }
        return keyByNumberOfLetters;
    }

    //Реализовать статический void метод, принимающий на вход String text и выводящий в консоль топ 10
    // самых часто встречаемых в тексте слов (можно добавить условие: артикли и предлоги не считаем за слова).
    private static void topLetters(String text) {
        String[] m = text.split(" ");
        HashMap<String, Integer> h = new HashMap<>();
        for (int i = 0; i < m.length; i++) {
            if (h.containsKey(m[i])) {
                h.replace(m[i], h.get(m[i]) + 1);
            } else {
                h.put(m[i], 1);
            }
        }
//        h.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .forEach(System.out::println);
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();

        for (HashMap.Entry<String, Integer> e : h.entrySet()) {
            int value = e.getValue();
            boolean isAdded = false;
            for (int i = 0; i < integers.size(); i++) {
                if (value > integers.get(i)) {
                    integers.add(i, value);
                    strings.add(i, e.getKey());
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                integers.add(value);
                strings.add(e.getKey());
            }
        }
        String[] out = new String[10];
        for(int i = 0; i< out.length; i++)
            out[i]=strings.get(i);
        System.out.println(Arrays.deepToString(out));
    }
}
