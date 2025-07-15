package org.example;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Integer> stack;
    private List<Integer> minStack;

    private List<Integer> maxStack;

    public MinStack(List<Integer> stack, List<Integer> minStack,List<Integer> maxStack) {
        this.stack = stack;
        this.minStack = minStack;
        this.maxStack = maxStack;
    }

    public boolean push(Integer element) {
        if (minStack.isEmpty()) {
            minStack.add(element);
        }else{
           if(minStack.get(minStack.size()-1) > element){
               minStack.add(element);
           }
        }

        if(maxStack.isEmpty()){
            maxStack.add(element);
        }else{
            if(element > maxStack.get(maxStack.size()-1)){
                maxStack.add(element);
            }
        }
       return stack.add(element);
    }

    public Integer pop() {
        Integer element = stack.remove(stack.size() - 1);
        if (minStack.contains(element)) {
            minStack.remove(element);
        }
        return element;
    }

    public Integer peek() {
        return stack.get(stack.size()-1);
    }

    public Integer getMinElement() {
        return minStack.get(minStack.size()-1);
    }

    public Integer getMaxElement() {
        return maxStack.get(maxStack.size()-1);
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "stack=" + stack +
                ", minStack=" + minStack +
                ", maxStack=" + maxStack +
                '}';
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack(new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        stack.push(1000);
        stack.push(5);
        stack.push(100);
        stack.push(7);
        stack.push(87);
        stack.push(97);
        stack.push(93);
        stack.push(3);
        stack.push(54);
        stack.push(69);
        System.out.println(stack);
    }

}
