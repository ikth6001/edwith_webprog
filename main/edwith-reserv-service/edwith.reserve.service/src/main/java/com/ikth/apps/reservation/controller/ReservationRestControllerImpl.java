package com.ikth.apps.reservation.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class ReservationRestControllerImpl {

    private static final Logger logger = LoggerFactory.getLogger(ReservationRestControllerImpl.class);
    
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

        return new ResponseEntity<ReservationResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

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

        return new ResponseEntity<CommentResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CategoryResponse> getCategoriesUsingGET() {
    	List<Category> categories= reservationSc.getAllCategories();
    	logger.debug("{} EA categories is detected.", categories.size());
    	
    	CategoryResponse responseBody= new CategoryResponse();
    	responseBody.setItems(categories);
    	return new ResponseEntity<CategoryResponse>(responseBody, HttpStatus.OK);
    }

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

        return new ResponseEntity<DisplayInfoResponse>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    @RequestMapping(value = "/api/productsss",
            produces = { "application/json" }, 
            method = RequestMethod.GET)
    public ResponseEntity<ProductResponse> getProductsUsingPUT(@Size(max=10, message="blah blah") @RequestParam String data)
    {
    	logger.debug("This is called !!!!");
    	ProductResponse responseBody= reservationSc.getProducts(0, 0);
    	return new ResponseEntity<ProductResponse>(responseBody, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/products",
            produces = { "application/json" }, 
            method = RequestMethod.GET)
    public ResponseEntity<ProductResponse> getProductsUsingGET(@ApiParam(value = "카테고리 아이디") @Min(0) @RequestParam(value = "categoryId", required = false) Integer categoryId, @ApiParam(value = "시작 위치", defaultValue = "0") @Min(0) @RequestParam(value = "start", required = false, defaultValue="0") Integer start) {
    	logger.debug("requested parameter category id [{}], start [{}]", categoryId, start);
    	ProductResponse responseBody= reservationSc.getProducts(categoryId, start);
    	return new ResponseEntity<ProductResponse>(responseBody, HttpStatus.OK);
    }

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
        produces = { "*/*" }, 
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

        return new ResponseEntity<ReservationInfoResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ReservationResponse> reserveProductUsingPOST(@ApiParam(value = "reservationParam" ,required=true )  @Valid @RequestBody ReservationParam reservationParam) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("")) {
//            try {
//                return new ResponseEntity<ReservationResponse>(objectMapper.readValue("", ReservationResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type ", e);
//                return new ResponseEntity<ReservationResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        return new ResponseEntity<ReservationResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
