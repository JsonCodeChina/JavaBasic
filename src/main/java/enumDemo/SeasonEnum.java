package enumDemo;

public enum SeasonEnum {

    ONE(1,"spring"),TWO(2,"summer"),THREE(3,"autumn"),FOUR(4,"winter");

    private int index;
    private String message;

    SeasonEnum(int index, String message) {
        this.index = index;
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static SeasonEnum forEachItemInSeasonEnum(Integer index){

        for (SeasonEnum element:values()) {
            if(element.index == index){
                return element;
            }
        }
        return null;
    }
}

class test{
    public static void main(String[] args) {
        for (int i = 1; i <= WeekEnum.getWeekEnumLength(); i++) {
            System.out.println(WeekEnum.forEachEleInWeekEnum(i).getContent());
        }
    }
}
