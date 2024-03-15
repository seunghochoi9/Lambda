package com.erichgamma.api.menu;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Menu {
    private Long id;
    private String item;
    private String category;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Builder(builderMethodName = "builder")
    public Menu(Long id, String item, String category) {
        this.id = id;
        this.item = item;
        this.category = category;
    }

}
