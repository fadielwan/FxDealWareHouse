package com.fadi.insightwarehouse.rest.controller;
/**
 * ${typecomment}
 * 
 * @author Your Name
 */
import java.util.logging.Logger;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fadi.insightwarehouse.rest.common.exceptions.DuplicateRequestException;
import com.fadi.insightwarehouse.rest.common.messages.Response;
import com.fadi.insightwarehouse.rest.dto.FxDealDTO;
import com.fadi.insightwarehouse.rest.service.FxDealService;
@Validated
@RestController
@RequestMapping("/api/fx-deal")



public class FxDealController {

	@Autowired
	protected FxDealService fxDealService;
	 Logger logger  = Logger.getLogger(FxDealController.class.getName()); 

	@PostMapping(value = { "/create" })
	public ResponseEntity<Response> createOrUpdateFxDeal(@Valid @RequestBody FxDealDTO fxDealDTO)throws DuplicateRequestException {
		logger.info("request for create fx-deal has been recieved "+fxDealDTO.toString());
		Response response = fxDealService.createFxDeal(fxDealDTO);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}


}
