package com.ikth.apps.reserve.product.dao;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ikth.apps.reserve.product.vo.ProductVO;

@Component("tstProductDao")
public class TstProductDao implements ProductDao
{
	
	private List<ProductVO> tstDataAll= new ArrayList<>();
	{
		tstDataAll.add(new ProductVO("라이온킹", "라이온킹 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "부천 공연장", "THT", true, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (1).PNG")));
		tstDataAll.add(new ProductVO("드림걸즈", "드림걸즈 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "잠실 공연장", "DPL", false, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (2).PNG")));
		tstDataAll.add(new ProductVO("포켓몬스터", "포켓몬스터 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "강남 공연장", "MSC", true, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (3).PNG")));
		tstDataAll.add(new ProductVO("건담", "건담 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "강서 공연장", "CRT", false, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (4).PNG")));
		tstDataAll.add(new ProductVO("마리오", "마리오 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "강북 공연장", "CLS", true, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (5).PNG")));
		tstDataAll.add(new ProductVO("모모의시간여행", "모모의시간여행 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "강동 공연장", "THT", false, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (6).PNG")));
		tstDataAll.add(new ProductVO("라라랜드", "라라랜드 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "안산 공연장", "DPL", true, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (7).PNG")));
		tstDataAll.add(new ProductVO("엑소 콘서트", "엑소 콘서트 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "네모 공연장", "MSC", false, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (8).PNG")));
		tstDataAll.add(new ProductVO("HOT 콘서트", "HOT 콘서트 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "세모 공연장", "CRT", true, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (9).PNG")));
		tstDataAll.add(new ProductVO("GOD 콘서트", "GOD 콘서트 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "엑스 공연장", "CLS", false, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (10).PNG")));
		tstDataAll.add(new ProductVO("김건모 콘서트", "김건모 콘서트 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "이응 공연장", "THT", true, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (11).PNG")));
		tstDataAll.add(new ProductVO("난타 A", "난타 A 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "가가 공연장", "DPL", false, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (12).PNG")));
		tstDataAll.add(new ProductVO("난타 B", "난타 B 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "나나 공연장", "MSC", true, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (13).PNG")));
		tstDataAll.add(new ProductVO("고흐 미술관", "고흐 미술관 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "다다 공연장", "CRT", false, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (14).PNG")));
		tstDataAll.add(new ProductVO("마술 쇼", "마술 쇼 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "라라 공연장", "CLS", true, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (15).PNG")));
		tstDataAll.add(new ProductVO("터미네이터", "터미네이터 강력 추천 합니다. 정말 재미있습니다. 꼭 보러 오세요~", "마마 공연장", "THT", false, getImgBase64("C:\\Users\\TAEHOON\\Desktop\\images\\1 - 복사본 (16).PNG")));
	}

	@Override
	public List<ProductVO> selectProducts(int cnt) 
	{
		List<ProductVO> res= new ArrayList<>();
		
		for(int i=0; i<cnt; i++) {
			res.add(tstDataAll.get(i));
		}
		
		return res;
	}

	@Override
	public List<ProductVO> selectPromotionedProducts() 
	{
		List<ProductVO> res= new ArrayList<>();
		
		for(int i=0; i<tstDataAll.size(); i++) {
			if(tstDataAll.get(i).isPromotion()) {
				res.add(tstDataAll.get(i));
			}
		}
		
		return res;
	}
	
	@Override
	public int selectCountProducts(String code) 
	{
		int cnt= 0;
		for(int i=0; i<tstDataAll.size(); i++) {
			if("ALL".equals(code)
					|| code.equals(tstDataAll.get(i).getTypeCd())) {
				cnt++;
			}
		}
		
		return cnt;
	}

	@Override
	public List<ProductVO> selectProductsByCode(String code, int cnt) 
	{
		List<ProductVO> res= new ArrayList<>();
		
		int addCnt= 0;
		for(int i=0; i<tstDataAll.size(); i++) {
			if(code.equals(tstDataAll.get(i).getTypeCd())) {
				res.add(tstDataAll.get(i));
				addCnt++;
			}
			
			if(addCnt == cnt) {
				break;
			}
		}
		
		return res;
	}

	private String encodingBase64(byte[] binary) {
		return Base64.getEncoder().encodeToString(binary);
	}
	
	private String getImgBase64(String path) {
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
			
			return encodingBase64(baos.toByteArray());
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			if(baos != null) try { baos.close(); } catch(Exception e) { }
			if(baos != null) try { inStrm.close(); } catch(Exception e) { }
		}
	}
}
