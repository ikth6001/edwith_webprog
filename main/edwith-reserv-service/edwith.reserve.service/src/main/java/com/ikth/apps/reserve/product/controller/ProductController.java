package com.ikth.apps.reserve.product.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikth.apps.reserve.product.vo.ProductVO;

@RestController
@RequestMapping(path="/api/products")
public class ProductController 
{
	
	/**
	 * 이런식으로 응답 처리 하는 것이 REST 아키텍처에 맞는건지 잘 모르겠다..
	 * @return ProductVO의 이미지 바이너리는 Base64로 인코딩 후 응답한다..
	 */
	@GetMapping
	public List<ProductVO> getAllProducts()
	{
		List<ProductVO> products= new LinkedList<>();
		
		/**
		 * DAO 구현 전, 테스트 데이터 생성
		 */
		ProductVO lion= new ProductVO();
		lion.setName("라이온킹");
		lion.setDescription("라이온킹 연극입니다. 굉장히 재밌어요~");
		lion.setPlace("경기도 부천시 중동");
		lion.setType("THT");
		lion.setPromotion(true);
		lion.setImgBase64(
				encodingBase64(
						getImage("C:\\Users\\taehoonkim\\git\\edwith_webprog\\main\\edwith-reserv-service\\edwith.reserve.service\\src\\main\\webapp\\test\\imgLionKing.PNG")) );
		
		ProductVO dGirl= new ProductVO();
		dGirl.setName("뮤지컬 드림걸즈");
		dGirl.setDescription("뮤지컬 드림즈입니다. 굉장히 재밌습니다. 보고 울지 마세요..ㅜ.ㅜ");
		dGirl.setPlace("서울 송파구 잠실");
		dGirl.setType("MSC");
		dGirl.setPromotion(true);
		dGirl.setImgBase64(
				encodingBase64(
						getImage("C:\\Users\\taehoonkim\\git\\edwith_webprog\\main\\edwith-reserv-service\\edwith.reserve.service\\src\\main\\webapp\\test\\imgDreamGirls.PNG")) );
		
		for(int i=0; i<20; i++) {
			products.add(i%2 == 0 ? lion : dGirl);
		}
		
		return products;
	}
	
	private String encodingBase64(byte[] binary) {
		return Base64.getEncoder().encodeToString(binary);
	}
	
	private byte[] getImage(String path) {
		InputStream inStrm= null;
		ByteArrayOutputStream baos= null;
		
		try {
			inStrm= new FileInputStream(path);
			baos= new ByteArrayOutputStream();
			
			byte[] bf= new byte[1024];
			int rLen= inStrm.read(bf);
			
			while(rLen != -1) {
				baos.write(bf, 0, rLen);
				rLen= inStrm.read(bf);
			}
			
			return baos.toByteArray();
			
		} catch (Exception e) {
			e.printStackTrace();
			return new byte[] {};
		} finally {
			if(baos != null) try { baos.close(); } catch(Exception e) { }
			if(baos != null) try { inStrm.close(); } catch(Exception e) { }
		}
	}
}
