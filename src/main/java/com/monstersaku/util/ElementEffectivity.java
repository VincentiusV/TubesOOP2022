package com.monstersaku.util;
import java.io.File;
import java.util.List;

public class ElementEffectivity {
    protected double fireFire = 1;
    protected double fireWater = 1;
    protected double fireGrass = 1;
    protected double fireNormal = 1;
    protected double waterFire = 1;
    protected double waterWater = 1;
    protected double waterGrass = 1;
    protected double waterNormal = 1;
    protected double grassFire = 1;
    protected double grassWater = 1;
    protected double grassGrass = 1;
    protected double grassNormal = 1;
    protected double normalFire = 1;
    protected double normalWater = 1;
    protected double normalGrass = 1;
    protected double normalNormal = 1;


    public ElementEffectivity(){
        try {
            String file_path = "../configs/element-type-effectivity-chart.csv";
            CSVReader reader = new CSVReader(new File(ElementEffectivity.class.getResource(file_path).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for (String[] line : lines) {
                if(line[0].equals("FIRE")){
                    if(line[1].equals("FIRE")){
                        fireFire = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("WATER")){
                        fireWater = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("GRASS")){
                        fireGrass = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("NORMAL")){
                        fireNormal = Double.parseDouble(line[2]);
                    }
                }
                else if(line[0].equals("WATER")){
                    if(line[1].equals("FIRE")){
                        waterFire = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("WATER")){
                        waterWater = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("GRASS")){
                        waterGrass = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("NORMAL")){
                        waterNormal = Double.parseDouble(line[2]);
                    }
                }
                else if(line[0].equals("GRASS")){
                    if(line[1].equals("FIRE")){
                        grassFire = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("WATER")){
                        grassWater = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("GRASS")){
                        grassGrass = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("NORMAL")){
                        grassNormal = Double.parseDouble(line[2]);
                    }
                }
                else if(line[0].equals("NORMAL")){
                    if(line[1].equals("FIRE")){
                        normalFire = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("WATER")){
                        normalWater = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("GRASS")){
                        normalGrass = Double.parseDouble(line[2]);
                    }
                    else if(line[1].equals("NORMAL")){
                        normalNormal = Double.parseDouble(line[2]);
                    }
                }

            }
        } catch (Exception e) {
          System.out.println("Maafkan saya, saya tidak dapat membaca \"element-type-effectivity-chart.csv\"");
        }
    }
}
