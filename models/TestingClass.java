package models;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lasted Updated: 11/13/19
 * Tests the selectRandomDestination function from the user class.
 * @authors Steve Shay
 */
public class TestingClass {
    public static void main(String[] args){
        User test1 = new User("test1", 11111);
        User test2 = new User("test2", 11111);
        User test3 = new User("test3", 11111);
        User test4 = new User("test4", 11111);
        User test5 = new User("test5", 11111);

        int[] test1Responses = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,25};
        ArrayList<Integer> correct1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25));
        test1.setUserResponses(test1Responses);

        int[] test2Responses = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        ArrayList<Integer> correct2 = new ArrayList<Integer>(Arrays.asList(0));
        test2.setUserResponses(test2Responses);

        int[] test3Responses = {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        ArrayList<Integer> correct3 = new ArrayList<Integer>(Arrays.asList(10));
        test3.setUserResponses(test3Responses);

        int[] test4Responses = {1,1,1,0,0,1,0,0,0,1,1,0,1,0,1,1,0,0,1,1,0,1,0,1,1,14};
        ArrayList<Integer> correct4 = new ArrayList<Integer>(Arrays.asList(1,2,3,6,10,11,13,15,16,19,20,22,24,25));
        test4.setUserResponses(test4Responses);

        int[] test5Responses = {0,1,1,1,0,0,1,1,0,1,1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,12};
        ArrayList<Integer> correct5 = new ArrayList<Integer>(Arrays.asList(2,3,4,7,8,10,11,13,14,15,16,21));
        test5.setUserResponses(test5Responses);

        System.out.println("Test 1 Edge Case (All True) : " + blackboxTesting(test1, correct1));
        System.out.println("Test 2 Edge Case (No Trues) : " + blackboxTesting(test2, correct2));
        System.out.println("Test 3 Edge Case (1 True)   : " + blackboxTesting(test3, correct3));
        System.out.println("Test 4 Normal Case (14 True): " + blackboxTesting(test4, correct4));
        System.out.println("Test 5 Normal Case (12 True): " + blackboxTesting(test5, correct5));



    }
    private static String blackboxTesting (User _user, ArrayList _correct){
        int count = 0;
        int pass = 0;
        
        if (_correct.contains(0)){
            return "Failed as expected. Real users who select no travel options are assigned 5 random locations.";
        }

        while (count < 1000){
            int selected = _user.selectRandomDestination();
            if (_correct.contains(selected)){
                pass++;
            }
            count++;
        }
        if ((pass/1000) >= .950){
            return "Pass";
        }
        else{
            return "Fail";
        }
    }

}
