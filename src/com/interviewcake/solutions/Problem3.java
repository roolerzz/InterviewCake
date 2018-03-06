package com.interviewcake.solutions;

class Problem3 {

    public static int highestProductOf3(int[] intArray) {
        int len=intArray.length;
        if(len < 3)
        throw new IllegalArgumentException("Less than 3 args");
        int highest=Math.max(intArray[0],intArray[1]);
        int lowest=Math.min(intArray[0],intArray[1]);
        int highest2=intArray[0]*intArray[1];
        int lowest2=intArray[0]*intArray[1];
        // calculate the highest product of 3 integers
        int highest3= intArray[0]*intArray[1]*intArray[2];
      
        for(int i=2; i < len; i++){
            int current = intArray[i];
            highest3=Math.max(Math.max(highest3,current*highest2),current*lowest2);
            highest2=Math.max(Math.max(highest2,highest*current),lowest*current);
            lowest2=Math.min(Math.min(highest2,highest*current),lowest*current);
            highest = Math.max(highest,current);
            lowest = Math.min(lowest,current);     
        }
        return highest3;
    }

    public static void main(String[] args) {
        int[] intArray = {1, 10, -5, 1, -100};
        System.out.println(highestProductOf3(intArray));
    }
}