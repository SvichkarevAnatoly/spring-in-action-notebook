package ru;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class HomeControllerTest {
    @Test
    public void shouldDisplayRecentSpittles() {
        final List<Spittle> expectedSpittles =
                asList(new Spittle(), new Spittle(), new Spittle());

        final SpitterService spitterService = mock(SpitterService.class);

        when(spitterService.getRecentSpittles(HomeController.DEFAULT_SPITTLES_PER_PAGE))
                .thenReturn(expectedSpittles);

        final HomeController controller = new HomeController(spitterService);
        final HashMap<String, Object> model = new HashMap<String, Object>();

        final String viewName = controller.showHomePage(model);

        assertThat("home", is(viewName));

        assertThat(expectedSpittles, sameInstance(model.get("spittles")));
        verify(spitterService).getRecentSpittles(HomeController.DEFAULT_SPITTLES_PER_PAGE);
    }
}
