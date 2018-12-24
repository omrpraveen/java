package annotations;

import annotations.custom.ClassPreamble;

/**
 * @author praveen
 */

@ClassPreamble(
        author = "Praveen kumar")
public class AnnatationExample {


    @Override
    public String toString(){
        return "";
    }

    public void test(String value){

    }

    public static void main(String args[]){
        System.out.println(new AnnatationExample().toString());
    }




}
