# GridLayoutFrame Testing Documentation

This document explains the unit tests performed on the `GridLayoutFrame` application, detailing what was tested, on what grounds, and breaking down the lines of code used to test it.

## Overview
The tests in `GridLayoutFrameTest.java` are written using the **JUnit 4** framework. The primary goal of these tests is to ensure that the graphical user interface (GUI) of the application is initialized with the correct configuration and that the different graphical components (Panels) are created and placed correctly inside the main window (Frame).

There are three main tests implemented. Below is a breakdown of what they check and why.


### 1. testFrameInitialization()
**Grounds for Testing:** 
Before we check any specific component, we must confirm that the main application window is created properly and configured correctly. This test validates the core settings of the application frame.

**Code Breakdown:**
```java
@Test
public void testFrameInitialization() {
    // 1. Arrange: Creates an instance of the UI we are testing
    GridLayoutFrame glf = new GridLayoutFrame(); 
    // Retrieves the frame object from the UI instance
    JFrame frame = glf.frame; 

    // 2. Assert: Checks if the frame actually exists in memory (was successfully created)
    assertNotNull("JFrame should be created", frame); 
    
    // Asserts that the frame is set to become visible to the user
    assertTrue("JFrame should be visible", frame.isVisible()); 
    
    // Asserts that the application will terminate when the user closes the window
    assertEquals("JFrame close operation should be EXIT_ON_CLOSE", JFrame.EXIT_ON_CLOSE, frame.getDefaultCloseOperation()); 
    
    // Confirms that the frame uses a GridLayout to arrange its internal components
    assertTrue("Layout should be GridLayout", frame.getContentPane().getLayout() instanceof GridLayout); 
    
    // Gets the layout configuration to validate it was specifically configured for 1 row and 3 columns
    GridLayout layout = (GridLayout) frame.getContentPane().getLayout();
    assertEquals("Grid should have 1 row", 1, layout.getRows());
    assertEquals("Grid should have 3 columns", 3, layout.getColumns());
}
```

---

### 2. testPanelComponentsCreation()
**Grounds for Testing:** 
The application relies on three separate color-coded rectangles (Panels). If they aren't created in memory or colored correctly, the UI will be broken or misleading for the user. We must test their creation independently of whether they were added to the window.

**Code Breakdown:**
```java
@Test
public void testPanelComponentsCreation() {
    // 1. Arrange: Instantiate the main layout frame
    GridLayoutFrame glf = new GridLayoutFrame();

    // 2. Assert: Verify that the panel objects were actually defined inside the class and aren't 'null' objects
    assertNotNull("jPanel1 should be created", glf.jPanel1);
    assertNotNull("jPanel2 should be created", glf.jPanel2);
    assertNotNull("jPanel3 should be created", glf.jPanel3);

    // Assert: Verify that the correct background colors were applied to each individual panel
    assertEquals("jPanel1 background should be GRAY", Color.GRAY, glf.jPanel1.getBackground());
    assertEquals("jPanel2 background should be RED", Color.RED, glf.jPanel2.getBackground());
    assertEquals("jPanel3 background should be ORANGE", Color.ORANGE, glf.jPanel3.getBackground());
}
```

---

### 3. testPanelsAddedToFrame()
**Grounds for Testing:** 
Even if the JFrame and JPanels are created successfully, they won't show up correctly unless the panels are actually added to the frame's content pane in the proper sequential order. Because it's a 1x3 GridLayout, sequence matters.

**Code Breakdown:**
```java
@Test
public void testPanelsAddedToFrame() {
    // 1. Arrange: Set up the components
    GridLayoutFrame glf = new GridLayoutFrame();
    JFrame frame = glf.frame;

    // 2. Assert: Check that exactly three components were added to the frame's content block. 
    // If it's anything other than 3, the test will fail.
    assertEquals("Frame should contain exactly 3 components", 3, frame.getContentPane().getComponentCount());

    // Assert: Verify that the exact order the panels were inserted corresponds exactly to 
    // left-to-right alignment expected in the 1x3 grid
    assertEquals("First component should be jPanel1", glf.jPanel1, frame.getContentPane().getComponent(0));
    assertEquals("Second component should be jPanel2", glf.jPanel2, frame.getContentPane().getComponent(1));
    assertEquals("Third component should be jPanel3", glf.jPanel3, frame.getContentPane().getComponent(2));
}
```
