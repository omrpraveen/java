package reflection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReflectDto {


    public ReflectDto(){
        this.name="Kannan";
        this.age="12";
        this.testList = Arrays.asList("Test1","Test2","Test3");
    }

    public ReflectDto(String name,String age){
        this.name="Kannan";
        this.age="12";
        this.testList = Arrays.asList("Test1","Test2","Test3");
    }

    private String name;

    private String age;

    private List<String> testList;

    private Map<String,Long> map;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getTestList() {
        return testList;
    }

    public void setTestList(List<String> testList) {
        this.testList = testList;
    }

    public Map<String, Long> getMap() {
        return map;
    }

    public void setMap(Map<String, Long> map) {
        this.map = map;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "name - "+name+" ; age -- "+age;
    }

    public static String  getInt(){
        return "12";
    }

    private String getConcat(String newAge){
        return this.age.concat(newAge);
    }

    protected String getMessage(){
        return "message";
    }
}
