package dk.dtu.philipsclockradio;

import android.os.CountDownTimer;

public class State_Sleeping extends StateAdapter {

    private boolean mTimerR;
    private CountDownTimer mCDTimer;
    private long mTidTilbageIMilliSekunder = StartTid;
    private static final long StartTid = 5000;
    int [] interval = new int[] {120, 90, 60, 30, 15};
    int klik = 1;


    @Override
    public void onEnterState(ContextClockradio ccontext) {
        startTimer(ccontext);
        ccontext.ui.setDisplayText(interval[0] + "");
        ccontext.ui.turnOnLED(3);
    }

    public void startTimer (final ContextClockradio ccontext) {

        // 1 sekund
        mCDTimer = new CountDownTimer(mTidTilbageIMilliSekunder, 1000) {
            @Override
            public void onTick(long UntilFinished) {
                mTidTilbageIMilliSekunder = UntilFinished;

            }

            @Override
            public void onFinish() {

                mTimerR = false;
                ccontext.setState(new StateStandby(ccontext.getTime()));

            }
        }.start();

        mTimerR = true;

    }

    @Override
    public void onClick_Sleep(ContextClockradio ccontext) {

        stopTimer();
        startTimer(ccontext);

        if (klik <= 4) {

            ccontext.ui.turnOnLED(3);
            ccontext.ui.setDisplayText(interval[klik] + "");
            klik++;

        }

    }

    @Override
    public void onLongClick_Sleep(ContextClockradio ccontext) {

        ccontext.setState(new StateStandby(ccontext.getTime()));

    }


    public void stopTimer (){

        mCDTimer.cancel();

    }


}
