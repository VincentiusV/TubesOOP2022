import java.util.List;

public class Monster {
    private String name;
    private List<ElementType> elementTypeList;
    private Stats baseStats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ElementType> getElementTypeList() {
        return elementTypeList;
    }

    public void setElementTypeList(List<ElementType> elementTypeList) {
        this.elementTypeList = elementTypeList;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }
}
