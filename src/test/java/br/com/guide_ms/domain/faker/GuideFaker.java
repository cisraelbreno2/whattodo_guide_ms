package br.com.guide_ms.domain.faker;

import br.com.guide_ms.domain.entity.Guide;
import br.com.guide_ms.domain.port.dto.GuideRegisterRequest;
import br.com.guide_ms.domain.port.dto.GuideStopRegister;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GuideFaker {

    public static GuideRegisterRequest createGuideRegisterRequestValid(){
        var guideStopRegisterList = new ArrayList<GuideStopRegister>();
        guideStopRegisterList.add(StopFaker.createGuideStopRegister());
        return new GuideRegisterRequest("onf2s52f56ds1f1sd", "onf2s52f56ds1f1sd", "Viagem Pomerode", "Viagem de 07 de setembro", guideStopRegisterList);
    }

    public static GuideRegisterRequest createGuideRegisterRequestValidWithStopNull(){
        return new GuideRegisterRequest("onf2s52f56ds1f1sd", "onf2s52f56ds1f1sd", "Viagem Pomerode", "Viagem de 07 de setembro", null);
    }

    public static Guide createGuideRegisterValid(){
        return new Guide("1sd1f561dsf516dsf1", "onf2s52f56ds1f1sd", "onf2s52f56ds1f1sd", "Viagem Pomerode", "Viagem de 07 de setembro", LocalDateTime.now());
    }
}
