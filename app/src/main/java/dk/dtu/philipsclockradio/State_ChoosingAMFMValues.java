package dk.dtu.philipsclockradio;

public class State_ChoosingAMFMValues extends StateAdapter {

    private int gemtVærdi = 1;
    private boolean valgtFrekvens;

    State_ChoosingAMFMValues(boolean valgtFrekvens) {

        this.valgtFrekvens = valgtFrekvens;

    }

    @Override
    public void onEnterState(ContextClockradio ccontext) {

        ccontext.ui.turnOnTextBlink();

        ccontext.ui.setDisplayText(gemtVærdi + "");

    }

    public void onExitState (ContextClockradio ccontext) {

        ccontext.ui.turnOffTextBlink();


        if (valgtFrekvens) {

            ccontext.amFrekvenser[gemtVærdi - 1] = ccontext.getAmFrekvens();

        } else {

            ccontext.fmFrekvenser[gemtVærdi - 1] = ccontext.getFmFrekvens();

        }

    }

public void onLongClick_Preset (ContextClockradio ccontext) {

        if (gemtVærdi <= 10){

            gemtVærdi++;

        } else if (gemtVærdi > 10){

            gemtVærdi = 1;

        }

        ccontext.ui.setDisplayText(gemtVærdi + "");

}



}
