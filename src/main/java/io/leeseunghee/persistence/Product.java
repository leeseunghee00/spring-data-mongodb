package io.leeseunghee.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    public Product() {
    }

    public Product(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName() {
        this.name = name;
    }

    public void setDescription() {
        this.description = description;
    }
}
