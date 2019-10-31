package enumDemo;

public enum WeekEnum {
    one(1,"monday"),
    two(2,"tuesday"),
    three(3,"wednesday");

    private int index;
    private String content;

    WeekEnum(int index, String content) {
        this.index = index;
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static int getWeekEnumLength(){
        return WeekEnum.values().length;
    }

    public static WeekEnum forEachEleInWeekEnum(int index){
        for (WeekEnum element:values()
             ) {
            if(element.getIndex() == index){
                return  element;
            }
        }
        return null;
    }
}
