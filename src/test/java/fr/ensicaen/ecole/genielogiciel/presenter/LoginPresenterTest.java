package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.view.LoginView;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

    @BeforeEach
    public void initMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    void should_activate_view_error_display() {
        // TODO Interest of this test holds on the use of Mockito

        // given
        LoginPresenter presenter = new LoginPresenter();
        presenter.setView(_view);

        // when
        presenter.launchGame("", _playerName, _originPlayer, _majorPlayer, _colorPlayer);

        // then
        verify(_view, times(1)).displayError(LoginMain.getMessageBundle().getString("error.nickname"));
    }
}
