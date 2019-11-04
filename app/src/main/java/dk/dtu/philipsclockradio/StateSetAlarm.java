package dk.dtu.philipsclockradio;

import java.util.Date;

public class StateSetAlarm extends StateAdapter {


    Date clockTid;
    String clockSkærmTekst;

    /*
     Gøre brug af metoderne fra StateAdapter, og også derfor vi gør brug af nedarvning = state patterns
     */

    public void onEnterState(ContextClockradio ccontext){

        ccontext.ui.turnOffLED(2);

        clockTid = new Date();

        ccontext.ui.turnOffTextBlink();

    }

    public void onExitState(ContextClockradio ccontext){

        ccontext.ui.turnOffTextBlink();

    }

    public void onClick_Hour(ContextClockradio ccontext){

        clockTid.setTime(clockTid.getTime() + 3600000); // 3600 sekunder = 1 minut

        updateDisplayTime(ccontext);

    }

    public void onClick_Min(ContextClockradio ccontext){

        clockTid.setTime(clockTid.getTime() + 60000); //6 sekunder.
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

        clockSkærmTekst = clockTid.toString().substring(11, 16);

        ccontext.ui.setDisplayText(clockSkærmTekst);


    }


}
