package dk.dtu.philipsclockradio;

public class State_Radio extends StateAdapter {


    private double AMFrekvens = 0;
    private double FMFrekvens = 0;
    private boolean valgtForAtGemme;


    @Override
    public void onEnterState(ContextClockradio ccontext) {

        ccontext.ui.turnOnLED(1);
        valgtForAtGemme = ccontext.isValgtForAtGemme();
        AMFrekvens = ccontext.getAmFrekvens();
        FMFrekvens = ccontext.getFmFrekvens();
        ccontext.ui.statusTextview.setText("FM");


        if (valgtForAtGemme()){

            ccontext.ui.setDisplayText(AMFrekvens + "");

        } else {

            ccontext.ui.setDisplayText(FMFrekvens + "");

        }
    }

    private boolean valgtForAtGemme() {

        return valgtForAtGemme;
    }



    public void onClick_Hour (ContextClockradio ccontext) {

        if (valgtForAtGemme){

            AMFrekvens -= 1;
            ccontext.ui.setDisplayText(AMFrekvens + "");

        } else {

            FMFrekvens -= 1;
            ccontext.ui.setDisplayText(FMFrekvens + "");

        }
    }

    public void onClick_Min (ContextClockradio ccontext) {

        if (valgtForAtGemme){

            AMFrekvens += 1;
            ccontext.ui.setDisplayText(AMFrekvens + "");

        } else {

            FMFrekvens += 1;
            ccontext.ui.setDisplayText(FMFrekvens + "");

        }
    }


    @Override
    public void onLongClick_Power(ContextClockradio ccontext) {

        ccontext.setValgtForAtGemme(valgtForAtGemme());
        ccontext.setAmFrekvens(AMFrekvens);
        ccontext.setFmFrekvens(FMFrekvens);
        ccontext.setState(new StateStandby(ccontext.getTime()));

    }

    @Override
    public void onClick_Power(ContextClockradio ccontext) {

        if (valgtForAtGemme) {

            ccontext.setValgtForAtGemme(true);
            ccontext.ui.setDisplayText(AMFrekvens + "");
            ccontext.ui.statusTextview.setText("AM");

        } else {

            ccontext.setValgtForAtGemme(false);
            ccontext.ui.setDisplayText(FMFrekvens + "");
            ccontext.ui.statusTextview.setText("FM");

        }
    }

    public void onExitState (ContextClockradio ccontext) {


    }





}
