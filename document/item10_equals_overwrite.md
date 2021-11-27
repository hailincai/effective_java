## Correct equals implementation requirement
- ```x.equals(x)``` always true
- ```x.equals(null)``` always false
- if ```x.equlas(y)```, then ```y.equals(x)```
- if ```x.equals(y)```, and ```y.equals(z)```, then ```x.equals(z)```

## Wrong way to implement the equals
- If the pareent class has its own equals implementation, and the subclass has its own property, then most of the equals implementation is wrong. Because it violates either
  - ```parent.equals(sub)```, if the subclass doesn't overwrite the equals method
  - ```parent.equals(sub)``` and ```!sub.equals(parent)```, if the subclass overwrite the equals method
  - to resolve this issue, we should use compose pattern ```public class subclass {private Parent parent;....}``` to disconnect the subclass and parent class