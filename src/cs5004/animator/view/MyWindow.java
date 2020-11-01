package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;

import cs5004.animator.model.Action;
import cs5004.animator.model.Shape;

/**
 * A class that implements AnimationView, acts as the view for the animation. It also extends JFrame
 * and acts as the frame that holds the drawing panel and functions of the animation.
 */
public class MyWindow extends JFrame implements AnimatorView {
  ArrayList<Shape> shapes = new ArrayList<Shape>();
  int tempo = 5;
  DrawArea drawingPanel = new DrawArea(shapes, tempo);
  JPanel buttons;
  JButton play;
  JButton pause;
  JButton restart;
  JButton save;
  JButton addRect;
  JButton addOval;
  JButton removeRect;
  JButton removeOval;

  /**
   * A constructor that initializes the this JFrame, the JPanels, and the JButtons.
   */
  public MyWindow() {
    setSize(800, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    buttons = new JPanel();
    play = new JButton("Play");
    buttons.add(play);
    pause = new JButton("Pause");
    buttons.add(pause);
    restart = new JButton("Restart");
    buttons.add(restart);
    save = new JButton("Save");
    buttons.add(save);
    play = new JButton("add rectangle");
    buttons.add(addRect);
    pause = new JButton("add oval");
    buttons.add(addOval);
    restart = new JButton("remove rectangle");
    buttons.add(removeRect);
    save = new JButton("remove oval");
    buttons.add(removeOval);
    add(buttons, BorderLayout.SOUTH);
    add(drawingPanel, BorderLayout.CENTER);
    setVisible(true);
  }


  public void addPlayListener(ActionListener listener) {
    play.addActionListener(listener);
  }


  public void addStopListener(ActionListener listener) {
    pause.addActionListener(listener);
  }


  public void addRestartListener(ActionListener listener) {
    restart.addActionListener(listener);
  }

  public void addSaveListener(ActionListener listener) {
    save.addActionListener(listener);
  }


  public void addAddRListener(ActionListener listener) {
    addRect.addActionListener(listener);
  }


  public void addAddOListener(ActionListener listener) {
    addOval.addActionListener(listener);
  }


  public void addRemoveRListener(ActionListener listener) {
    removeRect.addActionListener(listener);
  }

  public void addRemoveOListener(ActionListener listener) {
    removeOval.addActionListener(listener);
  }


  @Override
  public void render() {
    drawingPanel.repaint();
  }






  @Override
  public void setSource(Appendable output) {
    int i = 0;
  }

  @Override
  public void setInput(String input) {
    int i = 0;
  }

  @Override
  public void setInput(ArrayList<Shape> data) {
    this.shapes = data;
  }








  //shape interface

  @Override
  public void move(Point2D.Double newLoc) {

  }

  @Override
  public void reSize(double scalingFactor, int dimension) throws IllegalArgumentException {

  }

  @Override
  public void reColor(Color c) throws IllegalArgumentException {

  }

  @Override
  public int getCreationTime() {
    return 0;
  }

  @Override
  public int getDestructionTime() {
    return 0;
  }

  @Override
  public Color getColor() {
    return null;
  }

  @Override
  public boolean validateActionTimes(int startTime, int endTime) {
    return false;
  }

  @Override
  public void addAction(Action a) {

  }

  @Override
  public Shape copy() {
    return null;
  }

  @Override
  public ArrayList<Action> getActions() {
    return null;
  }

  @Override
  public void setStartingAttributes(Point2D.Double location, Color color, double xWidth, double yHeight, int createTime, int destroyTime) {

  }

  @Override
  public void setDestroyTime(int destroyTime) {

  }

  @Override
  public void mutateShape(int time) {

  }

  @Override
  public void interpolate(Action a, int time) {

  }

  @Override
  public boolean isVisible(int time) {
    return false;
  }

  @Override
  public String getShapeTypeString() {
    return null;
  }

  @Override
  public void getLocation();

}