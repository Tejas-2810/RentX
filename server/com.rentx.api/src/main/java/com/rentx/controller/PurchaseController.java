package com.rentx.controller;

import com.rentx.businessservices.PurchaseService;
import com.rentx.config.UserAuthenticationProvider;
import com.rentx.dtos.UserDto;
import com.rentx.entities.Purchase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Getter
@Setter
@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {
    /**
     * autowire Purchase Service
     */
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    /**
     * gwt mapping to get All Purchases Details
     * @return list of purchase Service details
     */
    @GetMapping
    public List<Purchase> getAllPurchasesDetails(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        UserDto userDto = userAuthenticationProvider.getUserByToken(authorizationHeader.split(" ")[1]);
        return purchaseService.getAllPurchases(userDto.getUserID());
    }

    /**
     * post mapping to add Purchase Details
     * @param purchase purchase
     * @return updated purchase service
     */
    @PostMapping("/put")
    public Purchase addPurchaseDetails(@RequestBody Purchase purchase) {
        return purchaseService.addPurchase(purchase);
    }

    /**
     * get mapping to get Purchase Details By Id
     * @param purchaseId purchase Id
     * @return object for the response entity for purchase
     */
    @GetMapping("/{purchaseId}")
    public ResponseEntity<Purchase> getPurchaseDetailsById(@PathVariable int purchaseId) {
        Purchase purchase = purchaseService.getPurchaseDetailsById(purchaseId);
        return ResponseEntity.ok(purchase);
    }
}
