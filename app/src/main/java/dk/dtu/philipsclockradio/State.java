package dk.dtu.philipsclockradio;

public interface State {
    void onEnterState(ContextClockradio ccontext);
    void onExitState(ContextClockradio ccontext);
    void onClick_Hour(ContextClockradio ccontext);
    void onClick_Min(ContextClockradio ccontext);
    void onClick_Preset(ContextClockradio ccontext);
    void onClick_Power(ContextClockradio ccontext);
    void onClick_Sleep(ContextClockradio ccontext);
    void onClick_AL1(ContextClockradio ccontext);
    void onClick_AL2(ContextClockradio ccontext);
    void onClick_Snooze(ContextClockradio ccontext);
    void onLongClick_Hour(ContextClockradio ccontext);
    void onLongClick_Min(ContextClockradio ccontext);
    void onLongClick_Preset(ContextClockradio ccontext);
    void onLongClick_Power(ContextClockradio ccontext);
    void onLongClick_Sleep(ContextClockradio ccontext);
    void onLongClick_AL1(ContextClockradio ccontext);
    void onLongClick_AL2(ContextClockradio ccontext);
    void onLongClick_Snooze(ContextClockradio ccontext);
}