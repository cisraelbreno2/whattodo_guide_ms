package br.com.guide_ms.domain.useCase;

import br.com.guide_ms.domain.entity.Guide;
import br.com.guide_ms.domain.exceptions.GuideModifyException;
import br.com.guide_ms.domain.faker.GuideFaker;
import br.com.guide_ms.domain.repository.GuideRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Objects.nonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GuideModifyUseCaseTest {

    @Mock
    GuideRepository guideRepository;

    @InjectMocks
    GuideModifyUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste para verificar se a guia foi alterada")
    void modify() {
        var guideModifyRequestValid = GuideFaker.createGuideModifyRequestValid();
        when(guideRepository.findById(any())).thenReturn(GuideFaker.createGuideRegisterValid());
        when(guideRepository.saveGuide(any())).thenReturn(GuideFaker.createGuideRegisterValid());

        var guideModifyResponse = useCase.modify(guideModifyRequestValid);
        var guideCaptor = ArgumentCaptor.forClass(Guide.class);

        verify(guideRepository, times(1)).saveGuide(guideCaptor.capture());
        var guide = guideCaptor.getValue();

        assertEquals(guideModifyRequestValid.getDescription(), guide.getDescription());
        assertEquals(guideModifyRequestValid.getTitle(), guide.getTitle());
        assertEquals(guideModifyRequestValid.getId(), guide.getId());

        assertEquals(guideModifyResponse.getStatus(), "Guia alterado com sucesso");
    }

    @Test
    @DisplayName("Teste para verificar se foi interrompido a alteracao da guia")
    void modifyUnssusses() {
        var guideModifyRequestValid = GuideFaker.createGuideModifyRequestNoTitle();
        when(guideRepository.findById(any())).thenReturn(GuideFaker.createGuideRegisterValid());
        assertThrows(GuideModifyException.class, () -> useCase.modify(guideModifyRequestValid));
    }

}