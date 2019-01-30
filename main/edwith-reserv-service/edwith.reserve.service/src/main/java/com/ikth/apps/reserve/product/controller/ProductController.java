package com.ikth.apps.reserve.product.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ikth.apps.reserve.product.dao.ProductDao;
import com.ikth.apps.reserve.product.vo.ProductVO;

@RestController
@RequestMapping(path="/api/products")
public class ProductController 
{
	@Autowired
	private ProductDao productDao;
	
	@GetMapping(
//			value="/get-image-with-media-type",
			produces=MediaType.IMAGE_PNG_VALUE)
	public @ResponseBody byte[] getImage() {
		List<ProductVO> products= productDao.selectAllProduct();
		return Base64.getDecoder().decode(products.get(0).getImgBase64());
	}
	
	
//	@GetMapping
//	public List<ProductVO> getAllProduct()
//	{
//		return productDao.selectAllProduct();
//	}
	
	
	/**
	 * 잠시 테스트 데이터좀 만드느라 사용 함..
	 */
//	@GetMapping
//	public String createProducts()
//	{
//		List<ProductVO> products= new ArrayList<>();
//		products.add(new ProductVO("라이온킹", "라이온킹 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "부천 공연장", "THT", true, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (1).PNG")));
//		products.add(new ProductVO("드림걸즈", "드림걸즈 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "잠실 공연장", "DPL", false, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (2).PNG")));
//		products.add(new ProductVO("포켓몬스터", "포켓몬스터 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "강남 공연장", "MSC", true, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (3).PNG")));
//		products.add(new ProductVO("건담", "건담 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "강서 공연장", "CRT", false, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (4).PNG")));
//		products.add(new ProductVO("마리오", "마리오 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "강북 공연장", "CLS", true, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (5).PNG")));
//		products.add(new ProductVO("모모의시간여행", "모모의시간여행 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "강동 공연장", "THT", false, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (6).PNG")));
//		products.add(new ProductVO("라라랜드", "라라랜드 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "안산 공연장", "DPL", true, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (7).PNG")));
//		products.add(new ProductVO("엑소 콘서트", "엑소 콘서트 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "네모 공연장", "MSC", false, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (8).PNG")));
//		products.add(new ProductVO("HOT 콘서트", "HOT 콘서트 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "세모 공연장", "CRT", true, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (9).PNG")));
//		products.add(new ProductVO("GOD 콘서트", "GOD 콘서트 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "엑스 공연장", "CLS", false, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (10).PNG")));
//		products.add(new ProductVO("김건모 콘서트", "김건모 콘서트 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "이응 공연장", "THT", true, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (11).PNG")));
//		products.add(new ProductVO("난타 A", "난타 A 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "가가 공연장", "DPL", false, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (12).PNG")));
//		products.add(new ProductVO("난타 B", "난타 B 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "나나 공연장", "MSC", true, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (13).PNG")));
//		products.add(new ProductVO("고흐 미술관", "고흐 미술관 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "다다 공연장", "CRT", false, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (14).PNG")));
//		products.add(new ProductVO("마술 쇼", "마술 쇼 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "라라 공연장", "CLS", true, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (15).PNG")));
//		products.add(new ProductVO("터미네이터", "터미네이터 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "마마 공연장", "THT", false, getImgBase64("C:\\Users\\taehoonkim\\Desktop\\img\\1 - 복사본 (16).PNG")));
//
//		for(ProductVO p : products) {
//			productDao.insertProduct(p);
//		}
//		
//		return "finish";
//	}
//	
//	private String encodingBase64(byte[] binary) {
//		return Base64.getEncoder().encodeToString(binary);
//	}
//	
//	private String getImgBase64(String path) {
//		InputStream inStrm= null;
//		ByteArrayOutputStream baos= null;
//		
//		try {
//			inStrm= new FileInputStream(path);
//			baos= new ByteArrayOutputStream();
//			
//			byte[] bf= new byte[1024];
//			int rLen= inStrm.read(bf);
//			
//			while(rLen != -1) {
//				baos.write(bf, 0, rLen);
//				rLen= inStrm.read(bf);
//			}
//			
//			return encodingBase64(baos.toByteArray());
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "";
//		} finally {
//			if(baos != null) try { baos.close(); } catch(Exception e) { }
//			if(baos != null) try { inStrm.close(); } catch(Exception e) { }
//		}
//	}
	
}
