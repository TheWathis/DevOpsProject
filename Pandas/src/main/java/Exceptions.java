class ExceptionWrongColumnType extends Exception {
    public String message;
    public ExceptionWrongColumnType(String message){
        super();
        this.message = message;
    }
}

class ExceptionUnknowColumn extends Exception {
    public String message;
    public ExceptionUnknowColumn(String message){
        super();
        this.message = message;
    }
}