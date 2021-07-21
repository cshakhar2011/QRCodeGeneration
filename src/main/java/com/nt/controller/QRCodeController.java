package com.nt.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.nt.qrcode.QRCodeGeneration;

@RestController
public class QRCodeController {

	
	private static final String GENERATE_QR_CODE="./src/main/resources/QRCode.png";
	
	
	
	
	@GetMapping("/gen/{codeText}/{width}/{height}")
	public void downlode(@PathVariable("codeText")String codeText,@PathVariable("width")int width,@PathVariable("height")int height) throws WriterException, IOException
	{
		
		QRCodeGeneration.generateQRCode(codeText, width, height, GENERATE_QR_CODE);
		
	}
	
	@GetMapping("/gencode/{codeText}/{width}/{height}")	
	public ResponseEntity<byte[]> genertaeQRCode(@PathVariable("codeText")String codeText,@PathVariable("width")int width,@PathVariable("height")int height) throws WriterException, IOException
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(QRCodeGeneration.getQrCodeImage(codeText, width, height));
		
		
	}
	
	
	
	
}
