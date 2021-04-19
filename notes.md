# Notes

## Java Basics
### Method signature
We know that in a real world, signature of each person is unique.
Similarly, `method signature` is something which uniquely defines the method in a Java class.
_In a Java class, there can't be two methods with same `method signature`._

A method signature consists of `method name` and `method argument's types`.
Remember that other parts of methods like `return type`, `access modifiers` are not the part of method signature. For example,
```
public boolean sleep(Human human, int hours) {}
```
In this method, the method signature is `sleep(Human, int)`.
Here `boolean` or `public` are not the part of method signature.

Let's take another example,
```
public booleaan sleep(Human human, int hours) {}
public int sleep(Human h, int i) {}
```
Even though both methods have different return type, this is not allowed in Java as both methods have same signature `sleep(Human, int)`.

#### Why return types doesn't matter in method signature?
Let's take an example,
```
public static void main(String[] args) {
   boolean slept = sleep(human, hours); // Calling method which returns boolean.
   int hours = sleep(human, hours); // Calling method which returns int
}
public booleaan sleep(Human human, int hours) {
   System.out.println("I return boolean");
}
public int sleep(Human h, int i) {
   System.out.println("I return int");
}
```
Here as we are defining the variables in main method like `boolean slept`, we can easily tell which method we intend to call. So what is the problem?
Let's take another example where we are not defining the variables in main method, instead we are directly printing the values.
```
public static void main(String[] args) {
   System.out.println(sleep(human, hours)); // I want to call method which returns boolean.
   System.out.println(sleep(human, hours)); // I want to call method which returns int
}
public booleaan sleep(Human human, int hours) {
   System.out.println("I return boolean");
}
public int sleep(Human h, int i) {
   System.out.println("I return int");
}
```
This is where Java compiler gets confused. As we haven't defined any variable, it can't know which method user want to call, `boolean` one or `int` one?
As a programming language can't have ambuiguity, Java simply doesn't allow it. This is the reason Java doesn't include `return` type in method signature as it doesn't help in uniquely identifying the method.

### Overloading
In a same Java class, when multiple methods have same `method name` but different `method signature`s, then that method is `overloaded` in the class. For example,
```
public int sleep(Human human) {}
public int sleep(Human human, int hours) {}

public int eat(Human human) {}
public boolean eat(Human human, Food food) {}
```
Here `sleep` is an overloaded method because there are multiple methods with name `sleep` but with different `method signatures`, `sleep(Human)` and `sleep(Human, hours)`.

Additionally `eat` is also an overloaded method because there are multiple methods with name `eat` but with different `method signatures`, `eat(Human)` and `eat(Human, Food)`. `Return type` doesn't matter here.

### Access Modifiers
A modifier modifies something. `Access modifiers` modifies the visibility of a class, constructor, method, or field.
`private`: Access only within the class.
`default`: Access only within the package.
`protected`: Access within the package. Additionally, if a class outside the package has extended the class, then it can also access it.
`public`: Anyone can access it.
For example:

TODO: As we are mentioning about class extend here, we should first write the doc inheritance.
TODO: Create section of each access modifier, and take examples like class can't have private etc.
TODO: When writing overriding doc, mention that overriden method must not be more restrictive. 

### Non-access Modifiers
TODO: There are some other modifiers like static, abstract, synchronized, native, volatile, transient. Understand and write docs about it.



Notes - 9/03/2021 .......................................

1. public ,private, protected, default - are access modifiers - they can change the access of any class , method etc.
2. public - anyone can access it in the process.
3. private - anyone in that file can only access it.
4. doc, multiline, single line comment.
5. understand the meaning of doc comment ?????????????

Notes - 11/03/2021.................................
1. curly backet ki TC nikalne ke liye unke andar wale ki TC nickalni hai......tabhi hume pata chalega ki sigma me likhna kya hai.
2. learn sigma formula - 4
3. in SC sigma is not used because with every curly backet end the space occupied by variables get freed  not piled up. And space is ready for new start. But sigma is used in space complexity when varaibles are not freed but piled. For Eg: list.addLast() in a 'for loop' will cause SC of 'for loop' to be O(n).

Notes - 12/03/2021........................................
1. git clone = put git hub repository locally(in folder).
2. git add, git commit, git push
3. . means - any character ........in regex (regular expression)
4. * means - 0 or more ....... in regex
5. + means - 1 or more ....... in regex

Notes - 13/03/2021 ....................................
1. overloading is when two methods are of same name in same class but with different method signature.
2. two methods with same method signature is not allowed.

Notes - 14/03/2021 ................................
1. String to integer(primitive) conversion = Integer.parseInt()
2. String to Integer (reference) conversion = Integer.valueOf()
3. Integer(primitive) to String conversion = String.valueOf()
4. Integer (reference) to String conversion = x.toString(), where x is integer object.
5. String constructor takes O(n) time ..... eg= String str = "saloni" takes O(n) time where n is length of str. Eg = String str = new String("saloni") takes O(n) time.
6. ' + ' OPERATION  in String creates a new String with combine length of left and right. So it takes O(m + n) time where m is left length and n is right length.
7. If same method is being used again and again in same method then its better to call it once and stored it in a variable. Calling it again and again increases TC.

Notes - 17/03/2021 ......................................
1. ' == ' compare the reference address in object types but value in primitive types. So, for value comparision in object types use equals(). For eg - String a = new String("saloni"); , String b = new String("saloni"); , Here a == b is false but a.equals(b); is true.
2. String a = "saloni" ; and String b = "saloni"; Here we can use '==' and a == b will be true . This is a special case as variables are define without ' new ' keyword which uses a concept ie. String pool (you will learn latter).

Notes - 19/03/2021...........................
1. corner cases in any integer problem are negative values; overflow because of *, +, -; infinite because of 0 denominator in divide.
2. To avoid overflow issue we can use long whenever required for *, + -.
3. If 'if else' statement has only one line using same variable, use ternary operator. for eg => int y = (x > 0) ? x : 0;
4. Whenever you solve a problem, think in mind what steps are requied to solvethe problem, for eact step write a new method. if the step has only 1-2 lines then no need to create a new method but use " COMMENTS ".
5. corner cases in string are null & "".

Notes - 20/03/2021..............
1. How to solve a problem/ method:
   a. Understand the problem
   b. Write steps of solving the problemm and each method in it.
   c. After writing steps think of corner cases. If corner cases are not covered by steps, write steps to cover them.
   d. For each step implement a new method. But not need of new method if steps have only 1-2 lines. While implementing remember of null checks.
   e. Check in the code if any optimisations can be done. For eg: 
        1. inverse if-condition, 
        2. ternary operator, 
        3. directly calling condition if ifelse return true or false based on it, 
        4. defining variable once if method used multiple times, 
        5. not defining variable if used only once and it is simple, 
        6. if 'if condition' has only one line then no need of curly backets. etc.
   f. Code walkthrough via normal correct input cases.
   g. Code walkthrough via normal incorrect input cases.
   h. Code walkthrough via corner input cases(both correct and incorrect). For Eg: n = 0, 1; null object; empty array or string; out of bound indexes in array; overflowed integer etc.
   i. Write TC and Sc.
   j. Write comments.

Notes - 21/ 03/2021..........................................
1. if 'if statement' is returning boolean using || && operator , then it is good to return the condition directly instead of using 'if statement'.
2. if ' if statement ' is returning , then no need to use else .....instead return the else condition directly.

Notes - 1/04/2021.....................................
1. In loop , if null value for any variable then have proper null checks.
2. cautiously use ' new ' keyword.
3. Whenever you are calling object's method or variable use '.' ie. object.variable, object.method(). Whwnever you are using '.' in your logic always check whether the object can be null or not , if null then avoid it(null check).
4. if in 'if else' logic almost all code is same except 1-2 variable then try to use ternary operator to optmise the code(by take out the same cde outside).

Notes - 3/04/2021
1. Solve the problem with copy pen concept.

Notes - 10/04/2021...................................
Hashing:-
1. Hash is an integer representation of an object.
2. Hash is used in datastructure like hash map and hash set.
3. In hash map they store a 'key value pair'. 
4. In Hash map internally, array is used.
5. To get the index where the 'key value pair' should be store, we first find the hash of key object,  and then do hash % arrayLength to find the index.
7. Two same keys will always have same hashcode.
8. Two different keys can have same hashcode ie. hashcode collision, and thus they have same index for both keys. This creates a problem that how to store two 'key value pairs' at same index.
9. To store multiple 'key value pairs' at same index we use linked list at that index.
10. Using a linked list increases our time complexity of basic method of hashmap and hashset, so we should avoid the  hashcode colision as much as collision , so that linked list doesnot have more that 2-3 elements, and thus saving time complexity.
11. To avoid hashcode collions, write a good hash function.
12. To get a good hashcode of a string, we should consider all charcters in the string, their indexex, using prime number in the calculation etc. 31 has been found a good prime number.
13. Java uses- s[0].31^(m-1) + s[1].31^(m-2) + ... + s[m-1].31^0.
14. In questionsrealted to hashing, we assume that hashcode collision are less (assuming key class haa good function).
15. Even if hashcode are different for two different keys,their index in hashmap array an be same(i.e. index collision). This index collision can happen because we do hash % arrayLength.
16. To avoid index collision, we always keep arraylength > hashmap.size so that each element  has a chance to go to a different inde. Weachieve this by doubling the arrayLength, whenever arraylength == size.
17. hwen searching a sub string in a string, we can use rolling hash concept also known as Rabin karp algorithm, and this achieving O(n+m) instead of O(nm) assuming less collisin.
18. Rolling hash: newHash = oldHash*31 - str[start-1]*31^m + str[end].

Notes: 11/04/2021................

Binary Search:
1. It is only applied when array is sorted.
2. we use low, high, mid pointers. for each loop iteration, we decide whether we should go to left section or right section. Thus in each loop we reduce length/2 for check.
3. As in each loop length is redude by half for check, the while run in total for logn times. So the TC is logn  which is very fast.

General:
1. In an array we can use multiple concept to solve it. 
    1. Rolling fixed size window: In this approach, we do start++ and end++ based on some condition to roll our window. For eg: rolling hash/ Rabin karp algorithm.
    2. Rolling dynamic size window: In this approach, we either do start++ or end++ to change the size of our old window, or we do start = end = i to move to a new window. For eg: Finding contiguious sub array with maximum sum.
    3. 

Notes: 12/04/2021..............................
1. if int array is define then it contain 0 as default value.


