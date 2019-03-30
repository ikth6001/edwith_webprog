package com.ikth.apps.reservation.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ikth.apps.reservation.dto.Category;
import com.ikth.apps.reservation.dto.CategoryResponse;
import com.ikth.apps.reservation.dto.CommentResponse;
import com.ikth.apps.reservation.dto.DisplayInfoResponse;
import com.ikth.apps.reservation.dto.ProductResponse;
import com.ikth.apps.reservation.dto.ReservationInfoResponse;
import com.ikth.apps.reservation.dto.ReservationParam;
import com.ikth.apps.reservation.dto.ReservationResponse;
import com.ikth.apps.reservation.service.IReservationSc;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")
@Validated
@RestController
public class ReservationRestController {

    private static final Logger logger = LoggerFactory.getLogger(ReservationRestController.class);
    
    @Autowired
    private IReservationSc reservationSc;

//    private final ObjectMapper objectMapper;
//    private final HttpServletRequest request;
//
//    @org.springframework.beans.factory.annotation.Autowired
//    public ProductRestControllerImpl(ObjectMapper objectMapper, HttpServletRequest request) {
//        this.objectMapper = objectMapper;
//        this.request = request;
//    }

    @ApiOperation(value = "예약취소하기", nickname = "cancelReservationUsingPUT", notes = "[PJT-5] 예약취소하기는 실제 DB 에 적용된 값이 아닌, Random 으로 생성된 예약 객체를 반환한다.", response = ReservationResponse.class, tags={ "예약 API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ReservationResponse.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/reservations/{reservationId}",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    public ResponseEntity<ReservationResponse> cancelReservationUsingPUT(@ApiParam(value = "reservationId",required=true) @PathVariable("reservationId") Integer reservationId) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("")) {
//            try {
//                return new ResponseEntity<ReservationResponse>(objectMapper.readValue("", ReservationResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type ", e);
//                return new ResponseEntity<ReservationResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

    	/**
    	 * TODO
    	 */
        return new ResponseEntity<ReservationResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "한줄평 (Comment) 등록", nickname = "createReservationCommentUsingPOST", notes = "[PJT-6] 한중평 등록은 실제 DB 에 적용된 값이 아닌, Random 으로 생성된 Comment 객체를 반환한다.", response = CommentResponse.class, tags={ "예약 API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommentResponse.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/reservations/{reservationInfoId}/comments",
        produces = { "*/*" }, 
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    public ResponseEntity<CommentResponse> createReservationCommentUsingPOST(@NotNull @ApiParam(value = "comment", required = true) @Valid @RequestParam(value = "comment", required = true) String comment,@NotNull @ApiParam(value = "productId", required = true) @Valid @RequestParam(value = "productId", required = true) Integer productId,@ApiParam(value = "reservationInfoId",required=true) @PathVariable("reservationInfoId") Integer reservationInfoId,@NotNull @ApiParam(value = "score", required = true) @Valid @RequestParam(value = "score", required = true) Integer score,@ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile attachedImage) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("")) {
//            try {
//                return new ResponseEntity<CommentResponse>(objectMapper.readValue("", CommentResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type ", e);
//                return new ResponseEntity<CommentResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

    	/**
    	 * TODO
    	 */
        return new ResponseEntity<CommentResponse>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    @ApiOperation(value = "카테고리 목록 구하기", nickname = "getCategoriesUsingGET", notes = "[PJT-3]", response = CategoryResponse.class, tags={ "카테고리 API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CategoryResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/categories",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<CategoryResponse> getCategoriesUsingGET() {
    	
    	List<Category> categories= reservationSc.getAllCategories();
    	logger.debug("{} EA categories is detected.", categories.size());
    	
    	CategoryResponse responseBody= new CategoryResponse();
    	responseBody.setItems(categories);
    	return new ResponseEntity<CategoryResponse>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "상품 전시 정보 구하기", nickname = "getProductDisplayInfoUsingGET", notes = "[PJT-4 & 6] PJT 4 에서 개발과 테스트를 완료 (한줄평 등록 없는 상태), PJT 6 에서 한줄평 등록한 내용까지 잘 나오나 테스트", response = DisplayInfoResponse.class, tags={ "상품 API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = DisplayInfoResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/products/{displayInfoId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<DisplayInfoResponse> getProductDisplayInfoUsingGET(@ApiParam(value = "displayInfoId",required=true) @PathVariable("displayInfoId") Integer displayInfoId) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("")) {
//            try {
//                return new ResponseEntity<DisplayInfoResponse>(objectMapper.readValue("", DisplayInfoResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type ", e);
//                return new ResponseEntity<DisplayInfoResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        return new ResponseEntity<DisplayInfoResponse>(reservationSc.getDisplayInfo(displayInfoId), HttpStatus.OK);
    }
    
    @ApiOperation(value = "상품 목록 구하기", nickname = "getProductsUsingGET", notes = "[PJT-3]", response = ProductResponse.class, tags={ "상품 API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ProductResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/products",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<ProductResponse> getProductsUsingGET(
    		@ApiParam(value = "카테고리 아이디") 
    		@Min(value=0, message= "알 수 없는 카테고리입니다.") 
    		@RequestParam(value = "categoryId", required = false) 
    		Integer categoryId
    		, @ApiParam(value = "시작 위치", defaultValue = "0") 
    		@Min(value=0, message= "시작 값은 0보다 커야 합니다.") 
    		@RequestParam(value = "start", required = false, defaultValue="0") 
    		Integer start) {
    	logger.debug("requested parameter category id [{}], start [{}]", categoryId, start);
    	ProductResponse responseBody= reservationSc.getProducts(categoryId, start);
    	return new ResponseEntity<ProductResponse>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "프로모션 목록 구하기", nickname = "getPromotionsUsingGET", notes = "[PJT-3]", response = ProductResponse.class, tags={ "프로모션 API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ProductResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/promotions",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<ProductResponse> getPromotionsUsingGET() {
    	ProductResponse responseBody= reservationSc.getPromotionedProducts();
    	return new ResponseEntity<ProductResponse>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "예약정보 조회", nickname = "getReservationsUsingGET", notes = "[PJT-5]", response = ReservationInfoResponse.class, tags={ "예약 API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ReservationInfoResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/reservations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<ReservationInfoResponse> getReservationsUsingGET(@NotNull @ApiParam(value = "reservationEmail", required = true) @Valid @RequestParam(value = "reservationEmail", required = true) String reservationEmail) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("")) {
//            try {
//                return new ResponseEntity<ReservationInfoResponse>(objectMapper.readValue("", ReservationInfoResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type ", e);
//                return new ResponseEntity<ReservationInfoResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

    	/**
    	 * TODO SC, DAO
    	 */
    	ReservationInfoResponse response= reservationSc.getReservations(reservationEmail);
//    	ReservationInfoResponse response= new ReservationInfoResponse();
//    	
//    	{
//    		ReservationInfo info= new ReservationInfo();
//    		
//    		DisplayInfo display= new DisplayInfo();
//    		display.setProductContent("라이언킹");
//    		display.setOpeningHours("2019.03.01 ~ 2019.03.30");
//    		display.setPlaceName("서초구 예술의전당");
//    		info.setDisplayInfo(display);
//    		
//    		info.setTotalPrice(150000L);
//    		info.cancelYn(false);
//    		
//    		response.addReservationsItem(info);
//    	}
//    	
//    	{
//    		ReservationInfo info= new ReservationInfo();
//    		
//    		DisplayInfo display= new DisplayInfo();
//    		display.setProductContent("신데렐라");
//    		display.setOpeningHours("2019.02.01 ~ 2019.04.30");
//    		display.setPlaceName("송파구 샤로떼띠어떠");
//    		info.setDisplayInfo(display);
//    		
//    		info.setTotalPrice(350000L);
//    		info.cancelYn(false);
//    		
//    		response.addReservationsItem(info);
//    	}
//    	
//    	{
//    		ReservationInfo info= new ReservationInfo();
//    		
//    		DisplayInfo display= new DisplayInfo();
//    		display.setProductContent("신데렐라");
//    		display.setOpeningHours("2019.02.01 ~ 2019.02.25");
//    		display.setPlaceName("잠실 올림픽 공원");
//    		info.setDisplayInfo(display);
//    		
//    		info.setTotalPrice(50000L);
//    		info.cancelYn(true);
//    		
//    		response.addReservationsItem(info);
//    	}
    	
    	return new ResponseEntity<ReservationInfoResponse>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "예약하기", nickname = "reserveProductUsingPOST", notes = "[PJT-5] 예약하기는 실제 DB 에 적용된 값이 아닌, Random 으로 생성된 예약 객체를 반환한다.", response = ReservationResponse.class, tags={ "예약 API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ReservationResponse.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/reservations",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    public ResponseEntity<ReservationResponse> reserveProductUsingPOST(@ApiParam(value = "reservationParam" ,required=true )  @Valid @RequestBody ReservationParam reservationParam) {
    	boolean status= reservationSc.reservation(reservationParam);
    	if(status) {
    		return new ResponseEntity<ReservationResponse>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<ReservationResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

}
