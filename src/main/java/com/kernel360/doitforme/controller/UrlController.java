package com.kernel360.doitforme.controller;

import com.kernel360.doitforme.dto.UrlRequest;
import com.kernel360.doitforme.dto.UrlResponse;
import com.kernel360.doitforme.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/result")
    public String index(@RequestParam("convertUrl") String convertUrl, Model model) {
        model.addAttribute("convertUrl", convertUrl);
        return "index";
    }

    @PostMapping("/api/v1/shoutUrl")
    public String shoutUrl(@ModelAttribute final UrlRequest urlRequest) throws Exception {
        UrlResponse urlResponse = urlService.shortUrl(urlRequest);
        String convertUrl = urlResponse.getConvertUrl();
        return "redirect:/result?convertUrl="+convertUrl;
    }

    @GetMapping("/{convertUrl}")
    public String redirect(@PathVariable("convertUrl") String convertUrl) {
        return "redirect:" +urlService.findOriginUrl(convertUrl);
    }
}
