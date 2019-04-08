package com.netent.bonusgame.service;


import com.netent.bonusgame.BonusGameService.BonusGameConsolebased;
import com.netent.service.Service;
import com.netent.service.symbol.Symbol;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BonusGameConsolebasedTest {




    Service service;

    @InjectMocks
    private BonusGameConsolebased bonusGameConsolebased;


    @Test
    public void testRandomGenerator(){
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(4);

        Assert.assertNotNull(bonusGameConsolebased.getRandomSelection(list,1));

    }



}
