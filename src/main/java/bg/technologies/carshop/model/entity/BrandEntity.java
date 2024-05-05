package bg.technologies.carshop.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "brand"
    )
    private List<ModelEntity> models;

    public String getName() {
        return name;
    }

    public BrandEntity setName(String brand) {
        this.name = brand;
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
