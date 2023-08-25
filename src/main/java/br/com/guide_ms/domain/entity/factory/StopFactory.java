package br.com.guide_ms.domain.entity.factory;

import br.com.guide_ms.domain.entity.Stop;
import br.com.guide_ms.domain.port.dto.StopRegister;

public class StopFactory {

    private StopFactory(){}

    public static Stop fromRegisterRequest(StopRegister request){
        return new Stop(request.getTitle(), request.getCoordinates(), request.getWhatToDo(), request.getCategoryLocacion(), request.getInitialDateHour(), request.getFinalDateHour(), request.getAttachmentList());
    }

}
