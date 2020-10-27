package com.gyn.livestock.common.config;

import com.gyn.livestock.common.domain.JsonResult;
import com.gyn.livestock.common.domain.StandardException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String logExceptionFormat = "[EXIGENCE] Some thing wrong with the system: %s";

    /**
     * 自定义异常
     */
    @ExceptionHandler(StandardException.class)
    public JsonResult handleServiceMessageException(HttpServletRequest request, StandardException ex) {
        log.error("发生异常，异常码："+ ex.getCode() +"，异常信息：" + ex.getDescription());
        return new JsonResult(ex.getCode(), ex.getDescription());
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(Exception.class)
    public JsonResult handleServiceException(HttpServletRequest request, Exception ex) {
        log.error("发生异常，异常信息：" + ex.getMessage());
        return new JsonResult(ex.getMessage());
    }

    /**
     * MethodArgumentNotValidException: 实体类属性校验不通过
     * 如: listUsersValid(@RequestBody @Valid UserFilterOption option)
     */
   /* @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseBean handleMethodArgumentNotValid(HttpServletRequest request, MethodArgumentNotValidException ex) {
        logger.debug(ex);
        return validatorErrors(ex.getBindingResult());
    }

    private ResponseBean validatorErrors(BindingResult result) {
        List<FieldValidatorError> errors = new ArrayList<FieldValidatorError>();
        for (FieldError error : result.getFieldErrors()) {
            errors.add(toFieldValidatorError(error));
        }
        return ResponseBean.validatorError(errors);
    }*/

    /**
     * ConstraintViolationException: 直接对方法参数进行校验，校验不通过。
     * 如: pageUsers(@RequestParam @Min(1)int pageIndex, @RequestParam @Max(100)int pageSize)
     */
    /*@ExceptionHandler(ConstraintViolationException.class)
    public ResponseBean handleConstraintViolationException(HttpServletRequest request,
            ConstraintViolationException ex) {
        logger.debug(ex);
        //
        List<FieldValidatorError> errors = new ArrayList<FieldValidatorError>();

        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(toFieldValidatorError(violation));
        }
        return ResponseBean.validatorError(errors);
    }

    private FieldValidatorError toFieldValidatorError(ConstraintViolation<?> violation) {
        Path.Node lastNode = null;
        for (Path.Node node : violation.getPropertyPath()) {
            lastNode = node;
        }

        FieldValidatorError fieldNotValidError = new FieldValidatorError();
        // fieldNotValidError.setType(ValidatorTypeMapping.toType(violation.getConstraintDescriptor().getAnnotation().annotationType()));
        fieldNotValidError.setType(ValidatorErrorType.INVALID.value());
        fieldNotValidError.setField(lastNode.getName());
        fieldNotValidError.setMessage(violation.getMessage());
        return fieldNotValidError;
    }

    private FieldValidatorError toFieldValidatorError(FieldError error) {
        FieldValidatorError fieldNotValidError = new FieldValidatorError();
        fieldNotValidError.setType(ValidatorErrorType.INVALID.value());
        fieldNotValidError.setField(error.getField());
        fieldNotValidError.setMessage(error.getDefaultMessage());
        return fieldNotValidError;
    }*/

    /**
     * BindException: 数据绑定异常，效果与MethodArgumentNotValidException类似，为MethodArgumentNotValidException的父类
     */
   /* @ExceptionHandler(BindException.class)
    public ResponseBean handleBindException(HttpServletRequest request, BindException ex) {
        logger.debug(ex);
        return validatorErrors(ex.getBindingResult());
    }*/

    /**
     * 返回值类型转化错误
     */
   /* @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseBean exceptionHandle(HttpServletRequest request,
            HttpMessageConversionException ex) {
        return internalServiceError(ex);
    }*/

    /**
     * 对应 Http 请求头的 accept
     * 客户器端希望接受的类型和服务器端返回类型不一致。
     * 这里虽然设置了拦截，但是并没有起到作用。需要通过http请求的流程来进一步确定原因。
     */
    /*@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseBean handleHttpMediaTypeNotAcceptableException(HttpServletRequest request,
            HttpMediaTypeNotAcceptableException ex) {
        logger.debug(ex);
        StringBuilder messageBuilder = new StringBuilder().append("The media type is not acceptable.")
                .append(" Acceptable media types are ");
        ex.getSupportedMediaTypes().forEach(t -> messageBuilder.append(t + ", "));
        String message = messageBuilder.substring(0, messageBuilder.length() - 2);

        return new ResponseBean(HttpStatus.NOT_ACCEPTABLE.value(), message);
    }*/

    /**
     * 对应请求头的 content-type
     * 客户端发送的数据类型和服务器端希望接收到的数据不一致
     */
    /*@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseBean handleHttpMediaTypeNotSupportedException(HttpServletRequest request,
            HttpMediaTypeNotSupportedException ex) {
         logger.debug(ex);
        StringBuilder messageBuilder = new StringBuilder().append(ex.getContentType())
                .append(" media type is not supported.").append(" Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> messageBuilder.append(t + ", "));
        String message = messageBuilder.substring(0, messageBuilder.length() - 2);
        System.out.println(message);
        return new ResponseBean(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), message);
    }*/

    /**
     * 前端发送过来的数据无法被正常处理
     * 比如后天希望收到的是一个json的数据，但是前端发送过来的却是xml格式的数据或者是一个错误的json格式数据
     */
    /*@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseBean handlerHttpMessageNotReadableException(HttpServletRequest request,
            HttpMessageNotReadableException ex) {
        logger.debug(ex);
        String message = "Problems parsing JSON";
        return new ResponseBean(HttpStatus.BAD_REQUEST.value(), message);
    }*/

    /**
     * 将返回的结果转化到响应的数据时候导致的问题。
     * 当使用json作为结果格式时，可能导致的原因为序列化错误。
     * 目前知道，如果返回一个没有属性的对象作为结果时，会导致该异常。
     */
   /* @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseBean handlerHttpMessageNotWritableException(HttpServletRequest request,
            HttpMessageNotWritableException ex) {
        return internalServiceError(ex);
    }*/

    /**
     * 请求方法不支持
     */
    /*@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseBean exceptionHandle(HttpServletRequest request, HttpRequestMethodNotSupportedException ex) {
        logger.debug(ex);
        StringBuilder messageBuilder = new StringBuilder().append(ex.getMethod())
                .append(" method is not supported for this request.").append(" Supported methods are ");

        ex.getSupportedHttpMethods().forEach(m -> messageBuilder.append(m + ","));
        String message = messageBuilder.substring(0, messageBuilder.length() - 2);
        return new ResponseBean(HttpStatus.METHOD_NOT_ALLOWED.value(), message);
    }*/

    /**
     * 参数类型不匹配
     */
   /* @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseBean methodArgumentTypeMismatchExceptionHandler(HttpServletRequest request,
            MethodArgumentTypeMismatchException ex) {
        logger.debug(ex);
        String message = "The parameter '" + ex.getName() + "' should of type '"
                + ex.getRequiredType().getSimpleName().toLowerCase() + "'";

        FieldValidatorError fieldNotValidError = new FieldValidatorError();
        fieldNotValidError.setType(ValidatorErrorType.TYPE_MISMATCH.value());
        fieldNotValidError.setField(ex.getName());
        fieldNotValidError.setMessage(message);

        return ResponseBean.validatorError(Arrays.asList(fieldNotValidError));
    }*/

    /**
     * 缺少必填字段
     */
    /*@ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseBean exceptionHandle(HttpServletRequest request,
            MissingServletRequestParameterException ex) {
        logger.debug(ex);
        String message = "Required parameter '" + ex.getParameterName() + "' is not present";

        FieldValidatorError fieldNotValidError = new FieldValidatorError();
        fieldNotValidError.setType(ValidatorErrorType.MISSING_FIELD.value());
        fieldNotValidError.setField(ex.getParameterName());
        fieldNotValidError.setMessage(message);

        return ResponseBean.validatorError(Arrays.asList(fieldNotValidError));
    }*/

    /**
     * 文件上传时，缺少　file 字段
     */
   /* @ExceptionHandler(MissingServletRequestPartException.class)
    public ResponseBean exceptionHandle(HttpServletRequest request, MissingServletRequestPartException ex) {
        logger.debug(ex);
        return new ResponseBean(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }*/

    /**
     * 请求路径不存在
     */
    /*@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseBean exceptionHandle(HttpServletRequest request, NoHandlerFoundException ex) {
        logger.debug(ex);
        String message = "No resource found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
        return new ResponseBean(HttpStatus.NOT_FOUND.value(), message);
    }*/

    /**
     * 缺少路径参数
     * Controller方法中定义了　@PathVariable(required=true)　的参数，但是却没有在url中提供
     */
    /*@ExceptionHandler(MissingPathVariableException.class)
    public ResponseBean exceptionHandle(HttpServletRequest request, MissingPathVariableException ex) {
        return internalServiceError(ex);
    }*/

    /**
     * 其他所有的异常
     */
    /*@ExceptionHandler()
    public ResponseBean handleAll(HttpServletRequest request, Exception ex) {
        return internalServiceError(ex);
    }

    private String codeToMessage(int code) {
        //TODO 这个需要进行自定，每个 code 会匹配到一个相应的 msg
        return "The code is " + code;
    }

    private ResponseBean internalServiceError(Exception ex) {
        logException(ex);
        // do something else
        return ResponseBean.systemError();
    }

    private <T extends Throwable> void logException(T e) {
        logger.error(String.format(logExceptionFormat, e.getMessage()), e);
    }*/
}
