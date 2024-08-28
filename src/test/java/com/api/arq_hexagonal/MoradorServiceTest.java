package com.api.arq_hexagonal;

import com.api.arq_hexagonal.core.domain.Morador;
import com.api.arq_hexagonal.core.ports.MoradorRepositoryPort;
import com.api.arq_hexagonal.core.services.MoradorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MoradorServiceTest {

    @Mock
    private MoradorRepositoryPort moradorRepositoryPort;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private MoradorService moradorService;

    @Test
    void testCreateMorador() {
        Morador morador = getMorador1();
        when(moradorRepositoryPort.createMorador(morador)).thenReturn(morador);

        Morador result = moradorService.createMorador(morador);

        assertNotNull(result);
        assertEquals(morador, result);
        verify(moradorRepositoryPort).createMorador(morador);
    }

    public Morador getMorador1() {
        Morador morador = new Morador();
        morador.setId(1L);
        morador.setNomeMorador("Teste 1");
        morador.setCpf("111.111.111-11");
        morador.setEndereco("Rua Teste 1");
        morador.setCelular("11 11111-1111");
        return morador;
    }
}
