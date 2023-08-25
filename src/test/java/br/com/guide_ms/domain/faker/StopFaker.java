package br.com.guide_ms.domain.faker;

import br.com.guide_ms.domain.entity.Stop;
import br.com.guide_ms.domain.entity.enums.CategoryLocacion;
import br.com.guide_ms.domain.port.dto.StopRegister;

import java.time.LocalDateTime;

public class StopFaker {

    public static Stop createStopRegisterRequestValid(){
        return new Stop("a3xs1x56v198xc","Restaurante", "123415; 1616161", "Comer", CategoryLocacion.FOOD, LocalDateTime.now(), LocalDateTime.now(), null, "1sd1f561dsf516dsf1");
    }

    public static StopRegister createGuideStopRegister(){
        return new StopRegister("Restaurante", "123415; 1616161", "Comer", CategoryLocacion.FOOD, LocalDateTime.now(), LocalDateTime.now(), null);
    }
}
