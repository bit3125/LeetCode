package others.codingtest.Airbnb;

//输出字典序


import java.util.*;

public class Solution0 {

    private static class Person {
        String name;
        int power;
        boolean alive;

        public Person(String name) {
            this.name = name;
            this.power = 1;
            this.alive = true;
        }

    }

    static List<String> evaluateActions(List<String> actions) {
        Map<String, Person> persons = new TreeMap<>();
        Map<String, String> supports = new HashMap<>();
        Map<String, List<String>> spots = new HashMap<>();

        //统计 supportList spots
        for (String action : actions) {
            String[] strs = action.split(" ");
            List<String> spot = spots.getOrDefault(strs[1], new ArrayList<>());
            Person person = new Person(strs[0]);
            if (strs[2].equals("Support")) {
                supports.put(strs[0], strs[3]);
            } else if (strs[2].equals("Hold")) {
            } else if (strs[2].equals("Move")) {
                spot = spots.getOrDefault(strs[3], new ArrayList<>());
            }

            persons.put(strs[0], person);
            spot.add(strs[0]); //
            spots.put(strs[1], spot);//update spot
        }

        //根据spots切断support
        for (String spotName : spots.keySet()) {
            List<String> curSpot = spots.get(spotName);
            if (curSpot.size() > 1) { //TODO 只移除第一个的support吗？
                supports.remove(curSpot.get(0));
            }
        }

        //cal support
        for (String support : supports.keySet()) {
            persons.get(supports.get(support)).power++;
        }

        //fight
        for (String spotName : spots.keySet()) {
            List<String> spot = spots.get(spotName);
            if (spot.size() > 1) {//fight
                int maxPow = Integer.MIN_VALUE;
                for (String personName : spot) {
                    maxPow = Integer.max(maxPow, persons.get(personName).power);
                }

                for (String personName : spot) {
                    Person person = persons.get(personName);
                    if (person.power <= maxPow) {
                        person.alive = false;
                    }
                }
            }

        }

        //output

        return null;
    }



}
