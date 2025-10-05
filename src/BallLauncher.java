import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class BallLauncher extends GraphicsProgram{
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int SIZE = 25;
	private ArrayList<GOval> balls;
	int MS = 50;
	int SPEED = 2;
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		balls = new ArrayList<>();
		requestFocus();
	}
	
	public void run() {
		makeBall(20,20);
		makeBall(100,100);
		makeBall(60,60);
		addMouseListeners();
		Timer time = new Timer(MS, this);
		time.start();
		
		
	}
	
	public void mousePressed(MouseEvent e) {
		GOval ball = makeBall(SIZE/2, e.getY());
		add(ball);
	}
	
	public GOval makeBall(double x, double y) {
		GOval temp = new GOval(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
		temp.setColor(Color.RED);
		temp.setFilled(true);
		balls.add(temp);
		
		return temp;
	}
	
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < balls.size(); i++) {
			balls.get(i).move(SPEED, 0); 
			add(balls.get(i));
		}
	}
	
	public static void main(String[] args) {
		new BallLauncher().start();
	}

}
