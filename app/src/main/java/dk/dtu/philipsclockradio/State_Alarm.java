package dk.dtu.philipsclockradio;



import android.os.Handler;

import java.util.Date;


public class State_Alarm extends StateAdapter {


    Date mTime;
    String mDisplayText;
    private boolean snooze;



    /*
     Gøre brug af metoderne fra StateAdapter, og også derfor vi gør brug af nedarvning (statepattern)
     */

    @Override
    public void onEnterState(ContextClockradio ccontext){

        ccontext.ui.turnOffLED(2);

        mTime = new Date();

        ccontext.ui.turnOffTextBlink();

    }


    public String getmDisplayText() {

        return mDisplayText;

    }

    @Override
    public void onExitState(ContextClockradio ccontext){

        System.out.println(getmDisplayText());
        ccontext.ui.turnOffTextBlink();

    }




    public void onClick_Hour(ContextClockradio ccontext){

        mTime.setTime(mTime.getTime() + 3600000); // 3600 sekunder = 1 time

        updateDisplayTime(ccontext);

    }

    public void onClick_Min(ContextClockradio ccontext){

        mTime.setTime(mTime.getTime() + 60000); //6 sekunder.
        updateDisplayTime(ccontext);


    }


    public void onLongClick_AL1 (ContextClockradio ccontext){

        ccontext.ui.turnOffLED(1);
        ccontext.ui.turnOnLED(2);
        ccontext.setState(new StateStandby(ccontext.getTime()));

    }


    public void onLongClick_AL2 (ContextClockradio ccontext){

        ccontext.ui.turnOffLED(1);
        ccontext.ui.turnOnLED(2);
        ccontext.setState(new StateStandby(ccontext.getTime()));

    }



    private void updateDisplayTime(ContextClockradio ccontext) {

        mDisplayText = mTime.toString().substring(11, 16);

        ccontext.ui.setDisplayText(mDisplayText);


    }


    @Override
    public void onClick_Snooze(final ContextClockradio ccontext) {

        if (snooze) {

            ccontext.setSnooze(true);


            final android.os.Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                public void run() {

                    ccontext.ui.setDisplayText(snooze + "");
                    ccontext.ui.statusTextview.setText("Alar udskudt 9 minutter");

                    handler.postDelayed(this, 540000); // 9 minutter

                }
            };
            handler.postDelayed(runnable, 540000);



        } else {

            ccontext.setValgtForAtGemme(false);
            ccontext.ui.setDisplayText(snooze + "");
            ccontext.ui.statusTextview.setText("Alarm ikke udskudt");

        }
    }
}
