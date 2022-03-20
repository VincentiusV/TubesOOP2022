import java.util.List;

public class Monster {
    private String nama;
    private List<ElementType> elementTypeList;
    private Stats baseStats;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
