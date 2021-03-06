package nitinka.quartzrest.util;

import javax.ws.rs.core.Response;

public class ResponseBuilder {
    public static Response resourceAlreadyExists(String resourceType, String resourceName) {
        return response(Response.Status.CONFLICT,
                String.format("{\"reason\" : \"%s %s Already Exists\"}", resourceType, resourceName));
    }

    public static Response resourceNotFound(String resourceType, String resourceName) {
        return response(Response.Status.NOT_FOUND,
                String.format("{\"reason\" : \"%s %s Does Not exist\"}", resourceType, resourceName));
    }

    public static Response resourceCreated(String resourceType, String resourceName) {
        return response(Response.Status.CREATED,
                String.format("{\"message\" : \"Resource %s %s created\"}", resourceType, resourceName));
    }

    public static Response response(Response.Status status, Object message) {
        return Response.status(status).entity(message).build();
    }

    public static Response internalServerError(Exception e) {
        return response(Response.Status.INTERNAL_SERVER_ERROR, e);
    }

    public static Response badRequest(String message) {
        return response(Response.Status.BAD_REQUEST,
                String.format("{\"reason\" : \"%s\"}", message));
    }

    public static Response resourceDeleted(String resourceType, String resourceName) {
        return response(Response.Status.OK,
                String.format("{\"message\" : \"Resource %s %s deleted\"}", resourceType, resourceName));
    }
}

