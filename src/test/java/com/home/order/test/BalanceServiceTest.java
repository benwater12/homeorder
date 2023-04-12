package com.home.order.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;


import com.home.order.Enitiy.Person;
import com.home.order.repo.RepositoryPerson;
import com.home.order.service.BalanceService;

public class BalanceServiceTest {
    @Mock
    private RepositoryPerson repositoryPerson;
    @InjectMocks
    private BalanceService balanceService;
    Person person_test;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Before
    public void setup()  {
        person_test = new Person();
        person_test.setPerson_id(1);
        person_test.setBalance(50);
        person_test.setPerson_name("Benson"); 
        
    }
    @Test
    public void UpdateBalance(){  
        given(repositoryPerson.BalanceUpdateByPerson_name(100,"Benson")).willReturn(new Person());
        Person updateperson=balanceService.BalanceUpdate("Benson", 100);
        assertNotNull(updateperson);
    }
    @Test
    public void givenPersoName_thengiveBalance(){
       
        given(repositoryPerson.BalanceFindByPerson_name(person_test.getPerson_name())).willReturn(person_test.getBalance());        
        int ans=balanceService.NewBalance("Benson", 100);
        assertEquals(ans, 150);
    }


}
