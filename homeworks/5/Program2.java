package homework5;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ClassLevelAnnotationExample {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldLevelAnnotationExample {
    public String name() default "";
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MethodLevelAnnotationExample {
}

@ClassLevelAnnotationExample
class Person {
    Person(String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.initNames();
    }
    @FieldLevelAnnotationExample(name = "firstName")
    private String firstName;
    @FieldLevelAnnotationExample(name = "lastName")
    private String lastName;
    @FieldLevelAnnotationExample(name = "age")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void initNames() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase()
                + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase()
                + this.lastName.substring(1);
    }
}


public class Program2 {
    public static void main(String[] args) {
        Person person = new Person("hemanth", "kumar", 21);


        for (Field field : person.getClass().getDeclaredFields()) {
            FieldLevelAnnotationExample myField = field.getAnnotation(FieldLevelAnnotationExample.class);
            System.out.println("field name: " + myField.name());

       
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(person);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            System.out.println("field value: " + value);


            System.out.println();
        }

    }
}
