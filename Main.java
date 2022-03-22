// Ini juga coba-coba
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<ElementType> elementTypes = new ArrayList<ElementType>();
        elementTypes.add(ElementType.FIRE);
        elementTypes.add(ElementType.NORMAL);

        Stats baseStats = new Stats(100, 300, 90, 340, 120, 30);
        Monster monster = new Monster("Apeka", elementTypes, baseStats);

        Stats baseStats2 = new Stats(400, 300, 90, 340, 120, 30);
        Monster monster2 = new Monster("Arta", elementTypes, baseStats);

        monster.fight(monster2);
        Stats monster2Stats = monster2.getBaseStats();
        monster2Stats.printStats();

    }
}
