package br.com.guide_ms.domain.faker;

import br.com.guide_ms.domain.entity.Guide;
import br.com.guide_ms.domain.port.dto.GuideModifyRequest;
import br.com.guide_ms.domain.port.dto.GuideRegisterRequest;
import br.com.guide_ms.domain.port.dto.StopRegister;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GuideFaker {

    public static GuideRegisterRequest createGuideRegisterRequestValid(){
        return new GuideRegisterRequest("onf2s52f56ds1f1sd", "onf2s52f56ds1f1sd", "Viagem Pomerode", "Viagem de 07 de setembro");
    }

    public static Guide createGuideRegisterValid(){
        return new Guide("1sd1f561dsf516dsf1", "onf2s52f56ds1f1sd", "onf2s52f56ds1f1sd", "Viagem Pomerode", "Viagem de 07 de setembro", LocalDateTime.now());
    }

    public static Guide createGuideModifyValid(){
        return new Guide("1sd1f561dsf516dsf1", "onf2s52f56ds1f1sd", "onf2s52f56ds1f1sd", "Viagem Pomerode", "Viagem de 07 de setembro", LocalDateTime.now());
    }

    public static GuideModifyRequest createGuideModifyRequestValid(){
        return new GuideModifyRequest("1sd1f561dsf516dsf1", "Viagem Pomerode", "Viagem de 07 de setembro");
    }

    public static GuideModifyRequest createGuideModifyRequestNoTitle(){
        return new GuideModifyRequest("1sd1f561dsf516dsf1", "", "Viagem de 07 de setembro");
    }
}
