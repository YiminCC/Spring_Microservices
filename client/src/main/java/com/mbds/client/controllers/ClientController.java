package com.mbds.client.controllers;

import com.mbds.client.beans.*;
import com.mbds.client.proxies.MsCartProxy;
import com.mbds.client.proxies.MsOrderProxy;
import com.mbds.client.proxies.MsProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    MsProductProxy msProductProxy;
    @Autowired
    MsCartProxy msCartProxy;
    @Autowired
    MsOrderProxy msOrderProxy;

    OrderItemBean orderItemBean;


    @RequestMapping("/")
    public String index(Model model){
        List<ProductBean> productBeanList = msProductProxy.list();
        model.addAttribute("products", productBeanList);
        return "index";
    }

    @RequestMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Long id, Model model){
        Optional<ProductBean> productBean = msProductProxy.get(id);
        model.addAttribute("product",productBean.get());
        return  "productDetail";
    }
    @RequestMapping("/addProduct/1/product/{id}")
    public String addProductToCart(@PathVariable Long id, int quantity, Model model ){
        Optional<ProductBean> productBean = msProductProxy.get(id);
        ResponseEntity<CartBean> cartBean = msCartProxy.getCart(1l);
        CartItemBean cartItemBean = new CartItemBean(productBean.get().getId(),productBean.get().getTitle(),productBean.get().getDescription(),productBean.get().getIllustration(),productBean.get().getPrice(), quantity);
        ResponseEntity<CartBean> addProductToCart=msCartProxy.addProductToCart(cartBean.getBody().getId(), cartItemBean);
        List<CartItemBean> cartItemBeanList = addProductToCart.getBody().getItems();
        model.addAttribute("cartItemBeanList",cartItemBeanList);
        return "cart";
    }

    @RequestMapping("/addCart/1/cart/1")
    public String addCartItemToOrder(Model model){
        ResponseEntity<CartBean> cartBean = msCartProxy.getCart(1l);
        double orderBeanPriceTotal = msOrderProxy.getOrder(1l).getBody().getPriceTotal();
        for (int i=0; i<cartBean.getBody().getItems().size(); i++){
            CartItemBean cartItemBean = msCartProxy.getCart(1l).getBody().getItems().get(i);
            ResponseEntity<OrderBean> orderBean=msOrderProxy.getOrder(1l);
            orderItemBean = new OrderItemBean(cartItemBean.getProductId(),cartItemBean.getTitle(),cartItemBean.getDescription(),cartItemBean.getIllustration(),cartItemBean.getPrice(),cartItemBean.getQuantity());
            msOrderProxy.addCartItemToOrder(1l, orderItemBean);
        }
        List<OrderItemBean> orderItemBeanList=msOrderProxy.getOrder(1l).getBody().getItems();
        model.addAttribute("OrderItemList",orderItemBeanList);
        double priceTotal = 0;
        for(int j=0; j<orderItemBeanList.size(); j++){
            priceTotal = priceTotal+orderItemBeanList.get(j).getPrice()* orderItemBeanList.get(j).getQuantity();
        }
        msCartProxy.deleteItems(1l);
        model.addAttribute("OrderItemListPrice",priceTotal);
        return "order";
    }
}
