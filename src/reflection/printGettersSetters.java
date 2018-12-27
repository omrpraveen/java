package reflection;

import java.lang.reflect.Method;

public class printGettersSetters {

public static void main(String args[]){
    try{
        Class clss = Class.forName("reflection.ReflectDto");
        System.out.println("Started for analysing "+clss.getName());


        /**
         * it will return all the methods include privdate & protected modifiers
         */
        Method[] methods = clss.getDeclaredMethods();

        for(Method method: methods){
            System.out.println();
            System.out.print(method.getName());
            if(
                    method.getName().startsWith("get")
                    && method.getParameterTypes().length == 0
                    && !void.class.equals(method.getReturnType())
            ){
                System.out.print(" -- This is getter method");
            }
            if(
                    method.getName().startsWith("set")
                            && method.getParameterTypes().length > 0
                            && void.class.equals(method.getReturnType())
            ){
                System.out.print(" -- This is setter method");
            }
            System.out.println();
        }




    }catch(ClassNotFoundException e){
        e.printStackTrace();
    }
}





}
