package org.example.controller;

import org.example.domain.InvoiceDetail;
import org.example.domain.Product;
import org.example.service.ProductCategoryService;
import org.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/product")
public class ProductController {

    static private Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("/browse")
    public Model browse(Model model) {

        model.addAttribute("products", productService.getAllProducts());

        return model;
    }

    @GetMapping(value = "/editProduct")
    @ModelAttribute
    public void getProduct(@RequestParam(required = false, defaultValue = "0") long productId, Model model) {

        if (productId > 0 && productService.getProduct(productId) != null)

            model.addAttribute("product", productService.getProduct(productId));
        else
            model.addAttribute("product", new Product());

        model.addAttribute("invoiceDetail", new InvoiceDetail(productId));
    }

    @RequestMapping(value = {"/add", "/update"}, method = RequestMethod.POST)
    public ModelAndView addProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {

            for (var fieldError : bindingResult.getFieldErrors()) {
                LOGGER.info(fieldError.getField() + " " + fieldError.getDefaultMessage());
            }

            modelAndView.setViewName("/product/editProduct");
            modelAndView.addObject("invoiceDetail", new InvoiceDetail(product.getProductId()));

            return modelAndView;
        }


        long productId = product.getProductId();

        if (productId > 0 && productService.getProduct(productId) != null) {

            Product curProduct = productService.getProduct(productId);

            productService.updateProduct(productId, product.getName(), product.getCode(),
                    product.getDescription(),
                    product.getQuantity(), product.getPrice(),
                    product.getProductCategoryId(), product.getCreatorUserId(), curProduct.getCreateDate());

        } else {

            product.setCreateDate(new Date());

            productService.addProduct(product.getName(), product.getCode(),
                    product.getDescription(),
                    product.getQuantity(), product.getPrice(),
                    product.getProductCategoryId(), product.getCreatorUserId(), product.getCreateDate());

        }

        modelAndView.addObject("products", productService.getAllProducts());

        modelAndView.setViewName("/product/browse");

        return modelAndView;
    }
}
