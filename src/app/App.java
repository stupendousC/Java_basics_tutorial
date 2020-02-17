package app;
import java.text.NumberFormat;
import java.util.*;
// I imported all of java.util b/c I'm gonna be using java.util.Arrays and java.util.Scanner

public class App {
    public static void main(String[] args) {
        System.out.println("\n\n\n--------------------------------------------------");
        System.out.println("GO READ SRC/NOTES.MD!!");
        System.out.println("in VS Code, can type 'sysout' to gen intellisense for System.out.println");
        System.out.println("--------------------------------------------------");

        System.out.println("\n================== ARRAY ==================");
        String[] array1 = {"A", "B"};
        System.out.println("printing just the array1 instance..." + array1);
        System.out.println("print the actual array1 contents..." + Arrays.toString(array1));
        System.out.println("Can I assign a 3rd item to array1?");
        try {
            array1[2] = "C";
        } catch(Exception e) {
            System.out.println("\tNope! B/c ARRAYS ARE FIXED IN SIZE!  you're gonna have to use ArrayLists if u want dynamic sizes!");
        }

        String[] array2 = new String[2];
        System.out.println("\nWhat if I didn't assign any values to array2? " + Arrays.toString(array2));
        array2[0] = "decided";
        array2[1] = "finally";
        System.out.println("Now I finished assigning... " + Arrays.toString(array2));

        String[][] array2D = { {"a", "b", "c"}, {"d", "e", "f"}};
        System.out.println("\nWhat if I want to print a 2d array with .toString? ");
        System.out.println(".toString = " + Arrays.toString(array2D));
        System.out.println(".deepToString = " + Arrays.deepToString(array2D));
        
        System.out.println("\n================== ArrayList ==================");
        // it implements the List interface, and List extends Collections which extends Iterables
        // https://www.callicoder.com/java-arraylist/
        List<String> animals = new ArrayList<>();
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Cat");
        animals.add("Dog");

        System.out.println(animals);
        animals.add(2, "Elephant");
        System.out.println(animals);

        
        List<Integer> firstFivePrimeNumbers = new ArrayList<>();
        firstFivePrimeNumbers.add(2);
        firstFivePrimeNumbers.add(3);
        firstFivePrimeNumbers.add(5);
        firstFivePrimeNumbers.add(7);
        firstFivePrimeNumbers.add(11);

        // Creating an ArrayList from another collection
        List<Integer> firstTenPrimeNumbers = new ArrayList<>(firstFivePrimeNumbers);
        List<Integer> nextFivePrimeNumbers = new ArrayList<>();
        nextFivePrimeNumbers.add(13);
        nextFivePrimeNumbers.add(17);
        nextFivePrimeNumbers.add(19);
        nextFivePrimeNumbers.add(23);
        nextFivePrimeNumbers.add(29);

        // Adding an entire collection to an ArrayList
        firstTenPrimeNumbers.addAll(nextFivePrimeNumbers);
        System.out.println(firstTenPrimeNumbers);

        List<String> tvShows = new ArrayList<>();
        tvShows.add("Simpsons");
        tvShows.add("Futurama");
        tvShows.add("Archer");
        tvShows.add("Ugly Americans");

        System.out.println("\n=== listInst.forEach(e-> code) ===");
        tvShows.forEach(tvShow -> {
            System.out.println(tvShow);
        });

        System.out.println("\n=== for(dataType e:listInst) {code} ===");
        for(String tvShow: tvShows) {
            System.out.println(tvShow);
        }

        System.out.println("\n=== for(int i=0; i<max; i++) {code} ===");
        for(int i = 0; i < tvShows.size(); i++) {
            System.out.println(tvShows.get(i));
        }

        System.out.println("\n=== while (iteratorInst.hasNext()) { code } ===");
        Iterator<String> tvShowIterator = tvShows.iterator();
        while (tvShowIterator.hasNext()) {
            String tvShow = tvShowIterator.next();
            System.out.println(tvShow);
        }

        System.out.println("\n=== iteratorInst.forEachRemaining(e->{code}) ===");
        // I can make new instance to iterate over too
        // Iterator<String> tvShowIterator2 = tvShows.iterator();       
        // tvShowIterator2.forEachRemaining(tvShow -> {
        //     System.out.println(tvShow);
        // })

        // But, I can also 'refresh' the previous iterator used before
        tvShowIterator = tvShows.iterator();    // <- without this line, tvShowIterator has nothign remaining to iter over
        tvShowIterator.forEachRemaining(tvShow -> {
            System.out.println(tvShow);
        });
        
        System.out.println("\n=*= Iterator<dataType> instances start from the beginnning of the list,\nvs... ListIterator<dataType> instances start from the end of the list =*=");

        System.out.println("\n=== while(listIteratorInst.hasPrevious() {code}) ===");
        // Here, we start from the end of the list and traverse backwards.
        ListIterator<String> tvShowListIterator = tvShows.listIterator(tvShows.size());
        while (tvShowListIterator.hasPrevious()) {
            String tvShow = tvShowListIterator.previous();
            System.out.println(tvShow);
        }
        System.out.println("...Now the tvShowListIterator is scrolled to the beginning, can I scroll back down w/ .hasNext()?");
        while (tvShowListIterator.hasNext()) {
            System.out.println(tvShowListIterator.next());
        }

        System.out.println("\nSORTING an ArrayList");
        System.out.println("  Using Collections.sort(listInstance) ");
        Collections.sort(animals);
        System.out.println("\t\tAfter : " + animals);

        System.out.println("  Using listInstance.sort(comparator c)        <- chunk of code! ");
        animals.sort(new Comparator<String>() {
            // @Override        // does not look like i actually need this line...
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println("\t\tAfter : " + animals);

        System.out.println("  Using listInstance.sort((a,b)->a.compareTo(b));");
        animals.sort((a, b) -> a.compareTo(b));
        System.out.println("\t\tAfter : " + animals);

        System.out.println("  Using listInstance.sort(Comparator.naturalOrder());");
        animals.sort(Comparator.naturalOrder());
        System.out.println("\t\tAfter : " + animals);

        System.out.println("  Using a custom comparator()... listInstance.sort((a,b)->{ return a.getAttr() - b.getAttr(); });");
        // example: people.sort((person1, person2) -> { return person1.getAge() - person2.getAge(); });
        System.out.println("  Using a custom comparator()... listInstance.sort(Comparator.comparingInt(ClassOfListInstEntries::getAttr1));");
        // example: people.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("  Using a custom comparator()... Collections.sort(listInstance, Comparator.comparing(ClassOfListInstEntries::getAttr1;");
        // example: Collections.sort(people, Comparator.comparing(Person::getName));

        System.out.println("\nArrayList is not synchronized.  If multiple threads try to modify an ArrayList at same time thne final result becomes non-deterministic bc 1 thread might override the changes done by another thread");
        System.out.println(" go read bottom part of https://www.callicoder.com/java-arraylist/ for more");

        System.out.println("\n================== TYPES ==================");
        System.out.println("Implicit casts:");
        int x = 1;
        double xx = x;
        System.out.println(x + " -implicit-> " + xx);

        System.out.println("Explicit casts:");
        double yy = 3.14;
        int y = (int) yy;   // = yes i know yy is actually a float, but i want to force it into type integer
        System.out.println(yy + " -explicit-> " + y);

        System.out.println("Via method calls:");    // also called wrapper fcns
        String str = "1";
        int s = Integer.parseInt(str);
        System.out.println(str + " -Integer.parseInt(str)-> " + s);


        System.out.println("\n================== MATH ==================");
        System.out.println("simple integer math: 10/3 --> " + 10/3);
        double fakeResult = 10/3;
        double realResult = (double)10/(double)3;
        System.out.println("double fakeResult = 10/3 --> " + fakeResult);
        System.out.println("double realResult = (double)10/(double)3; --> " + realResult);

        System.out.println("\nFORMATTING NUMBERS");
        //first make a CurrencyInstance under NumberFormat class
        NumberFormat busFare = NumberFormat.getCurrencyInstance(); 
        // NumberFormat instances are FACTORIES!
        // then give that CurrecyInstance a value for the String it's going to return
        String busFareStr = busFare.format(2.75); 
        String discountBusFareStr = busFare.format(1.50);  
        System.out.println(busFareStr + " vs " + discountBusFareStr);

        //How about using NumberFormat to make a Percent Instance?
        // percentInst can be used to make other % strings, it's a FACTORY that lets u make new methods!
        NumberFormat percentInst = NumberFormat.getPercentInstance();
        String taxRateStr = percentInst.format(0.10);
        String tipRateStr = percentInst.format(0.15);
        String goodTipRateStr = NumberFormat.getPercentInstance().format(0.20); // chained!
        System.out.println(taxRateStr);
        System.out.println(tipRateStr);
        System.out.println(goodTipRateStr);

        // System.out.println("\n================== User INPUT ==================");

        // READING/SCANNING USER INPUT, reactivate the blocks below if u want to see it in action
        // System.out.println("\nREADING/SCANNING USER INPUT");
        // Scanner scanner = new Scanner(System.in);

        // System.out.println("weirdness!!! if I prompt for scanner.next() BEFORE scanner.nextLine(), the immed subseq scanner.nextLine() will NOT run");
        
        // System.out.println("What's your mom's FULL name?");
        // String mom = scanner.nextLine();    // .nextLine() corresp to a full String which can be sev tokens
        
        // System.out.println("What's your first name? ");
        // String name = scanner.next();       // .next() corresp to a single String token
        
        // System.out.println("Now see this following .nextLine() just straight up does not run");
        // String ignored = scanner.nextLine();
        // System.out.println("But this .nextLine() will... so type something");
        // String ignored2 = scanner.nextLine();

        // System.out.println("How old are you? ");
        // byte age = scanner.nextByte();      // .nextByte() corresp to a Byte
        
        // System.out.println(String.format("Hi there %s! You're %d years old!  Your mom %s is super cool!", name, age, mom));
        // System.out.println("the var ignored didn't even get a chance for input... ignored = " + ignored + "<- see? NOTHING!");
        // System.out.println("Yet ignored2 was fine... " + ignored2);
        // System.out.println("Now I have to remember to close() the Scanner obj to avoid leaks");
        // scanner.close();

        System.out.println("\n================== CONDITIONALS ==================");
        
        System.out.println("\nIf/else with FIZZBUZZ(157)...");
        int number = 157;
        if (number%5 == 0 && number%3 == 0)
            // no {} needed if it's just 1 line  
            System.out.println("fizzbuzz");
        else if (number%5 == 0)
            System.out.println("fizz");
        else if (number%3 == 0)
            System.out.println("buzz");
        else {
            System.out.println("nope!");
            System.out.println("sad!");
            // why is this else block in {}?  b/c it's more than 1 line!
        }

        System.out.println("\n================== listInstance.STREAM() ==================");

        System.out.println("\nlistInstance.stream() and its many chains");
        // a STREAM represents a seq of elements and supports diff operations on top of these elements
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c1", "c2", "cool");
        
        myList.stream()
            .filter(item -> item.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);

        Optional<String> firstZ= myList.stream()
            .filter(item -> item.startsWith("z"))
            .findFirst();
        System.out.println("\nOptional<> on something that may NOT exist");
        System.out.println(firstZ);
        System.out.println(firstZ.isPresent());
        System.out.println(firstZ.getClass());

        Optional<String> firstA= myList.stream()
            .filter(item -> item.startsWith("a"))
            .findFirst();
        System.out.println("\nOptional<> on something that does exist");
        System.out.println(firstA);
        System.out.println(firstA.isPresent());
        System.out.println(firstA.getClass());

        System.out.println("\nSTREAM collection");
        String[] abc = { "A", "B", "C" };
        List<String> alphabets = Arrays.asList(abc);
        System.out.println(alphabets);
        System.out.println(alphabets.stream());

        System.out.println("\n================== LinkedHashMap, Set, Iterator, Map ==================");

        System.out.println("\nLinkedHashMap");
        System.out.println("\tthis is what I get from a POST request, if I set the header with key:value to Content-Type:Application/json");
        System.out.println("\tthen, when I receive it in Spring... public void receive(@RequestBody Map<String, Object> payload) {code...}");

        LinkedHashMap<String, String> lhmap = new LinkedHashMap<String, String>();
        lhmap.put("a", "apple");
        lhmap.put("b", "bee");
        lhmap.put("a", "astronaut");
        System.out.println("linkedHashMapInstance.get(key1) => value1 \t" + lhmap.get("a"));

        Set set1 = lhmap.entrySet();
        System.out.println("What if I were to make a Set?\t" + set1);
        
        Iterator iterator = set1.iterator();
        System.out.println("What if I were to make .iterator() from that set?\t" + iterator);
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("Key = " + entry.getKey() + " & Value = " + entry.getValue());
        }











        System.out.println("\n\n\n--------------------------------------------------");


        //getting username using System.getProperty in Java
    //    String user = System.getProperty("user.name") ;
    //    System.out.println("Username using system property: "  + user);
   
    //  //getting username as environment variable in java, only works in windows
    //    String userWindows = System.getenv("USERNAME");
    //    System.out.println("Username using environment variable in windows : "  + userWindows);
   
     
    //  //name and value of all environment variable in Java  program
    //   Map<String, String> env = System.getenv();
    //     for (String envName : env.keySet()) {
    //         System.out.format("%s=%s%n", envName, env.get(envName));
    //     }
    }
    }

    // public class Puppy {
    //     String name;
    //     int age;
    //     String favTreat;

    //     public Puppy(String name, int age, String favTreat) {
    //         this.name = name;
    //         this.age = age;
    //         this.favTreat = favTreat;
    //     }
    // }
