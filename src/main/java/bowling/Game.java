package bowling;

public class Game {

    private final FrameList frameList = new FrameList();

    public void roll(int pins){
        frameList.put(pins);
    }

    public int getScore(){
        return frameList.getTotalScore();
    }

}

