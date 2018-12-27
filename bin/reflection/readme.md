Reflection:
    
    package - java.lang.reflect
    
    Java refelction makes it possible to inspect classes, interfaces, fields and
    methods at runtime. without knowing the name of the classes. methods. etc. at compile time.
    
    it is also possible to instantiate the new objects, invokes methods, get set field values.
    
    it is used in Jackson,Gson,Boon,Hibernate etc,
    Ex:
        in hibernate it used to map the result set to the getter and setter method.
        
        
    
Java Reflection Classes:
    
    you can inspect the java classes at runtime. you will get the 
        class name
        class modifiers
        package info
        super class
        implemented interface
        constructor
        methods
        fields
        annotations, .... etc.,
        more refer https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html
    
        
    Class Object:
        java.lang.Class
        before you need any inspection of the class you need to obtain its java.lang.Class object.
        all types primitive or non primitive have an associated Class object.
        
        Ex:
            Class myObjectClass = MyObject.class //this is for compile time
            Class.forName(className) //this is used for runtime. you must supply the fully qualified
                class name.
                it throws ClassNotFoundException
                
                
            
            
            
        
    
    
    
    
    
    volatile in java
    Java compiler's type erasure
    isNative in java
    isStrict in java
    isTransient in java
    isVolatile in java
    