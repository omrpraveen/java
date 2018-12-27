package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * This is an example for accessing fields and inner classes
 */
public class FieldGetSet {


    public class Test{
        public String value = null;
    }

    public static void main(String args[]){

        try{

            Class parentClass = FieldGetSet.class;
            Object parentObject = parentClass.newInstance();

            Class childClss = Test.class;
            Constructor ctor = childClss.getDeclaredConstructor(parentClass);
            Object childObject = ctor.newInstance(parentObject);



            Field[] fields = childClss.getDeclaredFields();
            for(Field field : fields){
                System.out.println(field.getName());
                field.set(childObject,"test");
                System.out.println(field.get(childObject));
            }



        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
