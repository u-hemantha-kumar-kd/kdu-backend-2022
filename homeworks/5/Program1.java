package homework5;

import java.lang.annotation.*;
import java.lang.reflect.*;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
    int mySingleVariable();
}
class Single {
    @MySingle(mySingleVariable = 20)
    public static void myMethod() {
        Single obj = new Single();

        try {
            Method m = obj.getClass().getMethod("myMethod");

            MySingle anno = m.getAnnotation(MySingle.class);

            System.out.println(anno.mySingleVariable());      // displays 20

        } catch(NoSuchMethodException exc) {
            System.out.println("Method not found..!!");
        }
    }
}

class Base{
    public void show()
    {
        System.out.println("Inside Base Class");
    }

}

class Child extends Base{
//    @Override is an example of Marker annotation
    @Override
    public void show(){
        System.out.println("Inside Child Class");
    }

    @Deprecated
    public void myDeprecatedMethod()
    {
        System.out.println("This is a deprecated Method");
    }
}

public class Program1 {
    public static void main(String[] args) {
        Child childObj = new Child();
        Single singleObj = new Single();
        childObj.show();
        singleObj.myMethod();

        int usedVariable = 10;
        //not using any variable that has been declared will result in a warning, which can be ignored using SuppressWarnings Annotation
        @SuppressWarnings("unused")
        int unUsedVariable = 20;
        System.out.println(usedVariable);

        childObj.myDeprecatedMethod();
    }
}
