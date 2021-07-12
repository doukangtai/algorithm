package imooc.design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/07/11
 */
public class CourseCatalog extends CatalogComponent {
    private List<CatalogComponent> items = new ArrayList<>();
    private String name;
    private Integer level;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        this.items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        this.items.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CatalogComponent catalogComponent : items) {
            if (level != null) {
                for (int i = 0; i < level; i++) {
                    System.out.print(" ");
                }
            }
            catalogComponent.print();
        }
    }
}
