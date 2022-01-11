package com.example.baskballsocre;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> TeamA;
    private MutableLiveData<Integer> TeamB;

    public MutableLiveData<Integer> getTeamA() {
        if (TeamA == null) {
            TeamA = new MutableLiveData<>();
            TeamA.setValue(0);
        }
        return TeamA;
    }

    public MutableLiveData<Integer> getTeamB() {
        if (TeamB == null) {
            TeamB = new MutableLiveData<>();
            TeamB.setValue(0);
        }
        return TeamB;
    }

    public void addA1() {
        TeamA.setValue(getTeamA().getValue() + 1);
    }
    public void addA2() {
        TeamA.setValue(getTeamA().getValue() + 2);
    }
    public void addA3() {
        TeamA.setValue(getTeamA().getValue() + 3);
    }

    public void addB1() {
        TeamB.setValue(getTeamB().getValue() + 1);
    }
    public void addB2() {
        TeamB.setValue(getTeamB().getValue() + 2);
    }
    public void addB3() {
        TeamB.setValue(getTeamB().getValue() + 3);
    }

}
