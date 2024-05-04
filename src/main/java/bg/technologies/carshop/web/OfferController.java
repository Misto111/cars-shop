package bg.technologies.carshop.web;

import bg.technologies.carshop.model.dto.CreateOfferDTO;
import bg.technologies.carshop.model.enums.EngineEnum;
import bg.technologies.carshop.model.enums.TransmissionEnum;
import bg.technologies.carshop.service.BrandService;
import bg.technologies.carshop.service.OfferService;
import org.apache.catalina.Engine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService,
                           BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String all() {
        return "offers";
    }

    @ModelAttribute("engines")
    public EngineEnum[] engines() {
        return EngineEnum.values();
    }
    @ModelAttribute("transmissions")
    public TransmissionEnum[] transmissions() {
        return TransmissionEnum.values();
    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }

    @PostMapping("/add")
    public String add(CreateOfferDTO createOfferDTO){

        offerService.createOffer(createOfferDTO);

        return "index";

    }


    @GetMapping("/{uuid}details")
    public String details(@PathVariable ("uuid") UUID uuid) {
        return "details";
    }
}
