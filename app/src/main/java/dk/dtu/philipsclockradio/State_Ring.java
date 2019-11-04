package dk.dtu.philipsclockradio;

public class State_Ring extends StateAdapter {

    @Override
    public void onEnterState(ContextClockradio ccontext) {
        ccontext.ui.statusTextview.setText("Alarm ringer");

    }

    @Override
    public void onClick_Snooze(ContextClockradio ccontext) {

        ccontext.ui.statusTextview.setText("Alarmen er udskudt");

    }

    @Override
    public void onExitState(ContextClockradio ccontext) {
        super.onExitState(ccontext);
    }

    @Override
    public void onClick_AL1(ContextClockradio ccontext) {

        ccontext.ui.statusTextview.setText("Alarm slået fra");

    }
}
