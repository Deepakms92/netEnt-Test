package com.netent.framework;


import com.netent.service.Service;
import com.netent.service.symbol.Symbol;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.EnumMap;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @Mock
    EnumMap<Symbol,Integer> zerocount;

    @InjectMocks
    private Service service;

    @Test
    public void testSpin(){
        Assert.assertNotNull(service.spin());
    }

    @Test
    public void testPayout(){
        Mockito.when(service.payout(zerocount)).thenReturn(Mockito.anyInt());

    }

}
