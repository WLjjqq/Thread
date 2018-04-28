package algorithm;

public class CustomArray {
    //定义一个数组
    private int[] intArray;
    //定义数组的实际长度
    private int elems;
    //定义数组的最大长度
    private int length;

    //默认构造一个长度为50的数组
    public CustomArray() {
        elems = 0;
        length = 50;
        intArray = new int[length];
    }
    //构造函数，初始化一个长度为length的数组。
    public CustomArray(int length){
        elems=0;
        this.length=length;
        intArray = new int[length];
    }
    //获取数组的有效长度
    public int getSize(){
        return elems;
    }
    /**
     * 遍历数组
     */
    public void display(){
        for(int i=0;i<intArray.length;i++){
            System.out.println("遍历数组。"+i);
        }
    }

    /**
     * 查找元素。
     */
    public int find(int searchValue){
        //i 代表下标
        int i ;
            for ( i=0;i<elems;i++){
                if(intArray[i] == searchValue){
                    break;
                }
            }
            if(i==elems){
                return -1;
            }
            return i;
    }
    /**
     * 添加
     * (没有考虑数据重复的问题。)
     */
    public boolean add(int value){
        //代表数组已经满了，不能再添加了
        if(elems==length){
            return false;
        }else {
            //把传递进来的值赋值给数组
            intArray[elems] = value;
            elems++;
        }
    return true;
    }

    /**
     * 根据下标获取元素
     * @param i
     * @return
     */
    public int get(int i){
        if(i<0 || i>elems){
            throw new IndexOutOfBoundsException("数组下标越界");
        }
        return intArray[i];
    }


    /**
     * 删除
     * 如果存在，删除掉，所有的都往前移动一个。
     * 不存在，return false
     * @param value
     * @return
     */
    public boolean delete(int value){
        //先判断存在不存在
        int k = find(value);
        //find方法中，没有查询到返回 -1
        if(k == -1){
            System.out.println("不存在");
            return false;
        }else{
            //判断k是不是最后一个
            if(k == elems -1){
                elems--;
            }else {
                //下标k不是最后一个。后面的都往前移动一个。
                for(int i=k;i<elems-1; i++){
                    intArray[i]=intArray[i+1];
                }
                elems--;
            }
        }
        return true;
    }

    /**
     * 修改。
     * @param oldValue
     * @param newValue
     * @return
     */
    public boolean update(int oldValue,int newValue){
        //也是先去从数组中查询。如果有去计算。没有：return false
        int k = find(oldValue);
        if(k == -1){
            return false;
        }else {
            intArray[k] = newValue;
        }
        return true;
    }
}
