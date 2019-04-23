package EntityClass;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {

    public ArrayList<T> success;

    public ArrayList<T> getSuccess() {
        return success;
    }

    public void setSuccess(ArrayList<T> success) {
        this.success = success;
    }


}
