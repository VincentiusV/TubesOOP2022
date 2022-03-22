import java.util.List;

public class Monster {
    private String name;
    private List<ElementType> elementTypeList;
    private Stats baseStats;

    public Monster(String name, List<ElementType> elementTypeList, Stats baseStats) {
        this.name = name;
        this.elementTypeList = elementTypeList;
        this.baseStats = baseStats;
    }

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

    // Coba-coba aja
    public void fight(Monster monster){
        if (this.getBaseStats().getAttack() > monster.getBaseStats().getDefense()){
            Stats newStats = new Stats(this.getBaseStats().getAttack()-monster.getBaseStats().getHP(),
                                        monster.getBaseStats().getAttack(), monster.getBaseStats().getDefense(),
                                        monster.getBaseStats().getSpecialAttack(), monster.getBaseStats().getSpecialDefense(),
                                        monster.getBaseStats().getSpeed());
            monster.setBaseStats(newStats);
        }
    }
}
