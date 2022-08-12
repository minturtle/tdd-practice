package bowling;

public class Frame {

    private int first;
    private int second;
    private int bonusScore;

    private int trial;


    private final String trialErrMsg = "게임은 두번 플레이 되어야 합니다.";
    private final String overScoreMsg = "총 점수는 10점을 넘을 수 없습니다.";

    public void put(int score) throws RuntimeException{
        checkIsScoreOver10(score);
        if(isFirstTrial()) {
            first = score;
        }
        else if(isSecondTrial()) {
            second = score;
        }
        else throw new RuntimeException(trialErrMsg);
        trial++;
    }


    public void addBonusScore(Frame frame){
        if(bonusScore != 0) return; //보너스 스코어가 두번 더해지는 것을 막음.
        if(isStrike()){
            bonusScore += frame.first;
            bonusScore += frame.second;
        }
        else if(isSpare()){
            bonusScore += frame.first;
        }
    }

    //점수를 두번 다 입력하지 않으면 0점이 나온다.(스트라이크 제외)
    //spare이거나 strike인 경우에 bonusScore을 추가해줘야 한다.
    public int getTotalScore(){
        if(!isStrike() && trial != 2) return 0;
        return first + second + bonusScore;
    }

    public boolean isSpare(){return trial == 2 && (first + second == 10);}
    public boolean isStrike(){return trial == 1 && (first == 10);}
    public boolean isDone(){
        if(trial == 2 || isStrike()) return true;
        return false;
    }

    private void checkIsScoreOver10(int score) throws IllegalArgumentException{
        if(score + first > 10) throw new IllegalArgumentException(overScoreMsg);
    }
    private boolean isSecondTrial() {
        return trial == 1;
    }

    private boolean isFirstTrial() {
        return trial == 0;
    }
}
