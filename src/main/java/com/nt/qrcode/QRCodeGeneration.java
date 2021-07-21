package com.nt.qrcode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGeneration {

	
	public static void generateQRCode(String text,int width, int height, String filepath) throws WriterException, IOException
	{
		QRCodeWriter codeWriter=new QRCodeWriter();
		
		BitMatrix bitMatrix=codeWriter.encode(text,BarcodeFormat.QR_CODE, width, height);
		
		Path path=FileSystems.getDefault().getPath(filepath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		
	}
	
	
	
	
	public static byte[] getQrCodeImage(String text, int width,int height) throws WriterException, IOException
	{
		
		QRCodeWriter codeWriter=new QRCodeWriter();
		BitMatrix bitMatrix= codeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		ByteArrayOutputStream pngoutput=new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngoutput);
	    byte[] pngdata=pngoutput.toByteArray();
		
		
		
		
		
		return pngdata;
		
	}
	
	
	
	
	
	
	
}
