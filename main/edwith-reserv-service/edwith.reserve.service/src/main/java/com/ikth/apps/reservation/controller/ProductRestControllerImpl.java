package com.ikth.apps.reservation.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ikth.apps.reservation.dto.CategoryResponse;
import com.ikth.apps.reservation.dto.CommentResponse;
import com.ikth.apps.reservation.dto.DisplayInfoResponse;
import com.ikth.apps.reservation.dto.ProductResponse;
import com.ikth.apps.reservation.dto.ReservationInfoResponse;
import com.ikth.apps.reservation.dto.ReservationParam;
import com.ikth.apps.reservation.dto.ReservationResponse;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

@RestController
public class ProductRestControllerImpl implements ProductRestController {

    private static final Logger log = LoggerFactory.getLogger(ProductRestControllerImpl.class);

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
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("")) {
//            try {
//                return new ResponseEntity<CategoryResponse>(objectMapper.readValue("", CategoryResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type ", e);
//                return new ResponseEntity<CategoryResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        return new ResponseEntity<CategoryResponse>(HttpStatus.NOT_IMPLEMENTED);
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

    public ResponseEntity<ProductResponse> getProductsUsingGET(@ApiParam(value = "카테고리 아이디") @Valid @RequestParam(value = "categoryId", required = false) Integer categoryId,@ApiParam(value = "시작 위치", defaultValue = "0") @Valid @RequestParam(value = "start", required = false, defaultValue="0") Integer start) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("")) {
//            try {
//                return new ResponseEntity<ProductResponse>(objectMapper.readValue("", ProductResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type ", e);
//                return new ResponseEntity<ProductResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        return new ResponseEntity<ProductResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ProductResponse> getPromotionsUsingGET() {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("")) {
//            try {
//                return new ResponseEntity<ProductResponse>(objectMapper.readValue("", ProductResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type ", e);
//                return new ResponseEntity<ProductResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        return new ResponseEntity<ProductResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

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