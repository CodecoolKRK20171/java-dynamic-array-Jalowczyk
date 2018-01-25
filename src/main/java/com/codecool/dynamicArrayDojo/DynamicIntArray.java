package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {
    private int size;
    private int[] array;

    public DynamicIntArray(int size) {
        this.size = size;
        this.array = new int[size];
    }

    public DynamicIntArray() {
        this.array = new int[0];
    }

    private void enlargeArray() {

        int[] newArray = new int[size + 1];

        int i = 0;

        for (int element : this.array) {
            newArray[i] = element;
            i++;
        }

        this.array = newArray;
        this.size = newArray.length;
    }

    public void add(int number) {
        enlargeArray();
        this.array[this.size - 1] = number;
    }

    public void remove(int number) {

        int[] newArray = new int[this.size - 1];

        int i = 0;

        for (int element : this.array) {
            if (element != number) {
                newArray[i] = element;
                i++;
                }
            }

        this.array = newArray;
        this.size = this.array.length;
    }

    public void insert(int index, int number) {

        if (index <= this.size) {
            int[] newArray = new int[size + 1];

            for (int i = 0; i < newArray.length; i++) {
                if (i < index) {
                    newArray[i] = this.array[i];
                } else if (i == index) {
                    newArray[i] = number;
                } else {
                    newArray[i] = this.array[i - 1];
                }
            }

            this.array = newArray;
            this.size = newArray.length;

        } else {
            add(number);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int num : this.array) {
            sb.append(" ");
            sb.append(num);
        }

        String arrayToStr = sb.toString();

        return arrayToStr;
    }
}