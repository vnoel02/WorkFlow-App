package com.example.workflow;

import static org.junit.Assert.*;

import android.app.Activity;
import android.content.Intent;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class SecondFragmentTest {



    public FragmentScenario<SecondFragment> fragmentScenario;


    @Before
    public void setup() {
        fragmentScenario = FragmentScenario.launchInContainer(SecondFragment.class);
        fragmentScenario.moveToState(Lifecycle.State.STARTED);
    }


    @Test
    public void testIntent() {
        //Intent intent = new Intent(Intent.A,ProfileViewActivity.class);
    }

}