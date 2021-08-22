package com.vadres.procuct_mutex.service;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vadres.procuct_mutex.model.dto.ProductDTO;
import com.vadres.procuct_mutex.model.dto.UpdateAmountDTO;
import com.vadres.procuct_mutex.model.repository.ProductRepository;

@Service
public class ProductService {
	private ProductRepository repository;	
	ReentrantLock lock = new ReentrantLock();
	
	@Autowired
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public ProductDTO updateAmount(UpdateAmountDTO dto) throws InterruptedException {
		if (lock.isLocked())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		
		lock.lock();
				
		try {
			var product = repository.findById(dto.getId()).orElseThrow();
		
			Thread.sleep(10000);
			
			product.setAmount( product.getAmount() + dto.getAmount() );
			repository.save(product);
			
			var productDTO = new ProductDTO();
			BeanUtils.copyProperties(product, productDTO);
			
			return productDTO;
		} finally {
			lock.unlock();
		}
	}
}
