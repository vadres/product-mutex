package com.vadres.procuct_mutex.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vadres.procuct_mutex.model.dto.UpdateAmountDTO;
import com.vadres.procuct_mutex.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductResource {
    
	@Autowired
	private ProductService service;
	
	@PostMapping("amount")
	public ResponseEntity<?> updateAmount(@RequestBody UpdateAmountDTO dto) throws InterruptedException {
		return ResponseEntity.ok(service.updateAmount(dto));
	}
}
