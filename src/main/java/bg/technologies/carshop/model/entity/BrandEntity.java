package bg.technologies.carshop.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brands")
@NamedEntityGraph(  // дава описание на това ентити, като това описание има име и child релациите, които искаме да се дръпнат.
        name = "brandWithModels",
        attributeNodes = @NamedAttributeNode("models")  //задаваме името на атрибута, който искаме да бъде изтеглен
)
public class BrandEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,   //вземи моделите само, когато е необходимо
            cascade = CascadeType.ALL,
            mappedBy = "brand"
    )
    private List<ModelEntity> models;

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public BrandEntity setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }
}
