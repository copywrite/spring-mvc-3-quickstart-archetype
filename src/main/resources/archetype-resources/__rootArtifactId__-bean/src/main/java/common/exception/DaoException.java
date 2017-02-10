package ${package}.common.exception;

/**
 * Created by copywrite on 17/2/9.
 */
public class DaoException extends BaseException {
    private static final long serialVersionUID = 552144556224L;

    public DaoException(Throwable cause) {
        super(CommonExcs.DB_ERROR, cause);
    }
}
