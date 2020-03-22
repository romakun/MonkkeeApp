package models;

public class TagColors {


    public String getColor(String colorName){

        int r;
        int g;
        int b;

        switch (colorName) {
            case ("DimGray"):
                return "background-color: rgb(112, 112, 112);";
            case ("Gold"):
                return "background-color: rgb(255, 204, 0);";
            case ("DarkOrange"):
                return "background-color: rgb(255, 130, 0);";
            case ("Crimson"):
                return "background-color: rgb(194, 24, 72);";
            case ("DarkOrchid"):
                return "background-color: rgb(156, 39, 176);";
            case ("DodgerBlue"):
                return "background-color: rgb(19, 147, 216);";
            case ("LimeGreen"):
                return "background-color: rgb(97, 194, 59);";
            case ("Gray"):
                return "background-color: rgb(146, 112, 96);";
            case ("Black"):
                return "background-color: rgb(0, 0, 0);";
            default:
                return null;
        }
    }
}
