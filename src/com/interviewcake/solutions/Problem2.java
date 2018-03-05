package com.interviewcake.solutions;

class Problem2 {

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        // make an array of the products
        if(intArray == null || intArray.length < 2)
            throw new IllegalArgumentException("Invalid Input Array.");
        int len = intArray.length;
        int[] productExceptAtIndex = new int[len];
        
        // In the first pass we would calculate the product of all 
        // ints before index i.
        int product = 1;
        for(int i = 0 ; i < len ; i++){
            productExceptAtIndex[i] = product;
            product *= intArray[i];
        }
        // In this second pass we would calculate the product of all 
        // ints after index i and multiply with product calculated above.
        product = 1;
        for(int i = len-1 ; i >= 0 ; i--){
            productExceptAtIndex[i] *= product;
            product *= intArray[i];
        }
        return productExceptAtIndex;
    }

    public static void main(String[] args) {
        int[] intArray = {1, 7, 3, 4};
        int[] result = getProductsOfAllIntsExceptAtIndex(intArray);
        for (int value : result) {
            System.out.printf("%d ", value);
        }
        System.out.println();
    }
}