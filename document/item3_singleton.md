## 实现Singleton主要有下面3中方法

### 通过一个公共属性输出instance
```java
public class Test {
    public final static Test INSTANCE = new Test()
    private Test() {}

    /*other properties and methods*/
}
```

### 通过expose一个静态方法输出instance
```java
public class Test{
    private static final Test INSTANCE = new Test();
    private Test() {}

    public static Test getInstace() { return INSTANCE; }

    /*other properties and methods*/

    public Object readResolve() {
        return INSTANCE;
    }
}
```

### Using enum
```java
public enum Test{
    INSTANCE;

    /*Other properties and methods*/
}
```

### 3中方法的比较
- 使用第二种方法，由于使用了一个静态方法返回Singleton，因此比较灵活。比如你可以让这个方法，针对调用它的每个线程返回不同的实例。
- 使用第二种方法，这个静态方法可以当作Supplier方法来使用。比如上面例子中的 Test::instance == Supplier<Test>
- 当Singleton需要系列化和反序列化的时候，方法3是最正确的实现方法。方法1和方法2都需要做一些修改才能保证真正意义上的Singleton，不然每次反序列化的时候，都会产生一个新的instance。下面是针对方法1和方法2在需要序列化是的修改
  - 所有属性都必须是traisent的
  - 提供readResolve方法，返回Singleton的对象