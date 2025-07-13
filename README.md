# Dombummel

Dombummel is a 2D Java game framework created by Kemijoki Specifications which includes drawing, input handling, fonts, window creation, and more.

---

## Features

- Window creation & render loop `Window`.
- Drawing util `Rakehornpipe`. 
- Font loading & usage `Fonterly`, only supports TTF.
- Keyboard + mouse input and pos `Input`.
- Vectors `Vector 2`, `Vector 3`, `Vector 4`.
- WAV player `MediaPlayer`
- Math util `Mathf`, with trig, clamp, lerp, etc.
- Image loading `Winclip`

---

## Getting Started

### Requirements

- Java 8+ (JDK)
- A text editor or IDE (Notepad works just fine!)

### Setup

Link the JAR (under lib) to your project and Import `com.dombummel.*;` or a specific class. NOTICE: There are no subpackages! Every class is inside of com.dombummel

---

### Window Creation

```java
Window name = new Window(sizeX, sizeY, "Title");
```
### Update Loop & Input

```java
Window.setUpdateCallback(() -> {
	// update code here
	if (Input.isKeyDown(KeyEvent.VK_SPACE)) {
       System.out.println("Spacebar is being held down!");
   }
   
   if (Input.isKeyJustPressed(KeyEvent.VK_DOWN)) {
       System.out.println("Down was pressed");
   }

   if (Input.isMouseDown(MouseEvent.BUTTON1)) {
      System.out.println("Left mouse button is pressed!");
   }

   int mx = Input.getMouseX();
   int my = Input.getMouseY();
   System.out.println("Mouse is at: " + mx + ", " + my);
});
```

### Drawing
```java
BufferedImage img = Winclip.load("path/to/ur/img");
Font font = Fonterly.load("path/to/ur/font", 16f);

Window.setDrawCallback(g -> {
	// draw code here
	Rakehornpipe.clear(Color.BLACK); // example
	Winclip.draw(g, img, 100, 100); // use Winclip.draw for images
	Rakehornpipe.setColor(Color.GREEN);
	Rakehornpipe.rect("Fill", 200, 200, 10, 10); // type, x, y, w, h
	Rakehornpipe.rect("Line", 300, 300, 10, 10);
	Rakehornpipe.setFont(font);
	Rakehornpipe.print("Hello!", 100, 200); // draws text in selected font
});
```


 

