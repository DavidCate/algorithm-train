package org.david.array;

/**
 * @Author David Liu
 * 数组（Array）：
 * 1.定义？
 * 答：数组是一种线性表数据结构。它用一组连续的内存存储一组具有相同类型的数据。
 * 例子：
 * 在计算机内存中，每一块内存都有一个内存地址，假设int类型占用四个字节的内存，我们有一个int[] array=new int[10],如果array的起始内存地址int[0]是8000，
 * 那么int[1]起始地址就是8004,int[2]起始是8008依次类推..
 * 2.特性？
 *   2.1 根据上面的例子，当我们要访问数组中的某一个数据时，我们可以通过地址计算公式 ： base_address+i*data_type_size=array[i]_address 快速定位数据在数组中的位置。
 * 因此数组支持随机访问，我们可以通过下表随机访问数据，此时时间复杂度为O(1)
 *   2.2 当我们要往数组插入数据时如果往数组最后插入那么时间复杂度是O(1),如果往数组中间插入数据那么通常情况下 我们需要将第K位之后的数据进行拷贝然后插入K位数据
 *   再把K位之后的数据挪到K+1位，当然如果数组本身就是无序的那么我们可以直接把第K位数据复制到数组尾部然后直接把数据插入到K位。
 *   插入操作时间复杂度是O（n），但是效率低在数据拷贝。
 * 3.思考题：为什么数组的下标从0开始而不是从1开始？
 *   下标从0开始地址计算公式： base_address+i*data_type_size=array[i]_address
 *   下标从1开始地址计算公式：base_address+(i-1)*data_type_size=array[i]_address
 *   对于CPU来说多进行了一次减法运算
 */
public class Array {
    private Integer arraySize;
    private Integer insertIndex;
    Integer[] array;
    public Array(Integer initSize){
        this.arraySize=initSize;
        this.array=new Integer[arraySize];
        this.insertIndex=0;
    }

    public void addInt(Integer index,Integer value){
        checkNull(index,value);
        if (index>=arraySize){
            throw new RuntimeException("outbound exception");
        }
        if (index<insertIndex){
            throw new RuntimeException("index has content,cannot insert new value");
        }
        array[insertIndex]=value;
        this.insertIndex++;
    }


    private void checkNull(Integer... integer){
        int length = integer.length;
        for (int i = 0 ; i < length ; i++){
            Integer content = integer[i];
            if (content==null){
                throw new NullPointerException("index or value cannot be null");
            }
        }

    }

}
