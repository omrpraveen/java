package annotations;

import java.lang.annotation.Annotation;

public class SubClass extends  SuperClass {

    public static void main(String args[]){


        try{
            Annotation[] anno = SubClass.class.getAnnotations();
            for (Annotation annotation:anno) {
                System.out.println(annotation.annotationType());
                System.out.println(annotation.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
