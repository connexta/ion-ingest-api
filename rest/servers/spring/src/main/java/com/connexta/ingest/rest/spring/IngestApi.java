/**
 * Copyright (c) 2019 Connexta, LLC
 *
 * Released under the GNU Lesser General Public License version 3; see
 * https://www.gnu.org/licenses/lgpl-3.0.html
 */
package com.connexta.ingest.rest.spring;

import com.connexta.ingest.rest.models.ErrorMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Optional;

/*
 * TODO: This interface should be kept up to date and reflect the Open API spec file.
 * */

@Validated
@Api(value = "Ingest", description = "the Ingest API")
public interface IngestApi {
  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  @ApiOperation(
      value = "Ingest endpoint for a dataset.",
      nickname = "ingest",
      notes =
          "A system can use the Ingest endpoint to ingest a dataset for validation, transformation, and storage. ",
      tags = {"ingest"})
  @ApiResponses({
    @ApiResponse(code = 202, message = "The ingest request was accepted. "),
    @ApiResponse(
        code = 400,
        message =
            "The client message could not understood by the server due to invalid format or syntax. ",
        response = ErrorMessage.class),
    @ApiResponse(
        code = 401,
        message = "The client could not be authenticated. ",
        response = ErrorMessage.class),
    @ApiResponse(
        code = 403,
        message = "The client does not have permission. ",
        response = ErrorMessage.class),
    @ApiResponse(
        code = 501,
        message = "The requested API version is not supported and therefore not implemented. ",
        response = ErrorMessage.class)
  })
  @RequestMapping(
      value = {"/ingest"},
      produces = {"application/json"},
      consumes = {"multipart/form-data"},
      method = {RequestMethod.POST})
  default ResponseEntity<Void> ingest(
      @ApiParam(
              value =
                  "The minimal API version from which the client using this API will accept responses. ",
              required = true)
          @RequestHeader(value = "Accept-Version", required = true)
          String acceptVersion,
      @ApiParam(
              value =
                  "The last modified time of the dataset to be ingested. ",
              required = true)
          @RequestHeader(value = "Last-Modified", required = true)
              OffsetDateTime lastModified,
      @ApiParam(
              value =
                  "A file attachment that is sent in the ingest request. The current maximum is the character equivalent of 10GB.",
              required = true)
          @Valid
          @RequestPart(value = "file", required = true)
          MultipartFile file,
      @ApiParam(
              value =
                  "A unique correlation id for the dataset to be ingested which will allow the client to perform actions with the dataset and/or any other information associated with it in the future. Only one dataset can exist with a given correlation id. This means that a request to ingest a dataset with an existing correlation id will result in a failure with no changes to the existing dataset or associated information. ",
              required = true)
          @RequestParam(value = "correlationId", required = true)
          String correlationId,
      @ApiParam(
              value =
                  "A metacard.xml attachment that is sent in the ingest request to enhance validation and transformation. The current maximum is the character equivalent of 10GB.",
              required = true)
          @Valid
          @RequestPart(value = "metacard", required = true)
          MultipartFile metacard) {
    return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
  }
}
