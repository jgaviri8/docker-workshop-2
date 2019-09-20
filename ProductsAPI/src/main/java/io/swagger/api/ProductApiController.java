package io.swagger.api;

import io.swagger.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-20T03:43:35.949Z")

@Controller
public class ProductApiController implements ProductApi {

    private static final Logger log = LoggerFactory.getLogger(ProductApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Product> addProduct(@ApiParam(value = "product object that needs to be added" ,required=true )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            body.add(ControllerLinkBuilder.linkTo(ProductApi.class).slash(Long.valueOf(1L)).withSelfRel());
            return new ResponseEntity<Product>(body, HttpStatus.NOT_IMPLEMENTED);
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteProduct(@ApiParam(value = "Product id to delete",required=true) @PathVariable("productId") Long productId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Product>> findProductsByName(@NotNull @ApiParam(value = "part of the name to be considered for filtering", required = true) @Valid @RequestParam(value = "name", required = true) String name) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Product>>(objectMapper.readValue("[ {  \"productId\" : 0,  \"price\" : 40.0,  \"name\" : \"T-Shirt\",  \"description\" : \"T-Shirt s, m, l sizes. Red, blue, green colors\"}, {  \"productId\" : 0,  \"price\" : 40.0,  \"name\" : \"T-Shirt\",  \"description\" : \"T-Shirt s, m, l sizes. Red, blue, green colors\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Product>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> getProductById(@ApiParam(value = "ID of product to return",required=true) @PathVariable("productId") Long productId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{  \"productId\" : 0,  \"price\" : 40.0,  \"name\" : \"T-Shirt\",  \"description\" : \"T-Shirt s, m, l sizes. Red, blue, green colors\"}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> updateProduct(@ApiParam(value = "ID of product to update",required=true) @PathVariable("productId") Long productId,@ApiParam(value = "Product object that needs to be updated" ,required=true )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{  \"productId\" : 0,  \"price\" : 40.0,  \"name\" : \"T-Shirt\",  \"description\" : \"T-Shirt s, m, l sizes. Red, blue, green colors\"}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

}
