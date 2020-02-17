### SOURCES: 
  https://code.visualstudio.com/docs/java/java-tutorial
  https://dzone.com/articles/visual-studio-code-for-java-the-ultimate-guide-201
  https://www.codecademy.com/learn/learn-java
  https://stackify.com/streams-guide-java-8/
  https://stackoverflow.com/questions/46579074/what-is-the-difference-between-list-of-and-arrays-aslist
  https://www.youtube.com/watch?v=Q93JsQ8vcwY
  https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/ <- did NOT read
--------------------------------------------------
### To start a new project
  In VS code, bring up Command Palette via Shift-Cmd-P
  Type in 'java: create java project'
  Select the directory where u want the new project to go, click ok/select.  
  Give name of new project when prompted.

  At this point you shoud see the new directory being made, with default files:
    1. .vscode > settings.json
    2.  bin > App.class   <-- this is the binary we don't touch
    3.  src > App.java    <-- this is the entry point

### Running & debugging
  F5 to run & debug.
    Make sure the debug dragdown menu doesn't use prev def'd ruby settings, I think debug(launch) is the correct one for java?
  
# Java Dependency Viewer\
  1.  lets u manually add libraries/JARs
      * can put .jar files in a lib folder directly under root
      * vs code extensions will automatically load those jar libraries in the classpath & run
  2.  allows u to visualize the classpath ur project is currently set for, even if it's a Maven proj
      * What is Maven?  A popular project build and dependency mgmt tool in Java ecosystem.
      * we can generate & bootstrap Maven projs thru Maven archetypes/skeletons, manage dependencies and trigger Maven goals, and edit pom.xml files
      * To use maven, get Command Palette and type 'maven' to see all the options.



--------------------------------------------------
### CODECAdemy JAVA COURSE 
  https://www.codecademy.com/learn/learn-java
### plus JAVA tutorials w/ Mosh on youtube
  https://www.youtube.com/watch?v=eIrMbAQSU34&t=521s
### Coursera java course from Duke
  https://www.coursera.org/learn/java-programming/lecture/BNtuk/types
--------------------------------------------------

### VARIABLES
  # PRIMITIVE DATA types vs OBJECTS/REFERENCE types
    # PRIMITIVES:
      * Value is directly in box
      * Can't invoke methods on them
      * Can't be null (but can use wrapper class)
      * short vs int vs long
      * float vs double
      BYTE  - holds 1 byte, range [-128, 127]
      SHORT - holds 2 bytes, range [-32k, 32k]
      INT - holds 4 bytes, range[-2B, 2B]
      FLOAT - holds 4 bytes, have to suffix with "F" to differentiate from default of double
      DOUBLE  - holds 8 bytes, range 4.9 E-324 to 1.797 E+308
      LONG  - holds 8 bytes, have to suffix with "L" to differentiate from default of int
      BOOLEAN - holds 1 byte
      CHAR  - holds 2 bytes, uses single quotes '
    # OBJECTS/REFERENCE types
      * reference/arrow to object
      * can invoke methods, access fields with dot.
      * can be null
      * == checks reference and not value
      String  - uses double quotes "
  # CONSTANTS, via prefix of final
    float pi = 3.14F;   <- bad b/c other people can change pi value
    final float pi = 3.14F;   <- now it's a CONSTANT b/c FINAL!

  # PRIMITIVEs
    # DECLARATION
      int numberTBD;
    # ASSIGNMENT
      numberTBD = 100;
      numberTBD = 123_456_789;
    # DECLARE & ASSIGN = INITIALIZE
      int numberTBD = 100;
    # MEMORY ADDRESS
      int x = 1;
      int y = x;    <- y gets its own COPY of x's VALUE
      x and y are 2 different memory addresses, both with value of 1
      changing x does NOT change y!!

  # OBJECT/REFERENCE types
    # DECLARATION
      Date now = new Date();
      String name = new String();
    # MEMORY ADDRESS
      String string1 = new String("shared");    
      [SHORTCUT!] String string1 = "shared"; <- is acceptable for String databype b/c of popularity
      String string2 = string1;   <- string2 gets a COPY of the REFERENCE
      string1 and string2 have diff memory address, but what they store is the SAME POINTER/REFERENCE to "shared".
      changing string1 DOES change string2!

### TYPE CASTING
  consider this code...
    short x = 1;
    int y = x + 2;
    Is this cool?  
    Yes!  bc short takes 2 bytes and int takes 4 bytes, y can fit x. 
    UTH: java anonymously sets aside space for a copy of x value, then it adds 2 to that value, and the whole thing is y.  This is called IMPLICIT casting.
  # IMPLICIT CASTING happens when you won't lose data b/c the bigger memory variable is taking in the smaller memory variable.
  now consider this...
    double x = 1.1;
    double y = x + 2;
    Is this cool?   Yes
  What if I want to get an int y out of the double above?
    double x = 1.1;
    int y = (int)x + 2;
    is this cool? Yes.  This is EXPLICIT type casting
  # EXPLICIT CASTING can only be done on compatible data types.
  What if x started as a string?
    String x = "1";
    int y = Integer.parseInt(x) + 2;  <- Use WRAPPER CLASS Integer.parseInt()
  # WRAPPER CLASSES 
    like Integer.parseInt(x), can be used for explicit type conversion
    ex: Double.parseDouble(x), Short.parseShort(x), etc

### MATH class
  # Math.round(float)   => int
  # Math.round(double)  => long
  # Math.ceil(num)
  # Math.floor(num)
  # Math.max(num1, num2)
  # Math.random()   => a double between 0 and 1

### FORMATTING NUMBERS
  NumberFormat busFare = new NumberFormat(); <- not a thing! bc NumberFormat is abstract and CANNOT be instantiated

  NumberFormat class has a bunch of factory methods (it creates new objs)
  like .getCurrencyInstance() and .getPercentInstance()

  //first make a CurrencyInstance under NumberFormat class
  NumberFormat currencyMaker = NumberFormat.getCurrencyInstance(); 
  // then give that CurrecyInstance a value for the String it's going to return
  String busFare = currencyMaker.format(2.75);  
  String discountBusFare = currencyMaker.format(1.50);


### CLASSES
  see src/app/Store.java and src/app/Dog.java

example:
  public class Car {
    // scope of Car class starts after curly brace

    public static void main(String[] args) {
      // scope of main() starts after curly brace

      // program tasks

    }
    // scope of main() ends after curly brace

  }
  // scope of Car class ends after curly brace

  * public is an access level modifier that allows other classes to interact w/ it
  * the main() in this class runs when we execute the compiled Car.class file
  * ONLY 1 file needs a main()
  * printing a class instance/obj will print the name of the class plus its memory address
  * write a new method toString() if u want it to print soemthing other than memory address


### CONDITIONALS
  # IF/ELSE
    if (true) 
      // do this, but if only 1 line u can skip {}
    else if (somethig else) {
      // do this
      // and this
    } else 
      // do this
  # SWITCH/CASE
    switch (varHere) {
      case "val1":
        // code
        break;
      case "val2":
        // code
        break;
      default:
        // code
    }
  # TERNARY OPERATORS
    (conditional) ? "doThisIfTrue" : "doThisIfFalse";


### ARRAYS[]      (fixed size)
# import java.utils.arrays;
  # declare array ... 
    dataType[] varName;
    ex: double[] prices;
  # assign array
    varName = {entry1, entry2, entry3, etc};
    ex: prices = {13.15, 1.23, 4.52, 1.45, etc};
  # initialize = declare + assign
    dataType[] varName = {entry1, entry2, etc};
    ex: double[] prices = {13.15, 1.23, 4.52, 1.45, etc};
  # initialize an empty array
    dataType[] varName = new DataType[#entries];
    !!! varName will always be length = #entries !!!
    to assign each index... varName[i] = "whatever sits at index i";
    ex: String[] menuItems = new String[5];
      menuItems[0] = "hot dog";
  # printing the array instance...
    default is to print memory address
    IF U WANT SPECIAL PRINT MSG...
      import java.util.Arrays;
      String printActualArray = Arrays.toString(arrayVarName);
      System.out.println(printActualArray);
  # arrayInstance.length
  # arrayInstance[index]    <- to access & assign

### ARRAYLISTS<>    (flexible size, dynamic!)
# import java.util.ArrayList;   <- ArrayList is singular!
  # NO primitives! Only <Generic dataType> allowed!
    ArrayList<int> ages;      <- NO!
    ArrayList<Integer> ages;  <- YES!
    # Acceptable generics:
      <Integer>
      <Double>
      <Char>
  # Declare
    ArrayList<Generic dataType> varName;
    ex: ArrayList<String> dogNames;
  # Initialize
    ArrayList<Generic> varName = new ArrayList<Generic>();
    ex: ArrayList<String> dogNames = new ArrayList<String>();
    ex: ArrayList<Integer> ages = new ArrayList<Integer>();
  # arrayListInstance.add()
  # arrayListInstance.size()
  # arrayListInstance.get(index)
  # arrayListInstance.set(index, newValue)
  # arrayListInstance.remove(index)   -or-  arrayListInstance.remove(removeValueOfFirstOccurrence)
  # arrayListInstance.indexOf(value)


### <ArrayLists> vs. [Arrays]
    * import java.util.ArrayList VS. import java.util.Arrays <- plural
    * Both store elements of the same type
    * Both access elements by [index]
    * ArrayLists are dynamic: can add/remove elements, on top of reassigning specific index entries
    * Arrays can only reassign specific index entries
    * Arrays are fixed in size vs ArrayLists are flexible
    * ArrayLists will NOT accept <primitive> types
    * ArrayInstance.length vs ArrayListInstance.size()
    * ArrayInstance[index] vs ArrayListInstance.get(index)
    * ArrayInstance[index]= vs ArrayListInstance.set(index, newValue)
    * ArrayListInstance.remove(index) -or- ArrayListInstance.remove(removeValueOfFirstOccurrence)
    * no removal method for Arrays, maybe just assign to null?


### List<> vs ArrayList<>
  # ArrayList<> is built on List<>

### Arrays.asList() vs List<>
  
  # Arrays.asList() => mutable list               // internally calls... new ArrayList
  # List.of()       => immutable list             // 
    List<Integer> list = Arrays.asList(1, 2, null);
    list.set(1, 10); // OK
  VS
    List<Integer> list = List.of(1, 2, 3);
    list.set(1, 10); // Fails with UnsupportedOperationException
    
  # Arrays.asList()   allows null elements 
  # List.of()         no nulls!
    List<Integer> list = Arrays.asList(1, 2, null); // OK
    List<Integer> list = List.of(1, 2, null); // Fails with NullPointerException

  # Arrays.asList()   .contains(null) works
  # List.of()         .contains(null) fails with NullPointerException
    List<Integer> list = Arrays.asList(1, 2, 3);
    list.contains(null); // Returns false
    List<Integer> list = List.of(1, 2, 3);
    list.contains(null); // Fails with NullPointerException

  # Reference in/equality
    # asList1 != asList2        
        asList1 = origData.asList() calls on new ArrayList <- ref ineq
    # listOf1 ==/!= listOf2
  # Value in/equality
    list1.equals(list2) compares the values & order, NOT the memory address

  # Time & Space efficiency
    List.of()   slighty faster on some ops, like size(), contains (E e)


### Optional<>
    * Optional<dataType> may contain null values, which u can check against w/ .isPresent(), and act accordingly to avoid NullPointerException
    # MAKE AN OPTIONAL 
      optionalObjNow = Optional.of(originalObj);
    # GET ORIG OBJ OUT OF OPTIONAL 
      originalObj = optionalObjNow.get();

### .STREAM()   via java.util.stream      * FUNCTIONAL PROGRAMMING :-)
  https://stackify.com/streams-guide-java-8/
  # Streams are wrappers around a data source, allowing us to operate with that data and makes bulk processing convenient & fast
  # A stream does NOT store data and is NOT a data structure.  It does NOT modify the data source.
  # think map/reduce type transformations on collections
  # Operation: Intermediate VS Terminal
    # Intermediate: 
      peek(), 
      filter(), 
      map(), 
      skip(), 
      limit(), 
      sorted(), 
      distinct(),
      min(),          max(),      
    # Terminal: 
      forEach(), 
      count(), 
      collect(), 
      orElseThrow(),                    orElse() 
      allMatch(),     anyMatch(),       noneMatch()
      reduce()
  # Lazy (short-circuit-able) streams usually, unless something like sort() or min/max() requires all items to stream by first
  # GENERAL FORMATS
    # dataSource.stream().intermediate().intermediate2()....terminal()
    # dataSource.stream().terminal()
    # can use .peek() to extend the stream before the ultimate terminal()

  # Comparing, manual examples
    * blahblahblah.sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).collect(...);
    * blahblahblah.min((e1, e2) -> e1.getId() - e2.getId()).orElse(...);
  # Comparing w/ Comparator
    * Comparator.comparing(objectType::getterFcn)
    * example: blahblahblah.max(Comparator.comparing(Employee::getSalary)).orElse(...);
  
  # reduce()
    * most commonly... T reduce(T identity, BinaryOPerator<T> accumulator)
      identity = starting value, accumulator = binary operation we repeatedly apply
    ex: Double sumSal = empList.stream().map(Employee::getSalary).reduce(0.0, Double::sum);

  # advanced collect() methods
    # blahblahblah.collect(Collectors.joining("& ")).toString();
    # blahblahblah.collect(Collectors.toSet());
    # blahblahblah.collect(Collectors.toCollection(Vector::new));  < -- idk, go read site
    # DoubleSummaryStatistics stats = blahblahblah.collect(Collectors.summarizingDouble(Employee::getSalary));
      These are included when u gen a DoubleSummaryStatistics obj:
        stats.getCount()
        stats.getSum()
        stats.getMin()
        stats.getMax()
        stats.getAverage()
    # Map<Boolean, List<datatype>> partitioned = blahblahblah
      .collect(Collectors.partitioningBy(conditionT/F));
        =>  partitioned.get(true)   vs partitioned.get(false)
    # Map<category, List<dataType>> groupedByCats = blahblahblah
      .collect(Collectors.groupingBy(objClass::categoryGetterFcn));
        => groupedByCats.get(categ1)  vs groupedByCats.get(categ2) vs groupedByCats.get(categ_etc)
    # Map<newDataType, List<dataType>> groupedByNewDataType = blahblahblah
      .collect(Collectors.groupingBy(e -> new DataType(something), 
                    Collectors.mapping(objClass::getterFcnForNewDataType, Collectors.toList())));
      * Collectors.mapping() lets u adapt the collector to a diff dataType!
    # DataType varName = origData.stream()
        .collect(Collectors.reducing(initVal, e->code_for_e_to_gen_additive_value, (s1, s1)->(s1+s2)));

  # Parallel Streams
    // .parallel() is multi-threaded, need to ensure code is thread safe...
    empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0));
      vs
    // straight-up .forEach just does it iteratively
    empList.stream().forEach(e -> e.salaryIncrement(10.0));
      vs
    // if u don't want to end the stream w/ .forEach(), replaced that with .peek() and keep going
    empList.stream().peek(e -> e.salaryIncrement(10.0)).collect(...);

  # Infinite streams,   aka unbounded streams
    When we don't know how many elements we'll be goign over, use Stream.generate(). 
    Gen Format: Stream.generate(supplierClass::getterFcn).....infinity_unless_we_add....limit(#)...
    ex: Stream.generate(Math::random).limit(5).forEach(System.out::println);
  # iterate(initVal, fcn_to_gen_next_val)
    Stream<Integer> infEvenNumbers = Stream.iterate(2, i->i+2);
    List<Integer> justFiveEvens = infEvenNumbers.limit(5).collect(Collectors.toList());
    
  # File Write      // yeah idk...
    String[] words = {"aaa", "bbb", "ccc", "ddd"};
    try (PrintWriter pw = new PrintWriter(
      Files.newBufferedWritter(Paths.get(fileName)))) {
        Stream.of(words.forEach(pw::println));
      }
  # File Read
    i gave up

  # Declarative (old school, sep fcn calls) VS Imperative (functional programming with stream)
    https://www.youtube.com/watch?v=Q93JsQ8vcwY
    # DECLARATIVE APPROACH 
      ex1:  example from video, 3 sep statements :-|
        List<Person> females = new ArrayList<>();
        for (Person person: people) {
          if (person.getGender().equals(Gender.FEMALE)) {
            females.add(person);
          }
        }
      females.forEach(System.out::println);
    # IMPERATIVE APPROACH,  1 statement w/ origData.stream()
      ex1:  this does the same as ex1 above, but with just 1 statement :-D
        List<Person> females = people.stream()
          .filter(person -> person.getGender().equals(Gender.FEMALE))
          .collect(Collectors.toList());
      ex2:
        List<Person> sortedPeeps = people.stream()
          .sorted(Comparator.comparing(Person::getAge).thenComparing(People::getGender))
          .collect(Collectors.toList());
      ex3:
        boolean allMatch = people.stream()
          .allMatch(person -> person.getAge() > 8);
      ex4:
        boolean anyOskis = people.stream()
          .anyMatch(person -> person.getName().equals("Oski"));
      ex5:
        Map<Gender, List<Person>> groupedByGender = people.stream()
          .collect(Collectors.groupingBy(Person::getGender));
      
  # Streaming for primitives
    * IntStream
    * LongStream
    * DoubleStream
    * BUT... these do not extend Stream, but BaseStream on top of which Stream is buit
      So not all operations Stream uses are ok for primitives.
    # Creating a primitive stream
      Option 1: to make an IntStream, call mapToInt() on an existing stream
          * ex: Integer latestEmpId = empList.stream().mapToInt(Employee::geId).max().orElseThrow(NoSuchElementException::new);
      Option 2: IntStream.of(1,2,3,etc);    <- VS Stream.of(1,2,3) which is a Stream<Integer>
      Option 3: IntStream.range(10, 20);    <- creates 10 to 19
    # Specialized operations 
      sum()
      average()
      range() 
      etc
    








### LOOPS
  # WHILE loops
    while (conditionTrue) { code }
    ex: while (wishes < 3) { wishes++; }
  # DO WHILE loops
    do { // do this at least this once
    } while ( condition );    <- if cond'n=true, then do will run again
  # FOR loops
    for (start cond'n; end cond'n; incr/decr) {  code }
    ex: for (int i = 0; i< 5; i++ ) { //do this }
  # FOREACH loops
    for (dataType eachItemVar : arrayVar ) { code }
    ex: for (String dog : doggies ) { giveTreats(dog); }
  # BREAK 
    breaks out of the iteration loop
  # CONTINUE
    stops this iteration and moves onto the next iteration
    

### STRINGS
  ### Java STRINGS are IMMUTABLE! any fcns that modify it will return new string!
  # STRING CONCATENATION
    ex: str1 + " " + str2
  # STRING INTERPOLATION
    use String.format(" blah blah %s blah %d blah %f")
    use %s for string, %d for int, %f for float
    can specify number of decimal places like %.2f for dollars
    ex: go look at Store.java, line 25
  # .length()
  # .concat("new_addition")           
  # .equals("compareToThis")    <- don't use ==
  # .indexOf("string")       <- returns 1st occurrence, or -1 if not found
  # .charAt(index)         <- returns error if out of bounds
  # .substring(index_start, [excls_index_end])  
    <- index_end defaults to last index+1
  # .toUpperCase()
  # .toLowerCase()
  # .endsWith("string") <- T/F
  # .replace("target","replacement") 
  # .trim() <- gets rid of whitespace @ beginning & end
  
  
### INHERITANCE
  class Parent { code }
  class Child extends Parent { code }

  # Access modifiers
    * Public      : class(self), package, child class, global
    * Protected   : class(self), package, child class
    * None        : class(self), package
    * private     : class(self)
    * final (prefix access modifier to public/protected/private): disallows children from changing that method.  This parent has the final word.
    
   # @Annotations 
    * @Override (on line above child's fcn declaration): lets child class' fcn to override parental fcn.

  # Using a child class as its parent class
    ParentClass oski = new ChildClass();
    # If ChildClass has an @Override on a sharedFcn() that's being used by both parent & child, would oski.sharedFcn() run the Parent's version or the Child's version? Child's version! :-D
    # If ChildClass has a childFcn() that's NOT avail in ParentClass, would oski.childFcn() work? NO! B/c oski is being treated as a ParentClass!
    # Why would we want to do this?  It helps if we need to assemble a bunch of child classes soemwhere where they require the same classes...
      ex: 
        Monster dracula, wolfman, zombie1;
        dracula = new Vampire();
        wolfman = new Werewolf();
        zombie1 = new Zombie();
        Monster[] monsters = {dracula, wolfman, zombie1};
        # we're able to put all 3 monsters into an Array b/c they're the same class of Monster, we can't do it if we're trying to put a Vampire instance, a Werewolf instance, and a Zombie instance in the same array.
  
  # Summary on INHERITANCE & POLYMORPHISM
    # A Java class can inherit fields and methods from another class.
    # Each Java class requires its own file, but only one class in a Java package needs a main() method.
    # Child classes inherit the parent constructor by default, but it’s possible to modify the constructor using super() or override it completely.
    # You can use protected and final to control child class access to parent class members.
    # Java’s OOP principle of polymorphism means you can use a child class object like a member of its parent class, but also give it its own traits.
    # You can override parent class methods in the child class, ideally using the @Override keyword.
    # It’s possible to use objects of different classes that share a parent class together in an array or ArrayList.

### DEBUGGING
  # TRY/CATCH
    try {
      // block of code to try
    } catch (NullPointerException e) {
      System.err.println("Ain't nuthin' there: " + e.getMessage());
    } catch (ArithemeticException e) {
      System.err.println("Shitty math: " + e.getMessage());
    }

### READING INPUT
  # import java.util.Scanner;
  Scanner myScanner = new Scanner(System.in);
    * System.in is the terminal window
  myScanner.next_____() <- bunch of diff methods for the Scanner obj, all starting with .next<something>
  * Just go see App.java to see it in action
  example:
    System.out.println("what's your name?"); 
    * the next line is the terminal waiting for user input
    String name = myScanner.next(); <- if u only want the 1st word token
      -or-
    String fullName = myScanner.nextLine(); <- if u want all words
      -or-
    byte smallNumber = myScanner.nextByte();  <- if u want small number
      -or-
    double taxRate = myScanner.nextDouble();  <- if u want a double
      -or-
    <dataType> varName = myScanner.next<dataType>();
    
    * myScanner.close();  <- or get leak error





### NEATO LIBRARIES ###
# Random library
  import java.util.Random;
  Random randomGenerator = new Random();
  int dieRoll = randomGenerator.nextInt(6) + 1;
  # VS.... Math.random() => number between 0 and 1














