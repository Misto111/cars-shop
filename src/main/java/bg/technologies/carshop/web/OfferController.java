package bg.technologies.carshop.web;

import bg.technologies.carshop.model.dto.CreateOfferDTO;
import bg.technologies.carshop.model.dto.OfferDetailDTO;
import bg.technologies.carshop.model.enums.EngineEnum;
import bg.technologies.carshop.model.enums.TransmissionEnum;
import bg.technologies.carshop.service.BrandService;
import bg.technologies.carshop.service.OfferService;
import bg.technologies.carshop.service.exception.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService,
                           BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
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

        if (!model.containsAttribute("createOfferDTO")) {

            model.addAttribute("createOfferDTO", CreateOfferDTO.empty());

        }

        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }

    @PostMapping("/add")
    public String add(@Valid CreateOfferDTO createOfferDTO,
                      BindingResult bindingResult,
                      RedirectAttributes rAtt
    ){

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("createOfferDTO", createOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);

            return "redirect:/offer/add";
        }

        UUID newOfferUUID = offerService.createOffer(createOfferDTO);

        return "redirect:/offer/" + newOfferUUID;

    }


    @GetMapping("/{uuid}")
    public String details(@PathVariable("uuid") UUID uuid,
                          Model model
                        ) {

        OfferDetailDTO offerDetailDTO = offerService
                .getOfferDetail(uuid)
                .orElseThrow(() -> new ObjectNotFoundException("Offer with uuid " + uuid + " not found!"));

        model.addAttribute("offer", offerDetailDTO);

        return "details";
    }

    @DeleteMapping("/{uuid}")
    public String delete(@PathVariable ("uuid") UUID uuid) {

        offerService.deleteOffer(uuid);

        return "redirect:/offers/all";
    }
}
