package pandas;

class ExceptionNoLabel extends Exception {
    public String message;
    public ExceptionNoLabel() {
        super();
        this.message = "Cannot perform this operation with no labels";
    }
}
class ExceptionOperationOnEmptyTable extends Exception {
    public String message;
    public ExceptionOperationOnEmptyTable() {
        super();
        this.message = "Cannot perform this operation on empty table";
    }
}
class ExceptionSizeNotEqual extends Exception {
    public String message;
    public ExceptionSizeNotEqual(String message) {
        super();
        this.message = message;
    }
}
class ExceptionUnknownColumn extends Exception {
    public String message;
    public ExceptionUnknownColumn(String message){
        super();
        this.message = message;
    }
}
class ExceptionWrongColumnType extends Exception {
    public String message;
    public ExceptionWrongColumnType(String message){
        super();
        this.message = message;
    }
}
class ExceptionWrongIndex extends Exception {
    public String message;
    public ExceptionWrongIndex() {
        super();
        this.message = "Index isn't correct";
    }
}

