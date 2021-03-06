package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.*;
import javax.swing.JPanel;

import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;

/**
 * This class acts as the panel on which all of the animations for our Swing view are drawn. It has
 * a timer and continually updates the shapes that were passed to it from the model and repaints the
 * panel.
 */
public class DrawArea extends JPanel implements ActionListener {
  MyWindow myWindow;
  ArrayList<Shape> shapes;
  Timer timer;
  int tempo;
  int time;

  /**
   * Instantiate the panel. Store the list of shapes passed along. Set the temp of the animation
   * which will determine how often the panel is repainted.
   *
   * @param shapes the shapes (with their actions) present in the animation.
   * @param tempo  the tempo of the animation ie ticks per second
   */
  public DrawArea(ArrayList<Shape> shapes, int tempo) {
    super();
    this.time = 0;
    this.tempo = tempo;
    this.shapes = shapes;
    int timeForTimer = 1000 / this.tempo;
    this.timer = new Timer(timeForTimer, this);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // iterate through the shapes, and paint each of them accordingly
    for (Shape s : this.shapes) {
      if ((s.getClass() == Oval.class) && ((Oval) s).isVisible(this.time)) {
        g.setColor(s.getColor());
        g.fillOval((int) s.getLocation().getX(),
                (int) s.getLocation().getY(),
                (int) s.getWidth(), (int) s.getHeight());
      } else if (s.isVisible(this.time)) {
        g.setColor(s.getColor());
        g.fillRect((int) s.getLocation().getX(), (int) s.getLocation().getY(), (int) s.getWidth(),
                (int) s.getHeight());
      }
      timer.start();
    }
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    ArrayList<Shape> shapeList1 = new ArrayList<Shape>();
    ArrayList<Shape> shapeList2 = new ArrayList<Shape>();
    myWindow = new MyWindow();
    for (Shape shape : shapeList1) {
      if (shape instanceof Rectangle) {
        Shape shape1 = new Rectangle(shape.getName());
        shapeList2.add(shape1);
      }
      else if (shape instanceof Oval) {
        Shape shape1 = new Oval(shape.getName());
        shapeList2.add(shape1);
      }
    }

    myWindow.addPlayListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        timer.start();
      }
    });

    myWindow.addStopListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        timer.stop();
      }
    });

    myWindow.addRestartListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!timer.isRunning()) {
          timer.start();
        }
//        get the start shapes from shapelist2
      }
    });

    myWindow.addSaveListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser save = new JFileChooser();
        save.setDialogTitle("Save your file");
        int savePossible = save.showSaveDialog(save);
        if (savePossible == JFileChooser.APPROVE_OPTION) {
          File file = save.getSelectedFile();
          BufferedWriter writer = null;
          try {
            writer = new BufferedWriter(new FileWriter(file.getName()));
          } catch (IOException e1) {
            e1.printStackTrace();
          }
          try {
//            writer.append(shapes.toString());
          } catch (IOException e1) {
            e1.printStackTrace();
          }
          try {
            writer.close();
          } catch (IOException e1) {
            e1.printStackTrace();
          }
        }
      }
    });

    myWindow.addRemoveOListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (Shape shape1 : shapeList1) {
          if (shape1 instanceof Oval) {
            shapeList1.remove(shape1);
          }
        }
        }

    });

    myWindow.addRemoveRListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (Shape shape1 : shapeList1) {
          if (shape1 instanceof Rectangle) {
            shapeList1.remove(shape1);
          }
        }
      }
  });

    myWindow.addAddRListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        for (Shape shape1 : shapeList1 && shape1.getStart < time && shape1.getEnd > time) {
          shapeList1.add(shape1);
        }
          if (shape1 instanceof Rectangle) {
            shapeList1.remove(shape1);
          }
        }
      }
    });




    // update shapes each time this is called
//    for (Shape s : this.shapes) {
//      s.mutateShape(this.time);
//    }
//    this.time += 1;
//    repaint();
//  }
}