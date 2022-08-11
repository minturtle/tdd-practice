package bowling;

public class Game {

    private final FrameList frameList = new FrameList();

    public void roll(int pins){
        frameList.put(pins);
    }

    public int getScore(){
        return frameList.getTotalScore();
    }


    public void print(){
        int[] totalScoreList = frameList.getTotalScoreList();

        printHorizenLine();
        for (int score : totalScoreList) {
            System.out.print("|" + score + "|");
        }
        System.out.println();
        printHorizenLine();
    }
    private void printHorizenLine() {
        System.out.println("---------------------------------------");
    }

}

