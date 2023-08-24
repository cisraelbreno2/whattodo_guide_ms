package br.com.guide_ms.domain.useCase;

import br.com.guide_ms.domain.entity.Guide;
import br.com.guide_ms.domain.entity.Stop;
import br.com.guide_ms.domain.faker.GuideFaker;
import br.com.guide_ms.domain.faker.StopFaker;
import br.com.guide_ms.domain.repository.GuideRepository;
import br.com.guide_ms.domain.repository.StopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import static java.util.Objects.nonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GuideRegisterUseCaseTest {

    @Mock
    GuideRepository guideRepository;

    @Mock
    StopRepository stopRepository;

    @InjectMocks
    ModelMapper modelMapper;

    @InjectMocks
    GuideRegisterUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste para verificar se a guia e as paradas foi salvo")
    void register() {
        var guideRegisterRequest = GuideFaker.createGuideRegisterRequestValid();

        when(guideRepository.saveGuide(any())).thenReturn(GuideFaker.createGuideRegisterValid());
        var guideRegisterResponse = useCase.register(guideRegisterRequest);
        var guideCaptor = ArgumentCaptor.forClass(Guide.class);
        verify(guideRepository, times(1)).saveGuide(guideCaptor.capture());
        var guide = guideCaptor.getValue();
        assert guide.getId() == null;
        assertEquals(guideRegisterRequest.getDescription(), guide.getDescription());
        assertEquals(guideRegisterRequest.getTitle(), guide.getTitle());
        assertEquals(guideRegisterRequest.getUserId(), guide.getUserId());

        var stop = StopFaker.createStopRegisterRequestValid();
        when(stopRepository.saveStop(any())).thenReturn(StopFaker.createStopRegisterRequestValid());

        guideRegisterRequest.getGuideStopRegisterList().stream().forEach(e ->{
            assertEquals(stop.getAttachmentList(), e.getAttachmentList());
            assertEquals(stop.getTitle(), e.getTitle());
            assertEquals(stop.getWhatToDo(), e.getWhatToDo());
        });

        assert nonNull(guideRegisterResponse.id());
    }

    @Test
    @DisplayName("Teste para verificar se a guia sem as paradas foi salvo")
    void registerWithStopNull() {
        var guideRegisterRequest = GuideFaker.createGuideRegisterRequestValidWithStopNull();

        when(guideRepository.saveGuide(any())).thenReturn(GuideFaker.createGuideRegisterValid());

        var guideRegisterResponse = useCase.register(guideRegisterRequest);

        var guideCaptor = ArgumentCaptor.forClass(Guide.class);

        verify(guideRepository, times(1)).saveGuide(guideCaptor.capture());

        var guide = guideCaptor.getValue();

        assert guide.getId() == null;
        assertEquals(guideRegisterRequest.getDescription(), guide.getDescription());
        assertEquals(guideRegisterRequest.getTitle(), guide.getTitle());
        assertEquals(guideRegisterRequest.getUserId(), guide.getUserId());

        assert nonNull(guideRegisterResponse.id());
    }

}