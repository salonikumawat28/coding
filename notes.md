Notes - 8/03/2021 .......................................
1. Method signature = method name + method arguments ke type.
2. return type is not part of method signature.

**
multiple arguement
1.

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
   c. For each step implement a new method. But not need of new method if steps have only 1-2 lines. While implementing remember of null checks.
   d. Check in the code if any optimisations can be done. For eg: 
        1. inverse if-condition, 
        2. ternary operator, 
        3. directly calling condition if ifelse return true or false based on it, 
        4. defining variable once if method used multiple times, 
        5. not defining variable if used only once and it is simple, 
        6. if 'if condition' has only one line then no need of curly backets. etc.
   e. Code walkthrough via normal correct input cases.
   f. Code walkthrough via normal incorrect input cases.
   g. Code walkthrough via corner input cases(both correct and incorrect). For Eg: n = 0, 1; null object; empty array or string; out of bound indexes in array; overflowed integer etc.
   h. Write TC and Sc.
   i. Write comments.

Notes - 21/ 03/2021..........................................
1. if 'if statement' is returning boolean using || && operator , then it is good to return the condition directly instead of using 'if statement'.
2. if ' if statement ' is returning , then no need to use else .....instead return the else condition directly.

Notes - 1/04/2021.....................................
1. In loop , if null value for any variable then have proper null checks.
2. cautiously use ' new ' keyword.
3. Whenever you are calling object's method or variable use '.' ie. object.variable, object.method(). Whwnever you are using '.' in your logic always check whether the object can be null or not , if null then avoid it(null check).
4. if in 'if else' logic almost all code is same except 1-2 variable then try to use ternary operator to optmise the code(by take out the same cde outside).
