package reflection;

import Annotations.MyAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class ReflectEx {



    public static  void main(String args[]){

        /**
         * java.lang.Class
         * you will get the class object at compile time
         *
         */
        Class aclss =    ReflectDto.class;
        System.out.println(aclss.getSimpleName());
        /**
         * if you need to access the class at runtime then you need to give fully qualified name.
         * it will throw java.lang.ClassNotFoundException
         */
        try{
            String className = "reflection.ReflectDto";
            Class runClss = Class.forName(className);

            System.out.println("Class Name => "+runClss.getSimpleName());

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        /**
         *
         * You can access the modifiers of a class via the Class object.
         *
         *
         */
        int modifiers = aclss.getModifiers();

        System.out.println(modifiers);
        /**
         * using modifier class we will get the valid modifier info
         */
        System.out.println(Modifier.isAbstract(modifiers));

        System.out.println(Modifier.isFinal(modifiers));

        System.out.println(Modifier.isInterface(modifiers));

        System.out.println(Modifier.isNative(modifiers));

        System.out.println(Modifier.isPrivate(modifiers));

        System.out.println(Modifier.isProtected(modifiers));

        System.out.println(Modifier.isPublic(modifiers));

        System.out.println(Modifier.isStatic(modifiers));

        System.out.println(Modifier.isStrict(modifiers));

        System.out.println(Modifier.isSynchronized(modifiers));

        System.out.println(Modifier.isTransient(modifiers));

        System.out.println(Modifier.isVolatile(modifiers));

        /**
         * This method can be used to get the package info
         */
        System.out.println(aclss.getPackage());

        /**
         * this method help us to access the super class of the class
         */
        System.out.println(aclss.getSuperclass());
        /**
         * this is used to get array of implemented interfaces by a given class.
         * only the interfaces specifically declared implemented by a given class is
         * returned.
         *
         * if a super class of the class implements an interface, but the class doesn't specifically state
         * that it also implements that interface, that interface will not be returned in the array.
         *
         *
         *
         */
        System.out.println(aclss.getInterfaces());
        /**
         * Constructors :
         *
         *  Using java reflection you can inspect the constructors of classes and instantiate objects
         *  at runtime.
         *
         *  java.lang.reflect.Constructor
         *
         *
         *
         *
         */
        Constructor[] consArray = aclss.getConstructors();
        for (Constructor cons:consArray) {
            System.out.println(cons.getParameterCount());
        }
        try{
            /**
             * if you know the precise parameter types of the constructor you
             * want to access. you can do so rather than obtain the array all construct
             *
             * this returns the public constructor of the given class which takes a string as a parameter
             *
             */
            Constructor cons =  aclss.getConstructor(new Class[]{});

            System.out.println(cons.getAnnotatedReturnType());



            cons =  aclss.getConstructor(new Class[]{String.class,String.class});


            /**
             *we can read what parameters a given constructor takes like this
             */
            Type[] parameterTypes = cons.getGenericParameterTypes();
            for (Type type:parameterTypes) {
                System.out.println(type.getTypeName());
            }

            Parameter[] paramArray = cons.getParameters();
            for(Parameter param:paramArray){
                System.out.println(param.getName());
                System.out.println(param.getType());

                System.out.println("Parameter class"+ param.getType());
                System.out.println("Parameter name"+ param.getName());
                System.out.println("Modifiers"+ param.getModifiers());
                System.out.println("Is implicit?"+ param.isImplicit());
                System.out.println("Is name present?"+ param.isNamePresent());
                System.out.println("Is synthetic?"+ param.isSynthetic());
            }


            /**
             * we can instantiating the object using constructor object
             * new Instance returns the new instance of the object
             */
            Object obj = cons.newInstance("Test","Test");
            if(obj.getClass().getName().equals(ReflectDto.class.getName())){
                System.out.println(((ReflectDto)obj).getName());
            }

            System.out.println(cons.toGenericString());


            /**
             * Mehtod information
             *
             *  java.lang.reflect.Method
             *  we can use this class to get , modifing the method details
             *
             * getMethods() used to return the list of available methods
             *
             */

            Method[] methods = aclss.getMethods();

            for (Method method:methods) {
                /**
                 * This will return the all the method name
                 */
                System.out.println(method.getName());


                /**
                 *
                 */
                System.out.println();

            }

            /**
             * if you know the method details then this method used to get the method details
             *
             * if not method matches then it raises the NoSuchMethodException
             *
             * if method does not take any argument then you need to set null as the argument type
             */
            Method method = aclss.getMethod("getAge");
            System.out.println(method.getName());

            Method method1 = aclss.getMethod("setAge",new Class[]{String.class});
            System.out.println(method1.getName());

            Method method2 = aclss.getMethod("getAge",null);
            System.out.println(method2.getName());

            /**
             * getParameterTypes() - return the method parameters
             *
             * getReturnType() - return the return type
             */
            Class[] parameterTypes1 = method1.getParameterTypes();
            System.out.println(method.getReturnType());

            for (Class clss:parameterTypes1) {
                System.out.println(clss.getSimpleName());
                System.out.println(clss.getCanonicalName());
                Field[] fields = clss.getFields();
                for (Field field:fields) {
                    System.out.println(field.getName());
                }
            }

            /**
             * invoke is used to invoke the method.
             *
             * if you want to invoke the method you need to pass the
             * instance of the object.
             *
             * if the method is static the you pass null
             */

            System.out.println(method.invoke(obj));

            Method method4 = aclss.getDeclaredMethod("getInt",null);
            System.out.println(method4.invoke(null));

            /**
             * if the method declared as private
             * we need to used getDeclaredMethod and
             * we can use setAccessible(true)
             *
             * if it does not set then it throws IllegalAccessException
             *
             */

            Method method5 = aclss.getDeclaredMethod("getConcat",String.class);
            method5.setAccessible(true);
            System.out.println(method5.invoke(obj,"Test"));

            Method method6 = aclss.getDeclaredMethod("getMessage");

            method6.setAccessible(true);
            System.out.println(method6.invoke(obj,null));

            /**
             * Get public fields
             */
            Field[] fields = aclss.getFields();
            for(Field field:fields){
                System.out.println(field.getName());
                System.out.println(field.getModifiers());
                System.out.println(field.getGenericType());
            }
            /**
             * get private fields
             */
            Field[] fields1 = aclss.getDeclaredFields();
            for(Field field:fields1){
                System.out.println(field.getName());
                System.out.println(field.getModifiers());
                System.out.println(field.getGenericType());
            }
            Field field = aclss.getDeclaredField("name");
            System.out.println(field.getName());
            System.out.println(field.getModifiers());
            System.out.println(field.getGenericType());
            System.out.println(field.getType());

            /**
             * this method used to set the value of the field
             */
            field.setAccessible(true);
            field.set(obj,"Dynamic Value");

            System.out.println(field.get(obj));
            System.out.println(field.get(obj));

            Method method7 = aclss.getMethod("getName");
            System.out.println(method7.invoke(obj));


            /**
             * We can acess the annotatin like this
             * we can access method level, parameter level, class level annotations
             *
             */
            Class annClass = ExAnnotation.class;
            Annotation[] annotations = annClass.getAnnotations();

            for(Annotation annotation : annotations){
                if(annotation instanceof MyAnnotation){
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    System.out.println("name: " + myAnnotation.name());
                    System.out.println("value: " + myAnnotation.value());
                }
            }


            /**
             * Java Reflection Generics
             *
             * when you write a class or interface you can specify that it should be paramerizable.
             * Ex:
             *  java.util.List interface.
             *  List<String> mylist = new ArrayList<String>();
             *
             *
             *  most of the java programs are aware of the java compiler type erasure.
             *
             *  Tyre erasure - info about java class is lost during the compilation of its
             *      source code.
             *
             *  All generic representation of java calss share a single representations.
             *
             *
             */

            System.out.println(new ArrayList<String>().getClass() == new ArrayList<Integer>().getClass());
            /**
             * it returns true.
             *
             * In above example Generic Types are differs, but it shares the instance of
             *      ArrayList.class
             *
             *
             */


            MyGenericClass<String> str = new MyGenericClass<String>();
            /**
             * in above code we are not able to get the class generic type but in method or subclass or field level we can access the
             * generic type details
             *
             */
            System.out.println(str.getClass().getGenericSuperclass());

            Class subClass = MyStringSubClass.class;

            System.out.println(subClass.getSuperclass());

            /**
             * below method prints type with generic
              */
            System.out.println(subClass.getGenericSuperclass());

            System.out.println(subClass.getGenericSuperclass().getTypeName());

            ParameterizedType parameterizedType = (ParameterizedType)subClass.getGenericSuperclass();

            System.out.println(parameterizedType.getActualTypeArguments()[0]);

            System.out.println();

            /**
             * Get generic method return type
             */
            Method methodGeneric = aclss.getDeclaredMethod("getTestList",null);

            Type returnType = methodGeneric.getGenericReturnType();
            if(returnType instanceof ParameterizedType){
                /**
                 * ParameterizedType represents a parameterized type such as
                 *  * Collection<String>.
                 */
                ParameterizedType type = (ParameterizedType) returnType;
                Type[] typeArguments = type.getActualTypeArguments();
                for(Type typeArgument : typeArguments){
                    Class typeArgClass = (Class) typeArgument;
                    System.out.println("typeArgClass = " + typeArgClass);
                }
            }

            methodGeneric = aclss.getDeclaredMethod("setTestList", List.class);
            Type[] returnType1 = methodGeneric.getGenericParameterTypes();

            for (Type type1:returnType1) {
                if(type1 instanceof ParameterizedType){
                    /**
                     * ParameterizedType represents a parameterized type such as
                     *  * Collection<String>.
                     */
                    ParameterizedType type = (ParameterizedType) type1;
                    Type[] typeArguments = type.getActualTypeArguments();
                    for(Type typeArgument : typeArguments){
                        Class typeArgClass = (Class) typeArgument;
                        System.out.println("typeArgClass = " + typeArgClass);
                    }
                }
            }

            /**
             * generic field types
             *
             *
             *
             */

            Field field1 = aclss.getDeclaredField("map");
            returnType = field1.getGenericType();
            if(returnType instanceof ParameterizedType){
                /**
                 * ParameterizedType represents a parameterized type such as
                 *  * Collection<String>.
                 */
                ParameterizedType type = (ParameterizedType) returnType;
                Type[] typeArguments = type.getActualTypeArguments();
                for(Type typeArgument : typeArguments){
                    Class typeArgClass = (Class) typeArgument;
                    System.out.println("field type Arg Class = " + typeArgClass);
                }
            }



            /**
             * Java Reflection Arrays
             *      we can use reflection we will create array, get they are class object
             *      Working with arrays via Java Reflection is done using java.lang.reflect.Array class.
             *
             *util.Arrays vs reflect.Array
             *  reflect array:
             *      it provide static methods to create and access java arrays.
             *      it is a final class, which means it can't be instantiated or changed only the methods
             *          of this class can be used by the class name itself.
             *      it is immutable in nature because it is final.
             *      it does not provide any methods an sorting and searching
             *
             *   util.Arrays:
             *      it provide static methods to create and access java arrays.
             *      it is mutable.
             *      it provides various methods to sorting and searching
             *
             *
             */

            int[] intArray = (int[]) Array.newInstance(int.class,3);
            Array.set(intArray,0,0);
            Array.set(intArray,1,11111);
            Array.set(intArray,2,22222);
            Array.set(intArray,0,22222);
            System.out.println(intArray[0]);
            //Array.set(intArray,3,22222); throw ArrayIndexOutOfBoundsException

            /**
             * Class.forName(String[]) is not possible
             * so we use like this
             */
            Class cls = Class.forName("[I"); // It will generate int[] class
            System.out.println(cls.getTypeName());

            cls = Class.forName("[Ljava.lang.String;");
            System.out.println(cls.getTypeName());

            cls = Class.forName("[Ljava.lang.Long;");
            System.out.println(cls.getComponentType());


            /**
             * Dynamic Proxies
             *
             *       with the help of java.lang.reflect.Proxy we will provide the runtime implementations
             *  of the interface at runtime.
             *  it can be used for many different purposes.
             *      1. database connection and transaction management.
             *      2. dynamic mock objects for unit testing.
             *      3. AOP like method interception purposes.
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             */

        }catch (NoSuchMethodException e){
            /**
             *  if no constructor matches the given constructor arguments,
             *  the it raises NoSuchMethodException
             */
            e.printStackTrace();
        }catch (IllegalAccessException e){
            /**
             * if the access modifier declared as private or prodect then
             *  it throws an illegalaccessexception
             *
             * if you want to access this then we need to set
             *
             * class.setAccessible(true);
             * method.setAccessible(true);
             *
             *
             */
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }catch (NoSuchFieldException e){
            /**
             * if field not found then it rises no such field exception
             */
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            /**
             * when class.forName() throws if class name not found
             */
            e.printStackTrace();
        }



    }

}
