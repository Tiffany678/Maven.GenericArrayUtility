package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] arr;

    public ArrayUtility(T[] inputArr){
        this.arr = inputArr;
    }

    public <T> int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){

        int count =0;
        for(int i=0; i< arrayToMerge.length; i++){
            if (arrayToMerge[i].equals(valueToEvaluate)) {
                count++;
            }
        }
        return count+getNumberOfOccurrences(valueToEvaluate);
    }

    public <T> int getNumberOfOccurrences(T valueToEvaluate){
       int count =0;
        for(int i=0; i<arr.length; i++){
            if (arr[i].equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public <T> T[] removeValue(T valueToRemove){
        ArrayList<T> newArr = new ArrayList<T>();
        //List<T> newArr = new ArrayList<T>();
        for(int i=0; i<arr.length; i++){
            if (!arr[i].equals(valueToRemove)) {
                newArr.add((T) arr[i]);
            }
        }

        //T a[] = new T[4];
        //        a = (T[]) newArr.toArray();
        //        a = newArr.toArray(a);
        return (T[]) newArr.toArray();
     //return a;
    }
    public <T> T getMostCommonFromMerge(T[] arrayToMerge){
        Map<T, Integer> mostCommon = new HashMap<>();
        int count = 0;
        for(int i=0; i<arrayToMerge.length; i++){
           if (mostCommon.get(arrayToMerge[i])==null) {
               mostCommon.put((T) arrayToMerge[i], 1);
           } else {
               count = mostCommon.get(arrayToMerge[i]);
               mostCommon.put((T) arrayToMerge[i], count + 1);
           }
        }
        int most =0;
        T mostCommonElement = null;
        for(Map.Entry<T, Integer> mostEntry: mostCommon.entrySet()){

            if(mostEntry.getValue()>most){
                most = mostEntry.getValue();
                mostCommonElement = mostEntry.getKey();
            }
        }
        return mostCommonElement;
    }


}
