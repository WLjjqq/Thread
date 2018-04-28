package algorithm;

/**
 * 栈：先进后出。和枪的弹夹一样。
 * 定义三个属性。Object[] array; 用来保存数据  top 操作数据    maxSize设置数组的大小
 */
public class MyStack {
    private Object[] array;
    private int top;
    private int maxSize;

    public MyStack(int maxSize) {
        this.maxSize=maxSize;
        array = new Object[maxSize];
        top =-1;
    }
    //压入数据
    public void push(Object value){
       if( ! isFull()){
           array[++top] = value;
       }
    }

    //弹出栈顶数据
    public Object pop(){
        return array[top--];
    }
    //访问栈顶数据
    public Object peek(){
        return array[top];
    }
    //判断是否是空栈
    public boolean isEmpty(){
        return (top==-1);
    }
    //判断是否栈满了
    public boolean isFull(){
        return (top==maxSize-1);
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(15);
        String str="helloworld";
        char[] chars = str.toCharArray();
        for(char c:chars){
            System.out.println("c的值 "+c);
            myStack.push(c);
        }
        while (!myStack.isEmpty()){
            System.out.print(myStack.pop());
        }

    }
}
