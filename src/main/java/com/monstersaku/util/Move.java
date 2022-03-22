package src.main.java.com.monstersaku.util;

public class Move{
    private int id;
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;

    public Move(int id, String name, ElementType elementType, int accuracy, int priority, int ammunition){
        this.id = id;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
    }
}
