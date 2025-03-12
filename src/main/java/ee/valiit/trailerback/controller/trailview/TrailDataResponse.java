package ee.valiit.trailerback.controller.trailview;

public class TrailDataResponse<T> {
    private T data;
    private String message;
    private boolean success;

    private TrailDataResponse(T data, String message, boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public static <T> TrailDataResponse<T> ok(T data) {
        return new TrailDataResponse<>(data, null, true);
    }

    public static <T> TrailDataResponse<T> notFound(String message) {
        return new TrailDataResponse<>(null, message, false);
    }

}

