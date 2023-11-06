/*package com.comp2059.snakegame;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Random;

public class GamePanel extends Pane {
	static final int SCREEN_WIDTH = 1300;
	static final int SCREEN_HEIGHT = 750;
	static final int UNIT_SIZE = 50;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
	static final long DELAY = 175;
	final int[] x = new int[GAME_UNITS];
	final int[] y = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	AnimationTimer timer;
	Random random;
	Canvas canvas;
	GraphicsContext gc;

	public GamePanel() {
		random = new Random();
		canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		getChildren().add(canvas);
		setFocusTraversable(true);

		// Event handling for key presses
		setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.LEFT && direction != 'R') {
				direction = 'L';
			} else if (event.getCode() == KeyCode.RIGHT && direction != 'L') {
				direction = 'R';
			} else if (event.getCode() == KeyCode.UP && direction != 'D') {
				direction = 'U';
			} else if (event.getCode() == KeyCode.DOWN && direction != 'U') {
				direction = 'D';
			}
		});

		startGame();
	}

	private void startGame() {
		newApple();
		running = true;
		timer = new AnimationTimer() {
			long lastTick = 0;

			@Override
			public void handle(long now) {
				if (lastTick == 0 || now - lastTick > DELAY * 1_000_000) {
					lastTick = now;
					if (running) {
						move();
						checkApple();
						checkCollisions();
						draw();
					}
				}
			}
		};
		timer.start();
	}

	private void draw() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		if (running) {
			gc.setFill(Color.RED);
			gc.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

			for (int i = 0; i < bodyParts; i++) {
				if (i == 0) {
					gc.setFill(Color.GREEN);
				} else {
					gc.setFill(new Color(0.176, 0.705, 0, 1));
				}
				gc.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}

			drawCenteredString(gc, "Score: " + applesEaten, SCREEN_WIDTH, 40);
		} else {
			gameOver(gc);
		}
	}

	private void newApple() {
		appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
	}

	private void move() {
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}

		switch (direction) {
			case 'U':
				y[0] = y[0] - UNIT_SIZE;
				break;
			case 'D':
				y[0] = y[0] + UNIT_SIZE;
				break;
			case 'L':
				x[0] = x[0] - UNIT_SIZE;
				break;
			case 'R':
				x[0] = x[0] + UNIT_SIZE;
				break;
		}
	}

	private void checkApple() {
		if ((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}

	private void checkCollisions() {
		// 检查头部是否与身体相撞
		for (int i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
				break;
			}
		}
		// 检查头部是否触碰边界
		if (x[0] < 0 || x[0] >= SCREEN_WIDTH || y[0] < 0 || y[0] >= SCREEN_HEIGHT) {
			running = false;
		}

		// 如果游戏结束，停止动画计时器
		if (!running) {
			timer.stop();
		}
	}

	private void gameOver(GraphicsContext gc) {
		// 游戏结束时的绘制逻辑
		drawCenteredString(gc, "Score: " + applesEaten, SCREEN_WIDTH, 40);
		drawCenteredString(gc, "Game Over lol get rekt", SCREEN_WIDTH, SCREEN_HEIGHT / 2);
	}

	private void drawCenteredString(GraphicsContext gc, String text, double width, double yPos) {
		Text tempText = new Text(text);
		tempText.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
		double x = (width - tempText.getLayoutBounds().getWidth()) / 2;
		gc.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
		gc.setFill(Color.RED);
		gc.fillText(text, x, yPos);
	}
}*/





package com.comp2059.snakegame;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Random;

public class GamePanel extends Pane {
	static final int SCREEN_WIDTH = 1300;
	static final int SCREEN_HEIGHT = 750;
	static final int UNIT_SIZE = 50;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
	static final long DELAY = 175;
	final int[] x = new int[GAME_UNITS];
	final int[] y = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	private AnimationTimer timer;
	private Random random;
	private Canvas canvas;
	GraphicsContext gc;



	public GamePanel() {
		random = new Random();
		canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
		gc = canvas.getGraphicsContext2D(); // 确保这行代码在这里
		this.getChildren().add(canvas);
		startGame();
	}
		public void startGame() {
			newApple();
			running = true;
			timer = new AnimationTimer() {
				@Override
				public void handle(long now) {
					if (running) {
						move();
						checkApple();
						checkCollisions();
					}
					draw();
				}
			};
			timer.start();
			setFocusTraversable(true);
			setOnKeyPressed(e -> {
				if (e.getCode() == KeyCode.LEFT && direction != 'R') {
					direction = 'L';
				} else if (e.getCode() == KeyCode.RIGHT && direction != 'L') {
					direction = 'R';
				} else if (e.getCode() == KeyCode.UP && direction != 'D') {
					direction = 'U';
				} else if (e.getCode() == KeyCode.DOWN && direction != 'U') {
					direction = 'D';
				}
			});
		}

	private void draw() {
		if (gc == null) {
			return; // 如果gc是null，就不继续执行
		}
		GraphicsContext g = canvas.getGraphicsContext2D();
		g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		if (running) {
			gc.setFill(Color.RED);
			gc.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

			for (int i = 0; i < bodyParts; i++) {
				if (i == 0) {
					gc.setFill(Color.GREEN);
				} else {
					gc.setFill(new Color(0.176, 0.705, 0, 1));
				}
				gc.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}

			drawCenteredString(gc, "Score: " + applesEaten, SCREEN_WIDTH, 40);
		} else {
			gameOver(gc);
		}
	}

	private void newApple() {
		appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
	}

	private void move() {
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}

		switch (direction) {
			case 'U':
				y[0] = y[0] - UNIT_SIZE;
				break;
			case 'D':
				y[0] = y[0] + UNIT_SIZE;
				break;
			case 'L':
				x[0] = x[0] - UNIT_SIZE;
				break;
			case 'R':
				x[0] = x[0] + UNIT_SIZE;
				break;
		}
	}

	private void checkApple() {
		if ((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}

	private void checkCollisions() {
		// 检查头部是否与身体相撞
		for (int i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
				break;
			}
		}
		// 检查头部是否触碰边界
		if (x[0] < 0 || x[0] >= SCREEN_WIDTH || y[0] < 0 || y[0] >= SCREEN_HEIGHT) {
			running = false;
		}

		// 如果游戏结束，停止动画计时器
		if (!running) {
			timer.stop();
		}
	}

	private void gameOver(GraphicsContext gc) {
		// 游戏结束时的绘制逻辑
		drawCenteredString(gc, "Score: " + applesEaten, SCREEN_WIDTH, 40);
		drawCenteredString(gc, "Game Over lol get rekt", SCREEN_WIDTH, SCREEN_HEIGHT / 2);
	}

	private void drawCenteredString(GraphicsContext gc, String text, double width, double yPos) {
		Text tempText = new Text(text);
		tempText.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
		double x = (width - tempText.getLayoutBounds().getWidth()) / 2;
		gc.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
		gc.setFill(Color.RED);
		gc.fillText(text, x, yPos);
	}
}