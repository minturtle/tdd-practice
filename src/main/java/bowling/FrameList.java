package bowling;

public class FrameList {
    private Frame[] frames = new Frame[11];
    private int index;

    public FrameList() {
        index = 0;
        for(int i = 0; i < frames.length; i++) frames[i] = new Frame();
    }

    public void put(int score){
        findCurrentIndex();
        frames[index].put(score);
    }

    public int getTotalScore(){
        int score = 0;

        for(int i = 0; i < frames.length-1; i++){
            addBonusScoreIfSpareOrStrike(frames[i], frames[i+1]);
            score += frames[i].getTotalScore();
        }

        if(frames[9].isStrike() || frames[9].isSpare()){
            score += frames[10].getTotalScore();
        }
        return score;
    }

    private void addBonusScoreIfSpareOrStrike(Frame frame, Frame nextFrame) {
        if(frame.isSpare() || frame.isStrike()){
            frame.addBonusScore(nextFrame);
        }
    }

    private void findCurrentIndex() {
        while(frames[index].isDone()) index++;
    }
}
