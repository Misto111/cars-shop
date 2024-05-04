package bg.technologies.carshop.service.impl;

import bg.technologies.carshop.model.dto.BrandDTO;
import bg.technologies.carshop.model.dto.ModelDTO;
import bg.technologies.carshop.model.entity.ModelEntity;
import bg.technologies.carshop.repository.ModelRepository;
import bg.technologies.carshop.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {

        Map<String, BrandDTO> brands = new TreeMap<>();

        for (ModelEntity model : modelRepository.findAll()) {
            if (!brands.containsKey(model.getBrand().getBrand())) {
                brands.put(model.getBrand().getBrand(),
                new BrandDTO(model.getBrand().getBrand(),
                new ArrayList<>()));
            }

            brands.get(model.getBrand().getBrand()).models().add(
                    new ModelDTO(model.getId(), model.getName()));

        }

        return brands.values().stream().toList();
    }
}
