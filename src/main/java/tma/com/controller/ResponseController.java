package tma.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tma.com.dto.ResponseDTO;
import tma.com.service.IResponseService;

@RestController
public class ResponseController {
	
	@Autowired
	private IResponseService responseService;
	
	@PostMapping(value = "/responseDto")
	public ResponseEntity<ResponseDTO> insert(@RequestBody ResponseDTO responseDto) {
		ResponseDTO message = responseService.save(responseDto);
		return new ResponseEntity<ResponseDTO> (message, HttpStatus.OK);
	}
}
