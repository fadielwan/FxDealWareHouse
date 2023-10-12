package com.fadi.insightwarehouse.rest.service;

import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadi.insightwarehouse.rest.common.exceptions.DuplicateRequestException;
import com.fadi.insightwarehouse.rest.common.messages.CustomMessage;
import com.fadi.insightwarehouse.rest.common.messages.Response;
import com.fadi.insightwarehouse.rest.common.utils.Topic;
import com.fadi.insightwarehouse.rest.dto.FxDealDTO;
import com.fadi.insightwarehouse.rest.entity.FXDeal;
import com.fadi.insightwarehouse.rest.repo.FxDealRepo;

@Service
@Transactional
public class FxDealService {

	@Autowired
	private FxDealRepo fxDealRepo;
	Logger logger = Logger.getLogger(FxDealService.class.getName());
	public Response createFxDeal(FxDealDTO fxDealDTO) throws DuplicateRequestException {

		Optional<FXDeal> isExists = fxDealRepo.findById(fxDealDTO.getId());
		if (isExists.isPresent()) {
			throw new DuplicateRequestException("Duplicate Request");
		} else {
			FXDeal employeeEntity = copyFxDealDtoToEntity(fxDealDTO);
			fxDealRepo.save(employeeEntity);
			logger.info("request for created");

		}
		return new Response(Topic.FXDEAL.getName() + CustomMessage.SAVE_SUCCESS_MESSAGE);
	}

	private FxDealDTO copyFxDealEntityToDto(FXDeal FXDeal) {
		FxDealDTO fxDealDTO = new FxDealDTO();
		BeanUtils.copyProperties(FXDeal, fxDealDTO);
		return fxDealDTO;
	}

	private FXDeal copyFxDealDtoToEntity(FxDealDTO employeeDTO) {
		FXDeal fxDeal = new FXDeal();
		BeanUtils.copyProperties(employeeDTO, fxDeal);
		return fxDeal;
	}

}
