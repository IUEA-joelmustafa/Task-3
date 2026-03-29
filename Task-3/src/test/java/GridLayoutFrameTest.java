import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.*;
import java.awt.*;

public class GridLayoutFrameTest {

    // ---------------------------------------------------------------
    // Test 1: Verify the JFrame is initialized with the correct settings
    // ---------------------------------------------------------------
    @Test
    public void testFrameInitialization() {
        // Arrange: create an instance of the UI we are testing
        GridLayoutFrame glf = new GridLayoutFrame();
        JFrame frame = glf.frame;

        // Assert: frame was actually created in memory
        assertNotNull("JFrame should be created", frame);

        // Assert: frame is set to visible
        assertTrue("JFrame should be visible", frame.isVisible());

        // Assert: closing the window exits the application
        assertEquals("JFrame close operation should be EXIT_ON_CLOSE",
                JFrame.EXIT_ON_CLOSE, frame.getDefaultCloseOperation());

        // Assert: the layout manager is GridLayout
        assertTrue("Layout should be GridLayout",
                frame.getContentPane().getLayout() instanceof GridLayout);

        // Assert: the grid is configured for 1 row and 3 columns
        GridLayout layout = (GridLayout) frame.getContentPane().getLayout();
        assertEquals("Grid should have 1 row", 1, layout.getRows());
        assertEquals("Grid should have 3 columns", 3, layout.getColumns());

        frame.dispose();
    }

    // ---------------------------------------------------------------
    // Test 2: Verify all three JPanels are created with correct colors
    // ---------------------------------------------------------------
    @Test
    public void testPanelComponentsCreation() {
        // Arrange: instantiate the main layout frame
        GridLayoutFrame glf = new GridLayoutFrame();

        // Assert: all three panel objects exist (not null)
        assertNotNull("jPanel1 should be created", glf.jPanel1);
        assertNotNull("jPanel2 should be created", glf.jPanel2);
        assertNotNull("jPanel3 should be created", glf.jPanel3);

        // Assert: each panel has the correct background color
        assertEquals("jPanel1 background should be GRAY",
                Color.GRAY, glf.jPanel1.getBackground());
        assertEquals("jPanel2 background should be RED",
                Color.RED, glf.jPanel2.getBackground());
        assertEquals("jPanel3 background should be ORANGE",
                Color.ORANGE, glf.jPanel3.getBackground());

        glf.frame.dispose();
    }

    // ---------------------------------------------------------------
    // Test 3: Verify the panels are added to the frame in the correct order
    // ---------------------------------------------------------------
    @Test
    public void testPanelsAddedToFrame() {
        // Arrange: set up the components
        GridLayoutFrame glf = new GridLayoutFrame();
        JFrame frame = glf.frame;

        // Assert: exactly 3 components were added to the frame
        assertEquals("Frame should contain exactly 3 components",
                3, frame.getContentPane().getComponentCount());

        // Assert: panels appear in the correct left-to-right order for the 1x3 grid
        assertEquals("First component should be jPanel1",
                glf.jPanel1, frame.getContentPane().getComponent(0));
        assertEquals("Second component should be jPanel2",
                glf.jPanel2, frame.getContentPane().getComponent(1));
        assertEquals("Third component should be jPanel3",
                glf.jPanel3, frame.getContentPane().getComponent(2));

        frame.dispose();
    }
}
