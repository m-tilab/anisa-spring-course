package org.example.controller;

import org.example.domain.Invoice;
import org.example.domain.InvoiceDetail;
import org.example.domain.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("invoice")
public class ShoppingCardController {

    @Autowired
    private ProductService productService;

    @ModelAttribute
    public Invoice getInvoice() {

        System.out.println("getInvoice called");

        return new Invoice();
    }

    @PostMapping("/addToCard")
    public String addToCard(Model model, @ModelAttribute Invoice invoice, InvoiceDetail invoiceDetail) {

        long productPrice = productService.getProduct(invoiceDetail.getProductId()).getPrice();
        invoiceDetail.setPrice(productPrice * invoiceDetail.getQuantity());

        var invoiceDetails = invoice.getInvoiceDetails();

        if (invoiceDetails == null)
            invoiceDetails = new ArrayList<>();

        invoiceDetails.add(invoiceDetail);
        invoice.setInvoiceDetails(invoiceDetails);

        return "/home";
    }

    @GetMapping("/card")
    public String card(@SessionAttribute(value = "invoice", required = false) Invoice invoice, Model model) {

        if (invoice == null)
            invoice = new Invoice();

        model.addAttribute("invoice", invoice);

        var products = new ArrayList<Product>();

        if (invoice.getInvoiceDetails() != null) {

            for (InvoiceDetail invoiceDetail :
                    invoice.getInvoiceDetails()) {
                products.add(productService.getProduct(invoiceDetail.getProductId()));
            }
        }

        model.addAttribute("products", products);

        return "/shoppingcard";
    }

    @GetMapping("/clearcard")
    public String clearCard(SessionStatus status) {

        status.setComplete();

        return "/home";
    }

    public String removeProductFromSession(@SessionAttribute Invoice invoice) {

        //httpSession.setAttribute("invoice", null);
        //invoice.getInvoiceDetails()


        return "/home";
    }
}
