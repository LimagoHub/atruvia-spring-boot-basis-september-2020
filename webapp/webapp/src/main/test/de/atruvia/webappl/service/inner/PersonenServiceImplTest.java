package de.atruvia.webappl.service.inner;

import de.atruvia.webappl.repository.PersonenRepository;
import de.atruvia.webappl.service.PersonenServiceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonenServiceImplTest {

    @InjectMocks
    private PersonenServiceImpl objectUnderTest;

    @Mock
    private PersonenRepository repositoryMock;

    @Mock
    private List<String> antipathenMock;

    @Test
    void speichern_parameternull_throwsPersonenServiceException() {
        PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichernOderAendern(null));
        assertEquals("Person darf nicht null sein.", ex.getMessage());
    }

}