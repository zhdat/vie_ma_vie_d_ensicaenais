package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.view.LoginView;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Locale;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LoginPresenterTest {

    @Mock
    private LoginView _view;
    private AutoCloseable closeable;
    private String[] _playerName;
    private String[] _originPlayer;
    private String[] _majorPlayer;
    private Color[] _colorPlayer;
    private Locale _selectedLocale;

    @BeforeEach
    public void initMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    void shouldActivateViewErrorDisplay() {

        // given
        LoginPresenter presenter = new LoginPresenter();
        presenter.setView(_view);

        // when
        presenter.launchGame("", _playerName, _originPlayer, _majorPlayer, _colorPlayer, _selectedLocale);

        // then
        Locale selectedLocale = Locale.FRENCH;
        // @TODO: fix this test
        verify(_view, times(1)).displayError(LoginMain.getMessageBundle(selectedLocale).getString("error.nickname"));
    }
}
